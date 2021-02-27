According to the given exercise, the current solution use:

-Singleton pattern, for Payment detail database info
-Master-detail based structure, to record employee info and worked hours detail.

The solution runs in a console mode.

Internally, the solution constructs a new object from class Employee, which in turn constructs worked hours detail objects list using WorkedHours class.

Calculations of payment grand total are done from getGrandTotalPayment method from Employee class, 
which iterates WorkedHours based objects list and execute getTotalPayment method in order to calculate the amount for each worked hours object.

In order to run the solution, firstable, you must generate jar file, executing the following command into the solution's folder:

gradle jar

then, into <solution_folder>\build\libs folder, you can run the following command:

java -jar IoetExercise-1.0-SNAPSHOT.jar

The application requests to the user a text input.

When the user summits the input, the application returns a message with the calculations.

The solution uses TDD and you can run unit tests from AcmeTest class
