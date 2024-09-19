import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BarbeiroImp extends UnicastRemoteObject implements Barbeiro {

    protected BarbeiroImp() throws RemoteException {
        super();
    }
    public void cortarCabelo() throws RemoteException, InterruptedException {
        System.out.println("Barbeiro esta cortando o cabelo...");
        Thread.sleep(5000); 
        System.out.println("Corte de cabelo finalizado!");
    }
    public void cortarBarba() throws RemoteException, InterruptedException {
        System.out.println("Barbeiro esta cortando a barba...");
        Thread.sleep(4000); 
        System.out.println("Corte de barba finalizado!");
    }
    public void cortarBigode() throws RemoteException, InterruptedException {
        System.out.println("Barbeiro esta cortando o bigode...");
        Thread.sleep(3000); 
        System.out.println("Corte de bigode finalizado!");
    }
}
