package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplMockitoInjectTest {
	
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
	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDD() {
		//Given
		TodoService todoServiceMock =mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn dance");
		given(todoServiceMock.retrieveTodos("Swara")).willReturn(todos);
		TodoBusinessImpl toDoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		//when
		List<String> list  = toDoBusinessImpl.retrieveTodosRelatedToSpring("Swara");		
		
		//then
		assertThat( list.size(),is(2));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_UsingBDD() {
		//Given
		TodoService todoServiceMock =mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn dance");
		given(todoServiceMock.retrieveTodos("Swara")).willReturn(todos);
		TodoBusinessImpl toDoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		//when
		 toDoBusinessImpl.deleteToDosNotRelatedToSpring("Swara");		
		
		//then
		verify(todoServiceMock).deleteToDo("Learn dance");
		then(todoServiceMock).should().deleteToDo("Learn dance");
		
		verify(todoServiceMock,times(1)).deleteToDo("Learn dance");
		
		
		verify(todoServiceMock,never()).deleteToDo("Learn Spring");
		then(todoServiceMock).should(never()).deleteToDo("Learn Spring");
	}
	@Test
	public void testDeleteTodosNotRelatedToSpring_ArgumentCapture() {
		//Declare Argument captor 
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//Define argument captor on specific method call
		
		//Capture the argument
		
		
		
		//Given
		TodoService todoServiceMock =mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn","Learn dance");
		given(todoServiceMock.retrieveTodos("Swara")).willReturn(todos);
		TodoBusinessImpl toDoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		//when
		 toDoBusinessImpl.deleteToDosNotRelatedToSpring("Swara");		
		
		//then
		verify(todoServiceMock).deleteToDo("Learn dance");
		then(todoServiceMock).should(times(2)).deleteToDo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
		
	}

}
