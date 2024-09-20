import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TokenRingImp extends UnicastRemoteObject implements TokenRingInterface {
    private List<Integer> processos;  
    private int indiceDoToken;  

    public TokenRingImp(List<Integer> processos) throws RemoteException {
        this.processos = processos;
        this.indiceDoToken = 0;
    }
        public synchronized boolean possuiToken(int idProcesso) throws RemoteException {
        return processos.get(indiceDoToken) == idProcesso;
    }
    public synchronized void passarToken() throws RemoteException {
        indiceDoToken = (indiceDoToken + 1) % processos.size();
        System.out.println("Token passado para o cliente com ID " + processos.get(indiceDoToken));
    }
}
