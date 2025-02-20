package functions;

public class discreateFT {
    public static double [] dft(double arr[])
    {
        int n=arr.length;
        double ans[]=new double[n];
        for(int i=0;i<n;i++)
        {
            double real=0;
            double img=0;
            for(int j=0;j<n;j++)
            {
                real+= ( arr[j]*Math.cos((2*Math.PI*i*j)/(double)n)/(double)n );
                img+= ( arr[j]*Math.sin((2*Math.PI*i*j)/(double)n)/(double)n );
            }
            ans[i]= Math.sqrt(real*real+img*img);
            ans[i]=(ans[i]);
            // ans[i]=real;
        }
        return ans;
    }
    public static double[][] dft(int arr[][])
    {
        int n=arr.length;
        int m=arr[0].length;
        double ans[][]=new double[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                double real=0;
                double img=0;
                for(int x=0;x<n;x++)
                {
                    for(int y=0;y<m;y++)
                    {
                        real+=(arr[x][y]*Math.cos(2*Math.PI*( (x*i)/(double)n + (y*j)/(double)m)));
                        img-=(arr[x][y]*Math.sin(2*Math.PI*( (x*i)/(double)n + (y*j)/(double)m)));
                    }
                }
                ans[i][j]=Math.sqrt(real*real+img*img);
                System.out.println(i+" "+j);
            }
        }
        return ans;
    }
    public static int[][] inverseDft(double arr[][])
    {
        int n=arr.length;
        int m=arr[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                double real=0;
                double img=0;
                for(int x=0;x<n;x++)
                {
                    for(int y=0;y<m;y++)
                    {
                        real+=(arr[x][y]*Math.cos(2*Math.PI*( (x*i)/(double)n + (y*j)/(double)m)));
                        img-=(arr[x][y]*Math.sin(2*Math.PI*( (x*i)/(double)n + (y*j)/(double)m)));
                    }
                }
                ans[i][j]=(int)(Math.sqrt(real*real+img*img)/(n*m));
            }
        }
        return ans;
    }
}
