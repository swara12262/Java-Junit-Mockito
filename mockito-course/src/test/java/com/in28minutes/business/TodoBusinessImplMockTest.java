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
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest {
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl toDoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingEmptyList() {
		
		List<String> todos = Arrays.asList();
		
		when(todoServiceMock.retrieveTodos("Swara")).thenReturn(todos);
				
		List<String> list  = toDoBusinessImpl.retrieveTodosRelatedToSpring("Swara");
		assertEquals(0, list.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_UsingList() {
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn dance");
		when(todoServiceMock.retrieveTodos("Swara")).thenReturn(todos);
				
		List<String> list  = toDoBusinessImpl.retrieveTodosRelatedToSpring("Swara");
		assertEquals(2, list.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_UsingBDD() {
		//Given
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn dance");
		given(todoServiceMock.retrieveTodos("Swara")).willReturn(todos);
		
		//when
		List<String> list  = toDoBusinessImpl.retrieveTodosRelatedToSpring("Swara");		
		
		//then
		assertThat( list.size(),is(2));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_UsingBDD() {
		//Given
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn dance");
		given(todoServiceMock.retrieveTodos("Swara")).willReturn(todos);
		
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
	
		//Define argument captor on specific method call
		
		//Capture the argument

		//Given
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn","Learn dance");
		given(todoServiceMock.retrieveTodos("Swara")).willReturn(todos);

		//when
		 toDoBusinessImpl.deleteToDosNotRelatedToSpring("Swara");		
		
		//then
		verify(todoServiceMock).deleteToDo("Learn dance");
		then(todoServiceMock).should(times(2)).deleteToDo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
		
	}

}
