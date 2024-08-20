import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class TelaInicial extends JFrame {
    private JButton iniciarButton;
    private Clip musicaFundo;

    public TelaInicial() {
        setTitle("Taverna Medieval");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setIconImage(new ImageIcon(getClass().getResource("/resources/icone.png")).getImage());

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/resources/taverna.png")));
        setContentPane(background);
        setLayout(new FlowLayout());

        iniciarButton = new JButton("Entrar");
        iniciarButton.setFont(new Font("Arial", Font.BOLD, 20));
        iniciarButton.setPreferredSize(new Dimension(150, 50));
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pararMusicaFundo();
                synchronized (TelaInicial.this) {
                    TelaInicial.this.notify();
                }
                dispose();
            }
        });
        add(iniciarButton);

        tocarMusicaFundo("/resources/musica.wav");

        setVisible(true);
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

    private void pararMusicaFundo() {
        if (musicaFundo != null && musicaFundo.isRunning()) {
            musicaFundo.stop();
        }
    }

    public static void main(String[] args) {
        new TelaInicial();
    }
}
