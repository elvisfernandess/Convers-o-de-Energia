public class TesteFinal {

	public static void main(String[] args) {

		Teste teste = new Teste(); // instancia da classe Teste

		teste.polos = 4;
		teste.tensaoFonteV1 = 220.0;
		teste.anguloFonteV1 = 0;
		teste.frequenciaRede = 60.0;
		teste.potenciaMec = 20.0;
		teste.velocidadeMotor = 1750.0;
		teste.R1 = 0.095;
		teste.jX1 = 0.6800;
		teste.R2 = 0.3000;
		teste.jX2 = 0.6720;
		teste.Rf = 500;
		teste.jXm = 18.70;
		teste.Prot = 0;
		
		System.out.println("Quest�o 1)");
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
		teste.Z0_Z2();
		teste.Zeq();
		teste.I1();
		teste.E0();
		teste.I2();
		
		System.out.println("e)");
		teste.Pin();
		
		System.out.println("f)");
		teste.Pmec();
		teste.Peixo();
		
		System.out.println("g)");
		teste.TorqueEixo();
		
		System.out.println("h)");
		teste.Rendimento();
		
		System.out.println("i)");
		teste.FatorPotencia();
		
		System.out.println("j)");
		teste.Z1_Z0();
	}
}