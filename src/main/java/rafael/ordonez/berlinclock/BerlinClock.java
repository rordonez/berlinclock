package rafael.ordonez.berlinclock;

import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClock {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private final TopLamp topLamp;
    private final int fiveHourFieldsCount;
    private final int fullHourFieldsCount;
    private final int fiveMinuteFieldsCount;
    private final int fullMinuteFieldsCount;

    public BerlinClock(int hour, int minutes, int seconds) {
        this.topLamp = TopLamp.values()[moduleOfTwo.apply(seconds)];
        this.fiveHourFieldsCount = divideByFive.apply(hour);
        this.fullHourFieldsCount = moduleOfFive.apply(hour);
        this.fiveMinuteFieldsCount = divideByFive.apply(minutes);
        this.fullMinuteFieldsCount = moduleOfFive.apply(minutes);
    }

    BiFunction<Integer, Integer, Integer> module = (x, y) -> x % y;
    BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
    Function<Integer, Integer> moduleOfTwo = x -> module.apply(x, 2);
    Function<Integer, Integer> moduleOfFive = x -> module.apply(x, 5);
    Function<Integer, Integer> divideByFive= x -> divide.apply(x, 5);

    @Override
    public String toString() {
        return new StringJoiner(LINE_SEPARATOR)
                .add(topLamp.name())
                .add(String.valueOf(fiveHourFieldsCount))
                .add(String.valueOf(fullHourFieldsCount))
                .add(String.valueOf(fiveMinuteFieldsCount))
                .add(String.valueOf(fullMinuteFieldsCount))
                .toString();
    }
}

enum TopLamp {
    ON, OFF
}
