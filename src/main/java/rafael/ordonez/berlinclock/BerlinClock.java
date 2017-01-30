package rafael.ordonez.berlinclock;

import java.util.StringJoiner;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClock {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public BerlinClock(Object o, Object o1, int seconds) {
    }

    @Override
    public String toString() {
        return new StringJoiner(LINE_SEPARATOR)
                .add("ON")
                .toString();
    }
}
