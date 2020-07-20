import javax.swing.*;
import java.awt.GraphicsConfiguration;

public class VetApp {

    static GraphicsConfiguration gc;

    public static void main(String[] args) {
        JFrame frame = new JFrame(gc);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocation(300, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}