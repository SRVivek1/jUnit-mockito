13-mockito-spy
==================================
	Spy
	------------
		>> Creates a spy of the real object. The spy calls real methods unless they are stubbed. 
		>> Real spies should be used carefully and occasionally, for example when dealing with legacy code. 
		
		>> The field annotated with @Spy can be initialized by Mockito if a zero argument constructor can be found in the type 
			(even private). But Mockito cannot instantiate inner classes, local classes,abstract classes and interfaces. The field 
			annotated with @Spy can be initialized explicitly at declaration point. Alternatively, if you don't provide the instance 
			Mockito will try to find zero argument constructor (even private)and create an instance for you. But Mockito cannot 
			instantiate inner classes, local classes, abstract classes and interfaces. 
		
	Mock vs. Spy in Mockito
	---------------------------------
		>> Now – let's discuss the difference between Mock and Spy in Mockito – not the theoretical differences 
			between the two concepts, just how they differ within Mockito itself.

			
			Mock -- When Mockito creates a mock – it does so from the Class of a Type, not from an actual instance. The mock 
					simply creates a bare-bones shell instance of the Class, entirely instrumented to track interactions with it.

			Spy --  On the other hand, the spy will wrap an existing instance. It will still behave in the same way as the normal 
					instance – the only difference is that it will also be instrumented to track all the interactions with it.