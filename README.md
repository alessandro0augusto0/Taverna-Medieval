# Sincronização de Acesso a Mesas em uma Taverna 🍻

Este repositório contém duas implementações distintas para resolver o **Problema 5: Sincronização de Acesso a Mesas em um Boteco**, proposto no projeto interdisciplinar das disciplinas de **Sistemas Operacionais I** e **Programação Orientada a Objetos** do curso de Engenharia de Computação no IFSULDEMINAS.

## 🎯 Descrição do Problema

Em botecos, há um número limitado de mesas, cada uma capaz de suportar até 4 clientes. Um garçom (ou taverneiro, em uma das implementações) realiza inspeções periódicas nas mesas para garantir que estão limpas e prontas para novos clientes. A inspeção só pode ocorrer quando a mesa está vazia. Se todas as mesas estiverem ocupadas, os clientes devem esperar até que uma mesa fique disponível.

O desafio é criar uma solução que sincronize o uso das mesas por múltiplos clientes, garantindo que:
- Nenhuma mesa seja ocupada por mais de 4 clientes.
- O garçom só inspecione mesas vazias.
- Deadlock, race condition e starvation sejam evitados.

## 🛠️ Implementações

Este repositório contém **duas** implementações distintas, cada uma abordando o problema com uma dinâmica única:

### 1. **Taverna do Pônei Saltitante**
Esta implementação simula uma taverna onde mesas são disputadas por clientes. A interface gráfica foi criada utilizando **Swing**, com uma tabela que mostra o estado de cada mesa em tempo real. Um garçom realiza inspeções periódicas nas mesas.

- **Principais características**:
  - Interface gráfica com tabela mostrando o estado das mesas.
  - Sincronização utilizando `Thread`, `ReentrantLock`, e `ThreadLocalRandom` para tempos aleatórios de ocupação e inspeção.
  - Trilha sonora imersiva para enriquecer a experiência do usuário.

### 2. **Taverna Medieval**
Nesta versão, a taverna tem um tema medieval, com mesas personalizadas e clientes representados por ícones gráficos. Um taverneiro inspeciona as mesas, e a interface gráfica é mais visual, utilizando painéis personalizados para representar o estado das mesas e os clientes.

- **Principais características**:
  - Interface gráfica mais visual, com ícones e imagens.
  - Sincronização e controle de concorrência similar à primeira implementação.
  - Experiência imersiva com fundo de madeira e trilha sonora temática.

## 🚀 Como Executar

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/lessandro0augusto0/Taverna-Medieval.git
    ```

2. **Importe o projeto** no seu IDE preferido.

3. **Escolha a implementação que deseja executar**:
    - Para a **Taverna do Pônei Saltitante**, execute a classe `Taverna`.
    - Para a **Taverna Medieval**, execute a classe `TavernaMedieval`.

4. **Configure os recursos**:
    - Certifique-se de que a pasta `resources` contenha as imagens e sons necessários.

5. **Execute o projeto** e acompanhe a simulação.

## 🎨 Interface Gráfica

- **Taverna do Pônei Saltitante**: Apresenta uma tabela para visualização do estado das mesas.
- **Taverna Medieval**: Apresenta uma interface gráfica rica em detalhes visuais, com mesas e clientes personalizados.

## 📚 Problema e Solução

Este projeto foi desenvolvido como parte de um projeto interdisciplinar para as disciplinas de **Sistemas Operacionais I** e **Programação Orientada a Objetos**. O objetivo foi criar uma solução prática que demonstrasse o uso de threads, sincronização e o princípio de orientação a objetos para resolver um problema realista de sincronização entre processos.

## 👥 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir _issues_ ou enviar _pull requests_ com sugestões de melhorias ou novas funcionalidades.

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
