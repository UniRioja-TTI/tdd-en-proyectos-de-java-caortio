package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class RepositorioTest {

    private DBStub dbStub;
    private Repositorio repositorio;
    private ToDo task1;
    private ToDo task2;

    @BeforeEach
    public void setUp() {
        dbStub = new DBStub();
        repositorio = new Repositorio(dbStub);

        task1 = new ToDo("Tarea 1", "Descripción 1", new Date(), false);
        task2 = new ToDo("Tarea 2", "Descripción 2", new Date(), false);
    }

    @Test
    public void testStoreTask() {
        // Act: Almacenamos una tarea
        repositorio.storeTask(task1);

        // Assert: Verificamos que la tarea se haya almacenado correctamente en DBStub
        assertEquals(1, dbStub.getToDoList().size());
        assertEquals("Tarea 1", dbStub.getToDoList().get(0).getNombre());
    }

    @Test
    public void testGetTaskById() {
        // Arrange: Almacenamos las tareas en el repositorio
        repositorio.storeTask(task1);
        repositorio.storeTask(task2);

        // Act: Buscamos una tarea por ID
        ToDo foundTask = repositorio.getTaskById(1); 

        // Assert: Verificamos que la tarea encontrada sea la correcta
        assertNotNull(foundTask);
        assertEquals("Tarea 1", foundTask.getNombre());
    }

    @Test
    public void testGetIncompleteTasks() {
        // Arrange: Almacenamos tareas, una de ellas incompleta
        task1.setCompletado(false);
        task2.setCompletado(true);
        repositorio.storeTask(task1);
        repositorio.storeTask(task2);

        // Act: Obtenemos las tareas incompletas
        List<ToDo> incompleteTasks = repositorio.getIncompleteTasks();

        // Assert: Verificamos que solo se devuelvan las tareas incompletas
        assertEquals(1, incompleteTasks.size());
        assertEquals("Tarea 1", incompleteTasks.get(0).getNombre());
    }

    @Test
    public void testMarkTaskCompleted() {
        // Arrange: Almacenamos una tarea incompleta
        repositorio.storeTask(task1);

        // Act: Marcamos la tarea como completada
        repositorio.markTaskCompleted(1);

        // Assert: Verificamos que la tarea fue marcada como completada
        assertTrue(task1.isCompletado());
    }
}
