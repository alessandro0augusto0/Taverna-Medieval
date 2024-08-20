import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Taverneiro extends Thread {
    private final List<Mesa> mesas;
    private final GUI gui;

    public Taverneiro(List<Mesa> mesas, GUI gui) {
        this.mesas = mesas;
        this.gui = gui;
    }

    @Override
    public void run() {
        while (true) {
            for (Mesa mesa : mesas) {
                if (mesa.estaLivre() && !mesa.estaInspecionada()) {
                    mesa.inspecionar();
                    gui.atualizarEstadoMesa(mesa.getId(), mesa.getClientesNaMesa(), mesa.estaInspecionada());
                    System.out.println("Taverneiro inspecionou a mesa " + mesa.getId());
                }
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 10000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}