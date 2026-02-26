package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBStubTest {

    private DBStub dbStub;
    private ToDo todo1;
    private ToDo todo2;

    @BeforeEach
    void setUp() throws Exception {
        // Inicializamos el objeto DBStub y los ToDos para cada test
        dbStub = new DBStub();
        todo1 = new ToDo("Tarea 1", "Descripción 1", new Date(), false);
        todo2 = new ToDo("Tarea 2", "Descripción 2", new Date(System.currentTimeMillis() + 10000000), false);
    }

    @Test
    void testAddTask() {
        // Act: Agregar tareas al DBStub
        dbStub.addTask(todo1);
        dbStub.addTask(todo2);

        // Assert: Verificar que las tareas se han añadido a la lista
        assertEquals(2, dbStub.getToDoList().size(), "El número de tareas no coincide.");
        assertTrue(dbStub.getToDoList().contains(todo1), "La tarea 1 no fue añadida.");
        assertTrue(dbStub.getToDoList().contains(todo2), "La tarea 2 no fue añadida.");
    }

    @Test
    void testFindTaskById() {
        // Act: Añadir la tarea y buscarla por ID (índice)
        dbStub.addTask(todo1);
        dbStub.addTask(todo2);
        
        // Aquí implementamos el test asumiendo que ID está basado en el índice
        ToDo foundTask = dbStub.findTaskById(0); // Buscamos por índice (0 para la primera tarea)

        // Assert: Verificar que la tarea encontrada sea la correcta
        assertEquals(todo1, foundTask, "La tarea encontrada no es la correcta.");
    }

    @Test
    void testGetIncompleteTasks() {
        // Act: Marcar una tarea como completada y obtener las tareas incompletas
        dbStub.addTask(todo1);
        dbStub.addTask(todo2);
        todo1.setCompletado(true);
        
        List<ToDo> incompleteTasks = dbStub.getIncompleteTasks();
        
        // Assert: Verificar que solo hay una tarea incompleta
        assertEquals(1, incompleteTasks.size(), "El número de tareas incompletas no coincide.");
        assertTrue(incompleteTasks.contains(todo2), "La tarea incompleta no fue encontrada.");
        assertFalse(incompleteTasks.contains(todo1), "La tarea completada debería ser ignorada.");
    }

    @Test
    void testMarkTaskAsCompleted() {
        // Arrange: Agregar tarea al DBStub
        dbStub.addTask(todo1);

        // Act: Marcar la tarea como completada, pasando el índice de la tarea (en este caso, 0)
        dbStub.markTaskAsCompleted(0);  // Usamos el índice 0, ya que es la primera tarea en la lista

        // Assert: Verificar que la tarea se haya marcado correctamente como completada
        assertTrue(todo1.isCompletado(), "La tarea no fue marcada como completada.");
    }

    @Test
    void testAddEmail() {
        // Act: Añadir un correo electrónico a la agenda
        String email = "test@example.com";
        boolean result = dbStub.addEmail(email);
        
        // Assert: Verificar que el correo fue agregado correctamente
        assertTrue(result, "El correo electrónico no fue agregado correctamente.");
        assertTrue(dbStub.getEmailAgenda().contains(email), "La agenda no contiene el correo electrónico.");
    }

    @Test
    void testGetEmailAgenda() {
        // Act: Añadir algunos correos a la agenda
        dbStub.addEmail("test1@example.com");
        dbStub.addEmail("test2@example.com");
        
        // Assert: Verificar que la agenda contiene los correos añadidos
        Set<String> agenda = dbStub.getEmailAgenda();
        assertTrue(agenda.contains("test1@example.com"), "El correo test1@example.com no está en la agenda.");
        assertTrue(agenda.contains("test2@example.com"), "El correo test2@example.com no está en la agenda.");
    }
}