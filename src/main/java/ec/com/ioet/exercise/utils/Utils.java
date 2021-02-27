package ec.com.ioet.exercise.utils;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Utils {

    public static DayOfWeek getDayOfWeekWithAbbreviation(String abbreviation) {
        DayOfWeek dayOfWeek = null;
        switch (abbreviation) {
            case "MO": dayOfWeek = DayOfWeek.MONDAY; break;
            case "TU": dayOfWeek = DayOfWeek.TUESDAY; break;
            case "WE": dayOfWeek = DayOfWeek.WEDNESDAY; break;
            case "TH": dayOfWeek = DayOfWeek.THURSDAY; break;
            case "FR": dayOfWeek = DayOfWeek.FRIDAY; break;
            case "SA": dayOfWeek = DayOfWeek.SATURDAY; break;
            case "SU": dayOfWeek = DayOfWeek.SUNDAY; break;
        }
        return dayOfWeek;
    }

    public static LocalTime getTimeFromString(String input) {
        String[] values = input.split(":");
        return LocalTime.of(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }
}
