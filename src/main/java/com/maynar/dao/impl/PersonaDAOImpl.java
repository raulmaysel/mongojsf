package com.maynar.dao.impl;

import org.bson.Document;

import com.maynar.dao.PersonaDAO;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PersonaDAOImpl implements PersonaDAO {

	private MongoClient mongo;
	
	@Override
	public void insert(Document doc) {
		// Connect to MongoDB server
		mongo = new MongoClient("localhost", 27017);

		/**
		// Display all databases
		List<String> dbs = mongo.getDatabaseNames();
		for (String database : dbs) {
			System.out.println(database);
		}
		**/
		// Get database. If the database doesn’t exist, MongoDB will create it
		// for you.
		MongoDatabase db = mongo.getDatabase("personas");

		// Get collection / table.
		MongoCollection<Document> table = db.getCollection("personas");

		table.insertOne(doc);
		mongo.close();
		
	}

}
