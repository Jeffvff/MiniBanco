package Application;

import Entities.Banco;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        banco.abrirConta(1, "Maria Silva", 100.0, 500.0, 15.0);
        banco.abrirConta(2, "João Souza", 1000.0, 0.005);

        /*
        1 - Abrir conta corrente
        2 - Abrir conta poupança
        3 - Depositar
        4 - Sacar
        5 - Transferir
        6 - Fechar o mês (todas as contas)
        7 - Listar contas
        0 - Sair
        */


        System.out.printf("1 - Abrir conta corrente.%n2 - Abrir conta poupança%n");
        System.out.printf("3 - Depositar.%n4 - Sacar.%n5 - Transferir%n");
        System.out.printf("6 - Fechar o mês.%n7 - Listar Contas.%n0 - Sair.%n");
        System.out.print("Selecione: ");
        int escolhaMenu = sc.nextInt();





    }
}
