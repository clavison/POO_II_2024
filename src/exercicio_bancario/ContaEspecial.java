package exercicio_bancario;

public class ContaEspecial extends ContaBancaria {
	private double limite;

	public ContaEspecial(int numeroConta, double saldo, double limite) {
		super(numeroConta, saldo);
		setLimite(limite);
	}

	@Override
	public boolean saque(double valor) {
		if (valor <= getSaldo() + getLimite()) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}
