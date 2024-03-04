package revisao_desafio_jogador.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import revisao_desafio_jogador.Jogador;

class JogadorTest {

	Jogador j1;
	Jogador j2;
	
	@BeforeEach
	public void inicializaJogadores() {
		j1 = new Jogador();
		j2 = new Jogador("A", 5, 3);
	}
	
	@Test
	public void construtorVazioTest() {
		assertEquals(999, j1.getCamisa());
		assertEquals(-1, j1.getGols());
		assertEquals("", j1.getNome());
		assertEquals("Jogador [nome=, camisa=999, gols=-1]", j1.toString());
	}
	@Test
	public void construtorParametros() {
		assertEquals(5, j2.getCamisa());
		assertEquals(3, j2.getGols());
		assertEquals("A", j2.getNome());
		assertEquals("Jogador [nome=A, camisa=5, gols=3]", j2.toString());
	}

}
