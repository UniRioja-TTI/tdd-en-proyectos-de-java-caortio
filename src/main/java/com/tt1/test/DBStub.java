package com.tt1.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBStub 
{
	private List<ToDo> toDoList;
    private Set<String> emailAgenda;

    public DBStub() {
        this.setToDoList(new ArrayList<>());
        this.emailAgenda = new HashSet<>();
    }

    public void addTask(ToDo task) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public ToDo findTaskById(int id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> getIncompleteTasks() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public boolean markTaskAsCompleted(ToDo todo) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public boolean addEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public Set<String> getEmailAgenda() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

	public List<ToDo> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDo> toDoList) {
		this.toDoList = toDoList;
	}
}
