package Entities;

public abstract class Conta {
    private int numero;
    private String titular;
    private double saldo;

    public Conta(int numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public boolean depositar(double quantidade) {
        if (quantidade <= 0) return false;
        creditar(quantidade);
        return true;
    }

    public abstract boolean sacar(double quantidade);

    public abstract void fecharMes();

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void creditar(double valor) {
        saldo += valor;
    }

    protected void debitar(double valor) {
        saldo -= valor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
