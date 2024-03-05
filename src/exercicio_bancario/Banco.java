package exercicio_bancario;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<ContaBancaria> contas;

	public Banco() {
		contas = new ArrayList<>();
	}

	public void adicionarConta(ContaBancaria conta) {
		contas.add(conta);
	}

	public List<ContaBancaria> getContas() {
		return contas;
	}
}
