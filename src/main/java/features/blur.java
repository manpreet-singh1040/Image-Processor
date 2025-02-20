package features;

import java.awt.image.BufferedImage;

public class blur {
    public static int[][] blurEffect(int pixel[][],int kernalSize)
    {
        int n=pixel.length;
        int m=pixel[0].length;
        int newPixel[][]=new int[n][m];
        // int kernal[][]=new int[kernalSize][kernalSize];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int num=0;
                long sum[]=new long[3];
                for(int x=i-kernalSize/2;x<=i+kernalSize/2;x++)
                {
                    for(int y=j-kernalSize/2;y<=j+kernalSize/2;y++)
                    {
                        if(x>=0 && y>=0 && x<n && y<m)
                        {
                            num++;
                            sum[0]+=( pixel[x][y] & 0xff);
                            sum[1]+=( ( pixel[x][y] >> 8) & 0xff);
                            sum[2]+=( ( pixel[x][y] >> 16) &  0xff);
                        }
                    }
                }
                newPixel[i][j]=( (int)(sum[0]/num) | ((int)(sum[1]/num) <<8) | ((int)(sum[2]/num) <<16 ));
            }
        }
        return newPixel;
    }
    public static BufferedImage blurEffect(BufferedImage image,int kernalSize)
    {
        int n=image.getWidth();
        int m=image.getHeight();
        // int newPixel[][]=new int[n][m];
        // int kernal[][]=new int[kernalSize][kernalSize];
        BufferedImage newImage=new BufferedImage(n, m, BufferedImage.TYPE_INT_BGR);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int num=0;
                long sum[]=new long[3];
                for(int x=i-kernalSize/2;x<=i+kernalSize/2;x++)
                {
                    for(int y=j-kernalSize/2;y<=j+kernalSize/2;y++)
                    {
                        if(x>=0 && y>=0 && x<n && y<m)
                        {
                            num++;
                            sum[0]+=( image.getRGB(x, y) & 0xff);
                            sum[1]+=( ( image.getRGB(x, y) >> 8) & 0xff);
                            sum[2]+=( ( image.getRGB(x, y) >> 16) &  0xff);
                        }
                    }
                }
                newImage.setRGB(i, j, ( (int)(sum[0]/num) | ((int)(sum[1]/num) <<8) | ((int)(sum[2]/num) <<16 )));
            }
        }
        return newImage;
    }
}
