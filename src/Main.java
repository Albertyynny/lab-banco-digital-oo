public class Main {

    public static void main(String[] args) {
        Cliente albertiny = new Cliente();
        albertiny.setNome("Albertiny Rodrigues");
        
        ContaCorrente cc = new ContaCorrente(albertiny, 2000.0); 
        ContaPoupanca poupanca = new ContaPoupanca(albertiny);

        cc.depositar(100);
        cc.imprimirExtrato();
        
        System.out.println("\n=== Teste de Cheque Especial ===");
        System.out.println("Sacando R$ 500,00 (saldo de R$ 100,00)");
        cc.sacar(500);
        cc.imprimirExtrato();
        
        System.out.println("\n=== Teste de Transferência usando Cheque Especial ===");
        System.out.println("Transferindo R$ 1000,00 para Poupança (saldo negativo)");
        cc.transferir(1000, poupanca);
        
        System.out.println("\n=== Extratos Finais ===");
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}