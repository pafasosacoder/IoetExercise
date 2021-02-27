OVERVIEW
-------
This is a console mode java project that gives solution to the problem of calculate total payment of a employee acording to the given worked hours detail.


ARCHITECTURE
------------
This is a console mode solution that uses Singleton pattern for database info, and a master-detail object oriented structure to load and doing calculations, uses TDD to validate distinct test cases and validates user input to reduce common errors.

The solution guarantees the best performance and good practices in design and clean codification.


APPROACH AND METHODOLOGY
------------------------
Along development, TDD was very used and the quality is assured by several test cases which consider the most common issues in the solution operation.

Project structure is based on the common easy-understand structure of a Java project nowadays.

The solution receives the user input, then, the algorithm extracts each data and constructs a Master-detail object oriented structure for the employee and
worked hours detail, then, when the main program request the grand total of worked hours, each worked hours detail can calculate its own payment amount according its conditions, and these information is summarized by a method in the employee class in order to return it to the user thru console output.

Database instantiates only one time and remains in memory thorough the entire process, reducing memory consumption and improves performance.


INSTRUCTIONS
------------
The solution needs Java 8 or further versions to run properly.

In order to run the solution, firstable, you must generate jar file, executing the following command into the solution's folder:

      gradle jar

then, into <solution_folder>\build\libs folder, you can run the following command:

      java -jar IoetExercise-1.0-SNAPSHOT.jar

The application requests to the user a text input.

When the user summits the input, the application returns a message with the calculations.