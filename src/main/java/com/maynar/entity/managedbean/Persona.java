package com.maynar.entity.managedbean;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Persona {
	private Long id;
	private String nombre;
	private String apellido;
	private int edad;
//	private ArrayList<String> agenda = new ArrayList<String>();;
	
	
	
	public Persona(Long id, String nombre, String apellido, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Persona() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

//	public ArrayList<String> getAgenda() {
//		return agenda;
//	}
//
//	public void setAgenda(ArrayList<String> agenda) {
//		this.agenda = agenda;
//	}

//	public String insertar(){
//		this.agenda.add(this.nombre);
//		return "./index.xhtml";
//	}
//	
//	public String eliminar(String _nombre){
//		agenda.remove(_nombre);
//		return null;
//	}
}
