package Ordinationssystem.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {
	private LocalDate startDato;
	private LocalDate slutDato;

	// association --> 0..1 laegemiddel
	private Laegemiddel laegemiddel;

	// constructor
	public Ordination(Patient patient, LocalDate startDato, LocalDate slutDato) {
		patient.addOrdination(this);
		this.startDato = startDato;
		this.slutDato = slutDato;

	}

	public LocalDate getStartDen() {
		return startDato;
	}

	public LocalDate getSlutDen() {
		return slutDato;
	}

	public Patient getPatient() {
		return getPatient();

	}

	/**
	 * Returner antal hele dage mellem startdato og slutdato (begge dage inklusive).
	 */
	public int antalDage() {
		return (int) ChronoUnit.DAYS.between(startDato, slutDato) + 1;
	}

	@Override
	public String toString() {
		return startDato.toString();
	}

	/**
	 * Returner den totale dosis, der er givet i den periode ordinationen er gyldig.
	 */
	public abstract double samletDosis();

	/**
	 * Returner den gennemsnitlige dosis givet pr dag i den periode ordinationen er
	 * gyldig.
	 */
	public abstract double doegnDosis();

	/**
	 * Returner ordinationstypen som en tekst.
	 */
	public abstract String getType();

	// -----------------------------------------------------

	// TODO: Metoder til at vedligeholde linket til lagemiddel.
	// association --> 0..1 Lægemiddel

	public Laegemiddel getLaegemiddel() {
		return laegemiddel;
	}

	/**
	 * Sets the laegemiddel as this ordination laegemiddel.
	 */
	public void setLaegemiddel(Laegemiddel laegemiddel) {
		if (this.laegemiddel != laegemiddel) {
			this.laegemiddel = laegemiddel;
		}
	}

}
