package ec.com.ioet.exercise.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ec.com.ioet.exercise.Exercise;
import ec.com.ioet.exercise.exception.InvalidUserInputException;
import ec.com.ioet.exercise.utils.Constants;

public class ExcerciseTest {
		
	  public void createFile(int countLines) {
			String pathName = System.getProperty(Constants.USER_HOME_KEY).concat(File.separator).concat(Constants.WORKED_HOURS_FILENAME_TEST);
		    try {
		      FileWriter writer = new FileWriter(pathName);
		      
		      for (int seq = 1; seq <= countLines; seq++) {
			      if (seq % 2 != 0) {
			    	  writer.write("RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");
			      } else {
				      writer.write("ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
			      }
				  writer.write("\r\n");
		      }

		      writer.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
	  
	@Test(expected = InvalidUserInputException.class)
	public void shouldValidateFileLengthNotEnoughtAndGiveInvalidUserInputException() throws IOException, InvalidUserInputException  {
		createFile(3);

		Exercise.readDataFile(Constants.WORKED_HOURS_FILENAME_TEST);
	}

	@Test
	public void shouldValidateRightFileLengthAndRunOk() throws IOException, InvalidUserInputException  {
		createFile(5);

		List<String> result = Exercise.readDataFile(Constants.WORKED_HOURS_FILENAME_TEST);

        assertEquals(5, result.size());
	}

	@Test
	public void shouldValidateFileLengthGreaterThanLimitAndRunOk() throws IOException, InvalidUserInputException  {
		createFile(7);

		List<String> result = Exercise.readDataFile(Constants.WORKED_HOURS_FILENAME_TEST);

        assertEquals(7, result.size());
}
	
}
