package ec.com.ioet.exercise.models;

import ec.com.ioet.exercise.database.AcmeDatabase;
import ec.com.ioet.exercise.database.AcmePayment;
import ec.com.ioet.exercise.exception.InvalidUserInputException;
import ec.com.ioet.exercise.utils.Constants;
import ec.com.ioet.exercise.utils.Utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public class WorkedHoursDetail {

    private final AcmeDatabase acmeDatabase = AcmeDatabase.getInstance();
    private DayOfWeek day;
    private LocalTime timeFrom;
    private LocalTime timeTo;

    public WorkedHoursDetail(DayOfWeek day, LocalTime timeFrom, LocalTime timeTo) {
        this.day = day;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public WorkedHoursDetail(String rawData) throws InvalidUserInputException {
        String dayAbbrev = rawData.substring(0,2);

        if (dayAbbrev == null) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No day abbreviation found");
        }

        this.day = Utils.getDayOfWeekWithAbbreviation(dayAbbrev);

        if (this.day == null) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No day found");
        }

        String rawTimeDetails = rawData.substring(2);
        if (rawTimeDetails == null) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No time ranges found");
        }

        String [] rawTimeDetailsArr = rawTimeDetails.split(Constants.MINUS);

        if (rawTimeDetailsArr.length != 2) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"Time ranges are not correct");
        }

        this.timeFrom = Utils.getTimeFromString(rawTimeDetailsArr[0]);
        this.timeTo = Utils.getTimeFromString(rawTimeDetailsArr[1]);
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    private int queryDatabase(DayOfWeek dayOfWeek, LocalTime paymentTime) {
        Optional<AcmePayment> recordPayment = acmeDatabase.dataList.stream().filter(item ->
                isDayBetween(dayOfWeek, item) && isTimeBetween(paymentTime, item)
        ).findAny();
        return recordPayment.isPresent() ? recordPayment.get().getPaymentAmount() : 0;
    }

    private boolean isDayBetween(DayOfWeek dayOfWeek, AcmePayment item) {
        return item.getDayOfWeekFrom().getValue() <= dayOfWeek.getValue() &&
                item.getDayOfWeekTo().getValue() >= dayOfWeek.getValue();
    }

    private boolean isTimeBetween(LocalTime paymentTime, AcmePayment item) {
        return (getDateTime(paymentTime).isAfter(getDateTime(item.getPaymentTimeFrom())) &&
                getDateTime(paymentTime).isBefore(getDateTime(item.getPaymentTimeTo()))) ||
                getDateTime(paymentTime).equals(getDateTime(item.getPaymentTimeFrom())) ||
                getDateTime(paymentTime).equals(getDateTime(item.getPaymentTimeTo()));
    }

    private LocalDateTime getDateTime(LocalTime time) {
        return LocalDateTime.of(2000,1,time.equals(LocalTime.of(0,0)) ? 2: 1,time.getHour(), time.getMinute());
    }

    private int getSubtotalPerHour(DayOfWeek day, LocalTime timeFrom) {
        LocalTime paymentTime = timeFrom;
        int paymentAmount = queryDatabase(day, paymentTime.plusMinutes(1));
        paymentTime = timeFrom.plusHours(1);
        if (paymentTime.equals(this.timeTo)) {
            return paymentAmount;
        } else {
            return paymentAmount + getSubtotalPerHour(day,paymentTime);
        }
    }

    public int getTotalPayment() {
        return getSubtotalPerHour(this.day, this.timeFrom);
    }


}
