
package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pessoa;
import model.Conta;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Estrutura de pagamento---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Pagar    	    |");
        System.out.println("|   Opção 4 - Listar        |");
        System.out.println("|   Opção 5 - Sair          |");
        System.out.println();
        System.out.print("Digite a opção desejada: ");
        int operacao = input.nextInt();;

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                pagar();
                break;
            case 4:
                listarContas();
                break;
            case 5:
                System.out.println("Flw é nóis!");
                System.exit(0); // para o sistema

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        //System.out.println("Você está criando uma conta\n");

        System.out.print("\nNome: ");
        String nome = input.next();

        System.out.print("\nCPF: ");
        String cpf = input.next();
        

        System.out.print("\nEmail: ");
        String email = input.next();

        System.out.print("\nConta bancaria: ");
        double num = input.nextDouble();
        Pessoa cliente = new Pessoa(nome, cpf, email);
        
       

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");
        System.out.println(conta);

        operacoes();

    }

    private static Conta encontrarConta(double depConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == depConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
    	  System.out.println("Conta bancaria: ");
          double depConta = input.nextDouble();
          Conta conta = encontrarConta(depConta);

          if(conta != null) {
              System.out.println("Valor do deposito:  ");
              Double valorDeposito = input.nextDouble();

              conta.depositar(valorDeposito);
          }else {
              System.out.println("--- Conta não encontrada ---");
          }

          operacoes();
          
      }

    
    
    
    public static void pagar() {
   	
        System.out.println("Qual o numero da conta bancaria? : ");
        double PagConta = input.nextDouble();
        Conta conta = encontrarConta(PagConta);

        if(conta != null) {
            System.out.print("Valor do pagamento:  ");
            Double valorPagamento = input.nextDouble();

            conta.pagar(valorPagamento);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();
        	System.out.println(conta);
    }


 

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        operacoes();
       
    }
}
