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

        BerlinClock berlinClock = new BerlinClock(0, 0, seconds);

        Assert.assertThat("Top lamp should be ON", TopLamp.ON.name(), is(getLine(berlinClock.toString(), 1)));
    }

    private static String getLine(String text, int line) {
        return text.split(BerlinClock.LINE_SEPARATOR)[line-1];
    }

    @Test
    public void topLampShouldBeOffWhenSecondsIsOdd() throws Exception {
        int seconds = ONE_SECOND;

        BerlinClock berlinClock = new BerlinClock(0, 0, seconds);

        Assert.assertThat("Top lamp should be OFF", TopLamp.OFF.name(), is(getLine(berlinClock.toString(), 1)));
    }

    @Test
    public void firstLineShouldDenoteFiveFullHourCounter() throws Exception {
        int hour = 10;

        BerlinClock berlinClock = new BerlinClock(hour, 0, SECOND_ZERO);

        Assert.assertThat("First line Should be 2 for 10am", "2", is(getLine(berlinClock.toString(), 2)));
    }

    @Test
    public void secondLineShouldDenoteFullHourFields() throws Exception {
        int hour = 22;

        BerlinClock berlinClock = new BerlinClock(hour, 0, ONE_SECOND);

        Assert.assertThat("First line should be 4 for 9pm", "4", is(getLine(berlinClock.toString(), 2)));
        Assert.assertThat("Second line should be 2 for 9pm", "2", is(getLine(berlinClock.toString(), 3)));
    }

    @Test
    public void thirdLineShouldDenoteFiveFullMinuteCounter() throws Exception {
        int minutes = 43;

        BerlinClock berlinClock = new BerlinClock(0, minutes, SECOND_ZERO);

        Assert.assertThat("Third line should be 8 for 43 seconds", "8", is(getLine(berlinClock.toString(), 4)));
    }

    @Test
    public void fourthLineShouldDenoteFullMinuteFieldsCounter() throws Exception {
        int minutes = 43;

        BerlinClock berlinClock = new BerlinClock(0, minutes, SECOND_ZERO);

        Assert.assertThat("Third line should be 8 for 43 seconds", "8", is(getLine(berlinClock.toString(), 4)));
        Assert.assertThat("Fourth line should be 3 for 43 seconds", "3", is(getLine(berlinClock.toString(), 5)));
    }
}
