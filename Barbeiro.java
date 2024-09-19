import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Barbeiro extends Remote {
    void cortarCabelo() throws RemoteException, InterruptedException;
    void cortarBarba() throws RemoteException, InterruptedException;
    void cortarBigode() throws RemoteException, InterruptedException;
}
