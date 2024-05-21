package prova2;

import java.util.ArrayList;

import prova2.model.Produto;
import prova2.services.ArquivoService;
import prova2.services.ProdutoService;

public class Loja {
	static ProdutoService produtoService = new ProdutoService();
	static ArquivoService arquivoService = new ArquivoService();
	
	public static void populaTabela() {
		produtoService.limpaTblProduto();
		ArrayList<Produto> produtosArq = arquivoService.lerArquivo();
		for (Produto p : produtosArq) {
			produtoService.insereProduto(p);
		}
	}
	
	public static double realizaVenda(int id, int qtd) {
		Produto p = produtoService.findById(id);
		double total = 0;
		if( p!= null) {
			if(p.getEstoque() >= qtd) {
				produtoService.atualizaEstoque(p, p.getEstoque()-qtd);
				total = p.getValor()*qtd;
			}
		}
		return total;
	}
	
	public static void exportaTbl() {
		ArrayList<Produto> produtosTbl = produtoService.listAll();
		arquivoService.criaArquivo(produtosTbl);
	}

}
