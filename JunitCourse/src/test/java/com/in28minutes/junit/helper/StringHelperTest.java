package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test
	public void testTruncateAInFirst2Positions_1() {
		StringHelper sh=new StringHelper();
		assertEquals("CD",sh.truncateAInFirst2Positions("AACD"));
	}
	@Test
	public void testTruncateAInFirst2Positions_2() {
		StringHelper sh=new StringHelper();
		assertEquals("CD",sh.truncateAInFirst2Positions("ACD"));
	}
}
