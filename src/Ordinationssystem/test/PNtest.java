package Ordinationssystem.test;

import ordination.PN;
import ordination.Patient;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PNtest {
	private Patient patient;

	@Test
	public void testSamletDosis1() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 2));
		pn1.givDosis(LocalDate.of(2021, 3, 4));
		// act
		double result = pn1.samletDosis();
		// assert
		assertEquals(4, result, 0.01);
	}

	@Test
	public void testSamletDosis2() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 1));
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		// act
		double result = pn1.samletDosis();
		// assert
		assertEquals(4, result, 0.01);
	}

	@Test
	public void testSamletDosis3() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);

		// act
		double result = pn1.samletDosis();
		// assert
		assertEquals(0, result, 0.01);
	}

	@Test
	public void testSamletDosis4() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		// act
		double result = pn1.samletDosis();
		// assert
		assertEquals(4, result, 0.01);
	}

	@Test
	public void testSamletDosis5() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 7));
		pn1.givDosis(LocalDate.of(2021, 3, 7));
		// act
		double result = pn1.samletDosis();
		// assert
		assertEquals(0, result, 0.01);
	}

	@Test
	public void testSamletDosis6() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 3, 1), 2);

		// act
		double result = pn1.samletDosis();
		// assert
		assertEquals(0, result, 0.01);
	}

	@Test
	public void testDoegnDosis1() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 2));
		pn1.givDosis(LocalDate.of(2021, 3, 4));
		// act
		double result = pn1.doegnDosis();
		// assert
		assertEquals(0.6666, result, 0.01);
	}

	@Test
	public void testDoegnDosis2() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 1), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 1));
		pn1.givDosis(LocalDate.of(2021, 3, 1));
		// act
		double result = pn1.doegnDosis();
		// assert
		assertEquals(4, result, 0.01);
	}

	@Test
	public void testDoegnDosis3() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);

		// act
		double result = pn1.doegnDosis();
		// assert
		assertEquals(0, result, 0.01);
	}

	@Test
	public void testDoegnDosis4() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		// act
		double result = pn1.doegnDosis();
		// assert
		assertEquals(0.6666, result, 0.01);
	}

	@Test
	public void testDoegnDosis5() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 3, 1), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		// act
		double result = pn1.doegnDosis();
		// assert
		assertEquals(-1, result, 0.01);
	}

	@Test
	public void testGetAntalGangeGivet1() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		pn1.givDosis(LocalDate.of(2021, 3, 6));
		// act
		double result = pn1.getAntalGangeGivet();
		// assert
		assertEquals(2, result, 0.01);
	}

	@Test
	public void testGetAntalGangeGivet2() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);
		pn1.givDosis(LocalDate.of(2021, 3, 1));
		pn1.givDosis(LocalDate.of(2021, 3, 2));
		pn1.givDosis(LocalDate.of(2021, 3, 3));
		pn1.givDosis(LocalDate.of(2021, 3, 4));
		// act
		double result = pn1.getAntalGangeGivet();
		// assert
		assertEquals(4, result, 0.01);
	}

	@Test
	public void testGetAntalGangeGivet3() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), 2);

		// act
		double result = pn1.getAntalGangeGivet();
		// assert
		assertEquals(0, result, 0.01);
	}

	@Test
	public void testGetAntalGangeGivet4() {
		// arrange
		patient = new Patient("121256-0512", "Jane Jensen", 63.4);
		PN pn1 = new PN(patient, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 3, 1), 2);

		// act
		double result = pn1.getAntalGangeGivet();
		// assert
		assertEquals(0, result, 0.01);
	}

}
