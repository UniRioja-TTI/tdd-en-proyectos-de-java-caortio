package com.tt1.test;

import java.util.List;

public class Repositorio {
	private DBStub dbStub;

    public Repositorio(DBStub dbStub) {
        this.dbStub = dbStub;
    }

    public void storeTask(ToDo task) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void storeEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public ToDo getTaskById(int id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void markTaskCompleted(int id) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> getIncompleteTasks() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
