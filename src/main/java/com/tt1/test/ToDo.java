package com.tt1.test;

import java.io.Serializable;
import java.util.Date;

public class ToDo implements Serializable {
	private String nombre;
	private String descripcion;
	private Date fechaLimite;
	private boolean completado;
	
	public ToDo (){	}
	
	public ToDo (String nombre, String descripcion, Date fecha, boolean completado)
	{
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}

	public String getNombre() {
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}

	public void setNombre(String nombre) {
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}

	public String getDescripcion() {
		throw new UnsupportedOperationException("Clase aún no implementada.");	
	}

	public void setDescripcion(String descripcion) {
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}

	public Date getFechaLimite() {
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}

	public void setFechaLimite(Date fechaLimite) {
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}

	public boolean isCompletado() {
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}

	public void setCompletado(boolean completado) {
		throw new UnsupportedOperationException("Clase aún no implementada.");
	}	
}
