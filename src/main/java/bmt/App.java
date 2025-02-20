package bmt;
import gui.gui;
import functions.fastFT;

import java.util.ArrayList;
import java.util.*;

import functions.displayImage;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! ncjiwjik " );
        gui GUI=new gui();
        // int r=500;
        // int c=500;
        // int pixel[][]=new int[r][c];
        // double a[][]=new double[r][c*2];
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         double x=Math.sin(2*Math.PI*j*0.90000001)*255;
        //         pixel[i][j]=((int)(x));
        //         a[i][2*j]=pixel[i][j];
        //         a[i][2*j+1]=0;
        //         // a[i*2*500+2*j+1]=pixel[i][j];

        //     }
        // }
        // fastFT.twoDfft(a, r, c);
        // double min=1000000000;
        // double max=-1000000000;
        // // fastFT.inverseTwoDfft(a, r, c, true);
        // int pixel2[][]=new int[r][c];
        // double tempp[][]=new double[r][c];
        // ArrayList<double[]> arr=new ArrayList<>();
        // Comparator<double[]> comp=(aa,bb)->{
        //     return Double.compare(bb[0], aa[0]);
        //     // return bb[0]-aa[0];
        // };
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         // double x=Math.cos(2*Math.PI*j*0.008)*255;
        //         // pixel2[i][j]=((int)(x));
        //         double magnitude = Math.sqrt(a[i][2 * j] * a[i][2 * j] + a[i][2 * j + 1] * a[i][2 * j + 1]);
        //         // Normalize magnitude to the range of 0-255
        //         pixel2[i][j] = (int)(magnitude / 255 * 255); // Just scale without using min value
        //         tempp[i][j] = magnitude;
        //         min=Math.min(min,magnitude);
        //         max=Math.max(max,magnitude);
        //         arr.add(new double[]{magnitude,i,j});
        //         // System.out.print(pixel2[i][j]+" ");
        //     }
        //     // System.out.println();
        // }
        // Collections.sort(arr,comp);
        // // for(int i=0;i<r;i++){
        // //     for(int j=0;j<c;j++){
        // //         System.out.print(pixel2[i][j]+" ");
        // //     }
        // //     System.out.println();
        // // }
        // System.out.println(min+" "+max);
        // for(int i=0;i<10;i++){
        //     System.out.println(arr.get(i)[0]+" "+arr.get(i)[1]+" "+arr.get(i)[2]);
        // }
        // displayImage.display(pixel);
        // displayImage.display(pixel2);

    }
}
