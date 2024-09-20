import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // inicializa o servico do barbeiro
            BarbeiroInterface barbeiro = new BarbeiroImp();
            LocateRegistry.createRegistry(1099); //cria o registro rmi na porta(1099)

            Naming.rebind("rmi://localhost:1099/BarbeiroService", barbeiro);
            System.out.println("BarbeiroService está pronto.");

            List<Integer> processos = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                processos.add(i);
            }
            TokenRingImp tokenRing = new TokenRingImp(processos);
            Naming.rebind("rmi://localhost:1099/TokenRingService", tokenRing);
            System.out.println("TokenRingService esta pronto.");

            
            List<Cliente> clientes = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Cliente cliente = new Cliente(i, barbeiro, tokenRing);
                clientes.add(cliente);
                cliente.start();
            }

            //aguarda os clientes terminarem
            for (Cliente cliente : clientes) {
                cliente.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
