package ec.com.ioet.exercise.database;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AcmeDatabase {

    public List<AcmePayment> dataList;
    private static AcmeDatabase instance;

    public AcmeDatabase() {
        dataList = new ArrayList<>();
        dataList.add(new AcmePayment(
                DayOfWeek.MONDAY,
                DayOfWeek.FRIDAY,
                LocalTime.of(0, 1),
                LocalTime.of(9, 0),
                25));
        dataList.add(new AcmePayment(
                DayOfWeek.MONDAY,
                DayOfWeek.FRIDAY,
                LocalTime.of(9, 1),
                LocalTime.of(18, 0),
                15));
        dataList.add(new AcmePayment(
                DayOfWeek.MONDAY,
                DayOfWeek.FRIDAY,
                LocalTime.of(18, 1),
                LocalTime.of(0, 0),
                20));
        dataList.add(new AcmePayment(
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY,
                LocalTime.of(0, 1),
                LocalTime.of(9, 0),
                30));
        dataList.add(new AcmePayment(
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY,
                LocalTime.of(9, 1),
                LocalTime.of(18, 0),
                20));
        dataList.add(new AcmePayment(
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
