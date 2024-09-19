import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

// Classe que gerencia o algoritmo de anel (token ring) para exclusão mútua
public class TokenRing extends UnicastRemoteObject implements TokenRingInterface {
    private List<Integer> processos;  // IDs dos processos (clientes)
    private int indiceDoToken;  // Índice do cliente que possui o token atualmente

    // Construtor que inicializa a lista de processos e o índice do token
    public TokenRing(List<Integer> processos) throws RemoteException {
        this.processos = processos;
        this.indiceDoToken = 0;  // O token começa com o primeiro cliente
    }

    // Verifica se o processo atual possui o token
  
    public synchronized boolean possuiToken(int idProcesso) throws RemoteException {
        return processos.get(indiceDoToken) == idProcesso;
    }

    // Passa o token para o próximo cliente no anel
    
    public synchronized void passarToken() throws RemoteException {
        indiceDoToken = (indiceDoToken + 1) % processos.size();
        System.out.println("Token passado para o cliente com ID " + processos.get(indiceDoToken));
    }
}
