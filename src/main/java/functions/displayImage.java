package functions;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.*;


public class displayImage extends JPanel {
    
    public static void display(int pixel[][])
    {
        BufferedImage image=new BufferedImage(pixel.length, pixel[0].length, BufferedImage.TYPE_INT_BGR);
        for (int x = 0; x < pixel.length; x++) {
            for (int y = 0; y < pixel[0].length; y++) {
                image.setRGB(x, y, pixel[x][y]); // Set RGB value for each pixel
            }
        }
        JFrame frame=new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this); // Draw the image
            }
        });
    }
    public static void displayGray(int pixel[][])
    {
        BufferedImage image=new BufferedImage(pixel.length, pixel[0].length, BufferedImage.TYPE_INT_BGR);
        for (int x = 0; x < pixel.length; x++) {
            for (int y = 0; y < pixel[0].length; y++) {
                image.setRGB(x, y,( pixel[x][y] | pixel[x][y]<<8 | pixel[x][y]<<16)); // Set RGB value for each pixel
            }
        }
        JFrame frame=new JFrame();
        frame.setVisible(true);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this); // Draw the image
            }
        });
    }
    
}
