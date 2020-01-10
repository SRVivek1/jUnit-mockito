/**
 * 
 */
package com.rpsoft.junit.mockito;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.beans.HasProperty;
import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.hamcrest.collection.IsArray;
import org.hamcrest.collection.IsArrayContaining;
import org.hamcrest.collection.IsArrayWithSize;
import org.hamcrest.core.IsNot;
import org.junit.Test;

/**
 * @author vivek
 *
 */
public class TestHamcrestLibraryFunctions {

	@SuppressWarnings("unchecked")
	@Test
	public void testHamcrestMatcherClass_basicMethods() {

		// Lets assume we have got a list of records as below
		final List<Integer> scores = Arrays.asList(new Integer[] { 23, 44, 105, 68, 84 });

		// Assert size
		assertThat(scores, hasSize(5));

		// Assert on Items
		assertThat(scores, hasItems(23, 84));

		assertThat(scores, everyItem(greaterThan(15)));
		assertThat(scores, everyItem(is(greaterThan(15))));

		assertThat(scores, everyItem(lessThan(200)));
		assertThat(scores, everyItem(is(lessThan(200))));

		// String : Assert for Null or empty
		assertThat("", isEmptyString());
		assertThat("", isEmptyOrNullString());
		assertThat("Hello World", containsString("W"));

		// Object - toString()
		assertThat(Boolean.TRUE, hasToString("true"));

		// Array :
		Integer[] marks = { 78, 89, 95, 73, 85 };

		// Matches all of the items of array and must be in same order.
		assertThat(marks, arrayContaining(78, 89, 95, 73, 85));
		assertThat(marks, arrayContainingInAnyOrder(73, 78, 85, 89, 95));
		assertThat(marks, arrayContainingInAnyOrder(greaterThan(50), greaterThan(50), greaterThan(50), greaterThan(50),
				greaterThan(50)));

	}

	/**
	 * Testing bean properties and their values.
	 */
	@Test
	public void testHamcrestBeansPackage_beanPropertyTesting() {

		// Lets assume we got this details from the business service app
		// which we have to test/validate now.
		final Employee sujeet = new Employee("Sujeet", "100245", 30000.00);
		final Employee rajiv = new Employee("Rajiv", "100245", 20000.00);

		// Property matching
		assertThat(sujeet, HasProperty.hasProperty("employeeId"));
		assertThat(sujeet, HasPropertyWithValue.hasProperty("salary", greaterThanOrEqualTo(20000.00)));

		// Object Matching
		assertThat(sujeet, IsNot.not(SamePropertyValuesAs.samePropertyValuesAs(rajiv)));
	}

	/**
	 * Testing bean properties and their values.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testHamcrestCollectionPackage_collectionTesting() {

		// Lets assume a business operation returned us below array.
		final Integer[] scores = { 2, 4, 8, 54, 99 };
		final String[] courses = { "Java", "Spring-MVC", "Spring-Boot", "Spring-Security" };

		// IsArray class.
		assertThat(scores,
				is(IsArray.array(equalTo(2), equalTo(2 * 2), equalTo(2 * 4), greaterThan(50), lessThan(100))));

		// IsArrayWithSize
		assertThat(scores, IsArrayWithSize.arrayWithSize(greaterThan(4)));
		assertThat(scores, IsArrayWithSize.arrayWithSize(5));

		// IsArrayContaining
		assertThat(courses, IsArrayContaining.hasItemInArray("Java"));
		assertThat(courses, IsArrayContaining.hasItemInArray(startsWith("Spring")));

		// Similarly there are lot other APIs avilable to test Collection based data -
		// Like for Map, Iterator, Collection Size etc.
	}
}
