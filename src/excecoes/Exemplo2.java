package excecoes;

import java.io.EOFException;

public class Exemplo2 {
	public static void main(String[] args) {
		Dado d = new Dado();
		try {
			//d.lerNumero();
			d.lerNumero3();
		}catch (NumberFormatException e) {
			System.out.println("Erro no main");
		}
		System.out.println(d.numero);
		System.err.println("Adeus");
	}

}
