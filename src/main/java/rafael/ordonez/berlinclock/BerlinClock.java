package rafael.ordonez.berlinclock;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClock {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final int ROW_SIZE = 4;
    public static final int LONG_ROW_SIZE = 11;

    private final Lamp topLamp;
    private final Lamp [] fiveHourLamps;
    private final Lamp [] fullHourLamps;
    private final Lamp [] fiveMinuteLamps;
    private final Lamp [] fullMinuteLamps;

    public BerlinClock(int hour, int minutes, int seconds) {
        this.topLamp = new Lamp(ColourEnum.YELLOW, isModuleOfTwo.test(seconds) ? StatusEnum.ON : StatusEnum.OFF);
        this.fiveHourLamps = fillHours(divideByFive.apply(hour));
        this.fullHourLamps = fillHours(moduleOfFive.apply(hour));
        this.fiveMinuteLamps = fillFiveMinutesLamps(divideByFive.apply(minutes));
        this.fullMinuteLamps = fillMinutes(moduleOfFive.apply(minutes));
    }

    private Lamp[] fillHours(int lampsToTurnOn) {
        return IntStream.range(1, ROW_SIZE+1)
                .mapToObj(x -> new Lamp(ColourEnum.RED, x <= lampsToTurnOn ? StatusEnum.ON : StatusEnum.OFF))
                .toArray(size -> new Lamp[ROW_SIZE]);
    }

    private Lamp[] fillFiveMinutesLamps(int lampsToTurnOn) {
        return IntStream.range(1, LONG_ROW_SIZE+1)
                .mapToObj(x -> new Lamp(isModuleOfThree.test(x) ? ColourEnum.RED : ColourEnum.YELLOW, x <= lampsToTurnOn ? StatusEnum.ON : StatusEnum.OFF))
                .toArray(size -> new Lamp[LONG_ROW_SIZE]);
    }

    private Lamp[] fillMinutes(int lampsToTurnOn) {
        return IntStream.range(1, ROW_SIZE+1)
                .mapToObj(x -> new Lamp(ColourEnum.YELLOW, x <= lampsToTurnOn ? StatusEnum.ON : StatusEnum.OFF))
                .toArray(size -> new Lamp[ROW_SIZE]);
    }

    BiFunction<Integer, Integer, Integer> module = (x, y) -> x % y;
    BiFunction<Integer, Integer, Integer> divide = (x, y) -> x / y;
    Predicate<Integer> isModuleOfTwo = x -> module.apply(x, 2) == 0;
    Predicate<Integer> isModuleOfThree = x -> module.apply(x, 3) == 0;
    Function<Integer, Integer> moduleOfFive = x -> module.apply(x, 5);
    Function<Integer, Integer> divideByFive= x -> divide.apply(x, 5);

    @Override
    public String toString() {
        return new StringJoiner(LINE_SEPARATOR)
                .add(topLamp.toString())
                .add(lampsIllumination(fiveHourLamps))
                .add(lampsIllumination(fullHourLamps))
                .add(lampsIllumination(fiveMinuteLamps))
                .add(lampsIllumination(fullMinuteLamps))
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
