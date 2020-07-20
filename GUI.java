import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.net.URL;

public class GUI {

    private static GraphicsConfiguration gc;
    private JFrame frame;

    GUI() {
        frame = new JFrame(gc);
        frame.setSize(800, 600);
        frame.setLocation(300, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void addBackground() {

        try {
            URL url = new URL("https://animalcarecentersmyrna.com/wp-content/uploads/2016/11/pets_big.png");
            final BufferedImage backgroundImage = ImageIO.read(url);

            JLabel contentPane = new JLabel();
            contentPane.setIcon(new ImageIcon(backgroundImage.getScaledInstance(backgroundImage.getWidth() / 2,
                    backgroundImage.getHeight() / 2, 4)));
            contentPane.setLayout(new BorderLayout());

            contentPane.setVisible(true);
            frame.setContentPane(contentPane);
            System.out.println("image added");

        } catch (Exception e) {
            System.out.println("Background image not loaded in");
        }

        frame.setVisible(true);
    }

}