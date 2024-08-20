import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Cliente extends Thread {
    private final List<Mesa> mesas;
    private final GUI gui;

    public Cliente(List<Mesa> mesas, GUI gui) {
        this.mesas = mesas;
        this.gui = gui;
    }

    @Override
    public void run() {
        while (true) {
            for (Mesa mesa : mesas) {
                if (mesa.ocupar()) {
                    gui.atualizarEstadoMesa(mesa.getId(), mesa.getClientesNaMesa(), mesa.estaInspecionada());
                    System.out.println("Cliente ocupou a mesa " + mesa.getId());
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(10000, 15000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    mesa.liberar();
                    gui.atualizarEstadoMesa(mesa.getId(), mesa.getClientesNaMesa(), mesa.estaInspecionada());
                    System.out.println("Cliente liberou a mesa " + mesa.getId());
                    break;
                }
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 8000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}