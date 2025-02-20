package functions;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.*;


public class animate extends JPanel {
    public static void animate(){
        int pixel[][]=new int[1200][900];
        int width=1200;
        int height=900;
        BufferedImage image=new BufferedImage(pixel.length,pixel[0].length,BufferedImage.TYPE_INT_BGR);
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,900);
        frame.setVisible(true);
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };
        
        
        frame.add(panel);
        Graphics2D g2d=image.createGraphics();
        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(2));
        int x1=width/2;
        int y1=height/2;
        try{

            for(int i=0;i<=350;i++)
            {
                int x2=i+width/2;
                int y2=+height/2;
                g2d.drawLine(x1, y1, x2, y2);
                panel.repaint();

                x1=x2;
                y1=y2;
                Thread.sleep(50);
            }
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        // // while(true)
        // // {
        //     for(int i=0;i<pixel.length;i++)
        //     {
        //         for(int j=;j<pixel[0].length;j++)
        //         {
        //             image.createGraphics()
        //         }
        //     }
        // // }
    }
}
