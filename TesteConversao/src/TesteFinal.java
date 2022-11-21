public class TesteFinal {

	public static void main(String[] args) {

		Teste teste = new Teste(); // instancia da classe Teste

		teste.polos = 4;
		teste.angulooFonteV1 = 220.0;
		teste.frequenciaRede = 60.0;
		teste.potenciaMec = 20.0;
		teste.velocidadeMotor = 1750.0;
		teste.R1 = 0.095;
		teste.jX1 = 0.6800;
		teste.R2 = 0.3000;
		teste.jX2 = 0.6720;
		teste.Rf = 500;
		teste.jXm = 18.70;
		System.out.print("a)");
		teste.escorregamento();
		System.out.print("b)");
		teste.velocidadeCampoGirante();
		System.out.print("c)");
		teste.frequenciaCorrentesInduzidas();

		System.out.println("d)");
		teste.correnteAlimentacaoRotor();
		teste.Z0();
		teste.Z1();
		teste.Z2();
	}
}