package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before Class");
	}
	
	@Before
	public void setup() {
		System.out.println("Before test");
	}
	@Test
	public void test1() {
		System.out.println("Test1 executed");
	}

	@Test
	public void test2() {
		System.out.println("Test2 executed");
	}
}
