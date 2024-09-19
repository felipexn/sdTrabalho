import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Inicializa o serviço remoto do Barbeiro
            Barbeiro barbeiro = new BarbeiroImp();
            LocateRegistry.createRegistry(1099); // Cria o registro RMI na porta padrão (1099)
            Naming.rebind("BarbeiroService", barbeiro);
            System.out.println("BarbeiroService está pronto.");

            // Inicializa a lista de clientes e o serviço de TokenRing
            List<Integer> processos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                processos.add(i);
            }
            TokenRing tokenRing = new TokenRing(processos);
            Naming.rebind("TokenRingService", tokenRing);
            System.out.println("TokenRingService está pronto.");

            // Inicializa os clientes
            List<Cliente> clientes = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Cliente cliente = new Cliente(i, barbeiro, tokenRing);
                clientes.add(cliente);
                cliente.start();
            }

            // Aguarda os clientes terminarem
            for (Cliente cliente : clientes) {
                cliente.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
