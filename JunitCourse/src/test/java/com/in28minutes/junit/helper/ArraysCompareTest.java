package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	//Arrays.sort
	
	@Test
	public void test() {
		int[] actual= {1,4,2,5};
		int[] expected = {1,2,4,5};
		Arrays.sort(actual);
		assertArrayEquals(expected, actual);
	}
	@Test(expected = NullPointerException.class)
	public void test_1() {
		int[] actual= null;
		int[] expected = {1,2,4,5};
		Arrays.sort(actual);
		
	}
	
	@Test(timeout=100)
	public void testPerformance() {
		int a[]= {1,33,23};
		for(int i=0;i<=1000000;i++) {
			a[0]+=5;
			Arrays.sort(a);
		}
	}
}
