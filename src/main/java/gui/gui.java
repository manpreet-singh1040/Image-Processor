package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import features.histogram;
import javax.swing.*;
import features.blur;
import functions.displayImage;
import functions.fastFT;
import functions.readImage;

public class gui {
    private static final int WIDTH=1920;
    private static final int HEIGHT=1080;
    private static ImagePanel imagePanel;
    private int x=0;
    private JTextField textField;
    private String imagePath; 
    private int curBlur=0;
    private BufferedImage image;
    private histogram Histobj;
    public gui(){
        System.setProperty("sun.java2d.opengl", "true"); // Enable OpenGL for Java2D
        System.setProperty("sun.java2d.d3d", "true"); // Enable Direct3D (Windows)
        System.out.println("hello from gui constructor!!");
        JFrame frame=new JFrame("Image Processor ");
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        

        JButton button1=new JButton("load !!");
        button1.setBounds(150,200,220,50);
        JButton button2=new JButton("blur ++");
        JButton button3=new JButton("contrast ++");
        JButton button4=new JButton("fft image");
        panel.add(button4);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        textField=new JTextField("enter image location",20);
        panel.add(textField);
        
        image=readImage.bufferReadImg("D:/wallpaper/816 Desktop Wallpaper @Papers.jpg");
        imagePanel=new ImagePanel(image);


        panel.add(imagePanel);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                // textField.setText("clicked "+x+" times !!");
                System.out.println(textField.getText());
                image=readImage.bufferReadImg(textField.getText());
                imagePanel.setImage(image);
                curBlur=0;
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                curBlur++;
                System.out.println(curBlur+" curBlur<<<<");
                image=blur.blurEffect(image, 3);
                imagePanel.setImage(image);
                System.out.println("blue effect done !!");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("normalize the image!!");
                Histobj=new histogram(image);
                Histobj.equalization();
                imagePanel.setImage(image);
            }
        });

        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("fft");
                int pixel[][]=readImage.bufferImageToArr(image);
                double[][] r=new double[pixel.length][pixel[0].length*2];
                for(int i=0;i<pixel.length;i++){
                    for(int j=0;j<pixel[0].length;j++){
                        r[i][2*j]=((double)pixel[i][j])/255;
                    }
                }
                // double[][] g=new double[pixel.length][pixel[0].length*2];
                // for(int i=0;i<pixel.length;i++){
                //     for(int j=0;j<pixel[0].length;j++){
                //         g[i][2*j]=pixel[i][j];
                //     }
                // }
                // double[][]b=new double[pixel.length][pixel[0].length*2];
                // for(int i=0;i<pixel.length;i++){
                //     for(int j=0;j<pixel[0].length;j++){
                //         b[i][2*j]=pixel[i][j];
                //     }
                // }
                fastFT.inverseTwoDfft(r, pixel.length, pixel[0].length, true);
                // fastFT.inverseTwoDfft(g, pixel.length, pixel[0].length, true);
                // fastFT.inverseTwoDfft(b, pixel.length, pixel[0].length, true);
                int newPixel[][]=new int[pixel.length][pixel[0].length];
                double maxA=0;
                double minA=Integer.MAX_VALUE;
                for(int i=0;i<pixel.length;i++){
                    for(int j=0;j<pixel[0].length;j++){
                        double temp=Math.sqrt( r[i][j*2]*r[i][j*2] + r[i][j*2+1]*r[i][j*2+1] );
                        maxA=Math.max(maxA,temp);
                        minA=Math.min(minA,temp);
                        // newPixel[i][j]=(( Math.min(255, Math.max(0, (int) temp))<<16) | (0x0000ffff));
                    }
                }
                for(int i=0;i<pixel.length;i++){
                    for(int j=0;j<pixel[0].length;j++){
                        double temp=Math.sqrt( r[i][j*2]*r[i][j*2] + r[i][j*2+1]*r[i][j*2+1] );

                        newPixel[i][j]=( (int)(((temp-minA)/(maxA-minA))*255*100)%256)<<16;
                    }
                }
                displayImage.display(newPixel);
                // imagePanel.setImage(image);

            }
        });
        frame.setSize(WIDTH,HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack(); 
    }
    public class ImagePanel extends JPanel{
        private BufferedImage image;
        public ImagePanel(BufferedImage newImage){
            setImage(newImage);
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if (image != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    
                int panelWidth = getWidth();
                int panelHeight = getHeight();
    
                // Draw scaled image to fit panel
                g2d.drawImage(image, 0, 0, panelWidth, panelHeight, this);
            }
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1080, 720); // Fixed panel size
        }
        public void setImage(int [][] pixel){
            // int pixel[][]=readImage.readImg(imagePath);
            image=new BufferedImage(pixel.length, pixel[0].length, BufferedImage.TYPE_INT_RGB);
            for(int i=0;i<pixel.length;i++){
                for(int j=0;j<pixel[0].length;j++){
                    image.setRGB(i, j, pixel[i][j]);
                }
            }
            repaint();
        }
        public void setImage(BufferedImage newImage){
            // int pixel[][]=readImage.readImg(imagePath);
            image=newImage;
            repaint();
        }
    }
}



