import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class player extends Sprite {
    private int move_axis_x, move_axis_y; //movimentação dos eixos// 
    private int frameWidth, frameHeight;
    private int currentFrame;
    private Image leftImage, rightImage;
    private boolean movingRight, movingLeft;

    public player(int startX, int startY, String imagePath, String leftImagePath, String rightImagePath) {
        super(startX, startY);
        loadImage(imagePath); // Carregar a imagem padrão
        this.leftImage = new ImageIcon(leftImagePath).getImage();
        this.rightImage = new ImageIcon(rightImagePath).getImage();
        
        frameWidth = 128;
        frameHeight = 128;
        currentFrame = 0;
        movingRight = false;
        movingLeft = false;
    }

    public void movimentos() {
        x += move_axis_x;
        y += move_axis_y;
        currentFrame = (currentFrame + 1) % (width / frameWidth);
    }

    @Override
    public void draw(Graphics g) {
        int sx = currentFrame * frameWidth;
        Image currentImage = image;

        if (movingRight) {
            currentImage = rightImage;
        } else if (movingLeft) {
            currentImage = leftImage;
        }

        g.drawImage(currentImage, x, y, x + frameWidth, y + frameHeight, sx, 0, sx + frameWidth, frameHeight, null);
    }

    public void keyboard(KeyEvent tecla) {
        int key = tecla.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) {
            move_axis_x = 2;
            movingRight = true;
            movingLeft = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            move_axis_x = -2;
            movingRight = false;
            movingLeft = true;
        }
    }

    public void quebrademovimento(KeyEvent tecla) {
        int key = tecla.getKeyCode();

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            move_axis_y = 0;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            move_axis_x = 0;
            movingRight = false;
            movingLeft = false;
        }
    }
}
