package functions;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class saveImage {
    public static void save(int[][] pixel,String path)
    {
        try{
            BufferedImage image = new BufferedImage(pixel.length, pixel[0].length, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < pixel.length; y++) {
                for (int x = 0; x <  pixel[0].length; x++) {
                    image.setRGB(x, y, pixel[x][y]);
                }
            }
            ImageIO.write(image, "jpg", new File(path));  // Save as PNG
            System.out.println("Image saved successfully: " + path);
        }
        catch( IOException e)
        {
            System.out.println(e);
        }
    }
}
