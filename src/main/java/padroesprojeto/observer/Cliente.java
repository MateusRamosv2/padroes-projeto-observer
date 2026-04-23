package padroesprojeto.observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void habilitarNotificacoes(ContaBancaria conta) {
        conta.addObserver(this); // O cliente se inscreve para observar a conta
    }

    @Override
    public void update(Observable conta, Object arg1) {
        this.ultimaNotificacao = this.nome + ", nova transação registrada na " + conta.toString();

    }
}