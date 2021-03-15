package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper sh=new StringHelper();
	@Test
	public void testTruncateAInFirst2Positions_1() {
		
		assertEquals("CD",sh.truncateAInFirst2Positions("AACD"));
	}
	@Test
	public void testTruncateAInFirst2Positions_2() {
		
		assertEquals("CD",sh.truncateAInFirst2Positions("ACD"));
	}
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		assertFalse( sh.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
}
