package prova2.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import prova2.Loja;
import prova2.model.Produto;
import prova2.services.ArquivoService;
import prova2.services.ProdutoService;

class LojaTest {
	
	ProdutoService produtoService = new ProdutoService();
	ArquivoService arquivoService = new ArquivoService();
	

	@Test
	void PopulaTbltest() {
		Loja.populaTabela();
		ArrayList<Produto> lista = produtoService.listAll();
		assertEquals(18, lista.size());
		
		Loja.populaTabela();
		lista = produtoService.listAll();
		assertEquals(18, lista.size());
	}
	
	@Test
	void vendeEstoqueOk() {
		double total = Loja.realizaVenda(1, 2);
		assertEquals(7999.98, total);
		Produto p = produtoService.findById(1);
		assertEquals(13, p.getEstoque());
	}
	
	@Test
	void vendeEstoqueInsuficiente() {
		double total = Loja.realizaVenda(2, 40);
		assertEquals(0, total);
		Produto p = produtoService.findById(2);
		assertEquals(30, p.getEstoque());
	}
	
	@Test
	void vendeProdutoInexistente() {
		double total = Loja.realizaVenda(8, 1);
		assertEquals(0, total);
		Produto p = produtoService.findById(8);
		assertNull(p);
	}
	
	@Test
	void exportaparaTbl() {
		Loja.exportaTbl();
		ArrayList<Produto> lista = arquivoService.lerArquivo();
		assertEquals(18,lista.size());
	}
	
	

}
