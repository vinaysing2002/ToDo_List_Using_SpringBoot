package com.example.ToDo_App.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ToDo_App.model.ToDo;
import com.example.ToDo_App.repository.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository repo;
	
	public List<ToDo> getAllToDoItems(){
		ArrayList<ToDo> todoList = new ArrayList<ToDo>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		
		return todoList;
	}
	
	public ToDo getToDoIteamById(Long id) {
		return repo.findById(id).get();
	}
	
	public boolean UpdateStatus(Long id) {
		ToDo todo = getToDoIteamById(id);
		todo.setStatus("completed");
		
		return saveorUpdateToDoItem(todo);
	}
	
	public boolean saveorUpdateToDoItem(ToDo todo) {
		ToDo updateObj = repo.save(todo);
		
		if(getToDoIteamById(updateObj.getId()) != null) {
			return true;
		}
		return false;
	}

	public boolean deleteToDoItem(Long id) {
		repo.deleteById(id);
		
		if(repo.findById(id).isEmpty()) {
			return true;
		}
		return false;
	}
}