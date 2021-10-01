package Ordinationssystem.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {
	private ArrayList<LocalDate> datoer = new ArrayList<>();
	private ArrayList<PN> ordinationer = new ArrayList<>();
	private double antalEnheder;

	public PN(Patient patient, LocalDate startDato, LocalDate slutDato, double antalEnheder) {
		super(patient, startDato, slutDato);
		this.antalEnheder = antalEnheder;

	}

	public double getAntalEnheder() {
		return antalEnheder;
	}

	/**
	 * Registrer dagen givesDen, hvor der er givet en dosis af PN. Returner true,
	 * hvis givesDen er inden for ordinationens gyldighedsperiode. Returner false
	 * ellers, og datoen givesDen ignoreres.
	 */
	public boolean givDosis(LocalDate givesDen) {

		if (givesDen.isBefore(getSlutDen()) && givesDen.isAfter(getStartDen())) {
			datoer.add(givesDen);

			return true;
		} else if (givesDen.isEqual(getSlutDen()) || givesDen.isEqual(getStartDen())) {
			datoer.add(givesDen);

			return true;

		} else
			return false;
	}

	/**
	 * Returner antal gange ordinationen er anvendt.
	 */
	public int getAntalGangeGivet() {

		return datoer.size();
	}

	@Override
	public double samletDosis() {

		return getAntalGangeGivet() * antalEnheder;
	}

	@Override
	public double doegnDosis() {
		// (antal gange ordinationen er anvendt * antal enheder)
		// / (antal dage mellem første og sidste givning)
		int antalGyldigeDage = (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen()) + 1;
		double gnsDoegnDosis = samletDosis() / antalGyldigeDage;
		return gnsDoegnDosis;
	}

	@Override
	public String getType() {

		return ("PN medicin");
	}
}
