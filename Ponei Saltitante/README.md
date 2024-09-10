# Taverna do Pônei Saltitante 🍻

Bem-vindo à **Taverna do Pônei Saltitante**! Este projeto simula o ambiente de uma taverna medieval, onde mesas são disputadas por clientes sedentos, e um garçom incansável cuida para que tudo esteja em perfeita ordem. Com uma interface gráfica envolvente e uma trilha sonora imersiva, você poderá acompanhar o movimento na taverna e garantir que todos os clientes sejam atendidos sem que ocorram problemas de sincronização.

## 🚀 Funcionalidades

- **Simulação de Mesas na Taverna**: Até 5 mesas disponíveis para acomodar clientes em grupos de até 4 pessoas.
- **Controle de Clientes**: Clientes ocupam mesas aleatoriamente e as liberam após um tempo, garantindo que a taverna esteja sempre movimentada.
- **Garçom Inspecionador**: O garçom realiza inspeções periódicas nas mesas livres, garantindo que tudo esteja em ordem para os próximos clientes.
- **Interface Gráfica (GUI)**: Acompanhe em tempo real o estado das mesas através de uma interface amigável e com um tema medieval.
- **Música Ambiente**: Trilha sonora imersiva que transporta você diretamente para o coração da Taverna do Pônei Saltitante.
- **Prevenção de Problemas de Sincronização**: Implementação cuidadosa para evitar deadlocks, race conditions e starvation.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Swing**: Biblioteca para a criação da interface gráfica.
- **Java Concurrency**: Utilização de `Thread`, `ReentrantLock` e outras ferramentas para sincronização.
- **Java Sound API**: Para a reprodução da música ambiente.
- **Recursos Multimídia**: Imagens e sons que enriquecem a experiência do usuário.

## 📚 Como Executar o Projeto

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/alessandro0augusto0/Taverna-medieval.git
    ```

2. **Importe o projeto** no seu IDE preferido (recomendado: IntelliJ IDEA, Eclipse, VS Code).

3. **Configure os recursos**:
    - Certifique-se de que a pasta `resources` contenha as imagens e sons necessários (`icone.jpg`, `taverna.jpg`, `taverna2.jpg`, `soundtaverna.wav`, `jrrtolkientrack1.wav`).
    - Ajuste o caminho dos recursos conforme necessário no código, utilizando `getClass().getResource("/caminho/do/arquivo")`.

4. **Execute a classe `Taverna`**:
    - Esta classe inicia a tela inicial e, após a interação do usuário, a simulação principal.

## 🎮 Como Jogar

- **Inicie o Jogo**: Ao iniciar o programa, você verá a tela inicial com a opção de "Iniciar".
- **Acompanhe a Simulação**: Após iniciar, observe os clientes ocupando mesas e o garçom inspecionando as mesas que ficaram livres.
- **Desfrute da Música**: Deixe-se levar pela trilha sonora enquanto acompanha a vida na taverna.

## 🎨 Interface Gráfica

- A interface apresenta uma tabela com o estado atual de cada mesa (Livre, Ocupada, ou Inspecionada).
- As mesas são representadas em tempo real, e cada atualização reflete a ação mais recente na taverna.

## 🧠 Desafios Técnicos

- **Sincronização**: A maior parte da complexidade do projeto está na correta sincronização entre clientes e garçom, evitando conflitos e garantindo que o garçom só inspecione mesas livres.
- **Evitar Deadlock e Starvation**: Implementação cuidadosa para garantir que todas as mesas sejam usadas eficientemente e que nenhuma thread (cliente ou garçom) fique permanentemente bloqueada.

## 👥 Contribuições

Sinta-se à vontade para contribuir com melhorias, ajustes ou novas funcionalidades para o projeto. Abra uma _issue_ ou faça um _pull request_!

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## O Programa se inicia em Taverna.java

Basta entrar na Taverna 🚪🍺

![taverna1](https://github.com/user-attachments/assets/5a6ae8c8-1b05-4d37-8dd2-830d58afa3ad)

Aqui mostra como estão sendo feitas as requisições

![taverna2](https://github.com/user-attachments/assets/35068481-c043-4242-9574-e7d77d916165)
