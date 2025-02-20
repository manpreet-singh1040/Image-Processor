package functions;
import org.jtransforms.fft.DoubleFFT_1D;
import org.jtransforms.fft.DoubleFFT_2D;

public class fastFT {
    public static double[][] twoDfft(double a[][],long rowl,long coll)
    {
        DoubleFFT_2D fft=new DoubleFFT_2D(rowl, coll);
        fft.complexForward(a);
        return a;
    }
    public static double[][] inverseTwoDfft(double a[][],long rowl,long coll,boolean scale){
        // in this the real part is in a[i][2*j] & img part is in a[i][2*j+1]
        DoubleFFT_2D fft=new DoubleFFT_2D(rowl, coll);
        fft.complexInverse(a, scale);
        return a ;
    }
    public static double[] OneDfft(double[] arr){
        DoubleFFT_1D fft = new DoubleFFT_1D(arr.length/2);
        fft.complexForward(arr);
        return arr;
    }
    public static double[] inverseOneDfft(double [] arr,boolean scale){
        DoubleFFT_1D fft = new DoubleFFT_1D(arr.length/2);
        fft.complexInverse(arr,scale);
        return arr;
    }
    public static void printRealAndImaginary(double[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            double real = arr[2 * i];
            double imaginary = arr[2 * i + 1];
            System.out.println("Frequency " + i + ": " + real + " + " + imaginary + "i");
        }
    }

}
