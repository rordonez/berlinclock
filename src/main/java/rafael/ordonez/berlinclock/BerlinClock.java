package rafael.ordonez.berlinclock;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClock {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final int ROW_SIZE = 4;

    private final Lamp topLamp;
    private final Lamp [] fiveHourLamps;
    private final Lamp [] fullHourLamps;
    private final int fiveMinuteFieldsCount;
    private final int fullMinuteFieldsCount;

    public BerlinClock(int hour, int minutes, int seconds) {
        this.topLamp = new Lamp(ColourEnum.YELLOW, StatusEnum.values()[moduleOfTwo.apply(seconds)]);
        this.fiveHourLamps = fill(divideByFive.apply(hour));
        this.fullHourLamps = fill(moduleOfFive.apply(hour));
        this.fiveMinuteFieldsCount = divideByFive.apply(minutes);
        this.fullMinuteFieldsCount = moduleOfFive.apply(minutes);
    }

    private Lamp[] fill(int lampsToTurnOn) {

        return Stream.concat(
                    IntStream.range(0, lampsToTurnOn).mapToObj(x -> new Lamp(ColourEnum.RED, StatusEnum.ON)),
                    IntStream.range(0, ROW_SIZE - lampsToTurnOn).mapToObj(x1 -> new Lamp(ColourEnum.RED, StatusEnum.OFF)))
                .toArray(size -> new Lamp[ROW_SIZE]);
    }

    BiFunction<Integer, Integer, Integer> module = (x, y) -> x % y;
    BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
    Function<Integer, Integer> moduleOfTwo = x -> module.apply(x, 2);
    Function<Integer, Integer> moduleOfFive = x -> module.apply(x, 5);
    Function<Integer, Integer> divideByFive= x -> divide.apply(x, 5);

    @Override
    public String toString() {
        return new StringJoiner(LINE_SEPARATOR)
                .add(topLamp.toString())
                .add(lampsIllumination(fiveHourLamps))
                .add(lampsIllumination(fullHourLamps))
                .add(String.valueOf(fiveMinuteFieldsCount))
                .add(String.valueOf(fullMinuteFieldsCount))
                .toString();
    }

    private String lampsIllumination(Lamp [] lamps) {
        return Arrays.stream(lamps)
                .map(Lamp::toString)
                .collect(Collectors.joining());
    }
}

enum StatusEnum {
    ON, OFF
}

enum ColourEnum {
    YELLOW, RED
}

class Lamp {
    private final ColourEnum colour;
    private final StatusEnum status;

    public Lamp(ColourEnum colour, StatusEnum status) {
        this.colour = colour;
        this.status = status;
    }

    @Override
    public String toString() {
        return "(" + colour.name() + " " + status.name() + ")";
    }
}
