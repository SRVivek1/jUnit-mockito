Topics
---------------
This project demonstrates the use of below mention jUnit annotations.

	1. @Before
		>> Executes before every @Test method execution.
	
	2. @After
		>> Executes after every @Test method execution.

	3. @BeforeClass
		>> Must be static.
		>> Executes only once when class is initialized for running tests.
		>> Used for one time operations which need to be carried out 
		   before running setup or test methods.
		   e.g. Database connections.

	4. @AfterClass
		>> Must be static.
		>> Executes only after running last @Test & @After methods.
		>> Used for releasing resource, e.g. Database connections.