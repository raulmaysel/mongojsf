package com.maynar.service.impl;

import org.bson.Document;

import com.maynar.dao.PersonaDAO;
import com.maynar.dao.impl.PersonaDAOImpl;
import com.maynar.entity.managedbean.Persona;
import com.maynar.service.PersonaService;

public class PersonaServiceImpl implements PersonaService {

	private PersonaDAO personaDao = new PersonaDAOImpl();
	
	@Override
	public void insert(Persona per) {
		Document document = new Document();
		document.put("nombre", per.getNombre());
		document.put("apellido",per.getApellido());
		document.put("edad", per.getEdad());
		document.put("email", per.getEmail());
		personaDao.insert(document);
	}

}
