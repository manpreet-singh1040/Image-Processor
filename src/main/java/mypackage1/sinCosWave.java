package mypackage1;

public class sinCosWave {
    public static double[] sinWave(double amp, double freq, int NumberOfSamples)
    {
        int n=NumberOfSamples;
        double ans[]=new double[n];
        for(int i=0;i<n;i++)
        {
            double t=(double)i/(double)n;
            ans[i]= ( amp*( Math.sin(2*Math.PI*freq*(t)) ) );
        }
        return ans;
    }
    public static double[] cosWave(double amp, double freq, int NumberOfSamples)
    {
        int n=NumberOfSamples;
        double ans[]=new double[n];
        for(int i=0;i<n;i++)
        {
            double t=(double)i/(double)n;
            ans[i]= ( amp*( Math.cos(2*Math.PI*freq*(t)) ) );
        }
        return ans;
    }
}
