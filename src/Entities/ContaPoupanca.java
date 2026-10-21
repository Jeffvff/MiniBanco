package Entities;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(int numero, String titular, double saldoInicial, double taxaRendimento) {
        super(numero, titular, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public boolean sacar(double quantidade) {
        if (quantidade > 0 && quantidade <= getSaldo()) {
            debitar(quantidade);
            return true;
        }
        return false;
    }

    @Override
    public void fecharMes() {
        double rendimento = getSaldo() * taxaRendimento;
        creditar(rendimento);
    }

    @Override
    public String toString() {
        return "Conta poupança - " + super.toString() + String.format(" | Taxa rendimento: %.2f%n", taxaRendimento);
    }
}
