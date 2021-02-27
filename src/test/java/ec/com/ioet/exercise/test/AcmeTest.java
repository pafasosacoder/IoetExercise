package ec.com.ioet.exercise.test;

import ec.com.ioet.exercise.models.Employee;
import ec.com.ioet.exercise.exception.InvalidUserInputException;
import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.assertEquals;

public class AcmeTest {

    @Test(expected = InvalidUserInputException.class)
    public void shouldValidateInputWhenNoInputData () throws InvalidUserInputException {
        Employee employee = new Employee("");
    }

    @Test(expected = InvalidUserInputException.class)
    public void shouldValidateInputWhenNoPaymentDetail () throws InvalidUserInputException {
        Employee employee = new Employee("RENE=");
    }

    @Test(expected = InvalidUserInputException.class)
    public void shouldValidateInputWhenNoDayOnPaymentDetail () throws InvalidUserInputException {
        Employee employee = new Employee("RENE=10:00-12:00");
    }

    @Test
    public void shouldValidateInput() throws InvalidUserInputException {
        Employee employee = new Employee("RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");
        assertEquals("RENE",employee.getEmployeeName());
        assertEquals(5, employee.getWorkedHoursDetailsList().size());
        assertEquals(DayOfWeek.MONDAY, employee.getWorkedHoursDetailsList().get(0).getDay());
        assertEquals(DayOfWeek.TUESDAY, employee.getWorkedHoursDetailsList().get(1).getDay());
        assertEquals(DayOfWeek.THURSDAY, employee.getWorkedHoursDetailsList().get(2).getDay());
        assertEquals(DayOfWeek.SATURDAY, employee.getWorkedHoursDetailsList().get(3).getDay());
        assertEquals(DayOfWeek.SUNDAY, employee.getWorkedHoursDetailsList().get(4).getDay());
    }

    @Test
    public void shouldCalculatePaymentGrandTotalFoFullCase1() throws InvalidUserInputException {

        Employee employeeDto = new Employee("RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");

        assertEquals(215, employeeDto.getGrandTotalPayment());

    }

    @Test
    public void shouldCalculatePaymentGrandTotalFoFullCase2() throws InvalidUserInputException {

        Employee employeeDto = new Employee("ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");

        assertEquals(85, employeeDto.getGrandTotalPayment());

    }

}
