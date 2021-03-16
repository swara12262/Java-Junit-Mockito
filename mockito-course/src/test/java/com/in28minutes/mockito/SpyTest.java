package com.in28minutes.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		//spy is like creating real arraylist but you can override/stub certain methods 
		List listSpy =  spy(ArrayList.class);
		listSpy.add("swara");
		
		assertEquals(1, listSpy.size());
	
		stub(listSpy.size()).toReturn(5);
		assertEquals(5, listSpy.size());
		
	}

}
