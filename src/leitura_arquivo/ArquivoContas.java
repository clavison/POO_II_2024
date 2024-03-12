package leitura_arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import exercicio_bancario.ContaBancaria;
import exercicio_bancario.ContaCorrente;
import exercicio_bancario.ContaEspecial;
import exercicio_bancario.ContaPoupanca;

public class ArquivoContas {
	
	public static void main(String[] args) {
		ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();
		try {
			FileReader fr = new FileReader("contas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String v[] = linha.split(",");
				int nr = Integer.parseInt(v[1]);
				double saldo = Double.parseDouble(v[2]);
				if(v[0].equals("0")) {
					contas.add(new ContaCorrente(nr, saldo));
				}
				if(v[0].equals("1")) {
					contas.add(new ContaPoupanca(nr, saldo));
				}
				if(v[0].equals("2")) {
					double limite = Double.parseDouble(v[3]);
					contas.add(new ContaEspecial(nr, saldo, limite));
				}
			}
			br.close();
			fr.close();
			
			for (ContaBancaria c : contas) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
