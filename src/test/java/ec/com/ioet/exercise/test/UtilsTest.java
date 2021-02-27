package ec.com.ioet.exercise.test;

import ec.com.ioet.exercise.utils.Utils;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void shouldGetDayOfWeekWithAbbreviation() {
        DayOfWeek dayOfWeekWithAbbreviation = Utils.getDayOfWeekWithAbbreviation("TH");
        assertEquals(DayOfWeek.THURSDAY, dayOfWeekWithAbbreviation);
    }
    @Test
    public void shouldGetTimeFromString() {
        LocalTime timeFromString = Utils.getTimeFromString("10:00");
        assertEquals(LocalTime.of(10,0), timeFromString);
    }
}
