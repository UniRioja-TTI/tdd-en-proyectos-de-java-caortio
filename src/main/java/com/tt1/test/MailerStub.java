package com.tt1.test;

public class MailerStub {
    
    public boolean sendEmail(String email, String message) {
        // Simulamos que el correo siempre se envía correctamente
        if (email == null || email.isEmpty() || message == null || message.isEmpty()) {
            return false; // No se envía si el correo o mensaje son inválidos
        }
        System.out.println("Enviando correo a: " + email);
        System.out.println("Mensaje: " + message);
        return true;
    }
}