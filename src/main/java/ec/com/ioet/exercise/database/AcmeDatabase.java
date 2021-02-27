package ec.com.ioet.exercise.database;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AcmeDatabase {

    public List<AcmePayment> entries;
    private static AcmeDatabase instance;

    public AcmeDatabase() {
        entries = new ArrayList<>();
        entries.add(new AcmePayment(
                DayOfWeek.MONDAY,
                DayOfWeek.FRIDAY,
                LocalTime.of(0, 1),
                LocalTime.of(9, 0),
                25));
        entries.add(new AcmePayment(
                DayOfWeek.MONDAY,
                DayOfWeek.FRIDAY,
                LocalTime.of(9, 1),
                LocalTime.of(18, 0),
                15));
        entries.add(new AcmePayment(
                DayOfWeek.MONDAY,
                DayOfWeek.FRIDAY,
                LocalTime.of(18, 1),
                LocalTime.of(0, 0),
                20));
        entries.add(new AcmePayment(
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY,
                LocalTime.of(0, 1),
                LocalTime.of(9, 0),
                30));
        entries.add(new AcmePayment(
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY,
                LocalTime.of(9, 1),
                LocalTime.of(18, 0),
                20));
        entries.add(new AcmePayment(
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY,
                LocalTime.of(18, 1),
                LocalTime.of(0, 0),
                25));

    }

    public static AcmeDatabase getInstance() {
        if (instance == null) {
            instance = new AcmeDatabase();
        }
        return instance;
    }

}
