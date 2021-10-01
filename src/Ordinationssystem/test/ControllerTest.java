package Ordinationssystem.test;

import controller.Controller;
import ordination.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

	@BeforeEach
	void setup() {

	}

	@Test
	public void testOpretPNOrdination1() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8), patient1,
				laegemiddel1, 2);
		// assert
		assertNotNull(pn1);
		assertEquals(LocalDate.of(2021, 3, 1), pn1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0), pn1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(pn1));

	}

	@Test
	public void testOpretPNOrdination2() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 2), LocalDate.of(2021, 3, 8), patient1,
				laegemiddel1, 3);
		// assert
		assertNotNull(pn1);
		assertEquals(LocalDate.of(2021, 3, 2), pn1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0), pn1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(pn1));
	}

	public void testOpretPNOrdination3() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 2), LocalDate.of(2021, 3, 2), patient1,
				laegemiddel1, 2);
		// assert
		assertNotNull(pn1);
		assertEquals(LocalDate.of(2021, 3, 2), pn1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0), pn1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(pn1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretPNOrdinationfail1() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 8), LocalDate.of(2021, 3, 1), patient1,
				laegemiddel1, 2);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretPNOrdinationfail2() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 8), LocalDate.of(2021, 3, 8), patient1,
				laegemiddel1, 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretPNOrdinationfail3() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		Controller.opretPNOrdination(LocalDate.of(2021, 3, 8), LocalDate.of(2021, 3, 8), patient1, laegemiddel1, -1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretPNOrdinationfail4() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 8), LocalDate.of(2020, 3, 8), patient1,
				laegemiddel1, 2);

	}

	@Test

	public void testOpretDagligFastOrdination1() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 1),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 1, 1, 1);
		// assert
		assertNotNull(dagligfast1);
		assertEquals(LocalDate.of(2021, 3, 1), dagligfast1.getStartDen());
		var test = Controller.getAllLaegemidler();
		assertEquals(laegemiddel1, dagligfast1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(dagligfast1));

	}

	@Test
	public void testOpretDagligFastOrdination2() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalDate startdato = LocalDate.of(2021, 3, 2);
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(startdato, LocalDate.of(2021, 3, 8), patient1,
				laegemiddel1, 2, 0, 1, 10);
		// assert
		assertNotNull(dagligfast1);
		assertEquals(startdato, dagligfast1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0),
		// dagligfast1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(dagligfast1));
	}

	@Test
	public void testOpretDagligFastOrdination3() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 3),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 2, 3, 4);
		// assert
		assertNotNull(dagligfast1);
		assertEquals(LocalDate.of(2021, 3, 3), dagligfast1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0),
		// dagligfast1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(dagligfast1));
	}

	@Test
	public void testOpretDagligFastOrdination4() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 4),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 4, 3, 2, 1);
		// assert
		assertNotNull(dagligfast1);
		assertEquals(LocalDate.of(2021, 3, 4), dagligfast1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0),
		// dagligfast1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(dagligfast1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretDagligFastOrdination5() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 11),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 4, 3, 2, 1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretDagligFastOrdination6() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		DagligFast dagligfast1 = Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 2),
				LocalDate.of(2021, 3, 8), patient1, laegemiddel1, 1, 1, -1, 1);
		// assert
		assertNotNull(dagligfast1);
		assertEquals(LocalDate.of(2021, 3, 2), dagligfast1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0),
		// dagligfast1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(dagligfast1));
	}

	@Test
	public void testOrdinationPNAnvendt1() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 8), LocalDate.of(2021, 3, 8), patient1,
				laegemiddel1, 2);
		Controller.ordinationPNAnvendt(pn1, LocalDate.of(2021, 3, 8));
		// assert
		assertNotNull(pn1);
		assertEquals(LocalDate.of(2021, 3, 8), pn1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0), pn1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(pn1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrdinationPNAnvendt2() {
		// act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		PN pn1 = Controller.opretPNOrdination(LocalDate.of(2021, 3, 8), LocalDate.of(2021, 3, 8), patient1,
				laegemiddel1, 2);
		Controller.ordinationPNAnvendt(pn1, LocalDate.of(2021, 3, 9));
		// assert
		assertNotNull(pn1);
		assertEquals(LocalDate.of(2021, 3, 8), pn1.getStartDen());
		// assertEquals(Controller.getAllLaegemidler().get(0), pn1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(pn1));
	}

	@Test
	public void testOpretDagligSkaevOrdination1() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(0, 0) };
		double[] antalEnheder = { 1 };
		DagligSkaev ds1 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds1);
		assertEquals(LocalDate.of(2021, 3, 1), ds1.getStartDen());
		assertEquals(laegemiddel1, ds1.getLaegemiddel());

		assertTrue(patient1.getOrdinationer().contains(ds1));
	}

	@Test
	public void testOpretDagligSkaevOrdination2() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(03, 00), LocalTime.of(06, 00) };
		double[] antalEnheder = { 2, 2 };
		DagligSkaev ds2 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds2);
		assertEquals(LocalDate.of(2021, 3, 1), ds2.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds2.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds2));
	}

	@Test
	public void testOpretDagligSkaevOrdination3() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(0, 0), LocalTime.of(6, 0), LocalTime.of(12, 0) };
		double[] antalEnheder = { 2, 3, 4 };
		DagligSkaev ds3 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds3);
		assertEquals(LocalDate.of(2021, 3, 1), ds3.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds3.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds3));
	}

	@Test
	public void testOpretDagligSkaevOrdination4() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(00, 00), LocalTime.of(06, 00), LocalTime.of(12, 00),
				LocalTime.of(18, 00) };
		double[] antalEnheder = { 2, 3, 4, 5 };
		DagligSkaev ds4 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds4);
		assertEquals(LocalDate.of(2021, 3, 1), ds4.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds2.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds4));
	}

	@Test
	public void testOpretDagligSkaevOrdination5() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(0, 0), LocalTime.of(6, 30), LocalTime.of(12, 45), LocalTime.of(18, 23),
				LocalTime.of(23, 59) };
		double[] antalEnheder = { 2, 3, 4, 5, 6 };
		DagligSkaev ds5 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds5);
		assertEquals(LocalDate.of(2021, 3, 1), ds5.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds3.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds5));
	}

	// ---------------------------------
	@Test(expected = IllegalArgumentException.class)
	public void testOpretDagligSkaevOrdination6() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(0, 0) };
		double[] antalEnheder = { 1 };
		DagligSkaev ds1 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 11), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds1);
		assertEquals(LocalDate.of(2021, 3, 1), ds1.getStartDen());
		assertEquals(Controller.getAllLaegemidler().get(0), ds1.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretDagligSkaevOrdination7() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(03, 00), LocalTime.of(06, 00) };
		double[] antalEnheder = { 2, 2, 3 };
		DagligSkaev ds2 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds2);
		assertEquals(LocalDate.of(2021, 3, 1), ds2.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds2.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOpretDagligSkaevOrdination8() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(0, 0), LocalTime.of(6, 0), LocalTime.of(12, 0), LocalTime.of(18, 0) };
		double[] antalEnheder = { 2, 3, 4 };
		DagligSkaev ds3 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds3);
		assertEquals(LocalDate.of(2021, 3, 1), ds3.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds3.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds3));
	}

	@Test(expected = DateTimeException.class)
	public void testOpretDagligSkaevOrdination9() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(25, 00), LocalTime.of(06, 00), LocalTime.of(12, 00),
				LocalTime.of(18, 00) };
		double[] antalEnheder = { 2, 3, 4, 5 };
		DagligSkaev ds4 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2020, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds4);
		assertEquals(LocalDate.of(2021, 3, 1), ds4.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds2.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds4));
	}

	@Test
	public void testOpretDagligSkaevOrdination10() {
		// Act
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		LocalTime[] klokkeSlet = { LocalTime.of(0, 0) };
		double[] antalEnheder = { -1 };
		DagligSkaev ds5 = Controller.opretDagligSkaevOrdination(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 8),
				patient1, laegemiddel1, klokkeSlet, antalEnheder);
		// Assert
		assertNotNull(ds5);
		assertEquals(LocalDate.of(2021, 3, 1), ds5.getStartDen());
//		assertEquals(Controller.getAllLaegemidler().get(0), ds3.getLaegemiddel());
		assertTrue(patient1.getOrdinationer().contains(ds5));
	}

	@Test
	public void testAnbefaletDosisPrDoegnTung() {
		double anbefaletDosis = 0;
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 120);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		anbefaletDosis = patient1.getVaegt() * laegemiddel1.getEnhedPrKgPrDoegnTung();
		double forventedeAnbefaletDosis = 240;
		assertEquals(forventedeAnbefaletDosis, anbefaletDosis);
	}

	@Test
	public void testAnbefaletDosisPrDoegnNormal() {

		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 85);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		double anbefaletDosis = patient1.getVaegt() * laegemiddel1.getEnhedPrKgPrDoegnNormal();
		double forventedeAnbefaletDosis = 127.5;
		assertEquals(forventedeAnbefaletDosis, anbefaletDosis);

	}

	@Test
	public void testAnbefaletDosisPrDoegnlet() {
		double anbefaletDosis = 0;
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 25);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		anbefaletDosis = patient1.getVaegt() * laegemiddel1.getEnhedPrKgPrDoegnLet();
		double forventedeAnbefaletDosis = 25;
		assertEquals(forventedeAnbefaletDosis, anbefaletDosis);
	}

	@Test
	public void testAntalOrdinationerPrVægtPrLægemiddel1() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 42);
		Patient patient2 = Controller.opretPatient("1234567811", "Bo Hansen", 120);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 3, 8), patient1, laegemiddel1,
				4, 3, 2, 1);
		Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 3, 8), patient2, laegemiddel1,
				4, 3, 2, 1);

		// act
		int forventedeAntal = 1;
		int fatiskantal = Controller.antalOrdinationerPrVægtPrLægemiddel(40, 80, laegemiddel1);

		// assert
		assertEquals(forventedeAntal, fatiskantal);

	}

	@Test
	public void testAntalOrdinationerPrVægtPrLægemiddel2() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 80);
		Patient patient2 = Controller.opretPatient("1234567811", "Bo Hansen", 30);
		Laegemiddel laegemiddel2 = Controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 3, 8), patient1, laegemiddel2,
				4, 3, 2, 1);
		Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 3, 8), patient2, laegemiddel1,
				4, 3, 2, 1);

		// act
		int forventedeAntal = 0;
		int fatiskantal = Controller.antalOrdinationerPrVægtPrLægemiddel(40, 80, laegemiddel1);

		// assert
		assertEquals(forventedeAntal, fatiskantal);

	}

	@Test
	public void testAntalOrdinationerPrVægtPrLægemiddel3() {
		// arrange
		Patient patient1 = Controller.opretPatient("1234567810", "Hans Hansen", 80);
		Patient patient2 = Controller.opretPatient("1234567811", "Bo Hansen", 40);
		Laegemiddel laegemiddel1 = Controller.opretLaegemiddel("Acetylsalicylsyre", 0.01, 0.015, 0.02, "Styk");
		Laegemiddel laegemiddel2 = Controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 3, 8), patient1, laegemiddel1,
				4, 3, 2, 1);
		Controller.opretDagligFastOrdination(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 3, 8), patient2, laegemiddel1,
				4, 3, 2, 1);

		// act
		int forventedeAntal = 2;
		int fatiskantal = Controller.antalOrdinationerPrVægtPrLægemiddel(40, 80, laegemiddel1);

		// assert
		assertEquals(forventedeAntal, fatiskantal);

	}

}
