import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class fase extends JPanel implements ActionListener {
    private Image fundo;
    private player player;
    private Timer timer;

    public fase() {
        initFase();
    }

    private void initFase() {
        ImageIcon ii = new ImageIcon("background.jpeg");
        fundo = ii.getImage(); // Carrega a imagem do background

        // Inicializa o jogador com diferentes sprites
        player = new player(200, 400, "Sprite/Hurt.png", "Sprite/Left.png", "Sprite/rigtht.png");

        // Configurar o painel
        setFocusable(true);
        addKeyListener(new TAdapter());
        setDoubleBuffered(true);

        // Configurar o Timer para a atualização do jogo
        timer = new Timer(16, this); 
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this); // Desenhar o background
        player.draw(g); // Desenhar o jogador
        Toolkit.getDefaultToolkit().sync(); // Suaviza a animação
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.movimentos(); // Atualizar a posição do jogador
        repaint(); // Repaint para atualizar a tela
    }

    // Adaptador de teclado interno
    private class TAdapter extends java.awt.event.KeyAdapter {
        @Override
        public void keyPressed(java.awt.event.KeyEvent e) {
            player.keyboard(e);
        }

        @Override
        public void keyReleased(java.awt.event.KeyEvent e) {
            player.quebrademovimento(e);
        }
    }
}
