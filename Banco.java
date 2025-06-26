import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void abrirConta(ContaBancaria novaConta) {
        contas.add(novaConta);
    }

    public ContaBancaria buscarConta(String numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    public void realizarOperacao(String numeroConta, String tipoOperacao, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            switch (tipoOperacao.toLowerCase()) {
                case "deposito":
                    conta.depositar(valor);
                    break;
                case "saque":
                    boolean sucesso = conta.sacar(valor);
                    if (!sucesso) {
                        System.out.println("Saldo insuficiente para saque em " + numeroConta);
                    }
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void listarContas() {
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
        }
    }
}
