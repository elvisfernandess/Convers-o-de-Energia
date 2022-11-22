
import java.lang.Math;

public class Teste {

	public int polos;
	public double tensaoFonteV1;
	public double angulooFonteV1;
	public double frequenciaRede;
	public double potenciaMec;
	public double velocidadeMotor;
	public double R1;
	public double jX1;
	public double R2;
	public double jX2;
	public double Rf;
	public double jXm;
	public double ns; // Velocidade do Campo Girante
	public double nr; // Velocidade do Motor
	public double s; // escorregamento
	public double fr; // escorregamento
	public double _R2; // valor referente � carga
	public double moduloZO;
	public double anguloZO;
	public double polar_real_Z2;
	public double imag_real_Z2;
	public double retangular_modulo_ZO;
	public double retangular_imag_ZO;
	public double real_Z2;
	public double imag_Z2;

	public void escorregamento() {

		// System.out.print("Velocidade do Campo Girante:");
		ns = (120 * frequenciaRede) / polos;
		// System.out.println(ns);

		System.out.print("Escorregamento:");
		nr = velocidadeMotor;
		s = ((ns - nr) / ns);
		System.out.println(s);

	}

	public void velocidadeCampoGirante() {
		System.out.print("Velocidade do Campo Girante:");
		ns = (120 * frequenciaRede) / polos;
		System.out.println(ns);

	}

	public void frequenciaCorrentesInduzidas() {
		System.out.print("Frequencia das Correntes Induzidas:");
		fr = s * ns;
		System.out.println(fr);

	}

	public void correnteAlimentacaoRotor() {
		System.out.print("R2':");
		_R2 = R2 * ((1 - s) / s);
		System.out.println(_R2);

	}

	public void Z0() {
		System.out.print("Parte Real de jXm: ");
		double real_jXm = jXm;
		System.out.println(real_jXm);
		System.out.print("�ngulo de jXm: ");
		double angulo_jXm = 90;
		System.out.println(angulo_jXm);

		System.out.print("Parte Real de Rf:");
		double real_Rf = Rf;
		System.out.println(real_Rf);
		System.out.print("�ngulo de Rf:");
		double angulo_Rf = 0;
		System.out.println(angulo_Rf);

		System.out.print("Parte Real do numerador ZO: ");
		double real_numerador_Z0 = real_jXm * Rf;
		System.out.println(real_numerador_Z0);

		System.out.print("Parte Imagin�ria do numerador ZO: ");
		double imag_numerador_Z0 = angulo_jXm + angulo_Rf;
		System.out.println(imag_numerador_Z0);

		System.out.print("Parte Real do denominador ZO: ");
		double real_denominador_Z0 = Math.sqrt(real_jXm * real_jXm + Rf * Rf);
		System.out.println(real_denominador_Z0);

		System.out.print("Parte Imagin�ria do denominador ZO: ");
		double imag_denominador_Z0 = (real_jXm / real_denominador_Z0) * (180 / 3.14);
		System.out.println(imag_denominador_Z0);

		System.out.print("|ZO|: ");
		moduloZO = real_numerador_Z0 / real_denominador_Z0;
		System.out.println(moduloZO);

		System.out.print("�ngulo de ZO: ");
		anguloZO = angulo_jXm - imag_denominador_Z0;
		System.out.println(anguloZO);

		retangular_modulo_ZO = (moduloZO * Math.cos(anguloZO * Math.PI / 180));
		System.out.println(retangular_modulo_ZO);

		retangular_imag_ZO = (moduloZO * Math.sin(anguloZO * Math.PI / 180));
		System.out.println(retangular_imag_ZO);

	}

	public void Z1() {

		System.out.print("Parte Real de Z1: ");
		double real_Z1 = R1;
		System.out.println(real_Z1);

		System.out.print("Parte Imagin�ria de Z1: ");
		double imag_Z1 = jX1;
		System.out.println(imag_Z1);

	}

	public void Z2() {

		System.out.print("Parte Real de Z2(retangular): ");
		real_Z2 = R2 + _R2;
		System.out.println(real_Z2);

		System.out.print("Parte Imagin�ria de Z2(retangular): ");
		imag_Z2 = jX2;
		System.out.println(imag_Z2);

		System.out.print("Parte Real Z2(polar): ");
		polar_real_Z2 = Math.sqrt(real_Z2 * real_Z2 + jX2 * jX2);
		System.out.println(polar_real_Z2);

		System.out.print("Parte Imagin�ria Z2(polar): ");
		imag_real_Z2 = (jX2 / real_Z2) * (180 / 3.14);
		System.out.println(imag_real_Z2);

	}

	public void Z0_Z2() {
		/*
		 * System.out.println("Teste");
		 * 
		 * System.out.print("|ZO|: "); System.out.println(moduloZO);
		 * System.out.print("�ngulo de ZO: "); System.out.println(anguloZO);
		 * 
		 * System.out.print("Parte Real Z2(polar): ");
		 * System.out.println(polar_real_Z2);
		 * System.out.print("Parte Imagin�ria Z2(polar): "); System.out.println();
		 */

		System.out.print("Parte Real do numerador ZO//Z2(polar): ");
		double real_numerador_Z0_Z2 = moduloZO * polar_real_Z2;
		System.out.println(real_numerador_Z0_Z2);

		System.out.print("Parte Imaginaria do numerador ZO//Z2(polar): ");
		double imag_numerador_Z0_Z2 = anguloZO + imag_real_Z2;
		System.out.println(imag_numerador_Z0_Z2);

		System.out.print("Parte Real do denominador ZO//Z2(retangular): ");
		double real_denominador_ZO_Z2 = retangular_modulo_ZO + real_Z2;
		System.out.println(real_denominador_ZO_Z2);

		System.out.print("Parte Imaginaria do denominador ZO//Z2(retangular): ");
		double imag_denominador_ZO_Z2 = retangular_imag_ZO + imag_Z2;
		System.out.println(imag_denominador_ZO_Z2);

		System.out.print("Parte Real do denominador ZO//Z2(polar): ");
		double real_denominador_Z0_Z2 = Math.sqrt(
				real_denominador_ZO_Z2 * real_denominador_ZO_Z2 + imag_denominador_ZO_Z2 * imag_denominador_ZO_Z2);
		System.out.println(real_denominador_Z0_Z2);
		
		

	}

}
