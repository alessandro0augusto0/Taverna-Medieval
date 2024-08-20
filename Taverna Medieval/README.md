# Taverna Medieval 🍻

Bem-vindo à **Taverna Medieval**! Este projeto simula o ambiente de uma taverna onde mesas são disputadas por clientes medievais, e um taverneiro incansável cuida para que tudo esteja em perfeita ordem. Com uma interface gráfica envolvente, personagens animados e uma trilha sonora autêntica, você poderá acompanhar o movimento na taverna e garantir que todos os clientes sejam atendidos sem que ocorram problemas de sincronização.

## 🚀 Funcionalidades

- **Simulação de Mesas na Taverna**: Até 9 mesas disponíveis para acomodar clientes em grupos de até 4 pessoas.
- **Controle de Clientes**: Clientes ocupam mesas aleatoriamente e as liberam após um tempo, garantindo que a taverna esteja sempre movimentada.
- **Taverneiro Inspecionador**: O taverneiro realiza inspeções periódicas nas mesas livres, garantindo que tudo esteja em ordem para os próximos clientes.
- **Interface Gráfica (GUI)**: Acompanhe em tempo real o estado das mesas através de uma interface amigável, com mesas personalizadas e rostos de clientes medievais.
- **Música Ambiente**: Trilha sonora imersiva que transporta você diretamente para o coração da Taverna Medieval.
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
    git clone https://github.com/alessandro0augusto0/taverna-medieval.git
    ```

2. **Importe o projeto** no seu IDE preferido (recomendado: IntelliJ IDEA, Eclipse, VS Code).

3. **Configure os recursos**:
    - Certifique-se de que a pasta `resources` contenha as imagens e sons necessários (`icone.png`, `taverna.png`, `mesa.png`, `rosto1.png`, `rosto2.png`, `rosto3.png`, `rosto4.png`, `musica.wav`).
    - Ajuste o caminho dos recursos conforme necessário no código, utilizando `getClass().getResource("/caminho/do/arquivo")`.

4. **Execute a classe `Taverna`**:
    - Esta classe inicia a tela inicial e, após a interação do usuário, a simulação principal.

## 🎮 Como Jogar

- **Inicie o Jogo**: Ao iniciar o programa, você verá a tela inicial com a opção de "Entrar".
- **Acompanhe a Simulação**: Após iniciar, observe os clientes ocupando mesas e o taverneiro inspecionando as mesas que ficaram livres.
- **Desfrute da Música**: Deixe-se levar pela trilha sonora enquanto acompanha a vida na taverna.

## 🎨 Interface Gráfica

- A interface apresenta uma visualização das mesas com imagens personalizadas e rostos de clientes medievais.
- As mesas são representadas em tempo real, e cada atualização reflete a ação mais recente na taverna.

## 🧠 Desafios Técnicos

- **Sincronização**: A maior parte da complexidade do projeto está na correta sincronização entre clientes e taverneiro, evitando conflitos e garantindo que o taverneiro só inspecione mesas livres.
- **Evitar Deadlock e Starvation**: Implementação cuidadosa para garantir que todas as mesas sejam usadas eficientemente e que nenhuma thread (cliente ou taverneiro) fique permanentemente bloqueada.

## 👥 Contribuições

Sinta-se à vontade para contribuir com melhorias, ajustes ou novas funcionalidades para o projeto. Abra uma _issue_ ou faça um _pull request_!

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
