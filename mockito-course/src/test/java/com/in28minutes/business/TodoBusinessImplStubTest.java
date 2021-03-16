package com.in28minutes.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	
	@Test
	public void test() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl toDoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> list  = toDoBusinessImpl.retrieveTodosRelatedToSpring("Swara");
		assertEquals(2, list.size());
	}

}
