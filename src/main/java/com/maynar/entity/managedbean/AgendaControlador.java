package com.maynar.entity.managedbean;

import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.maynar.service.PersonaService;
import com.maynar.service.impl.PersonaServiceImpl;

@ManagedBean
@ApplicationScoped
public class AgendaControlador {
 	
	private ArrayList<Persona> agenda;

	private PersonaService personaService = new PersonaServiceImpl();
	
	public ArrayList<Persona> getAgenda() {
		return agenda;
	}

	public void setAgenda(ArrayList<Persona> agenda) {
		this.agenda = agenda;
	};

	public String insertar(Persona per) {
		if (agenda != null && agenda.size() > 0) {
			per.setId(agenda.get(agenda.size() - 1).getId() + 1);
		} else {
			agenda = new ArrayList<Persona>();
			per.setId(1L);
		}
		//Insert object into DB through service
		personaService.insert(per);
		
		this.agenda.add(per);
		return null;
	}

	public String eliminar(Persona per) {
		agenda.remove(per);
		return null;
	}

	public String init() {
		Long cont = 0L;
		if (agenda != null && agenda.size() > 0) {
			// cont = (long) agenda.size();
		} else {
			agenda = new ArrayList<Persona>(Arrays.asList(new Persona(++cont,
					"Raul", "Maynar", 30), new Persona(++cont, "Pepe", "Illo",
					33), new Persona(++cont, "Inacio", "Maynar", 33)));
		}

		return null;
	}
}
