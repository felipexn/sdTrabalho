import java.rmi.Naming;
import java.rmi.RemoteException;

public class Cliente extends Thread {
    private int idProcesso;
    private Barbeiro barbeiro;
    private TokenRing anel;
    private int servicoAtual = 0; // 0 para cabelo, 1 para barba, 2 para bigode

    public Cliente(int id, Barbeiro barbeiro, TokenRing anel) {
        this.idProcesso = id;
        this.barbeiro = barbeiro;
        this.anel = anel;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {  
            try {
                tentarAcessarBarbeiro();
            } catch (InterruptedException | RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void tentarAcessarBarbeiro() throws InterruptedException, RemoteException {
        // Espera que o cliente receba o token
        while (!anel.possuiToken(idProcesso)) {
            Thread.sleep(100);
        }
        System.out.println("Cliente " + idProcesso + " está acessando o barbeiro.");
        realizarServico();
        System.out.println("Cliente " + idProcesso + " liberou o barbeiro.");
        // Passa o token para o próximo cliente
        anel.passarToken();
    }

    private void realizarServico() throws InterruptedException, RemoteException {
        switch (servicoAtual) {
            case 0:
                barbeiro.cortarCabelo(); 
                servicoAtual = 1; 
                break;
            case 1:
                barbeiro.cortarBarba(); 
                servicoAtual = 2; 
                break;
            case 2:
                barbeiro.cortarBigode(); 
                servicoAtual = 0; 
                break;
        }
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public static void main(String[] args) {
        try {
            // Obtem o serviço remoto Barbeiro
            Barbeiro barbeiro = (Barbeiro) Naming.lookup("rmi://localhost/BarbeiroService");
            // Obtem o serviço remoto TokenRing
            TokenRing anel = (TokenRing) Naming.lookup("rmi://localhost/TokenRingService");

            // Inicia 5 clientes
            for (int i = 0; i < 5; i++) {
                new Cliente(i, barbeiro, anel).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
