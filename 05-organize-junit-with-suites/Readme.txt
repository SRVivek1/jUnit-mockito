Topics
---------------
This project demonstrates the use of below mention jUnit annotations.

	1. @RunWith(Suite.class)
		-- Create a new class which will represent the test suite.
		
	2. @SuiteClasses({ ArrayUtilsTest.class, ....... })
		-- Provide above annotation with a list of classes of Test class 
			which we need to run as part of this suite.
			
	4. Configure Maven Surefire plugin and configure the test suites need to run with maven build.
		-- Check POM.xml for reference.
		
		