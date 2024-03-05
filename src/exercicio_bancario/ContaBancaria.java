package exercicio_bancario;

public class ContaBancaria {
	
	private int numeroConta;
    private double saldo;

    public ContaBancaria(int numeroConta, double saldo) {
        setNumeroConta(numeroConta);
        setSaldo(saldo);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void deposito(double valor) {
        setSaldo(getSaldo() + valor);
    }

    public boolean saque(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo()-valor);
            return true;
        }
        return false;
    }

    public boolean transferencia(ContaBancaria contaDestino, double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            contaDestino.deposito(valor);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
    	return getNumeroConta()+" - "+getSaldo();
    }

}
