package Ordinationssystem.storage;

import ordination.Laegemiddel;
import ordination.Patient;

import java.util.ArrayList;
import java.util.List;

public class Storage {
	private List<Patient> patienter = new ArrayList<>();
	private List<Laegemiddel> laegemidler = new ArrayList<>();

	private static Storage instance = null;

	private Storage() {
	}

	public static Storage getInstance() {
		if (instance == null) {
			instance = new Storage();
		}
		return instance;
	}

	/** Only used in tests. */
	public static Storage getEmptyInstance() {
		return new Storage();
	}

	// -----------------------------------------------------

	public List<Patient> getAllPatienter() {
		return new ArrayList<Patient>(patienter);
	}

	public void addPatient(Patient patient) {
		patienter.add(patient);
	}

	public List<Laegemiddel> getAllLaegemidler() {
		return new ArrayList<Laegemiddel>(laegemidler);
	}

	public void addLaegemiddel(Laegemiddel laegemiddel) {
		laegemidler.add(laegemiddel);
	}
}
