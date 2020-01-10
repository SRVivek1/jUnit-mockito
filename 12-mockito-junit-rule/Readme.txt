12-mockito-junit-rule
================================

	1. jUnit Rules
	--------------------------
		@Rule
		-------------------
			public MockitoRule m = MockitoJUnit.rule();
			
			>> Instead of @RunWith(...) annotation we can/should prefer to use @Rule annotation. 
			
			>> Initializes mocks annotated with org.mockito.Mock,so that explicit usage of org.mockito. 
				MockitoAnnotations.initMocks(Object) is not necessary.Mocks are initialized before each test method. 
			
			>> validates framework usage after each test method. See javadoc for org.mockito.Mockito.validateMockitoUsage(). 
			
			>> Rule will be executed once per Test method.

		
		@ClassRule
		--------------------
			>> Same funtionality as @Rule, except that for @ClassRule it will be invoked only once. 



	2. jUnit predefined rules
	--------------------------------
		1. public TestName testName = new TestName();	
	 	-----------------------------------------------------
	 		>> This rule helps get the name of currently executing test case.


		2. public TemporaryFolder temporaryFolder = new TemporaryFolder();
		------------------------------------------------------------------------	
			>> This rule helps in creating temporary folders and files.


		3. public ExpectedException expectedException = ExpectedException.none();
		--------------------------------------------------------------------------------
			>> This rule helps verify that particular test case throws an expected exception or not.


		4. public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
		-------------------------------------------------------------------------------
			>> The Timeout Rule applies the same timeout to all test methods in a class.


		5. public ErrorCollector errorCollector = new ErrorCollector();
		--------------------------------------------------------------------------------
			>> The ErrorCollector rule allows execution of a test to continue after the first problem is found.


		6. public Verifier verifier = new Verifier() {
				@Override
				protected void verify() throws Throwable {
					System.out.println("Verifier#Verify : " + testName.getMethodName());
				};
			}; 
		--------------------------------------------------------------------------
			>> Verifier is a base class for Rules like ErrorCollector, which can turn otherwise passing 
				test methods into failing tests if a verification check is failed.


		7. ExternalResource externalResource = new ExternalResource {

				@Override
				protected void before() throws Throwable {
			
					// setup database connection
					System.out.println("*********Database connection initialized successfully.");
				};
			
				@Override
				protected void after() {
			
					// Release resources
					System.out.println("*********Database connection closed.");
				};
			}
		----------------------------------------------------------------------
			>> Behaves same as @Before & @After annotations, idle for setting one time resources such as Database connection etc.
	
	
	
	3. Custom jUnit Rules
	---------------------------
		>> A jUnit Rule is an instance of 'TestRule' interface.
		
		>> Check  MyCustomJUnitRule Rule class for details.
		
	
	4. RuleChain
	---------------------------
		>> The RuleChain rule allows ordering of TestRules. You create a RuleChain with 
			outerRule(TestRule) and subsequent calls of around(TestRule).
			
			
			