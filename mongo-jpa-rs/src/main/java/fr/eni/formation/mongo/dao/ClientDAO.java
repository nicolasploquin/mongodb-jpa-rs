package fr.eni.formation.mongo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.bson.types.ObjectId;

import fr.eni.formation.mongo.banque.Client;

@Stateless
public class ClientDAO {
		
	@PersistenceContext(unitName="mongo-jpa")
	private EntityManager em;
	
	@PostConstruct
	private void init() {
		create("ainslie", "ben");
		create("scheidt", "robert");
	}
	
	public void create(Client client) {
		
		em.persist(client);
		
	}
	public void create(String nom, String prenom) {
		
		create(new Client(nom, prenom));

	}

	public List<Client> readAll() {	
		return em.createQuery("from Client").getResultList();
	}

	public Client read(String id) {
		return em.find(Client.class, id);
	}

	public List<Client> readNom(String nom) {
//		nom = nom.replace('{', ' ').replace('}', ' ');
//		String requete = "db.clients.find({nom:{$regex:/" + nom + "/i}})";
//		return em.createNativeQuery(requete, Client.class).getResultList();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Client> criteria = builder.createQuery( Client.class );
		Root<Client> client = criteria.from( Client.class );
		criteria.select( client );
		
		criteria.where( builder.like(builder.lower(client.get("nom")), nom.toLowerCase() ) );
		return em.createQuery( criteria ).getResultList();
		
	}

	public void update(ObjectId id, String nom, String prenom) {
		Client client = em.find(Client.class, id);
		client.setNom(nom);
		client.setPrenom(prenom);
	}

}
