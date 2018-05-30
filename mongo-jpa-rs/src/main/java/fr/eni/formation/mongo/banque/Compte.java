package fr.eni.formation.mongo.banque;

import javax.persistence.Embeddable;

@Embeddable
public class Compte {

	private String numero;
	private String intitule;
	private double solde;
//	
//	@Embedded
//	public List<Operation> operations = new LinkedList<>();
//	
	public Compte() {
	}

	public Compte(String numero, String intitule) {
		super();
		this.setNumero(numero);
		this.setIntitule(intitule);
	}


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	@Override
	public String toString() {
		return String.format("%8s - %s : %d", numero, intitule, solde);
	}
	
}
