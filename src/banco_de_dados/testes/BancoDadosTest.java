package banco_de_dados.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import banco_de_dados.CidadeService;
import banco_de_dados.ClienteService;
import banco_de_dados.model.Cidade;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BancoDadosTest {
	
	@BeforeAll
	static void inicializa() {
		CidadeService.limpaTblCidade();
		ClienteService.limpaTblCliente();
	}

	
	@Test
	@Order(1)
	void insereCidadeTest() {
		System.out.println("********* 1");
		Cidade c = new Cidade(0,"Araranguá","SC");
		assertEquals(1, CidadeService.insereCidade(c));
	}
	
	@Test
	@Order(2)
	void listaCidadeTest() {
		System.out.println("********* 2");
		ArrayList<Cidade> lista = CidadeService.listAll();
		assertEquals(1, lista.size());
		assertEquals("Araranguá", lista.get(0).getNome());
	}
	
//	@Test
//	void alteraCidadeExistente() {
//		Cidade c = new Cidade(5, "Brasília", "DF");
//		assertEquals(1, CidadeService.alteraCidade(c));
//	}
//	
//	@Test
//	void alteraCidadeInexistente() {
//		Cidade c = new Cidade(25, "Brasília", "DF");
//		assertEquals(0, CidadeService.alteraCidade(c));
//	}
//	
	
//	@Test
//	void listaClienteTest() {
//		ArrayList<Cliente> lista = ClienteService.listAll();
//		for (Cliente c : lista) {
//			System.out.println(c);
//		}
//	}
	
//	@Test
//	void excluiCidadeExistente() {
//		Cidade c = new Cidade(1,"","");
//		assertEquals(1, CidadeService.excluiCidade(c));
//	}
	
//	@Test
//	void excluiCidadeInexistente() {
//		Cidade c = new Cidade(1,"","");
//		assertEquals(0, CidadeService.excluiCidade(c));
//	}
//	
	
//	@Test
//	void insereClienteTest() {
//		Cliente c = new Cliente(0, "A", 11, "M", new Cidade(2, "Orleans","SC"));
//		assertEquals(1, ClienteService.insereCliente(c));
//	}
	
//	@Test
//	void alteraClienteExistente() {
//		Cliente c = new Cliente(1, "A", 11, "M", new Cidade(3, "São Paulo","SP"));
//		assertEquals(1, ClienteService.alteraCliente(c));
//	}
	
	
	

}
