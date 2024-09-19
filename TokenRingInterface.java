import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TokenRingInterface extends Remote {
    boolean possuiToken(int idProcesso) throws RemoteException;
    void passarToken() throws RemoteException;
}
