package ec.com.ioet.exercise.models;

import ec.com.ioet.exercise.exception.InvalidUserInputException;
import ec.com.ioet.exercise.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private String employeeName;
    private List<WorkedHoursDetail> workedHoursDetailsList;

    public Employee(String employeeName, List<WorkedHoursDetail> workedHoursDetailsList) {
        this.employeeName = employeeName;
        this.workedHoursDetailsList = workedHoursDetailsList;
    }

    public Employee(String rawData) throws InvalidUserInputException  {
        validateUserInput(rawData);
        String[] userInputArr = getEmployeeData(rawData);

        String employeeName = userInputArr[0];
        String rawWorkedHoursDetail = userInputArr[1];

        if (!(employeeName != null && !employeeName.isBlank() && !employeeName.isEmpty())) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No employee name found");
        }
        if (!(rawWorkedHoursDetail != null && !rawWorkedHoursDetail.isEmpty())) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No payment detail found");
        }

        this.employeeName = employeeName;
        String[] arrRawWorkedHours = rawWorkedHoursDetail.split(Constants.COMMA);

        loadWorkedHoursDetail(arrRawWorkedHours);

    }

    private void loadWorkedHoursDetail(String[] arrRawWorkedHours) throws InvalidUserInputException {
        this.workedHoursDetailsList = new ArrayList<>();
        for (String rawWorkedHoursData: arrRawWorkedHours) {
            workedHoursDetailsList.add(new WorkedHoursDetail(rawWorkedHoursData));
        }
    }

    private void validateUserInput(String userInput) throws InvalidUserInputException {
        if (!(userInput != null && !userInput.isBlank() && !userInput.isEmpty())) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"User input must have data");
        }
    }

    private String[] getEmployeeData(String rawData) throws InvalidUserInputException {
        String[] userInputArr = rawData.split(Constants.EQUAL);

        if (userInputArr.length != 2) {
            throw new InvalidUserInputException(Constants.USER_ERROR,"No payment detail found");
        }
        return userInputArr;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public List<WorkedHoursDetail> getWorkedHoursDetailsList() {
        return workedHoursDetailsList;
    }

    public int getGrandTotalPayment() {
        return this.workedHoursDetailsList.stream()
                .collect(Collectors.summingInt(WorkedHoursDetail::getTotalPayment));
    }
}
