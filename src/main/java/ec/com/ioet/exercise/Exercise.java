package ec.com.ioet.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ec.com.ioet.exercise.exception.InvalidUserInputException;
import ec.com.ioet.exercise.models.Employee;
import ec.com.ioet.exercise.utils.Constants;

public class Exercise {

	public static List<String> readDataFile(String fileName) throws IOException,InvalidUserInputException {
		String pathName = System.getProperty(Constants.USER_HOME_KEY).concat(File.separator).concat(fileName);
		File file = new File(pathName);

		BufferedReader br = new BufferedReader(new FileReader(file));

		List<String> stringList = new ArrayList<>();
		String st;
		while ((st = br.readLine()) != null) {
			stringList.add(st);
		}
		br.close();
		
		if (stringList.size() < Constants.DATASET_MINIMAL_COUNT) {
			throw new InvalidUserInputException(Constants.USER_ERROR,"There must be at least five sets of data");
		}

		return stringList;
	}

	public static void main(String[] args) {

		try {
			List<String> stringList = Exercise.readDataFile(Constants.WORKED_HOURS_FILENAME);
			if (!stringList.isEmpty()) {
				for (String str : stringList) {
					Employee employee = new Employee(str);
					System.out.printf("The amount to pay %s is: %d USD", employee.getEmployeeName(),
							employee.getGrandTotalPayment());
					System.out.println();
				}
			}
		} catch (InvalidUserInputException e) {
			System.out.printf("An error ocurred in user input: %s", e.getMessage());
		} catch (IOException e1) {
			System.out.printf("Can't read file from disk");
		} catch (Exception e) {
			System.out.printf("An fatal error ocurred: %s", e.getMessage());
		}

	}

}