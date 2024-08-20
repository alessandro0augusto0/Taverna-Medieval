import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private List<MesaPanel> mesas;
    private int numMesas;
    private Image[] rostosClientes;

    public GUI(int numMesas) {
        this.numMesas = numMesas;
        mesas = new ArrayList<>();
        rostosClientes = new Image[4];
        loadClienteImages();
        createAndShowGUI();
    }

    private void loadClienteImages() {
        rostosClientes[0] = new ImageIcon(getClass().getResource("/resources/rosto1.png")).getImage();
        rostosClientes[1] = new ImageIcon(getClass().getResource("/resources/rosto2.png")).getImage();
        rostosClientes[2] = new ImageIcon(getClass().getResource("/resources/rosto3.png")).getImage();
        rostosClientes[3] = new ImageIcon(getClass().getResource("/resources/rosto4.png")).getImage();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Taverna Medieval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.setIconImage(new ImageIcon(getClass().getResource("/resources/icone.png")).getImage());

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(77, 49, 25));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);

        for (int i = 0; i < numMesas; i++) {
            MesaPanel mesa = new MesaPanel(i + 1);
            mesa.setBounds(100 + (i % 3) * 200, 120 + (i / 3) * 200, 150, 150);
            mesas.add(mesa);
            panel.add(mesa);

            JLabel label = new JLabel("Mesa " + (i + 1), SwingConstants.CENTER);
            label.setFont(new Font("Serif", Font.BOLD, 16));
            label.setForeground(Color.WHITE);
            label.setBounds(100 + (i % 3) * 200, 90 + (i / 3) * 200, 150, 20);
            panel.add(label);
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    public void atualizarEstadoMesa(int mesaId, int numClientes, boolean inspecionada) {
        MesaPanel mesa = mesas.get(mesaId - 1); 
        mesa.setClientesNaMesa(numClientes);
        mesa.setInspecionada(inspecionada);
        mesa.repaint();
    }

    public void addClienteToMesa(int mesaIndex, int clienteIndex) {
        MesaPanel mesa = mesas.get(mesaIndex);
        mesa.addCliente(clienteIndex);
    }

    public void removeClienteFromMesa(int mesaIndex, int clienteIndex) {
        MesaPanel mesa = mesas.get(mesaIndex);
        mesa.removeCliente(clienteIndex);
    }

    private class MesaPanel extends JPanel {
        private int mesaId;
        private List<Image> clientes;
        private boolean inspecionada;
        private Image mesaImage;

        public MesaPanel(int mesaId) {
            this.mesaId = mesaId;
            this.clientes = new ArrayList<>();
            this.inspecionada = false;

            mesaImage = new ImageIcon(getClass().getResource("/resources/mesa.png"))
                    .getImage()
                    .getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        }

        public void setClientesNaMesa(int numClientes) {
            this.clientes = new ArrayList<>();
            for (int i = 0; i < numClientes; i++) {
                int randomIndex = ThreadLocalRandom.current().nextInt(0, 4);
                this.clientes.add(rostosClientes[randomIndex]
                        .getScaledInstance(40, 40, Image.SCALE_SMOOTH));
            }
        }

        public void setInspecionada(boolean inspecionada) {
            this.inspecionada = inspecionada;
        }

        public void addCliente(int clienteId) {
            if (clientes.size() < 4) {
                int randomIndex = ThreadLocalRandom.current().nextInt(0, 4);
                clientes.add(rostosClientes[randomIndex]
                        .getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                repaint();
            }
        }

        public void removeCliente(int clienteId) {
            if (!clientes.isEmpty()) {
                clientes.remove(clientes.size() - 1);
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(mesaImage, 0, 0, getWidth(), getHeight(), this);

            for (int i = 0; i < clientes.size(); i++) {
                g.drawImage(clientes.get(i), 30 * i + 20, 50, 40, 40, this);
            }

            if (inspecionada) {
                g.setColor(Color.GREEN);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI(9));
    }
}
