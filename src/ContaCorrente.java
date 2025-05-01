public class ContaCorrente extends Conta {
    
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.limiteChequeEspecial = 1000.0; 
    }
    
    public ContaCorrente(Cliente cliente, double limiteChequeEspecial) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        
        if (valor <= (saldo + limiteChequeEspecial)) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente. Seu limite disponível é: " + 
                String.format("%.2f", (saldo + limiteChequeEspecial)));
        }
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    
    public double getLimiteDisponivel() {
        return saldo + limiteChequeEspecial;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
        System.out.println(String.format("Limite de Cheque Especial: %.2f", this.limiteChequeEspecial));
        System.out.println(String.format("Limite Disponível para Saque: %.2f", (this.saldo + this.limiteChequeEspecial)));
    }
}