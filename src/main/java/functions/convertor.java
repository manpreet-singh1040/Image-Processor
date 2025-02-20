package functions;

public class convertor {
    public static int [][] rgbToGray(int [][]pixel){
        int n=pixel.length;
        int m=pixel[0].length;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int b= (pixel[i][j] & 0xff);
                int g= ( (pixel[i][j] >> 8)  & 0xff);
                int r= ( (pixel[i][j] >> 16)  & 0xff);
                ans[i][j]=((int)(0.299*r+0.587*g+b*0.114))%256;
            }
        }
        return ans;
    }
}
