import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Teste");

        Conta conta = new ContaCorrente(cliente);  // Using Conta reference, but instantiated as ContaCorrente

        boolean exit = false;

        while (!exit) {
            System.out.println("Voce deseja realizar qual operação:");
            System.out.println("Voce deseja realizar SAQUE (Aperte 1):");
            System.out.println("Voce deseja realizar DEPOSITO (Aperte 2):");
            System.out.println("Voce deseja realizar TRANSFERENCIA (Aperte 3)");
            System.out.println("Selecione 4 para sair:");
            int tipo = scanner.nextInt();

            if (tipo == 1) {
                System.out.println("Digite o valor do saque:");
                double valor = scanner.nextDouble();
                conta.sacar(valor);
                conta.imprimirExtrato();
            } else if (tipo == 2) {
                System.out.println("Digite o valor do deposito:");
                double valor = scanner.nextDouble();
                conta.depositar(valor);
                conta.imprimirExtrato();
            } else if (tipo == 3) {
                System.out.println("Digite o valor da transferencia:");
                double valor = scanner.nextDouble();
                Conta contaDestino = new ContaPoupanca(cliente);  // Destination account for the transfer
                conta.transferir(valor, contaDestino);
                conta.imprimirExtrato();
                contaDestino.imprimirExtrato();
            } else if (tipo == 4) {
                exit = true;
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
