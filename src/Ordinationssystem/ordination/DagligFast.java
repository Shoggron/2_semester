package Ordinationssystem.ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {

	public DagligFast(Patient patient, LocalDate startDato, LocalDate slutDato) {
		super(patient, startDato, slutDato);
		// TODO Auto-generated constructor stub
	}

	private Dosis[] doser = new Dosis[4];
	private int dosisCounter = 0;

	public Dosis[] getDoser() {
		return doser;

	}

	public Dosis CreateDosis(LocalTime tid, Double antal) {
		Dosis dosis = new Dosis(tid, antal);
		doser[dosisCounter] = dosis;
		dosisCounter++;
		return dosis;
	}

	@Override
	public double samletDosis() {
		// TODO Auto-generated method stub
		return doegnDosis() * antalDage();
	}

	@Override
	public double doegnDosis() {
		double samletDosisPaaEnDag = 0;
		for (int i = 0; i < dosisCounter; i++) {
			samletDosisPaaEnDag += doser[i].getAntal();
		}
		return samletDosisPaaEnDag;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "DagligFast-ordination";
	}

}
