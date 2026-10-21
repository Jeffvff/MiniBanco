package Entities;

public class ContaCorrente extends Conta {

    private final double limite;
    private final double tarifaMensal;

    public ContaCorrente(int numero, String titular, double saldoInicial, double limite, double tarifaMensal) {
        super(numero, titular, saldoInicial);
        this.limite = limite;
        this.tarifaMensal = tarifaMensal;
    }

    @Override
    public boolean sacar(double quantidade) {
        double total = limite + quantidade;

        if (quantidade > 0 && quantidade <= total) {
            debitar(quantidade);
            return true;
        }
        return false;
    }

    @Override
    public void fecharMes() {
        debitar(tarifaMensal);
    }

    @Override
    public String toString() {
        return "Conta corrente - " + super.toString() + String.format(" | Limite: %.2f | Tarifa mensal: %.2f%n", limite, tarifaMensal);
    }



}
