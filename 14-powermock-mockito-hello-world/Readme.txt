14-powermock-mockito-hello-world
============================================

	1. Power-Mock API's
	-----------------------------
		PowerMock consists of two extension API's.

		One for EasyMock and one for Mockito. To use PowerMock you need to depend on one of these API's as well as a test framework.
		
		Currently PowerMock supports JUnit and TestNG. There are three different JUnit test executors available, one for JUnit 
		4.4-4.12, one for JUnit 4.0-4.3. The test executor for JUnit 3 is not avaliable since PowerMock 2.0.

		There's one test executor for TestNG which requires version 5.11+ depending on which version of PowerMock you use.
	
		
	2. Dependencies
	-----------------------------
		<properties>
		    <powermock.version>2.0.2</powermock.version>
		</properties>
		<dependencies>
		   <dependency>
		      <groupId>org.powermock</groupId>
		      <artifactId>powermock-module-junit4</artifactId>
		      <version>${powermock.version}</version>
		      <scope>test</scope>
		   </dependency>
		   <dependency>
		      <groupId>org.powermock</groupId>
		      <artifactId>powermock-api-mockito</artifactId>
		      <version>${powermock.version}</version>
		      <scope>test</scope>
		   </dependency>
		</dependencies>
		
	
	3. Writing First PowerMock Test
	-----------------------------------
		>> Step-1 : @RunWith(PowerMockRunner.class)
		------------------------------------
			--- Tells jUnit to use PowerMockRunner instead of default jUnit Runner.
			
			
		>> Step-2 : @PrepareForTest(UtilityService.class)
		-------------------------------------------
			--- This annotation tells PowerMock to prepare certain classes for testing.Classes needed to be defined using this 
				annotation are typically those that needs to be byte-code manipulated. This includes final classes, classes with final, 
				private, static or native methods that should be mocked and also classes that should be return a mock object upon 
				instantiation. 
				
				
		>> Step-3 : PowerMockito.mockStatic(UtilityService.class);
		------------------------------------------------------------
			-- This enables static mocking for all methods of a class.
			
			
		>> Step-4 : given(UtilityService.staticMethodDemo(anyLong())).willReturn(200);
		--------------------------------------------------------------------------------
			-- Use Mockito way to mock the service methods.		
			
	
	4. Verify calls to mocked static methods
	-----------------------------------------------
		
		>> Code:
		-----------------
			Single verification
			--------------------------------
				PowerMockito.verifyStatic(atLeastOnce());
				UtilityService.staticMethodDemo(15);
		
			Multiple verification
			--------------------------------
				// #1
				PowerMockito.verifyStatic(atLeastOnce());
				UtilityService.staticMethodDemo(15);
				
				// #2
				PowerMockito.verifyStatic(atLeastOnce());
				UtilityService.staticMethodDemo(20);
				
				
			-- To verify calls to stubbed static method, in power mockito we always need to use both statements.
			-- PowerMockito.verifyStatic(atLeastOnce()) - reads only the immediate next statement and verifies it.
			

		
	5. Invoke private method
	--------------------------------
		>> PowerMockito has provided utility class Whitebox, which uses reflection to invoke private members of specified class.
		
		Whitebox
		------------
			-- Various utilities for accessing internals of a class. Basically a simplified reflection utility intended for tests.
			
		Code:
		--------
			--- Whitebox.invokeMethod(systemToBeTested, "calculateSumOfStats", dummyStats);
	

	6. Verify Private method invocation
	---------------------------------------
		>> To verify the invocation we have to make use of @Spy annotation.
			--- Check 'SystemToBeTestedInvokePrivateMethodTest' class for more details.
			
			
	7. Mock Constructor
	---------------------------------------
	
		>> Mocking constructor doesn't mean to mock the constructor of the business class in test, but it helps to mock the 
			constructor of the any other dependent class which is getting used in business class.
			
		>> Here in below example we are mocking ArrayList class constructor which is getting used by our business class.
	
		>> Step-1 : @PrepareForTest(SystemToBeTested.class)
		----------------------------------------------
			--- Preparing the class for mocking constructor.
			
			
		>> Step-2 : @Mock 
		   ArrayList<String> arrayListMock;
		----------------------------------------------------
			--- Create a mocked instance to be returned when someone invokes the constructor.
			
			
		>> Step-3 : PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(arrayListMock); 
		------------------------------------------------------------------------------------------------------
			--- Instructing to Mock constructor on invocation and return mocked instance.
		
		
		>> Step-4 : Perform normal mocking, assert and verify calls
		----------------------------------------------------------------
			// Customizing default mocked behavior.
			given(arrayListMock.size()).willReturn(100);

			// Make business call
			int size = systemToBeTested.methodUsingAnArrayListConstructor();

			// Asserting value
			assertThat(size, is(100));
		
		
		
		
	Other References
	---------------------------
		FIRST :-	 https://pragprog.com/magazines/2012-01/unit-tests-are-first
		Patterns :-  http://xunitpatterns.com
					 https://github.com/mockito/mockito/wiki/How-to-write-good-tests