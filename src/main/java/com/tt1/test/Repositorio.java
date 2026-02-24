package com.tt1.test;

import java.util.List;

public class Repositorio {
    private DBStub dbStub;

    public Repositorio(DBStub dbStub) {
        this.dbStub = dbStub;
    }

    public void storeTask(ToDo task) {
        dbStub.addTask(task);
    }

    public void storeEmail(String email) {
        dbStub.addEmail(email);
    }

    public ToDo getTaskById(int id) {
        return dbStub.findTaskById(id);
    }

    public void markTaskCompleted(int id) {
        ToDo task = dbStub.findTaskById(id);
        if (task != null) {
            dbStub.markTaskAsCompleted(task);
        }
    }

    public List<ToDo> getIncompleteTasks() {
        return dbStub.getIncompleteTasks();
    }
}