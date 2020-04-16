Venn DiagramFX Version: 3.0.0

This release:
	- Sees the final version of the product

This release includes:
	- Save/Load Function
	- Redo/Undo Function
	- Reset to default values
	- Refined Focus System
	- Subtitles are not change with respect to their circles
	- Scaling circles to always have an intersection

CAN'T RUN THE JAR FILE
	- The circleCI shows no error in publishing releases on github.
	- This is a common issue when it comes to releasing JavaFX programs using gradle and circleCI.
	Our team was not able to solve the problem. If you are having issues running the jar file
	you can use an IDE to run the program.
		- Ensure that your Java JDK version is version 13 or above
		- Ensure that your JavaFX version is version 11 or above
		- In the VM arguments of the run configurations add the follow argument:

		 [--module-path "PATH_TO_JAVAFX_LIBRARY" --add-modules=ALL-MODULE-PATH]	


		- Without the square brackets, and change the "PATH_TO_JAVAFX_LIBRARY" to
		the file path of your javaFX library, ensure that there are double 
		quotations in the file and the square brackets are not included.
		- From there run the Main class as a java application.
