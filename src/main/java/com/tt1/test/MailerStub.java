package com.tt1.test;

import java.util.regex.Pattern;

public class MailerStub {
    
	public boolean sendEmail(String email, String message) {
        // Verificamos que el correo electrónico y el mensaje no sean nulos o vacíos
        if (email == null || email.isEmpty() || message == null || message.isEmpty()) {
            return false; // No enviamos el correo si faltan los datos
        }

        // Expresión regular para validar un correo electrónico básico
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zAzel]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        
        // Validamos el formato del correo electrónico
        if (!pattern.matcher(email).matches()) {
            return false;  // Si el correo no es válido, no lo enviamos
        }

        // Si el correo es válido, "simulamos" el envío
        System.out.println("Enviando correo a: " + email);
        System.out.println("Mensaje: " + message);
        return true; // Simulamos que el correo fue enviado exitosamente
    }
}