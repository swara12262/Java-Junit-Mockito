package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{

	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		return  Arrays.asList("Learn Spring MVC","Learn Spring", "Learn dance");
	}

	public void deleteToDo(String toDo) {
		// TODO Auto-generated method stub
		
	}
	
}
