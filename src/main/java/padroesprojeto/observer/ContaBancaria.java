package padroesprojeto.observer;

import java.util.Observable;

public class ContaBancaria extends Observable {

    private Integer agencia;
    private Integer numeroConta;
    private String tipoConta;
    private String banco;

    public ContaBancaria(Integer agencia, Integer numeroConta, String tipoConta, String banco) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.banco = banco;
    }

    public void registrarTransacao() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "agencia=" + agencia +
                ", numeroConta=" + numeroConta +
                ", tipoConta='" + tipoConta + '\'' +
                ", banco='" + banco + '\'' +
                '}';
    }
}