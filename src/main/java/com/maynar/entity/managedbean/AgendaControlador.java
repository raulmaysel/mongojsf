package com.maynar.entity.managedbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@ManagedBean
@ApplicationScoped
public class AgendaControlador {

	private ArrayList<Persona> agenda;

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
		// Connect to MongoDB server
		MongoClient mongo = new MongoClient("localhost", 27017);
		
		// Display all databases
		List<String> dbs = mongo.getDatabaseNames();
		for (String database : dbs) {
			System.out.println(database);
		}
		
		// Get database. If the database doesn’t exist, MongoDB will create it
		// for you.
		MongoDatabase db = mongo.getDatabase("personas");
		
		//Get collection / table.
		MongoCollection<Document> table = db.getCollection("personas");
		
		//Save data
		Document document = new Document();
		document.put("nombre", per.getNombre());
		document.put("edad", per.getEdad());
		table.insertOne(document);
		mongo.close();
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
