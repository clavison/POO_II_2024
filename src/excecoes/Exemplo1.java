package excecoes;

import javax.swing.JOptionPane;

public class Exemplo1 {

	public static void main(String[] args) {
		try {
			int n = Integer.parseInt(JOptionPane.showInputDialog("N"));
			if( n % 2 != 0) {
				throw new Exception("Apenas números pares");
			}
			int vetor[] = new int[n];
			for (int i = 0; i < n; i++) {
				vetor[i] = i * i;
			}
			int indice = Integer.parseInt(JOptionPane.showInputDialog("Índice"));
			System.out.println(vetor[indice]);
			// vetor = null;
			// System.out.println(vetor.length);
		} catch (NumberFormatException e) {
			System.out.println("Número deve ser inteiro");
		}catch (NegativeArraySizeException e) {
			System.out.println("Tamanho array não pode ser negativo");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Índice Inválido");
		}catch ( Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Adeus");
	}

}
