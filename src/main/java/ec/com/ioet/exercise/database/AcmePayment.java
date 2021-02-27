package ec.com.ioet.exercise.database;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class AcmePayment {
    private DayOfWeek dayOfWeekFrom;
    private DayOfWeek dayOfWeekTo;
    private LocalTime paymentTimeFrom;
    private LocalTime paymentTimeTo;
    private Integer paymentAmount;

    public DayOfWeek getDayOfWeekFrom() {
        return dayOfWeekFrom;
    }

    public DayOfWeek getDayOfWeekTo() {
        return dayOfWeekTo;
    }

    public LocalTime getPaymentTimeFrom() {
        return paymentTimeFrom;
    }

    public LocalTime getPaymentTimeTo() {
        return paymentTimeTo;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public AcmePayment(DayOfWeek dayOfWeekFrom, DayOfWeek dayOfWeekTo, LocalTime paymentTimeFrom, LocalTime paymentTimeTo, Integer payAmount) {
        this.dayOfWeekFrom = dayOfWeekFrom;
        this.dayOfWeekTo = dayOfWeekTo;
        this.paymentAmount = payAmount;
        this.paymentTimeFrom = paymentTimeFrom;
        this.paymentTimeTo = paymentTimeTo;
    }

}