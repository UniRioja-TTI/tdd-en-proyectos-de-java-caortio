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
        // Lógica para agregar tareas (deberías implementarlo)
    }

    public void addEmail(String email) {
        // Lógica para agregar el email a la agenda en DBStub
        repositorio.storeEmail(email);
    }

    public void markTaskAsCompleted(int taskId) {
        // Lógica para marcar tarea como completada (deberías implementarlo)
    }

    public List<ToDo> getIncompleteTasks() {
        // Lógica para obtener tareas incompletas (deberías implementarlo)
        return null;
    }

    public void checkForOverdueTasks() {
        // Lógica para verificar tareas vencidas (deberías implementarlo)
    }
}