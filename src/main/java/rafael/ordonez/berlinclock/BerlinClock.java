package rafael.ordonez.berlinclock;

import java.util.StringJoiner;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClock {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private final TopLamp topLamp;
    private final int firstLine;

    public BerlinClock(int hour, Object o1, int seconds) {
        this.topLamp = TopLamp.values()[seconds];
        this.firstLine = hour / 5;
    }

    @Override
    public String toString() {
        return new StringJoiner(LINE_SEPARATOR)
                .add(topLamp.name())
                .add(String.valueOf(firstLine))
                .toString();
    }
}

enum TopLamp {
    ON, OFF
}
