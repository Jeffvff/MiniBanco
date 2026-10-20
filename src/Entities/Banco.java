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

    


}
