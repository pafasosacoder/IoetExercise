package ec.com.ioet.exercise;

import ec.com.ioet.exercise.models.Employee;
import ec.com.ioet.exercise.exception.InvalidUserInputException;

import java.util.Scanner;

public class Exercise {

    public static void main (String [] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter values: ");
        String userInput= sc.nextLine();
        userInput = userInput.toUpperCase();

        try {
            Employee employee = new Employee(userInput);
            System.out.printf("The amount to pay %s is: %d USD",employee.getEmployeeName(),employee.getGrandTotalPayment());
        } catch (InvalidUserInputException e) {
            System.out.printf("An error ocurred in user input: %s",e.getMessage());
        } catch (Exception e) {
            System.out.printf("An fatal error ocurred: %s",e.getMessage());
        }

    }

}