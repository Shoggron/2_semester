package Ordinationssystem.test;

import controller.Controller;
import ordination.DagligFast;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DagligFastTest {

	@Test
	public void testSamletDosis1() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 1),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 1, 1, 1);
		// act
		double samletDosis = dagligfast1.samletDosis();
		// assert
		assertEquals(32.0, samletDosis, 0.001);
	}

	@Test
	public void testSamletDosis2() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 2),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 2, 0, 1, 10);
		// act
		double samletDosis = dagligfast1.samletDosis();
		// assert
		assertEquals(91.0, samletDosis, 0.001);
	}

	@Test
	public void testSamletDosis3() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 3),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 2, 3, 4);
		// act
		double samletDosis = dagligfast1.samletDosis();
		// assert
		assertEquals(60.0, samletDosis, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSamletDosis4() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 11),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSamletDosis5() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 3),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 1, -10, 1);
		// act
		double samletDosis = dagligfast1.samletDosis();
		// assert
		assertEquals(-42.0, samletDosis, 0.001);
	}

	@Test
	public void testDoegnDosis1() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 2),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 1, 1, 1);
		// act
		double doegndosis = dagligfast1.doegnDosis();
		// assert
		assertEquals(4.0, doegndosis, 0.001);
	}

	@Test
	public void testDoegnDosis2() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 2),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 5, 1.5, 1, 4);
		// act
		double doegndosis = dagligfast1.doegnDosis();
		// assert
		assertEquals(11.5, doegndosis, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDoegnDosis3() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 2),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, -20, 1.5, 1, 4);
		// act
		double doegndosis = dagligfast1.doegnDosis();
		// assert
		assertEquals(-13.5, doegndosis, 0.001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetType() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 2),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, -20, 1.5, 1, 4);
		// act
		String type = dagligfast1.getType().toString();
		// assert
		assertEquals("DagligFast-ordination", type);
	}

	@Test
	public void testDagligFast() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 2),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 5, 1.5, 1, 4);
		// assert
		assertNotNull(dagligfast1);
		assertTrue(patient1.getOrdinationer().contains(dagligfast1));
	}

}
