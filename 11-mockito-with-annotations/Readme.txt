11-mockito-with-annotations
==================================
	>> This project demonstrates annotation based Mockito test configuration.
	
	>> In order to enable Mockito annotation (such as @InjectMocks, @Mock, … ) – we need to do one of the following:
		>>> Call the method MockitoAnnotations.initMocks(this) to initialize annotated fields
		>>> Use the built-in runner @RunWith(MockitoJUnitRunner.class)
		>>> Use @Rule MockitoRule.
			--- public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	>> Some of the common useful annotations are;
		1. @Mock
			>> Mocks the annotated service interface/class automatically.
			
		2. @InjectMocks
			>> Inject the mocked service into the annotated business bean.
			
		3. @RunWith(MockitoJUnitRunner.class)
			>> Instructs jUnit to use Mockito Runner as we are using Mockito specific annotations.
			
		4. @Captor
			>> Create argument captor to capture arguments.