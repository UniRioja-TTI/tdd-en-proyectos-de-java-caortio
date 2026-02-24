package com.tt1.test;

import java.util.List;

public class Servicio {
    private Repositorio repositorio;
    private MailerStub mailerStub;

    public Servicio(Repositorio repositorio, MailerStub mailerStub) {
        this.repositorio = repositorio;
        this.mailerStub = mailerStub;
    }

    public void addTask(String taskName, String dueDate) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void addEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void markTaskAsCompleted(int taskId) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<ToDo> getIncompleteTasks() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void checkForOverdueTasks() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}
