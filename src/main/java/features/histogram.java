package features;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.HashMap;
import plotting.simplePlot;
public class histogram {
    private int [][]histogram;
    private int [][] cdf;
    private int maping[][];
    private BufferedImage image;
    public histogram(BufferedImage img){
        image=img;
        histogram=new int[256][3];
        cdf=new int[256][3];
        maping=new int[256][3];
        for(int i=0;i<image.getWidth();i++){
            for(int j=0;j<image.getHeight();j++){
                histogram[ image.getRGB(i, j) & 0xff ][0]++;
                histogram[ (image.getRGB(i, j) >> 8) & 0xff ][1]++;
                histogram[ (image.getRGB(i, j) >> 16) & 0xff ][2]++;
            }
        }
        for(int i=0;i<256;i++){
           if(i==0){
            cdf[i][0]=histogram[i][0];
            cdf[i][1]=histogram[i][1];
            cdf[i][2]=histogram[i][2];
           }
           else{
            cdf[i][0]=histogram[i][0]+cdf[i-1][0];
            cdf[i][1]=histogram[i][1]+cdf[i-1][1];
            cdf[i][2]=histogram[i][2]+cdf[i-1][2];
           }
        }
        System.out.println("int histogram constructor!!");
    }
    public void equalization(){
        for(int i=0;i<256;i++){
            if(i==0){
             cdf[i][0]=histogram[i][0];
             cdf[i][1]=histogram[i][1];
             cdf[i][2]=histogram[i][2];
            }
            else{
             cdf[i][0]=histogram[i][0]+cdf[i-1][0];
             cdf[i][1]=histogram[i][1]+cdf[i-1][1];
             cdf[i][2]=histogram[i][2]+cdf[i-1][2];
            }
         }
        int irmax=-1;
        int irmin=Integer.MAX_VALUE;
        int igmax=-1;
        int igmin=Integer.MAX_VALUE;
        int ibmax=-1;
        int ibmin=Integer.MAX_VALUE;
        int newHistogram[][]=new int[256][3];
        for(int i[]:histogram){
            irmax=Math.max(irmax,i[0]);
            irmin=Math.min(irmin,i[0]);
            igmax=Math.max(igmax,i[0]);
            igmin=Math.min(igmin,i[0]);
            ibmax=Math.max(ibmax,i[0]);
            ibmin=Math.min(ibmin,i[0]);
        }
        int totalPixel=cdf[255][0];
        for(int i=0;i<256;i++){
            
                newHistogram[i][0]=(int)(( ((double)(histogram[i][0]-irmin ))/(irmax-irmin) )*255);
                newHistogram[i][1]=(int)(( ((double)(histogram[i][1]-igmin ))/(igmax-igmin) )*255);
                newHistogram[i][2]=(int)(( ((double)(histogram[i][2]-ibmin ))/(ibmax-ibmin) )*255);
                // newHistogram[i][0]=(int)(( ((double)(totalPixel))/(256) ));
                // newHistogram[i][1]=(int)(( ((double)(totalPixel))/(256) ));
                // newHistogram[i][2]=(int)(( ((double)(totalPixel))/(256) ));
                
        }
        int newcdf[][]=new int[256][3];
        // for(int i=0;i<256;i++){
        //     if(i==0){
        //      newcdf[i][0]=newHistogram[i][0];
        //      newcdf[i][1]=newHistogram[i][1];
        //      newcdf[i][2]=newHistogram[i][2];
        //     }
        //     else{
        //         newcdf[i][0]=newHistogram[i][0]+newcdf[i-1][0];
        //         newcdf[i][1]=newHistogram[i][1]+newcdf[i-1][1];
        //         newcdf[i][2]=newHistogram[i][2]+newcdf[i-1][2];
        //     }
        //  }
        //  for(int k=0;k<3;k++){

        //      for(int i=0;i<256;i++){
        //         int closestValue = 0;
        //     int minDiff = Integer.MAX_VALUE;
        //     for (int j = 0; j < 256; j++) {
        //         int diff = Math.abs(cdf[i][k] - newcdf[j][k]);
        //         if (diff < minDiff) {
        //             minDiff = diff;
        //             closestValue = j;
        //         }
        //     }
        //     maping[i][k] = closestValue;
        //  }
        // }
        for (int i = 0; i < 256; i++) {
            maping[i][0] = (int)((((double)cdf[i][0] - cdf[0][0]) / (totalPixel - cdf[0][0])) * 255);
            maping[i][1] = (int)((((double)cdf[i][1] - cdf[0][1]) / (totalPixel - cdf[0][1])) * 255);
            maping[i][2] = (int)((((double)cdf[i][2] - cdf[0][2]) / (totalPixel - cdf[0][2])) * 255);
        }
        int sumr=0;
        int sumg=0;
        int sumb=0;
        for(int i=0;i<256;i++){
            histogram[i][0]=0;
            histogram[i][1]=0;
            histogram[i][2]=0;
        }
        for(int i=0;i<image.getWidth();i++){
            for(int j=0;j<image.getHeight();j++){
                int r=(image.getRGB(i, j) & 0xff);
                int g=((image.getRGB(i, j) >> 8) & 0xff);
                int b=((image.getRGB(i, j) >> 16) & 0xff);
                // sumr+=r;
                // sumg+=g;
                // sumb+=b;
                int newrgb=( maping[r][0] | (maping[g][1] << 8) | (maping[b][2] << 16) );
                histogram[r][0]++;
                histogram[g][1]++;
                histogram[b][2]++;
                image.setRGB(i, j, newrgb);
            }
        }
        // boolean check=true;
        // for(int i=0;i<256;i++){
        //     System.out.println(i+" mapping--> "+maping[i][0]+" "+maping[i][1]+" "+maping[i][2]);
        // }

        // simplePlot.plot(histogram, "original");
        // simplePlot.plot(newHistogram, "modified");
        // simplePlot.plot(maping, "mapping");
        System.out.println("image transformation done !!");
    }
}
