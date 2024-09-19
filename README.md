# Barbeiro RMI com Token Ring

## Descrição

Este projeto implementa um sistema distribuído onde múltiplos clientes acessam um serviço remoto de barbeiro usando RMI (Remote Method Invocation) e o algoritmo de Token Ring para controle de acesso. Cada cliente pode agendar cortes de cabelo, barba e bigode de forma ordenada, garantindo que apenas um cliente por vez use o serviço.

## Funcionalidades

- **Barbeiro**: Serviço remoto que oferece os serviços de cortar cabelo, barba e bigode.
- **Cliente**: Cada cliente tenta acessar o barbeiro, aguardando sua vez através do Token Ring.
- **TokenRing**: Gerencia o controle de acesso ao barbeiro, garantindo que o token seja passado de um cliente para outro de forma sequencial.

## Estrutura do Projeto

1. **Interface `Barbeiro`**: Define os métodos remotos para cortar cabelo, barba e bigode.
2. **Classe `BarbeiroImp`**: Implementa os serviços do barbeiro, simulando o tempo de execução para cada corte.
3. **Classe `Cliente`**: Cada cliente tenta acessar o barbeiro, aguardando o token para realizar um serviço.
4. **Interface `TokenRingInterface`**: Define os métodos para verificar e passar o token entre os clientes.
5. **Classe `TokenRing`**: Implementa o controle de posse e passagem do token entre os clientes.
6. **Classe `Main`**: Inicializa os serviços remotos e inicia os clientes para simular o sistema.

