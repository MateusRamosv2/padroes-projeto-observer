# Padrões de Projeto - Observer

---

## Estrutura do Projeto

Este repositório contém um exemplo prático de implementação do padrão de projeto **Observer** utilizando **Java**, com foco em um sistema de **Notificações de Transações Bancárias**.

- **Subject (Observável):** `ContaBancaria` → Estende a classe nativa `Observable`. É o objeto central que detém o estado (os dados da conta) e é responsável por disparar as notificações (`notifyObservers`) sempre que uma nova transação é registrada.
- **Observer (Observador):** `Cliente` → Implementa a interface nativa `Observer`. Representa os interessados em receber atualizações. Os clientes se inscrevem para observar uma conta específica e reagem automaticamente através do método `update` quando a conta sinaliza uma mudança.
- **Testes:** `ClienteTest` → Valida as regras de negócio utilizando JUnit, garantindo que clientes inscritos recebam a notificação correta, clientes não inscritos sejam ignorados, e que notificações sejam disparadas apenas para as contas corretas.

---

## Diagrama de Classes

Abaixo está o diagrama de classes representando a estrutura da implementação e a relação clássica de "Publish/Subscribe" (Inscrição e Notificação) entre as classes do Java e as classes do nosso domínio.

<img width="600" height="660" alt="Diagrama-Observer" src="https://github.com/user-attachments/assets/3532a972-219a-41e0-9669-32a0a4ef14ba" />
