package padroesprojeto.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        ContaBancaria conta = new ContaBancaria(1234, 98765, "Corrente", "Nubank");
        Cliente cliente = new Cliente("João");
        cliente.habilitarNotificacoes(conta);

        conta.registrarTransacao();

        assertEquals("João, nova transação registrada na ContaBancaria{agencia=1234, numeroConta=98765, tipoConta='Corrente', banco='Nubank'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVariosClientesDaMesmaConta() {

        ContaBancaria contaConjunta = new ContaBancaria(1234, 98765, "Corrente", "Nubank");
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        cliente1.habilitarNotificacoes(contaConjunta);
        cliente2.habilitarNotificacoes(contaConjunta);

        contaConjunta.registrarTransacao();

        assertEquals("João, nova transação registrada na ContaBancaria{agencia=1234, numeroConta=98765, tipoConta='Corrente', banco='Nubank'}", cliente1.getUltimaNotificacao());
        assertEquals("Maria, nova transação registrada na ContaBancaria{agencia=1234, numeroConta=98765, tipoConta='Corrente', banco='Nubank'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteNaoInscrito() {
        ContaBancaria conta = new ContaBancaria(1234, 98765, "Corrente", "Nubank");
        Cliente cliente = new Cliente("João");

        conta.registrarTransacao();

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteApenasDaContaCorreta() {
        ContaBancaria contaCorrente = new ContaBancaria(1234, 98765, "Corrente", "Nubank");
        ContaBancaria contaPoupanca = new ContaBancaria(1234, 55555, "Poupança", "Nubank");

        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        cliente1.habilitarNotificacoes(contaCorrente);
        cliente2.habilitarNotificacoes(contaPoupanca);

        contaCorrente.registrarTransacao();

        assertEquals("João, nova transação registrada na ContaBancaria{agencia=1234, numeroConta=98765, tipoConta='Corrente', banco='Nubank'}", cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());
    }
}