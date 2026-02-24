package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestToDo {

    private ToDo todo;

    @BeforeEach
    void setUp() throws Exception {
        // Inicializamos el objeto ToDo antes de cada test
        todo = new ToDo("Tarea de ejemplo", "Descripción de la tarea", new Date(), false);
    }

    @Test
    void testGettersAndSetters() {
        // Arrange: Preparar el objeto ToDo
        todo.setNombre("Tarea modificada");
        todo.setDescripcion("Descripción modificada");
        todo.setFechaLimite(new Date(System.currentTimeMillis() + 1000000000)); 
        todo.setCompletado(true);

        // Act: Obtener los valores a través de los getters
        String nombre = todo.getNombre();
        String descripcion = todo.getDescripcion();
        Date fechaLimite = todo.getFechaLimite();
        boolean completado = todo.isCompletado();

        // Assert: Verificar que los valores establecidos con los setters son los mismos al obtenerlos
        assertEquals("Tarea modificada", nombre, "El nombre no coincide.");
        assertEquals("Descripción modificada", descripcion, "La descripción no coincide.");
        assertNotNull(fechaLimite, "La fecha límite no debe ser nula.");
        assertTrue(completado, "El estado de completado no coincide.");
    }

    @Test
    void testConstructor() {
        // Act: Verificamos el constructor con parámetros
        String nombre = todo.getNombre();
        String descripcion = todo.getDescripcion();
        Date fechaLimite = todo.getFechaLimite();
        boolean completado = todo.isCompletado();

        // Assert: Verificamos que los valores pasados en el constructor sean correctos
        assertEquals("Tarea de ejemplo", nombre, "El nombre no coincide.");
        assertEquals("Descripción de la tarea", descripcion, "La descripción no coincide.");
        assertNotNull(fechaLimite, "La fecha límite no debe ser nula.");
        assertFalse(completado, "El estado de completado no debe ser verdadero.");
    }

    @Test
    void testSetNombre() {
        // Act: Cambiar el nombre de la tarea
        todo.setNombre("Nuevo nombre");

        // Assert: Verificar que el nombre se ha actualizado correctamente
        assertEquals("Nuevo nombre", todo.getNombre(), "El nombre no fue actualizado correctamente.");
    }

    @Test
    void testSetDescripcion() {
        // Act: Cambiar la descripción de la tarea
        todo.setDescripcion("Nueva descripción");

        // Assert: Verificar que la descripción se ha actualizado correctamente
        assertEquals("Nueva descripción", todo.getDescripcion(), "La descripción no fue actualizada correctamente.");
    }

    @Test
    void testSetFechaLimite() {
        // Act: Cambiar la fecha límite
        Date nuevaFecha = new Date(System.currentTimeMillis() + 2000000000);
        todo.setFechaLimite(nuevaFecha);

        // Assert: Verificar que la fecha límite ha sido actualizada correctamente
        assertEquals(nuevaFecha, todo.getFechaLimite(), "La fecha límite no fue actualizada correctamente.");
    }

    @Test
    void testSetCompletado() {
        // Act: Marcar la tarea como completada
        todo.setCompletado(true);

        // Assert: Verificar que la tarea está marcada como completada
        assertTrue(todo.isCompletado(), "La tarea no fue marcada como completada correctamente.");
    }
}