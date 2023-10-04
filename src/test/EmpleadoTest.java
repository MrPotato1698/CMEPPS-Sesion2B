package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;

class EmpleadoTest {
	private Empleado.TipoEmpleado valueTipo;
	private float valueVentaMes;
	private float valueHorasExtras;
	private float valueNominaBruta;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		valueTipo = Empleado.TipoEmpleado.Vendedor;
		valueVentaMes = 1000;
		valueHorasExtras = 5;
		valueNominaBruta = 2000;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test  //Probamos TipoEmpleado.Vendedor, VentaMes entre 100-1500, Horas Extra Positivo
	void testCalculaNominaBruta() {
		float expected = 2250;
		float actual = Empleado.calculaNominaBruta(valueTipo, valueVentaMes, valueHorasExtras);
		assertEquals(expected, actual);
	}

	@Test  // Probamos NominaBruta menor que 2100
	void testCalculaNominaNeta() {
		float expected = 2000;
		float actual = Empleado.calculaNominaNeta(valueNominaBruta);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaBrutaEncargado() {
		valueTipo=Empleado.TipoEmpleado.Encargado;
		float expected = 2750;
		float actual = Empleado.calculaNominaBruta(valueTipo, valueVentaMes, valueHorasExtras);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaBrutaOtro() {
		valueTipo=null;
		float expected = 2750;
		float actual = Empleado.calculaNominaBruta(valueTipo, valueVentaMes, valueHorasExtras);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaBrutaVentasMesNegativa() {
		valueVentaMes=-1;
		float expected = 2150;
		float actual = Empleado.calculaNominaBruta(valueTipo, valueVentaMes, valueHorasExtras);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaBrutaVentasMesMenor1000() {
		valueVentaMes=850;
		float expected = 2150;
		float actual = Empleado.calculaNominaBruta(valueTipo, valueVentaMes, valueHorasExtras);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaBrutaVentasMesMayor1500() {
		valueVentaMes=2000;
		float expected = 2350;
		float actual = Empleado.calculaNominaBruta(valueTipo, valueVentaMes, valueHorasExtras);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaBrutaHorasExtraNegativo() {
		valueHorasExtras=-5;
		float expected = 1950;
		float actual = Empleado.calculaNominaBruta(valueTipo, valueVentaMes, valueHorasExtras);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaNetaNegativa() {
		valueNominaBruta = -100;
		float expected = -100;
		float actual = Empleado.calculaNominaNeta(valueNominaBruta);
		assertEquals(expected, actual);
	}


	@Test
	void testCalculaNominaNetaMayor2100Menor2500() {
		valueNominaBruta = 2400;
		float expected = 2040;
		float actual = Empleado.calculaNominaNeta(valueNominaBruta);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculaNominaNetaMayor2500() {
		valueNominaBruta = 3000;
		float expected = 2460;
		float actual = Empleado.calculaNominaNeta(valueNominaBruta);
		assertEquals(expected, actual);
	}

}
