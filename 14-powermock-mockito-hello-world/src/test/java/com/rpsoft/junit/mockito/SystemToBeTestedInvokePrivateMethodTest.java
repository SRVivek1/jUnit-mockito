/**
 * 
 */
package com.rpsoft.junit.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.rpsoft.junit.mockito.service.RemoteService;

/**
 * @author vivek
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemToBeTested.class)
public class SystemToBeTestedInvokePrivateMethodTest {

	/**
	 * Rule to initialize mockito annotations.
	 */
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	RemoteService remoteServiceMock;

	@InjectMocks
	@Spy
	SystemToBeTested systemToBeTested;

	@Test
	public void testInvokingPrivateMethodOfAnotherClass() throws Exception {

		// Mock remote service method with dummy data.
		final List<Integer> dummyStats = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		given(remoteServiceMock.retrieveAllStats()).willReturn(dummyStats);

		
		// Invoking private method with empty list so that it will make call to
		// RemoteService for data.
		List<Integer> emptyList = new ArrayList<>();
		long sum = Whitebox.invokeMethod(systemToBeTested, "calculateSumOfStats", emptyList);

		
		// Verify call to private method
		PowerMockito.verifyPrivate(systemToBeTested).invoke("calculateSumOfStats", emptyList);

		
		// Verify Mocked service call
		verify(remoteServiceMock, atMost(1)).retrieveAllStats();
		
		// Assert the result.
		assertThat(sum, is(15L));

	}
}
