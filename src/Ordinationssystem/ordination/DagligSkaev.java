package Ordinationssystem.ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

	// TODO

	// Komposition til Dosis -> 0..*
	private ArrayList<Dosis> doser = new ArrayList<>();

	public DagligSkaev(Patient patient, LocalDate startDato, LocalDate slutDato) {
		super(patient, startDato, slutDato);
		// TODO Auto-generated constructor stub
	}

	public Dosis opretDosis(LocalTime tid, double antal) {
		Dosis dosis = new Dosis(tid, antal);
		doser.add(dosis);
		return dosis;
	}

	public ArrayList<Dosis> getDoser() {
		return doser;
	}

	@Override
	public double samletDosis() {
		return this.doegnDosis() * super.antalDage();
	}

	@Override
	public double doegnDosis() {
		double antal = 0;
		for (Dosis dosis : doser) {
			antal += dosis.getAntal();
		}
		return antal;
	}

	@Override
	public String getType() {
		String type = "";
		for (Dosis dosis : doser) {
			type = dosis.toString();
		}
		return type;
	}
}
