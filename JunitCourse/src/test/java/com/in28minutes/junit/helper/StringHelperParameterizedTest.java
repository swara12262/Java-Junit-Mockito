package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	StringHelper sh;
	String intput;
	String expectedOutput;
	
	
	
	public StringHelperParameterizedTest(String intput, String expectedOutput) {
		super();
		this.intput = intput;
		this.expectedOutput = expectedOutput;
	}

	@Before
	public void before() {
		
		sh=new StringHelper();
	}
	
	@Parameters
	public static Collection<String[]> testConditions() {
		String[][] expectedOutputs={ {"AACD","CD"},
		{"ACD","CD"}};
		
		return Arrays.asList(expectedOutputs);
	}
	
	@Test
	public void testTruncateAInFirst2Positions_2() {
		
		assertEquals(expectedOutput,sh.truncateAInFirst2Positions(intput));
	}
	
}
