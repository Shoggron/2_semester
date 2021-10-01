package Ordinationssystem.controller;

import ordination.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public abstract class Controller {
	private static Storage storage = Storage.getInstance();

	/**
	 * Opret en DagligFast ordination. Hvis startDato er efter slutDato kastes en
	 * IllegalArgumentException og ordinationen oprettes ikke.
	 */
	public static PN opretPNOrdination(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
			double antal) {
		if (startDen.isAfter(slutDen)) {
			throw new IllegalArgumentException("Startdato skal være før slutdato");
		} else if (antal <= 0) {
			throw new IllegalArgumentException("der må ikke være negative antal eller ingen taget");
		} else {
			PN pn = new PN(patient, startDen, slutDen, antal);
			pn.setLaegemiddel(laegemiddel);
			patient.addOrdination(pn);

			return pn;
		}
	}

	/**
	 * Opret en DagligFast ordination. Hvis startDato er efter slutDato kastes en
	 * IllegalArgumentException og ordinationen oprettes ikke.
	 */
	public static DagligFast opretDagligFastOrdination(LocalDate startDen, LocalDate slutDen, Patient patient,
			Laegemiddel laegemiddel, double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
		if (startDen.isAfter(slutDen)) {
			throw new IllegalArgumentException("Startdato skal være før slutdato");
		} else if (morgenAntal < 0 || middagAntal < 0 || aftenAntal < 0 || natAntal < 0) {
			throw new IllegalArgumentException("der må ikke være negative antal");
		} else {
			DagligFast dagligFast = new DagligFast(patient, startDen, slutDen);

			dagligFast.CreateDosis(LocalTime.of(8, 0), morgenAntal);

			dagligFast.CreateDosis(LocalTime.of(12, 0), middagAntal);

			dagligFast.CreateDosis(LocalTime.of(18, 0), aftenAntal);

			dagligFast.CreateDosis(LocalTime.of(23, 0), natAntal);
			dagligFast.setLaegemiddel(laegemiddel);
			patient.addOrdination(dagligFast);
			return dagligFast;
		}

	}

	/**
	 * Opret en DagligSkæv ordination. Hvis startDato er efter slutDato kastes en
	 * IllegalArgumentException og ordinationen oprettes ikke. Hvis antallet af
	 * elementer i klokkeSlet og antalEnheder er forskellige kastes en
	 * IllegalArgumentException.
	 */
	public static DagligSkaev opretDagligSkaevOrdination(LocalDate startDen, LocalDate slutDen, Patient patient,
			Laegemiddel laegemiddel, LocalTime[] klokkeSlet, double[] antalEnheder) {
		if (startDen.isAfter(slutDen) || klokkeSlet.length != antalEnheder.length) {
			throw new IllegalArgumentException("Startdato skal være før slutdato");
		} else {
			DagligSkaev dagligSkaev = new DagligSkaev(patient, startDen, slutDen);
			for (int i = 0; i < klokkeSlet.length; i++) {
				dagligSkaev.opretDosis(klokkeSlet[i], antalEnheder[i]);
			}
			dagligSkaev.setLaegemiddel(laegemiddel);
			patient.addOrdination(dagligSkaev);
			return dagligSkaev;
		}
	}

	/**
	 * Tilføj en dato for anvendelse af PN ordinationen. Hvis datoen ikke er
	 * indenfor ordinationens gyldighedsperiode kastes en IllegalArgumentException.
	 */
	public static void ordinationPNAnvendt(PN ordination, LocalDate dato) {
		if (!ordination.givDosis(dato)) {
			throw new IllegalArgumentException("datoen er ikke  indenfor ordinationens gyldighedsperiod");
		}
	}

	/**
	 * Returner den anbefalede dosis af lægemidlet for patienten. (Beregningen
	 * anvender en enhedsfaktor, der er afhængig af patientens vægt.)
	 */
	public static double anbefaletDosisPrDoegn(Patient patient, Laegemiddel laegemiddel) {
		double anbefaletDosis = 0;
		if (patient.getVaegt() < 25) {
			anbefaletDosis = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnLet();
		} else if (patient.getVaegt() > 120) {
			anbefaletDosis = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnTung();
		} else {
			anbefaletDosis = patient.getVaegt() * laegemiddel.getEnhedPrKgPrDoegnNormal();
		}
		return anbefaletDosis;
	}

	/**
	 * Returner antal ordinationer af lægemidlet for patienter med vægt i
	 * intervallat vægtStart..vægtslut.
	 */
	public static int antalOrdinationerPrVægtPrLægemiddel(double vægtStart, double vægtSlut, Laegemiddel laegemiddel) {
		int antalOrdinationer = 0;
		for (Patient patient : Storage.getInstance().getAllPatienter()) {
			if (patient.getVaegt() >= vægtStart && patient.getVaegt() <= vægtSlut) {
				for (Ordination ordination : patient.getOrdinationer()) {
					if (ordination.getLaegemiddel() == laegemiddel) {
						antalOrdinationer++;
					}
				}
			}
		}

		return antalOrdinationer;
	}

	// -----------------------------------------------------

	/**
	 * Returner true, hvis slutDato <= slutDato.
	 */
	private static boolean checkStartFoerSlut(LocalDate startDato, LocalDate slutDato) {
		return startDato.compareTo(slutDato) <= 0;
	}

	public static Patient opretPatient(String cpr, String navn, double vaegt) {
		Patient p = new Patient(cpr, navn, vaegt);
		storage.addPatient(p);
		return p;
	}

	public static Laegemiddel opretLaegemiddel(String navn, double enhedPrKgPrDoegnLet, double enhedPrKgPrDoegnNormal,
			double enhedPrKgPrDoegnTung, String enhed) {
		Laegemiddel lm = new Laegemiddel(navn, enhedPrKgPrDoegnLet, enhedPrKgPrDoegnNormal, enhedPrKgPrDoegnTung,
				enhed);
		storage.addLaegemiddel(lm);
		return lm;
	}

	public static void initStorage() {
		opretPatient("121256-0512", "Jane Jensen", 63.4);
		opretPatient("070985-1153", "Finn Madsen", 83.2);
		opretPatient("050972-1233", "Hans Jørgensen", 89.4);
		opretPatient("011064-1522", "Ulla Nielsen", 59.9);
		opretPatient("090149-2529", "Ib Hansen", 87.7);

		opretLaegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
		opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		opretLaegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
		opretLaegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

		opretPNOrdination(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 12), storage.getAllPatienter().get(0),
				storage.getAllLaegemidler().get(1), 123);

		opretPNOrdination(LocalDate.of(2019, 2, 12), LocalDate.of(2019, 2, 14), storage.getAllPatienter().get(0),
				storage.getAllLaegemidler().get(0), 3);

		opretPNOrdination(LocalDate.of(2019, 1, 20), LocalDate.of(2019, 1, 25), storage.getAllPatienter().get(3),
				storage.getAllLaegemidler().get(2), 5);

		opretPNOrdination(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 12), storage.getAllPatienter().get(0),
				storage.getAllLaegemidler().get(1), 123);

		opretDagligFastOrdination(LocalDate.of(2019, 1, 10), LocalDate.of(2019, 1, 12),
				storage.getAllPatienter().get(1), storage.getAllLaegemidler().get(1), 2, 1, 1, 1);

		LocalTime[] kl = { LocalTime.of(12, 0), LocalTime.of(12, 40), LocalTime.of(16, 0), LocalTime.of(18, 45) };
		double[] an = { 0.5, 1, 2.5, 3 };

		opretDagligSkaevOrdination(LocalDate.of(2019, 1, 23), LocalDate.of(2019, 1, 24),
				storage.getAllPatienter().get(1), storage.getAllLaegemidler().get(2), kl, an);
	}

	// -----------------------------------------------------

	public static List<Patient> getAllPatienter() {
		return storage.getAllPatienter();
	}

	public static List<Laegemiddel> getAllLaegemidler() {
		return storage.getAllLaegemidler();
	}
}
