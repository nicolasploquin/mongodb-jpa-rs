package fr.eni.formation.mongo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import fr.eni.formation.mongo.banque.Client;

@ApplicationScoped
public class ClientDAO {
		
	@Inject
	private Datastore datastore;
	

	@PostConstruct
	private void init() {
		create("ainslie", "ben");
		create("scheidt", "robert");
	}
	
	
	public void create(Client client) {
		
		datastore.save(client);
		
	}
	public void create(String nom, String prenom) {
		
		create(new Client(nom, prenom));

	}

	public List<Client> readAll() {
		
		return datastore.createQuery(Client.class).asList();
	}

	public Client read(ObjectId id) {
		return datastore.get(Client.class, id);
	}

	public List<Client> read(String nom) {
		return datastore
				.createQuery(Client.class)
				.filter("nom", nom)
				.asList();
	}

	public void update(ObjectId id, String nom, String prenom) {
		Client client = datastore.get(Client.class, id);
		client.setNom(nom);
		client.setPrenom(prenom);
		datastore.save(client);
	}

}
