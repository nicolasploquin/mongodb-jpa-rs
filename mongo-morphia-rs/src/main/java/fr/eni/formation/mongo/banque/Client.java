package fr.eni.formation.mongo.banque;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value="clients", noClassnameStored=true)
public class Client {

	@Id
	private ObjectId id;

	@NotNull @Size(min=3)
	private String nom;
	private String prenom;
	
	private String email;
	
//	private LocalDate naissance;
//	
//	@Embedded
//	private List<Compte> comptes = new LinkedList<>();

	public Client() {
	}

	public Client(String nom, String prenom) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
//		this.setNaissance(LocalDate.now());
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

//	public List<Compte> getComptes() {
//		return comptes;
//	}
//
//	public void setComptes(List<Compte> comptes) {
//		this.comptes = comptes;
//	}

	@Override
	public String toString() {
		return String.format("%s %s (%d comptes)", prenom, nom, 0);//comptes.size());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public LocalDate getNaissance() {
//		return naissance;
//	}
//
//	public void setNaissance(LocalDate naissance) {
//		this.naissance = naissance;
//	}

	
	
}
