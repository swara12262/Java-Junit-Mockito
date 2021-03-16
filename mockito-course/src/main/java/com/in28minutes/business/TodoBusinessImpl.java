package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> toDos = (List<String>) todoService.retrieveTodos(user);
		
		for(String toDo: toDos) {
			if(toDo.contains("Spring"))
				filteredTodos.add(toDo);
		}
		return filteredTodos;
	}
}
