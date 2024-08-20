import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class GUI {
    private final JFrame frame;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private Clip musicaFundo;

    public GUI(int numMesas) {
        frame = new JFrame("Taverna do Pônei Saltitante");
        frame.setSize(1000, 800); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.setLocationRelativeTo(null);

        frame.setIconImage(new ImageIcon(getClass().getResource("/resources/icone.jpg")).getImage());

        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource("/resources/taverna2.jpg"));
                Image image = icon.getImage();
                g.drawImage(image, 0, 250, getWidth(), getHeight() - 250, this);
            }
        };
        mainPanel.setOpaque(false);
        frame.setContentPane(mainPanel);

        String[] columnNames = {"Mesa", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    label.setForeground(Color.WHITE);
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    label.setOpaque(true);
                    label.setBackground(new Color(0, 0, 0, 150));
                }
                return c;
            }
        };
        table.setFont(new Font("Arial", Font.BOLD, 16));
        table.setRowHeight(40);

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(800);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setPreferredSize(new Dimension(900, 250));
        mainPanel.add(scrollPane, BorderLayout.NORTH);

        for (int i = 1; i <= numMesas; i++) {
            tableModel.addRow(new Object[]{"Mesa " + i, "Livre"});
        }

        tocarMusicaFundo("/resources/soundtaverna.wav");

        frame.setVisible(true);
    }

    public void atualizarEstadoMesa(int id, int clientesNaMesa, boolean inspecionada) {
        SwingUtilities.invokeLater(() -> {
            if (id - 1 < tableModel.getRowCount()) {
                String estado = (clientesNaMesa > 0 ? "Ocupada por " + clientesNaMesa + " cliente(s)" : "Livre");
                estado += inspecionada ? " e Inspecionada" : " e Precisa de Inspeção";
                tableModel.setValueAt(estado, id - 1, 1);
            }
        });
    }

    private void tocarMusicaFundo(String caminhoMusica) {
        try {
            musicaFundo = AudioSystem.getClip();
            InputStream audioSrc = getClass().getResourceAsStream(caminhoMusica);
            musicaFundo.open(AudioSystem.getAudioInputStream(audioSrc));
            musicaFundo.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pararMusicaFundo() {
        if (musicaFundo != null && musicaFundo.isRunning()) {
            musicaFundo.stop();
        }
    }
}
