package prova2.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import prova2.model.Produto;

public class ArquivoService {
	
	public ArrayList<Produto> lerArquivo(){
		 ArrayList<Produto> lista = new ArrayList<Produto>();
		 try {
			FileReader fr = new FileReader("produto.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				Produto p = new Produto(linha);
				if(p.isValid()) {
					lista.add(p);
				}
			}
			br.close();
			fr.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void criaArquivo(ArrayList<Produto> lista) {
		try {
			FileWriter fw = new FileWriter("produto.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Produto p : lista) {
				bw.append(p.toString()+"\n");
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
