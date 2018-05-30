package fr.eni.formation.mongo.banque;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Operation {

	private LocalDate date;
	private String libelle;
	private double montant;
	
	public Operation() {
	}

	public Operation(LocalDate date, String libelle, double montant) {
		super();
		this.setDate(date);
		this.setLibelle(libelle);
		this.setMontant(montant);
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return String.format("%tD - %s : %12s", getDate(), getLibelle(), getMontant());
	}

	
	
}
