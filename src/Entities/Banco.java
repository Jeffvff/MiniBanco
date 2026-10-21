package Entities;

import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();

    //conta corrente
    public void abrirConta(int numero, String titular, double saldoInicial, double limite, double tarifaMensal) {
        contas.add(new ContaCorrente(numero, titular, saldoInicial, limite, tarifaMensal));
    }

    //conta poupanca
    public void abrirConta(int numero, String titular, double saldoInicial, double taxaRendimento) {
        contas.add(new ContaPoupanca(numero, titular, saldoInicial, taxaRendimento));
    }

    public Conta buscarPorNumero(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    public boolean transferir(Conta origem, Conta destino, double valor) {
        if (origem.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void fecharMesDeTodas() {
        for (Conta c : contas) {
            c.fecharMes();
        }
    }

    public void listarContas() {
        for (Conta c : contas) {
            System.out.print(c);
        }
    }

}
