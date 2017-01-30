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

        BerlinClock berlinClock = new BerlinClock(null, null, seconds);

        Assert.assertThat("Top lamp should be ON", TopLamp.ON.name(), is(berlinClock.toString()));
    }

    @Test
    public void topLampShouldBeOffWhenSecondIsOdd() throws Exception {
        int seconds = ONE_SECOND;

        BerlinClock berlinClock = new BerlinClock(null, null, seconds);

        Assert.assertThat("Top lamp should be OFF", TopLamp.OFF.name(), is(berlinClock.toString()));
    }
}
