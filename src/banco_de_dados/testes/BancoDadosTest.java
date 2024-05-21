package banco_de_dados.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import banco_de_dados.CidadeService;
import banco_de_dados.ClienteService;
import banco_de_dados.model.Cidade;
import banco_de_dados.model.Cliente;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BancoDadosTest {
	
	@BeforeAll
	static void inicializa() {
		ClienteService.limpaTblCliente();
		CidadeService.limpaTblCidade();
	}

	
	@Test
	@Order(1)
	void insereCidadeTest() {
		Cidade c = new Cidade(0,"Araranguá","SC");
		assertEquals(1, CidadeService.insereCidade(c));
	}
	
	@Test
	@Order(2)
	void listaCidadeTest() {
		ArrayList<Cidade> lista = CidadeService.listAll();
		assertEquals(1, lista.size());
		assertEquals("Araranguá", lista.get(0).getNome());
	}
	
	@Test
	@Order(3)
	void alteraCidadeExistente() {
		Cidade c = new Cidade(1, "Brasília", "DF");
		assertEquals(1, CidadeService.alteraCidade(c));
	}
	
	@Test
	@Order(4)
	void alteraCidadeInexistente() {
		Cidade c = new Cidade(25, "Brasília", "DF");
		assertEquals(0, CidadeService.alteraCidade(c));
	}
	
	@Test
	@Order(5)
	void insereClienteTest() {
		Cliente c = new Cliente(0, "A", 11, "M", new Cidade(1, "",""));
		assertEquals(1, ClienteService.insereCliente(c));
	}
	
	
	@Test
	@Order(6)
	void listaClienteTest() {
		ArrayList<Cliente> lista = ClienteService.listAll();
		assertEquals(1, lista.size());
		assertEquals("Brasília", lista.get(0).getCidade().getNome());
	}
	
	@Test
	@Order(7)
	void excecaoTest() {
		assertThrows(NullPointerException.class, () ->{
			ClienteService.retornaExcecao(true);
		});
	}
	
}
