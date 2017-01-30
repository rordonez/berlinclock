package rafael.ordonez.berlinclock;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClockTest {

    public static final int SECOND_ZERO = 0;

    @Test
    public void topLampShouldBeOnWhenSecondsIsEven() throws Exception {
        int seconds = SECOND_ZERO;

        BerlinClock berlinClock = new BerlinClock(null, null, seconds);

        Assert.assertThat("Top lamp should be ON", "ON", is(berlinClock.toString()));
    }
}
