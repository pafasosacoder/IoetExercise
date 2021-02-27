package ec.com.ioet.exercise.models;

import ec.com.ioet.exercise.exception.InvalidUserInputException;
import ec.com.ioet.exercise.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private String employeeName;
    private List<WorkedHoursDetail> paymentDetailDtoList;

    public Employee(String employeeName, List<WorkedHoursDetail> paymentDetailDtoList) {
        this.employeeName = employeeName;
        this.paymentDetailDtoList = paymentDetailDtoList;
    }

    public Employee(String rawData) throws InvalidUserInputException  {
        validateUserInput(rawData);
        String[] userInputArr = getEmployeePaymentData(rawData);

        String employeeName = userInputArr[0];
        String rawPaymentDetails = userInputArr[1];

        if (!(employeeName != null && !employeeName.isBlank() && !employeeName.isEmpty())) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No employee name found");
        }
        if (!(rawPaymentDetails != null && !rawPaymentDetails.isEmpty())) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No payment detail found");
        }

        this.employeeName = employeeName;
        String[] arrRawPaymentDetails = rawPaymentDetails.split(Constants.COMMA);

        loadPaymentDetails(arrRawPaymentDetails);

    }

    private void loadPaymentDetails(String[] arrRawPaymentDetails) throws InvalidUserInputException {
        this.paymentDetailDtoList = new ArrayList<>();
        for (String rawPaymentData: arrRawPaymentDetails) {
            paymentDetailDtoList.add(new WorkedHoursDetail(rawPaymentData));
        }
    }

    private void validateUserInput(String userInput) throws InvalidUserInputException {
        if (!(userInput != null && !userInput.isBlank() && !userInput.isEmpty())) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"User input must have data");
        }
    }

    private String[] getEmployeePaymentData(String rawData) throws InvalidUserInputException {
        String[] userInputArr = rawData.split(Constants.EQUAL);

        if (userInputArr.length != 2) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No payment detail found");
        }
        return userInputArr;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public List<WorkedHoursDetail> getPaymentDetailDtoList() {
        return paymentDetailDtoList;
    }

    public int getGrandTotalPayment() {
        return this.paymentDetailDtoList.stream()
                .collect(Collectors.summingInt(WorkedHoursDetail::getTotalPayment));
    }
}
