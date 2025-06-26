public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaCorrente cc = new ContaCorrente("019", "Filipi", 3.7);
        ContaPoupanca cp = new ContaPoupanca("020", "Annie", 2.0);

        banco.abrirConta(cc);
        banco.abrirConta(cp);

        banco.realizarOperacao("019", "deposito", 5000);
        banco.realizarOperacao("020", "deposito", 9000);

        banco.realizarOperacao("019", "saque", 100);  // taxa será aplicada
        banco.realizarOperacao("020", "saque", 500);

        // Polimorfismo funcionando aqui (método sacar)
        banco.listarContas();

        // Acessando comportamento específico de ContaPoupanca
        ContaBancaria conta = banco.buscarConta("020");
        if (conta instanceof ContaPoupanca) {
            ((ContaPoupanca) conta).aplicarRendimento();
        }

        System.out.println("\nApós aplicar rendimento:");
        banco.listarContas();
    }
}
