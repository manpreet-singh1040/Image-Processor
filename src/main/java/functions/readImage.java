package functions;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class readImage {
    public static int[][] readImg(String path)
    {
        try{

            File imageFile=new File(path);
            BufferedImage image= ImageIO.read(imageFile);
            int h=image.getHeight();
            int w=image.getWidth();
            int pixel[][]=new int[w][h];
            for(int i=0;i<w;i++)
            {
                for(int j=0;j<h;j++)
                {
                    pixel[i][j]=image.getRGB(i, j);
                }
            }
            return pixel;
        }
        catch(IOException e)
        {
            System.out.println(e);
            return new int[][]{};
        }
        
    }
    public static BufferedImage bufferReadImg(String path){
        try{
            File imagFile=new File(path);
            BufferedImage image=ImageIO.read(imagFile);
            return image;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
    }
    public static BufferedImage arrToBufferedImage(int pixel[][]){
        BufferedImage image=new BufferedImage(pixel.length, pixel[0].length, BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<pixel.length;i++){
            for(int j=0;j<pixel[0].length;j++){
                image.setRGB(i, j, pixel[i][j]);
            }
        }
        return image;
    }
    public static int[][] bufferImageToArr(BufferedImage image){
        int pixel[][]=new int[image.getWidth()][image.getHeight()];
        for(int i=0;i<image.getWidth();i++){
            for(int j=0;j<image.getHeight();j++){
                pixel[i][j]=image.getRGB(i, j);
            }
        }
        return pixel;
    }
}