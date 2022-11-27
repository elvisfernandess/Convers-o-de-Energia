
import java.lang.Math;

public class Teste {

	public int polos;
	public double tensaoFonteV1;
	public double anguloFonteV1;
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
	public double moduloZO;
	public double anguloZO;
	public double polar_real_Z2;
	public double imag_real_Z2;
	public double retangular_modulo_ZO;
	public double retangular_imag_ZO;
	public double real_Z2;
	public double imag_Z2;
	public double real_Z1;
	public double imag_Z1;
	public double retangular_modulo_Z0_Z2;
	public double retangular_angulo_Z0_Z2;
	public double polar_Zeq;
	public double angulo_Zeq;
	public double modulo_I1;
	public double angulo_I1;
	public double polar_modulo_Z0_Z2;
	public double polar_angulo_Z0_Z2;
	public double modulo_E0;
	public double angulo_E0;
	public double Pmec;
	public double Pin;
	public double modulo_I2;
	public double Prot;
	public double Peixo;
	public double FP;
	public double TorqueEixo;

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
		double imag_denominador_Z0 = (real_jXm / real_denominador_Z0) * (180 / Math.PI);
		System.out.println(imag_denominador_Z0);

		System.out.print("|ZO|: ");
		moduloZO = real_numerador_Z0 / real_denominador_Z0;
		System.out.println(moduloZO);

		System.out.print("Ângulo de ZO: ");
		anguloZO = angulo_jXm - imag_denominador_Z0;
		System.out.println(anguloZO);

		retangular_modulo_ZO = (moduloZO * Math.cos(anguloZO * Math.PI / 180));
		System.out.println(retangular_modulo_ZO);

		retangular_imag_ZO = (moduloZO * Math.sin(anguloZO * Math.PI / 180));
		System.out.println(retangular_imag_ZO);

	}

	public void Z1() {

		System.out.print("Parte Real de Z1: ");
		real_Z1 = R1;
		System.out.println(real_Z1);

		System.out.print("Parte Imaginária de Z1: ");
		imag_Z1 = jX1;
		System.out.println(imag_Z1);

	}

	public void Z2() {

		System.out.print("Parte Real de Z2(retangular): ");
		real_Z2 = R2 + _R2;
		System.out.println(real_Z2);

		System.out.print("Parte Imaginária de Z2(retangular): ");
		imag_Z2 = jX2;
		System.out.println(imag_Z2);

		System.out.print("Parte Real Z2(polar): ");
		polar_real_Z2 = Math.sqrt(real_Z2 * real_Z2 + jX2 * jX2);
		System.out.println(polar_real_Z2);

		System.out.print("Parte Imaginária Z2(polar): ");
		imag_real_Z2 = (jX2 / real_Z2) * (180 / Math.PI);
		System.out.println(imag_real_Z2);

	}

	public void Z0_Z2() {

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

		double angulo_denominador_Z0_Z2 = Math.atan(imag_denominador_ZO_Z2 / real_denominador_ZO_Z2) * (180 / Math.PI);
		System.out.println(angulo_denominador_Z0_Z2);

		polar_modulo_Z0_Z2 = real_numerador_Z0_Z2 / real_denominador_Z0_Z2;
		System.out.println(polar_modulo_Z0_Z2);

		polar_angulo_Z0_Z2 = imag_numerador_Z0_Z2 - angulo_denominador_Z0_Z2;
		System.out.println(polar_angulo_Z0_Z2);

		retangular_modulo_Z0_Z2 = polar_modulo_Z0_Z2 * Math.cos(polar_angulo_Z0_Z2 * Math.PI / 180);
		System.out.println(retangular_modulo_Z0_Z2);

		retangular_angulo_Z0_Z2 = polar_modulo_Z0_Z2 * Math.sin(polar_angulo_Z0_Z2 * Math.PI / 180);
		System.out.println(retangular_angulo_Z0_Z2);
	}

	public void Zeq() {
		double real_Zeq = real_Z1 + retangular_modulo_Z0_Z2;
		System.out.println(real_Zeq);

		double imag_Zeq = imag_Z1 + retangular_angulo_Z0_Z2;
		System.out.println(imag_Zeq);

		polar_Zeq = Math.sqrt(real_Zeq * real_Zeq + imag_Zeq * imag_Zeq);
		System.out.println(polar_Zeq);

		angulo_Zeq = Math.atan(imag_Zeq / real_Zeq) * (180 / Math.PI);
		System.out.println(angulo_Zeq);

	}

	public void I1() {
		modulo_I1 = tensaoFonteV1 / polar_Zeq;
		System.out.println(modulo_I1);

		angulo_I1 = anguloFonteV1 - angulo_Zeq;
		System.out.println(angulo_I1);
	}

	public void E0() {
		modulo_E0 = modulo_I1 * polar_modulo_Z0_Z2;
		System.out.println(modulo_E0);

		angulo_E0 = angulo_I1 + polar_angulo_Z0_Z2;
		System.out.println(angulo_E0);

	}

	public void I2() {

		modulo_I2 = modulo_E0 / polar_real_Z2;
		System.out.println(modulo_I2);

		double angulo_I2 = angulo_E0 - imag_real_Z2;
		System.out.println(angulo_I2);

	}

	public void Pin() {

		double modulo_S1 = modulo_I1 * tensaoFonteV1;
		System.out.println(modulo_S1);

		double angulo_S1 = (-angulo_I1) + anguloFonteV1;
		System.out.println(angulo_S1);

		double P1 = modulo_S1 * Math.cos(angulo_S1 * Math.PI / 180);
		System.out.println(P1);

		double Q1 = modulo_S1 * Math.sin(angulo_S1 * Math.PI / 180);
		System.out.println(Q1);

		Pin = 3 * P1;
		System.out.println(Pin);
	}

	public void Pmec() {
		// Pmec = potenciaMec * 745.7;
		System.out.print("Pmec: ");
		Pmec = 3 * modulo_I2 * modulo_I2 * (R2) * ((1 - s) / s);
		System.out.println(Pmec);

	}

	public void Peixo() {
		System.out.print("Peixo: ");
		Peixo = Pmec - Prot;
		System.out.println(Peixo);
	}

	public void TorqueEixo() {
		System.out.print("Torque do Eixo: ");
		double TorqueEixo = (Peixo * frequenciaRede) / (2 * Math.PI * velocidadeMotor);
		System.out.println(TorqueEixo);
	}

	public void Rendimento() {
		System.out.print("Rendimento: ");
		double Rendimento = (Pmec / Pin) * 100;
		System.out.println(Rendimento);
	}

	public void FatorPotencia() {
		System.out.print("Fator de Potência: ");
		FP = Math.cos(-angulo_I1 * Math.PI / 180);
		System.out.println(FP);

	}

	public void Z1_Z0() {
		System.out.println("Sobrecarga: ");

		System.out.print("Parte Real Z1(polar): ");
		double modulo_Z1 = Math.sqrt(real_Z1 * real_Z1 + jX1 * jX1);
		System.out.println(modulo_Z1);

		System.out.print("Parte Imaginária Z1(polar): ");
		double anguloZ1 = Math.atan(jX1 / real_Z1) * (180 / Math.PI);
		System.out.println(anguloZ1);

		System.out.print("Parte Real Z1_Z0(polar): ");
		double moduloZ1_Z0 = modulo_Z1 * moduloZO;
		System.out.println(moduloZ1_Z0);

		System.out.print("Ângulo Z1_Z0(polar): ");
		double anguloZ1_Z0 = anguloZ1 + anguloZO;
		System.out.println(anguloZ1_Z0);

		System.out.print("Parte real denominador Z1_Z0(retangular): ");
		double real_Z1_Z0_den = Rf + R1;
		System.out.println(real_Z1_Z0_den);

		System.out.print("Parte imaginaria denominador Z1_Z0(retangular): ");
		double imag_Z1_Z0_den = jX1 + jXm;
		System.out.println(imag_Z1_Z0_den);

		System.out.print("Parte Real denominador Z1_Z0(polar): ");
		double modulo_Z1_Z0_real = Math.sqrt(real_Z1_Z0_den * real_Z1_Z0_den + imag_Z1_Z0_den * imag_Z1_Z0_den);
		System.out.println(modulo_Z1_Z0_real);

		System.out.print("Ângulo denominador Z1_Z0(polar): ");
		double angulo_Z1_Z0_real = Math.atan(imag_Z1_Z0_den / real_Z1_Z0_den) * (180 / Math.PI);
		System.out.println(angulo_Z1_Z0_real);

		double modulo_Z1_Z0_final = moduloZ1_Z0 / modulo_Z1_Z0_real;
		System.out.println(modulo_Z1_Z0_final);

		double angulo_Z1_Z0_final = anguloZ1_Z0 - angulo_Z1_Z0_real;
		System.out.println(angulo_Z1_Z0_final);

		double retangular_modulo_Z1_Z0_final = modulo_Z1_Z0_final * Math.cos(angulo_Z1_Z0_final * Math.PI / 180);
		System.out.println(retangular_modulo_Z1_Z0_final);

		double retangular_angulo_Z1_Z0_final = modulo_Z1_Z0_final * Math.sin(angulo_Z1_Z0_final * Math.PI / 180);
		System.out.println(retangular_angulo_Z1_Z0_final);

		double zth_imag = retangular_angulo_Z1_Z0_final + jX2;
		System.out.println(zth_imag);

		double zth_real = retangular_modulo_Z1_Z0_final;
		System.out.println(zth_real);

		System.out.print("Modulo Zth: ");
		double modulo_Zth = Math.sqrt((zth_real * zth_real) + zth_imag * zth_imag);
		System.out.println(modulo_Zth);

		System.out.print("Escorregamento: ");
		double s_sobrecarga = (R2 / Math.abs(modulo_Zth));
		System.out.println(s_sobrecarga);

		System.out.print("nr: ");
		double nr_sobrecarga = -((s_sobrecarga * 1800) - 1800);
		System.out.println(nr_sobrecarga);

		double TorqueCarga = (Pmec * 60) / (2 * Math.PI * nr_sobrecarga);
		System.out.println(TorqueCarga);

		if (TorqueCarga > TorqueEixo) {
			System.out.println("Sim, está à sobrecarga (o torque da carga está acima do Torque Nominal).");

		} else {
			System.out.println("Não está à sobrecarga (o torque da carga está abaixo do Torque Nominal).");
		}

	}

}
