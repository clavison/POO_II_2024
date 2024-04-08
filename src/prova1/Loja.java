package prova1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Loja {
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<ItemCompra> itens = new ArrayList<ItemCompra>();
	
	public double getTotalCompra() {
		double total = 0;
		try {
			FileReader fr = new FileReader("compra.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				total += Double.parseDouble(parts[3]);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public void processarCompra() {
		try {
			FileWriter fw = new FileWriter("compra.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (ItemCompra item : itens) {
				if(item.podeVender()) {
					bw.append(item.toString());
				}
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregaProdutos() {
		try {
			FileReader fr = new FileReader("lista_produtos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				String nome = parts[0];
				int estoque = Integer.parseInt(parts[1]);
				String vlStr = parts[2] +"."+ parts[3];
				vlStr = vlStr.replace("R$ ", "").trim();
				double vl = Double.parseDouble(vlStr);
				produtos.add(new Produto(nome, estoque, vl));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void carregaListaCompra() {
		try {
			FileReader fr = new FileReader("lista_compras.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String parts[] = linha.split(",");
				Produto p = buscaProduto(parts[0]);
				if(p != null) {
					itens.add(new ItemCompra(p, Integer.parseInt(parts[1])));
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Produto buscaProduto(String nome) {
		for (Produto p : produtos) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<ItemCompra> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemCompra> itens) {
		this.itens = itens;
	}
	
	

}
