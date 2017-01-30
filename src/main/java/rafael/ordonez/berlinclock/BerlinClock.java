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

    public BerlinClock(int hour, Object o1, int seconds) {
        this.topLamp = TopLamp.values()[moduleOfTwo.apply(seconds)];
        this.fiveHourFieldsCount = divideByFive.apply(hour);
        this.fullHourFieldsCount = moduleOfFive.apply(hour);
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
                .toString();
    }
}

enum TopLamp {
    ON, OFF
}
