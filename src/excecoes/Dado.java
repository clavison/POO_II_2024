package excecoes;

import javax.swing.JOptionPane;

public class Dado {
	
	int numero;
	
	public void lerNumero() {
		try {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Nr"));
		} catch (NumberFormatException e) {
			System.err.println("Erro na classe dado");
		}
	}
	public void lerNumero3() throws NumberFormatException{
		try {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Nr"));
		} catch (NumberFormatException e) {
			System.err.println("Desconectando da AWS");
			throw e;
		}
	}
	
	public void lerNumero2() throws NumberFormatException {
		numero = Integer.parseInt(JOptionPane.showInputDialog("Nr"));
	}

}
