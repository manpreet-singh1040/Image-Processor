import mypackage1.pro1;
import mypackage1.sinCosWave;
import functions.readImage;
import plotting.simplePlot;
import functions.animate;
import functions.discreateFT;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.imageio.ImageIO;
import gui.*;
import functions.saveImage;
import functions.displayImage;
import features.blur;
import functions.*;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        gui Gui=new gui();
        // pro1 obj=new pro1();
        // obj.printMe();
        // mypackage1.pro1("hey man")
        // pro1 obj=new pro1();
        // long startTime=System.nanoTime();
        // String imagePath="D:\\projects\\imageProcessor\\pexels-eberhardgross-1302312.jpg";
        // int [][] imagePixel=readImage.readImg(imagePath);
        // int n=imagePixel.length*imagePixel[0].length;
        // double imageArr[]=new double[n];
        // int count=0;
        // double blue[]=new double[256];
        // double red[]=new double[n];
        // double green[]=new double[256];
        // for(int i[]: imagePixel)
        // {
        //     for(int j:i)
        //     {
        //         red[ count ]=(j>>16) & 0xff;
        //         imageArr[count++]=(j & 0xffffff);
        //         // imageArr[count++]=count;
        //         blue[j & 0xff]++;
        //         green[ (j>>8) & 0xff ]++;
        //     }
        // }
        // obj.printMe(imageArr);
        // double redDFT[]=discreateFT.dft(red);
        // long endTime=System.nanoTime();
        // double x=((double)(endTime-startTime))/1000000000.0;
        // System.out.println((n));
        // System.out.println(x);
        // simplePlot.plot(red,"red plot");
        // // simplePlot.plot(green,"green plot");
        // // simplePlot.plot(blue,"blue plot");
        // simplePlot.plot(redDFT, "DFT-red");
        // simplePlot.plot(red,"red");
        // simplePlot.plot(discreateFT.dft(green), "DFT-green");
        // simplePlot.plot(discreateFT.dft(blue), "DFT-blue");






        // double arr1[]=new double[n];
        // int tri=0;
        // for(int i=0;i<n;i++)
        // {
        //     arr1[i]= Math.random();
        // // //    if(i==2000) arr1[i]=1;
        // //       if(i>=2000 && i<=3000)
        // //       {
        // //         arr1[i]=tri++;
        // //       }
        // //       if(i>3000 && tri>=0)
        // //       {
        // //         arr1[i]=tri--;
        // //       }
        // }
        // double arr2[]=new double[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr2[i]= Math.random()*Math.pow(1000,Math.random()) ;
        //     // arr2[i]=1;
        // }
        // double sinWave1[]=sinCosWave.sinWave(1,3000,n);
        // double sinWave2[]=sinCosWave.sinWave(1, 1000, n);
        // double ans[]=convolution.convol(arr1,sinWave);
        // System.out.println(x);
        // Thread thread1=new Thread();
        // thread1.start();
        // simplePlot.plot(arr2);
        // simplePlot.plot(arr1);
        // simplePlot.plot(sinWave);
        // double mixedSignal[]=new double[n];
        // for(int i=0;i<n;i++)
        // {
        //     mixedSignal[i]=sinWave1[i]+sinWave2[i];
        // }
        // Arrays.sort(arr1);
        // double sinDFT1[]=discreateFT.dft(sinWave1);
        // double sinDFT2[]=discreateFT.dft(sinWave2);
        // simplePlot.plot(sinDFT1);
        // simplePlot.plot(sinDFT2);
        // simplePlot.plot(discreateFT.dft(mixedSignal));
        // simplePlot.plot(arr1);
        // simplePlot.plot(discreateFT.dft(arr1));
        // simplePlot.plot(discreateFT.dft(arr1));
        // obj.printMe(sinDFT);
        // simplePlot.plot(ans);
        // int savePixel[][]=new int [200][200];
        // for(int i=0;i<200;i++)
        // {
        //     for(int j=0;j<200;j++)
        //     {
        //         savePixel[i][j]=255;
        //     }
        // }



        // int inputImage[][]=readImage.readImg(imagePath);
        // // displayImage.display(imagePixel);
        // int newImage[][]=blur.blurEffect(imagePixel, 3);
        // for(int i=0;i<5;i++)
        // {
        //     int temp[][]=blur.blurEffect(newImage,3);
        //     for(int j=0;j<newImage.length;j++)
        //     {
        //         for(int k=0;k<newImage[0].length;k++)
        //         {
        //             newImage[j][k]=temp[j][k];
        //         }
        //     }
            
        // }




        // displayImage.display(newImage);
        // writingTxt.array(inputImage, "D:\\\\projects\\\\imageProcessor\\\\testing-saving.txt");
        // saveImage.save(savePixel, "D:\\projects\\imageProcessor\\testing-saving.jpg");
        // animate.animate();
        // readTxt.runLength("D:\\\\projects\\\\imageProcessor\\\\testing-saving.txt","D:\\\\projects\\\\imageProcessor\\\\runlengthResult.txt");
        // plotDFTofImg("D:\\projects\\imageProcessor\\pexels-eberhardgross-1302312.jpg");
    }



    public static void plotDFTofImg(String path){
        int pixel[][]=readImage.readImg(path);
        int grayScale[][]=convertor.rgbToGray(pixel);
        double[][] dftOfImage=discreateFT.dft(pixel);
        System.out.println("dft calculated !!");
        double max=0;
        displayImage.display(pixel);
        System.out.println("the original image displayed !!");
        displayImage.displayGray(grayScale);
        System.out.println("the gray image displayed !!");
        for(double i[]:dftOfImage)
        {
            for(double j:i)
            {
                max=Math.max(max,j);
            }
        }
        int [][] dftimagePixel=new int[dftOfImage.length][dftOfImage[0].length];
        for(int i=0;i<dftOfImage.length;i++)
        {
            for(int j=0;j<dftOfImage[0].length;j++)
            {
                dftimagePixel[i][j]=(int)(((dftOfImage[i][j]*100*256)/(double)max)%256);
            }
        }
        displayImage.displayGray(dftimagePixel);
        System.out.println("the dft image displayed !!");
    }
}
