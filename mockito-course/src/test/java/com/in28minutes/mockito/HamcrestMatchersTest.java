package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.text.IsEmptyString;
import org.junit.Test;
import org.mockito.internal.matchers.GreaterThan;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);

		assertThat(scores, hasItems(99, 100));

	}

}
