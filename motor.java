import javax.swing.JFrame;

public class motor extends JFrame {
    public motor(){
        //title//
        setTitle("LobO PIdAum");
        //window game//
        setSize(720, 480);
        //to close game//
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //0//
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
        //painel personalizado//
        setContentPane(new fase());
        //exibir painel//
        setVisible(true);

    }
    public static void main(String [] args){
        new motor();
        JFrame frame = new JFrame("lobo Pidaum");
        fase fase = new fase();
        frame.add(fase);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
