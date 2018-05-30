package fr.eni.formation.mongo.client;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.ValidationExtension;

import com.mongodb.MongoClient;

@ApplicationScoped
public class DatastoreProducer {
	
	@Produces
	public Datastore getDatastore() {
		Morphia morphia = new Morphia();
		morphia.mapPackage("fr.eni.formation.mongo.banque");
		new ValidationExtension(morphia);
		Datastore datastore = morphia.createDatastore(new MongoClient(), "banque-morphia-rs");
		return datastore;
	}

}
