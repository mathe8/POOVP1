package com.prova.main;

import java.util.Scanner;

public class Main {

    static Conta[] ListaContas = new Conta[10];

    public static void main(String[] args) {
        System.out.println("Bem-vindo(a) ao Caixa EletrÔnico ADA\n");

        Movimentos();
    }

    public static void ControleOperacao() {

        int Selecionado;

        Scanner op = new Scanner(System.in);

        do {
            System.out.print("\n");
            System.out.println("1 - Confirmar Operação.");
            System.out.println("2 - Cancelar Operação. Volte ao menu inicial");
            System.out.print("\n");
            System.out.print("Digite aqui → ");

            Selecionado = op.nextInt();
            if (Selecionado < 1 || Selecionado > 2){
                System.out.println("\nOperação Inválida. Tente novamente informando uma operação existente! :)");
            }
        } while (Selecionado < 1 || Selecionado > 2);

        if (Selecionado == 2) {
            Movimentos();
        }
    }

    public static void VoltarMenuPrincipal() {

        int Selecionado;

        Scanner op = new Scanner(System.in);

        do {
            System.out.println("1 - Caso deseje voltar ao menu inicial.\n");
            System.out.print("Digite aqui → ");

            Selecionado = op.nextInt();
            if (Selecionado != 1){
                System.out.println("\nOperação Inválida. Tente novamente informando uma operação existente! :)");
            }
        } while (Selecionado != 1);

        Movimentos();
    }

    public static void Movimentos() {

        int Selecionado;

        Scanner mv = new Scanner(System.in);

        do {
            System.out.println("Selecione a operação que deseja realizar (Digite o número correspondente):\n");
            System.out.println("1 - Abrir Conta Corrente");
            System.out.println("2 - Realizar Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Realizar Transferência");
            System.out.println("5 - Consultar Informações da Conta");
            System.out.println("6 - Sair do Caixa EletrÔnico");

            System.out.print("\n");
            System.out.print("Digite aqui → ");

            Selecionado = mv.nextInt();
            if (Selecionado < 1 || Selecionado > 6){
                System.out.println("\nOperação Inválida. Tente novamente informando uma operação existente! :)");
            }
        } while (Selecionado < 1 || Selecionado > 6);

        switch (Selecionado) {
            case 1:
                AbrirConta();

            case 2:
                Deposito();
            case 3:
                Saque();
            case 4:
                Transferencia();
            case 5:
                Consultar();
            case 6:
                System.out.println("Até a próxima!");
                break;
            default:
                System.out.println("\nInfelizmente algo de errado não está certo. Tente novamente!");
                Movimentos();
        }
    }

    public static void AbrirConta(){

        Scanner sc = new Scanner(System.in);

        Conta conta = new Conta();

        System.out.print("\n");
        System.out.println("Que bom lhe ver aqui! Vamos iniciar o seu cadastro.\n");
        System.out.print("Como deseja ser chamado? "); conta.setNome(sc.nextLine());
        System.out.print("Informe seu CPF (123.456.789-21): "); conta.setCPF(sc.nextLine());

        conta.atribuirNumeroConta();

        System.out.print("\n");
        System.out.println("Olá "+conta.getNome()+", tudo certo. Sua conta foi cadastrada com sucesso!\n");
        System.out.println(".~* Aqui estão suas informações *~.");
        System.out.println("Nome.................: "+conta.getNome());
        System.out.println("Número da Conta......: "+conta.getNumeroConta());
        System.out.println("CPF..................: "+conta.getCPF());
        System.out.println("Saldo:...............: R$"+conta.getSaldo());
        System.out.print("\n");

        VoltarMenuPrincipal();
    }

    public static void Deposito() {

        int NumeroConta;
        double ValorDeposito;

        Scanner sc = new Scanner(System.in);

        Conta conta = new Conta();

        ControleOperacao();

        System.out.print("\n");
        System.out.print("Digite o número da conta que deseja fazer o depósito → "); NumeroConta = sc.nextInt();
        System.out.print("Digite aqui o valor que deseja depositar → "); ValorDeposito = sc.nextDouble();

        conta.realizarDeposito(ValorDeposito);

        System.out.println("\n* O valor de R$"+ValorDeposito+" foi depositado na conta "+NumeroConta+"! *\n");

        VoltarMenuPrincipal();
    }

    public static void Saque() {

        int NumeroConta;
        double ValorSaque;

        Scanner sc = new Scanner(System.in);

        Conta conta = new Conta();

        ControleOperacao();

        System.out.print("\n");
        System.out.print("Digite o número da conta que deseja fazer o saque → "); NumeroConta = sc.nextInt();
        System.out.print("Digite aqui o valor que deseja sacar → "); ValorSaque = sc.nextDouble();

        conta.realizarSaque(ValorSaque);

        System.out.println("\n* O valor de R$"+ValorSaque+" foi sacado da conta "+NumeroConta+"! *\n");

        VoltarMenuPrincipal();
    }

    public static void Transferencia() {

        int NumeroConta;
        int ContaDEMO;
        double ValorTransferencia;

        Scanner sc = new Scanner(System.in);

        Conta conta = new Conta();

        ControleOperacao();

        System.out.print("\n");
        System.out.print("Digite o número da conta que irá transferir → "); NumeroConta = sc.nextInt();
        System.out.print("Digite o número da conta que irá receber → "); ContaDEMO = sc.nextInt();
        System.out.print("Digite aqui o valor que deseja transferir → "); ValorTransferencia = sc.nextDouble();

        conta.realizarTransferencia(ValorTransferencia);

        System.out.println("\n* O valor de R$"+ValorTransferencia+" foi transferido da conta "+NumeroConta+" para a conta "+ContaDEMO+"! *\n");

        VoltarMenuPrincipal();
    }

    public static void Consultar() {

        int NumeroConta;

        Scanner sc = new Scanner(System.in);

        Conta conta = new Conta();

        System.out.print("\n");
        System.out.print("Digite o número da conta que deseja visualizar as informações da conta → "); NumeroConta = sc.nextInt();

        System.out.print("\n");
        System.out.println(".~* Exibindo os dados da conta "+NumeroConta+" *~.");
        System.out.println("Nome.................: "+conta.getNome());
        System.out.println("Número da Conta......: "+conta.getNumeroConta());
        System.out.println("CPF..................: "+conta.getCPF());
        System.out.println("Saldo:...............: R$"+conta.getSaldo());
        System.out.print("\n");

        VoltarMenuPrincipal();
    }

}
