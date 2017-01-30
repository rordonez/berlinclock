package rafael.ordonez.berlinclock;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by rafa on 30/1/17.
 */
public class BerlinClockTest {

    public static final int EVEN_SECOND = 0;
    private static final int ODD_SECOND = 1;

    @Test
    public void topLampShouldBeOnWhenSecondsIsEven() throws Exception {
        int seconds = EVEN_SECOND;

        BerlinClock berlinClock = new BerlinClock(0, 0, seconds);

        Assert.assertThat("Top lamp should be ON", "(YELLOW ON)", is(getLine(berlinClock.toString(), 1)));
    }

    private static String getLine(String text, int line) {
        return text.split(BerlinClock.LINE_SEPARATOR)[line-1];
    }

    @Test
    public void topLampShouldBeOffWhenSecondsIsOdd() throws Exception {
        int seconds = ODD_SECOND;

        BerlinClock berlinClock = new BerlinClock(0, 0, seconds);

        Assert.assertThat("Top lamp should be OFF", "(YELLOW OFF)", is(getLine(berlinClock.toString(), 1)));
    }

    @Test
    public void firstLineShouldDenoteFiveFullHourCounter() throws Exception {
        int hour = 10;

        BerlinClock berlinClock = new BerlinClock(hour, 0, EVEN_SECOND);

        Assert.assertThat("First line Should be 2 for 10am", "(RED ON)(RED ON)(RED OFF)(RED OFF)", is(getLine(berlinClock.toString(), 2)));
    }

    @Test
    public void secondLineShouldDenoteFullHourFields() throws Exception {
        int hour = 22;

        BerlinClock berlinClock = new BerlinClock(hour, 0, ODD_SECOND);

        Assert.assertThat("First line should be 4 for 9pm", "(RED ON)(RED ON)(RED ON)(RED ON)", is(getLine(berlinClock.toString(), 2)));
        Assert.assertThat("Second line should be 2 for 9pm", "(RED ON)(RED ON)(RED OFF)(RED OFF)", is(getLine(berlinClock.toString(), 3)));
    }

    @Test
    public void thirdLineShouldDenoteFiveFullMinuteCounter() throws Exception {
        int minutes = 43;

        BerlinClock berlinClock = new BerlinClock(0, minutes, EVEN_SECOND);

        Assert.assertThat("Third line should be 8 for 43 seconds", "(YELLOW ON)(YELLOW ON)(RED ON)(YELLOW ON)(YELLOW ON)(RED ON)(YELLOW ON)(YELLOW ON)(RED OFF)(YELLOW OFF)(YELLOW OFF)", is(getLine(berlinClock.toString(), 4)));
    }

    @Test
    public void fourthLineShouldDenoteFullMinuteFieldsCounter() throws Exception {
        int minutes = 43;

        BerlinClock berlinClock = new BerlinClock(0, minutes, EVEN_SECOND);

        Assert.assertThat("Third line should be 8 for 43 seconds", "(YELLOW ON)(YELLOW ON)(RED ON)(YELLOW ON)(YELLOW ON)(RED ON)(YELLOW ON)(YELLOW ON)(RED OFF)(YELLOW OFF)(YELLOW OFF)", is(getLine(berlinClock.toString(), 4)));
        Assert.assertThat("Fourth line should be 3 for 43 seconds", "(YELLOW ON)(YELLOW ON)(YELLOW ON)(YELLOW OFF)", is(getLine(berlinClock.toString(), 5)));
    }
}
