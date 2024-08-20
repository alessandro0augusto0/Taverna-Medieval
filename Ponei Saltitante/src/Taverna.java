import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Taverna {
    public static void main(String[] args) {
        TelaInicial telaInicial = new TelaInicial();
        synchronized (telaInicial) {
            try {
                telaInicial.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int numMesas = 5;
        List<Mesa> mesas = new ArrayList<>();
        for (int i = 1; i <= numMesas; i++) {
            mesas.add(new Mesa(i));
        }

        GUI gui = new GUI(numMesas);

        Garcom garcom = new Garcom(mesas, gui);
        garcom.start();

        for (int i = 0; i < 20; i++) {
            new Cliente(mesas, gui).start();
        }
    }
}