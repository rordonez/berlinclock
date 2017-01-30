package rafael.ordonez.berlinclock;

import java.util.StringJoiner;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClock {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private TopLamp topLamp;

    public BerlinClock(Object o, Object o1, int seconds) {
        this.topLamp = TopLamp.values()[seconds];
    }

    @Override
    public String toString() {
        return new StringJoiner(LINE_SEPARATOR)
                .add(topLamp.name())
                .toString();
    }
}

enum TopLamp {
    ON, OFF
}
