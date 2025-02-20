package features;

public class lowPassfilter {
    static void lowPass(double arr[][]){
        int n=arr.length;
        int m=arr[0].length/2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                double real=arr[i][2*j];
                double img=arr[i][j*2+1];
                
            }
        }
    }
}
