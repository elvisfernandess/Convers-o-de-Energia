
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
	public double _R2; // valor referente à carga

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
		System.out.print("Ângulo de jXm: ");
		double angulo_jXm = 90;
		System.out.println(angulo_jXm);

		System.out.print("Parte Real de Rf:");
		double real_Rf = Rf;
		System.out.println(real_Rf);
		System.out.print("Ângulo de Rf:");
		double angulo_Rf = 0;
		System.out.println(angulo_Rf);

		System.out.print("Parte Real do numerador ZO: ");
		double real_numerador_Z0 = real_jXm * Rf;
		System.out.println(real_numerador_Z0);

		System.out.print("Parte Imaginária do numerador ZO: ");
		double imag_numerador_Z0 = angulo_jXm + angulo_Rf;
		System.out.println(imag_numerador_Z0);

		System.out.print("Parte Real do denominador ZO: ");
		double real_denominador_Z0 = Math.sqrt(real_jXm * real_jXm + Rf * Rf);
		System.out.println(real_denominador_Z0);

		System.out.print("Parte Imaginária do denominador ZO: ");
		double imag_denominador_Z0 = (real_jXm / real_denominador_Z0) * (180 / 3.14);
		System.out.println(imag_denominador_Z0);

		System.out.print("|ZO|: ");
		double moduloZO = real_denominador_Z0;
		System.out.println(moduloZO);

		System.out.print("Ângulo de ZO: ");
		double anguloZO = angulo_jXm - imag_denominador_Z0;
		System.out.println(anguloZO);

	}

	public void Z1() {

		System.out.print("Parte Real de Z1: ");
		double real_Z1 = R1;
		System.out.println(real_Z1);

		System.out.print("Parte Imaginária de Z1: ");
		double imag_Z1 = jX1;
		System.out.println(imag_Z1);

	}

	public void Z2() {

		System.out.print("Parte Real de Z2: ");
		double real_Z2 = R2;
		System.out.println(real_Z2);

		System.out.print("Parte Imaginária de Z2: ");
		double imag_Z2 = jX2;
		System.out.println(imag_Z2);

	}

}
