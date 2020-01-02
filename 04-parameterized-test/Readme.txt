Topics
---------------
This project demonstrates the use of below mention jUnit annotations.

	1. @RunWith(Parameterized.class)
		-- This defines that the class is using parameterized test conditions.
		-- One class can have only one type of test condition.
		--
	
	2. @Parameters
		-- This defines a method which will return a collection of test conditions.
		-- Each condition will be in pair of {"input", "expected"}.
		-- A constructor and 2 instance variables are required to initialize and hold the data.
		
	3. @Test
		--Inside @Test method make use of the instance variables to run the test.
		