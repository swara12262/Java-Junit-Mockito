package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testMockListSizeMethod() {
		List listmock = mock(List.class);
		when(listmock.size()).thenReturn(2);
		assertEquals(2,listmock.size());
	}
	
	@Test
	public void testMockListSizeMethod_ReturnMultipleValues() {
		List listmock = mock(List.class);
		when(listmock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2,listmock.size());
		assertEquals(3,listmock.size());
	}
	
	@Test
	public void testMockListGetMethod() {
		List listmock = mock(List.class);
		when(listmock.get(0)).thenReturn("Swara");
		assertEquals("Swara",listmock.get(0));
		assertEquals(null,listmock.get(1));
	}
	
	@Test(expected =RuntimeException.class)
	public void testMockList_ThrowException() {
		List listmock = mock(List.class);
		when(listmock.get(anyInt())).thenThrow(new RuntimeException());
		listmock.get(0);
		
	}
	@Test
	public void testMockListGetMethod_UsingBDD() {
		//given
		List<String> listmock = mock(List.class);	
		given(listmock.get(0)).willReturn("Swara");
		
		//when
		String s  = listmock.get(0);
		//then
		assertThat(s,is("Swara"));
		
	}
	
	

}
