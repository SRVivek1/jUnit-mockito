/**
 * 
 */
package com.rpsoft.junit.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.rpsoft.junit.mockito.service.RemoteService;
import com.rpsoft.junit.mockito.utility.UtilityService;

/**
 * @author vivek
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityService.class)
public class SystemToBeTestedMockStaticMethodTest {

	/**
	 * Rule to initialize mockito annotations.
	 */
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	RemoteService remoteServiceMock;

	@InjectMocks
	SystemToBeTested systemToBeTested;

	@Test
	public void testMethodInternallyCallingStaticMethod() {

		// Test data
		final List<Integer> dummyStats = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });

		// Given
		given(remoteServiceMock.retrieveAllStats()).willReturn(dummyStats);

		// Mocking static method of UtilityService class.
		PowerMockito.mockStatic(UtilityService.class);
		// 15 is the sum of numbers provided in stat.
		given(UtilityService.staticMethodDemo(15)).willReturn(200);

		// When
		long sum = systemToBeTested.methodInternallyCallingStaticMethod();

		// Start : Verify the static method invocation
		PowerMockito.verifyStatic(atLeastOnce());
		// 15 is the sum of numbers provided in stat.
		UtilityService.staticMethodDemo(15);
		
		// End : Verify the static method invocation
		
		
		// Then, Suffixing 'L' as the returned value is of long type.
		assertThat(sum, is(200L));
	}
}
