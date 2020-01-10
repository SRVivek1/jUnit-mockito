/**
 * 
 */
package com.rpsoft.junit.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author vivek
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemToBeTested.class)
public class SystemToBeTestedMockConstructorTest {

	/**
	 * Rule to initialize mockito annotations.
	 */
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	ArrayList<String> arrayListMock;

	// @InjectMocks -- Not required as we don't need to mock the service and inject it.
	SystemToBeTested systemToBeTested = new SystemToBeTested(null);

	@Test
	public void testMockConstructorOfProvidedClass() throws Exception {

		// Instructing to Mock constructor on invocation and return mocked instance.
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(arrayListMock);
		given(arrayListMock.size()).willReturn(100);

		// Make business call
		int size = systemToBeTested.methodUsingAnArrayListConstructor();

		assertThat(size, is(100));
	}
}
