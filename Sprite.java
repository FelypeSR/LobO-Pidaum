import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Carregar imagem
    protected void loadImage(String imagePath) {
        ImageIcon ii = new ImageIcon(imagePath);
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    // Desenhar o sprite
    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    // Getters para a imagem, posição e dimensões
    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
