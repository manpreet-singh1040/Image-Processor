package functions;

public class convolution {
    public static double[] convol(double x[],double y[])
    {
        int n=x.length;
        int m=y.length;
        double ans[]=new double[n+m-1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans[i+j]+=(x[i]*y[j]);
            }
        }
        return ans;
    }
}
