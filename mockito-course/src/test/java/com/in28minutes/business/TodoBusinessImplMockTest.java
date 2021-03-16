package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplMockTest {

	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingEmptyList() {
		TodoService todoServiceMock =mock(TodoService.class);
		
		List<String> todos = Arrays.asList();
		
		when(todoServiceMock.retrieveTodos("Swara")).thenReturn(todos);
		
		TodoBusinessImpl toDoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> list  = toDoBusinessImpl.retrieveTodosRelatedToSpring("Swara");
		assertEquals(0, list.size());
	}
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingList() {
		TodoService todoServiceMock =mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn dance");
		when(todoServiceMock.retrieveTodos("Swara")).thenReturn(todos);
		
		TodoBusinessImpl toDoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> list  = toDoBusinessImpl.retrieveTodosRelatedToSpring("Swara");
		assertEquals(2, list.size());
	}

}
