package Application;

import Entities.Banco;
import Entities.Conta;

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


        do {
                System.out.printf("1 - Abrir conta corrente.%n2 - Abrir conta poupança%n");
                System.out.printf("3 - Depositar.%n4 - Sacar.%n5 - Transferir%n");
                System.out.printf("6 - Fechar o mês.%n7 - Listar Contas.%n0 - Sair.%n");
                System.out.print("Selecione: ");
                int escolhaMenu = sc.nextInt();
                switch (escolhaMenu) {
                    case 1:
                        // conta corrente: numero, titular, saldo, limite e tarifa mensal
                        int numeroConta = 0;
                        do {
                            System.out.print("Digite o numero da conta: ");
                            numeroConta = sc.nextInt();
                            sc.nextLine();
                            if (banco.buscarPorNumero(numeroConta) != null) {
                                System.out.println("Ja existe uma conta com esse numero! Tente novamente!");
                            } else {
                                System.out.println("Sucesso.");
                            }
                        } while (banco.buscarPorNumero(numeroConta) != null);
                        System.out.print("Insira o nome do titular: ");
                        String titular = sc.nextLine().trim();
                        System.out.println("Sucesso.");
                        double saldoInicial = 0;
                        do {
                            System.out.print("Insira o saldo inicial da conta: ");
                            saldoInicial = sc.nextDouble();
                            sc.nextLine();
                            if (saldoInicial <= 0) {
                                System.out.println("Saldo invalido. Insira um valor maior que 0!");
                            } else {
                                System.out.println("Sucesso.");
                            }
                        } while (saldoInicial <= 0);
                        double limite = 0;
                        do {
                            System.out.print("Insira o limite: ");
                            limite = sc.nextDouble();
                            sc.nextLine();
                            if (limite <= 0) {
                                System.out.println("Limite invalido. Insira um valor maior que 0!");
                            } else {
                                System.out.println("Sucesso.");
                            }
                        } while (limite <= 0);
                        double tarifaMensal = 0;
                        do {
                            System.out.print("Insira a tarifa mensal: ");
                            tarifaMensal = sc.nextDouble();
                            sc.nextLine();
                            if (tarifaMensal <= 0) {
                                System.out.println("tarifa mensal invalido. Insira um valor maior que 0!");
                            } else {
                                System.out.println("Sucesso.");
                            }
                        } while (tarifaMensal <= 0);
                        banco.abrirConta(numeroConta, titular, saldoInicial, limite, tarifaMensal);
                        System.out.println("Conta corrente aberta com sucesso.");
                        System.out.print("Press enter to continue:");
                        sc.nextLine();

                        break;
                    case 2:
                        //conta poupanca: numero, titular, saldo inicial e taxa de rendimento
                        do {
                            System.out.print("Digite o numero da conta: ");
                            numeroConta = sc.nextInt();
                            sc.nextLine();
                            if (banco.buscarPorNumero(numeroConta) != null) {
                                System.out.println("Ja existe uma conta com esse numero! Tente novamente!");
                            } else {
                                System.out.println("Sucesso.");
                            }
                        } while (banco.buscarPorNumero(numeroConta) != null);
                        System.out.print("Insira o nome do titular: ");
                        titular = sc.nextLine().trim();
                        System.out.println("Sucesso.");
                        saldoInicial = 0;
                        do {
                            System.out.print("Insira o saldo inicial da conta: ");
                            saldoInicial = sc.nextDouble();
                            sc.nextLine();
                            if (saldoInicial <= 0) {
                                System.out.println("Saldo invalido. Insira um valor maior que 0!");
                            } else {
                                System.out.println("Sucesso.");
                            }
                        } while (saldoInicial <= 0);
                        double taxaRendimento = 0.005;
                        do {
                            System.out.print("Insira a taxa de rendimento (padrao: 0.005): ");
                            taxaRendimento = sc.nextDouble();
                            sc.nextLine();
                            if (taxaRendimento <= 0) {
                                System.out.println("Taxa de rendimento invalida. Insira um valor maior que 0!");
                            } else {
                                System.out.println("Sucesso.");
                            }
                        } while (taxaRendimento <= 0);
                        banco.abrirConta(numeroConta, titular, saldoInicial, taxaRendimento);
                        System.out.println("Conta poupança aberta com sucesso.");
                        System.out.print("Press enter to continue:");
                        sc.nextLine();

                        break;
                    case 3:
                        System.out.print("Insira o numero da conta que deseja realizar o deposito: ");
                        numeroConta = sc.nextInt();
                        sc.nextLine();
                        Conta contaDeposito = banco.buscarPorNumero(numeroConta);
                        if (contaDeposito == null) {
                            System.out.println("Não existe uma conta com esse numero.");
                        } else {
                            System.out.print("insira o valor que deseja depositar: ");
                            double quantidadeDeposito = sc.nextDouble();
                            sc.nextLine();
                            if (!contaDeposito.depositar(quantidadeDeposito)) {
                                System.out.println("Numero Invalido. Transação não realizada!");
                            } else {
                                System.out.println("Transação realizada com sucesso.");
                            }
                        }
                        System.out.print("Press enter to continue:");
                        sc.nextLine();

                        break;
                    case 4:
                        System.out.print("Insira o numero da conta que deseja realizar o saque: ");
                        numeroConta = sc.nextInt();
                        sc.nextLine();
                        Conta contaSaque = banco.buscarPorNumero(numeroConta);
                        if (contaSaque == null) {
                            System.out.println("Não existe uma conta com esse numero.");
                        } else {
                            System.out.print("insira o valor que deseja sacar: ");
                            double quantidadeSaque = sc.nextDouble();
                            sc.nextLine();
                            if (!contaSaque.sacar(quantidadeSaque)) {
                                System.out.println("Numero invalido. Transação não realizada.");
                            } else {
                                System.out.println("Saque realizado com sucesso.");
                            }
                        }
                        System.out.print("Press enter to continue:");
                        sc.nextLine();

                        break;
                    case 5:
                        System.out.print("Insira o numero da conta de origem: ");
                        int numeroContaOrigem = sc.nextInt();
                        sc.nextLine();
                        Conta contaOrigem = banco.buscarPorNumero(numeroContaOrigem);
                        if (contaOrigem == null) {
                            System.out.println("Não existe conta com esse numero.");
                        } else {
                            System.out.print("Insira o numero da conta de destino: ");
                            int numeroContaDestino = sc.nextInt();
                            sc.nextLine();
                            Conta contaDestino = banco.buscarPorNumero(numeroContaOrigem);
                            if (contaDestino == null) {
                                System.out.println("Não existe conta com esse numero.");
                            } else {
                                System.out.println("Insira a quantidade da transação.");
                                double valorTransacao = sc.nextDouble();
                                sc.nextLine();
                                if (!banco.transferir(contaOrigem, contaDestino, valorTransacao)) {
                                    System.out.println("Transação falhou. insira valores corretos.");
                                } else {
                                    banco.transferir(contaOrigem, contaDestino, valorTransacao);
                                    System.out.println("Transação Concluida com sucesso.");
                                }
                            }
                        }
                        System.out.print("Press enter to continue:");
                        sc.nextLine();

                        break;
                    case 6:
                        System.out.println("Fechando mes de todas as contas.");
                        banco.fecharMesDeTodas();
                        System.out.println("Sucesso.");
                        System.out.print("Press enter to continue:");
                        sc.nextLine();
                        break;
                    case 7:
                        System.out.println("Listando contas: ");
                        banco.listarContas();
                        System.out.print("Press enter to continue:");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("Fechando Programa!!");
                        return;
                }
        } while(true);
    }
}
