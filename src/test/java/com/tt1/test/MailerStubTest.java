package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailerStubTest {

    private MailerStub mailerStub;

    @BeforeEach
    void setUp() throws Exception {
        // Inicializamos MailerStub antes de cada test
        mailerStub = new MailerStub();
    }

    @Test
    void testSendEmailValidInput() {
        // Arrange: Definir los parámetros de entrada
        String email = "test@example.com";
        String message = "Este es un mensaje de prueba.";

        // Act: Llamar al método sendEmail con parámetros válidos
        boolean result = mailerStub.sendEmail(email, message);

        // Assert: Verificar que el envío de correo fue exitoso (suponiendo que implementes esta lógica)
        assertTrue(result, "El correo no fue enviado correctamente.");
    }

    @Test
    void testSendEmailEmptyMessage() {
        // Arrange: Definir los parámetros con un mensaje vacío
        String email = "test@example.com";
        String message = "";

        // Act: Llamar al método sendEmail con un mensaje vacío
        boolean result = mailerStub.sendEmail(email, message);

        // Assert: Verificar que el correo con mensaje vacío no sea enviado
        assertFalse(result, "El correo no debería ser enviado con un mensaje vacío.");
    }

    @Test
    void testSendEmailInvalidEmail() {
        // Arrange: Definir un correo electrónico inválido
        String email = "invalid-email";
        String message = "Este es un mensaje de prueba.";

        // Act: Llamar al método sendEmail con un correo electrónico inválido
        boolean result = mailerStub.sendEmail(email, message);

        // Assert: Verificar que el correo no se envíe con un email inválido
        assertFalse(result, "El correo no debería ser enviado con un email inválido.");
    }

    @Test
    void testSendEmailNullEmail() {
        // Arrange: Definir un correo electrónico nulo
        String email = null;
        String message = "Este es un mensaje de prueba.";

        // Act: Llamar al método sendEmail con un correo nulo
        boolean result = mailerStub.sendEmail(email, message);

        // Assert: Verificar que el correo no se envíe con un correo electrónico nulo
        assertFalse(result, "El correo no debería ser enviado con un email nulo.");
    }

    @Test
    void testSendEmailNullMessage() {
        // Arrange: Definir un mensaje nulo
        String email = "test@example.com";
        String message = null;

        // Act: Llamar al método sendEmail con un mensaje nulo
        boolean result = mailerStub.sendEmail(email, message);

        // Assert: Verificar que el correo no se envíe con un mensaje nulo
        assertFalse(result, "El correo no debería ser enviado con un mensaje nulo.");
    }
}