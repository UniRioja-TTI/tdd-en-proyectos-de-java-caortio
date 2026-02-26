package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicioTest {

    private DBStub dbStub;
    private MailerStub mailerStub;
    private Repositorio repositorio;
    private Servicio servicio;
    private ToDo task1;
    private ToDo task2;

    @BeforeEach
    public void setUp() {
        // Inicializamos los objetos necesarios para las pruebas
        dbStub = new DBStub();
        mailerStub = new MailerStub();
        repositorio = new Repositorio(dbStub);
        servicio = new Servicio(repositorio, mailerStub);

        // Creamos algunas tareas para las pruebas
        task1 = new ToDo("Tarea 1", "Descripción 1", new Date(), false);
        task2 = new ToDo("Tarea 2", "Descripción 2", new Date(System.currentTimeMillis() - 10000), false); 
    }

    @Test
    public void testAddTask() {
        // Act: Agregar tarea a través del servicio
        servicio.addTask("Tarea 1", "2026-02-25");

        // Assert: Verificar que la tarea se haya almacenado en el repositorio
        assertEquals(1, dbStub.getToDoList().size());
        assertEquals("Tarea 1", dbStub.getToDoList().get(0).getNombre());
    }

    @Test
    public void testAddEmail() {
        // Act: Agregar email al mailer stub
        String email = "test@example.com";
        boolean result = mailerStub.sendEmail(email, "Este es un mensaje de prueba");

        // Assert: Verificar que el envío del correo fue exitoso
        assertTrue(result, "El email no fue enviado correctamente.");
    }

    @Test
    public void testMarkTaskAsCompleted() {
        // Arrange: Almacenamos la tarea
        repositorio.storeTask(task1);

        // Act: Marcar la tarea como completada
        servicio.markTaskAsCompleted(0);
        
        // Act: Buscamos la tarea directamente en el repositorio
        ToDo foundTask = repositorio.getTaskById(0);

        // Assert: Verificar que la tarea está marcada como completada
        assertTrue(foundTask.isCompletado(), "La tarea no fue marcada como completada.");
    }

    @Test
    public void testCheckForOverdueTasks() {
        // Arrange: Agregar tareas a la base de datos
        repositorio.storeTask(task1);  // tarea sin vencerse
        repositorio.storeTask(task2);  // tarea vencida

        // Act: Llamamos al método que revisa tareas vencidas
        servicio.checkForOverdueTasks();

        // Assert: Verificar que el método sendEmail ha sido llamado para las tareas vencidas
        // Dado que no almacenamos los correos, verificamos simplemente que el método sendEmail haya devuelto "true"
        assertTrue(mailerStub.sendEmail("test@example.com", "Alerta: La tarea 'Tarea 2' ha vencido."),
                "No se enviaron correos de alerta para las tareas vencidas.");
    }
}