package exercicio_bancario;

import java.time.LocalDate;

public class ContaPoupanca extends ContaBancaria {
	
    private static final int LIMITE_SAQUES_MES = 5;
    private int saquesRealizadosMes;
    private int mesUltimoSaque;

    public ContaPoupanca(int numeroConta, double saldo) {
        super(numeroConta, saldo);
        saquesRealizadosMes = 0;
        mesUltimoSaque = LocalDate.now().getMonthValue(); 
    }

    @Override
    public boolean saque(double valor) {
        LocalDate hoje = LocalDate.now();
        if (hoje.getMonthValue() != mesUltimoSaque) {
            saquesRealizadosMes = 0; 
            mesUltimoSaque = hoje.getMonthValue(); 
        }
        if (saquesRealizadosMes < LIMITE_SAQUES_MES && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            saquesRealizadosMes++;
            return true;
        }
        return false;
    }
}
