package rafael.ordonez.berlinclock;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClockTest {

    public static final int SECOND_ZERO = 0;
    private static final int ONE_SECOND = 1;

    @Test
    public void topLampShouldBeOnWhenSecondsIsEven() throws Exception {
        int seconds = SECOND_ZERO;

        BerlinClock berlinClock = new BerlinClock(0, null, seconds);

        Assert.assertThat("Top lamp should be ON", TopLamp.ON.name(), is(getLine(berlinClock.toString(), 1)));
    }

    private static String getLine(String text, int line) {
        return text.split(BerlinClock.LINE_SEPARATOR)[line-1];
    }

    @Test
    public void topLampShouldBeOffWhenSecondsIsOdd() throws Exception {
        int seconds = ONE_SECOND;

        BerlinClock berlinClock = new BerlinClock(0, null, seconds);

        Assert.assertThat("Top lamp should be OFF", TopLamp.OFF.name(), is(getLine(berlinClock.toString(), 1)));
    }

    @Test
    public void firstLineShouldDenoteFiveFullHourCounter() throws Exception {
        int hour = 10;

        BerlinClock berlinClock = new BerlinClock(hour, null, SECOND_ZERO);

        Assert.assertThat("Should be 2 for 10am", "2", is(getLine(berlinClock.toString(), 2)));
    }


}
