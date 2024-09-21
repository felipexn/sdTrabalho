<h1>Sistema Distribuído de Barbeiro com Token Ring usando Java RMI</h1>
    <h2>Descrição do Projeto</h2>
    <p>Este projeto implementa um sistema distribuído usando <strong>Java RMI</strong> (Remote Method Invocation) para simular um serviço de barbeiro, onde vários clientes podem solicitar serviços como corte de cabelo, barba ou bigode. O sistema utiliza o conceito de <strong>Token Ring</strong>, um algoritmo de exclusão mútua distribuída, para garantir que apenas um cliente por vez possa acessar o barbeiro, controlando a ordem de acesso.</p>
    <h3>Componentes Principais:</h3>
    <ul>
        <li><strong>Barbeiro:</strong> Responsável por fornecer serviços de corte de cabelo, barba e bigode.</li>
        <li><strong>Cliente:</strong> Um cliente que solicita o serviço do barbeiro. Cada cliente espera sua vez de acordo com o Token Ring.</li>
        <li><strong>Token Ring:</strong> Um mecanismo de controle que garante que o acesso ao barbeiro seja controlado e sincronizado.</li>
    </ul>
    <h2>Funcionalidades</h2>
    <ul>
        <li>Simulação de serviços de um barbeiro (cortar cabelo, barba e bigode).</li>
        <li>Controle de acesso ao barbeiro através do protocolo <strong>Token Ring</strong>, garantindo que apenas um cliente por vez utilize o serviço.</li>
        <li>Implementação distribuída usando Java RMI, possibilitando execução de clientes em diferentes máquinas.</li>
    </ul>
    <h2>Estrutura do Código</h2>
    <ul>
        <li><strong>BarbeiroInterface.java:</strong> Define os métodos remotos para o barbeiro (cortar cabelo, barba e bigode).</li>
        <li><strong>BarbeiroImp.java:</strong> Implementa os métodos definidos na interface, simulando o barbeiro.</li>
        <li><strong>Cliente.java:</strong> Simula os clientes que solicitam os serviços do barbeiro em um loop, aguardando o token.</li>
        <li><strong>TokenRingInterface.java:</strong> Interface que define os métodos para verificar e passar o token no anel.</li>
        <li><strong>TokenRingImp.java:</strong> Implementa a lógica do Token Ring, controlando a ordem de atendimento dos clientes.</li>
        <li><strong>Main.java:</strong> Classe principal para iniciar os serviços de barbeiro e Token Ring, registrando-os no RMI Registry.</li>
    </ul>
    <h2>Pré-requisitos</h2>
    <ul>
        <li><strong>Java 8</strong> ou superior instalado.</li>
        <li><strong>RMI Registry</strong> (parte do JDK, disponível no ambiente de execução Java).</li>
        <li>Conhecimento básico sobre o protocolo de exclusão mútua <strong>Token Ring</strong>.</li>
    </ul>
    <h2>Como Executar</h2>
    <h3>Passo 1: Compile o Projeto</h3>
    <p>Use o seguinte comando para compilar todos os arquivos <code>.java</code>:</p>
    <pre><code>javac *.java</code></pre>
    <h3>Passo 2: Inicie o Servidor do Barbeiro e o Token Ring</h3>
    <p>Inicie a classe principal para registrar os serviços do barbeiro e do Token Ring no RMI:</p>
    <pre><code>java Main</code></pre>
    <p>Isso vai registrar o <strong>BarbeiroService</strong> e o <strong>TokenRingService</strong> no registro RMI.</p>
    <h3>Passo 3: Inicie os Clientes</h3>
    <p>Agora, inicie os clientes que vão se conectar ao serviço de barbeiro e solicitar os serviços. Cada cliente tenta acessar o barbeiro usando o token:</p>
    <pre><code>java Cliente</code></pre>
    <h3>Passo 4: Visualize a Execução</h3>
    <p>Os clientes vão alternar entre os serviços (corte de cabelo, barba e bigode), aguardando sua vez de acessar o barbeiro, conforme controlado pelo token.</p>
    <h2>Explicação do Código</h2>
    <h3>BarbeiroInterface.java</h3>
    <p>Define os métodos remotos que o barbeiro implementará:</p>
    <ul>
        <li><code>cortarCabelo()</code></li>
        <li><code>cortarBarba()</code></li>
        <li><code>cortarBigode()</code></li>
    </ul>
    <h3>BarbeiroImp.java</h3>
    <p>Implementa a lógica do barbeiro. Cada método simula um corte (cabelo, barba ou bigode) usando o <code>Thread.sleep()</code> para simular o tempo necessário para concluir o serviço.</p>
    <h3>Cliente.java</h3>
    <p>Simula os clientes que esperam receber o token para acessar o barbeiro. Cada cliente alterna entre solicitar corte de cabelo, barba e bigode. Ao finalizar um serviço, o token é passado para o próximo cliente.</p>
    <h3>TokenRingInterface.java</h3>
    <p>Define os métodos para verificar se um cliente possui o token e para passá-lo adiante:</p>
    <ul>
        <li><code>possuiToken(int idProcesso)</code></li>
        <li><code>passarToken()</code></li>
    </ul>
    <h3>TokenRingImp.java</h3>
    <p>Implementa a lógica de controle do Token Ring. Cada cliente possui um ID, e o token circula sequencialmente entre os clientes.</p>
    <h3>Main.java</h3>
    <p>Inicia o sistema, registrando o barbeiro e o serviço de controle de Token Ring no RMI Registry.</p>
    <h2>Melhoria Potencial</h2>
    <ul>
        <li><strong>Persistência:</strong> Implementar uma persistência do estado do token em caso de falha.</li>
        <li><strong>Distribuição:</strong> Configurar clientes em diferentes máquinas e testar o sistema em uma rede distribuída real.</li>
        <li><strong>Interface Gráfica:</strong> Implementar uma interface gráfica para monitorar o estado do barbeiro e dos clientes.</li>
    </ul>
    
