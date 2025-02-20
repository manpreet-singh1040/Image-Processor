package functions;
import java.io.*;
import java.util.TreeMap;


public class writingTxt {
    public static void array(int[][]arr,String path)
    {
        try{
            FileWriter writer = new FileWriter(path,true);
            TreeMap<Integer,String> map=new TreeMap<>();
            StringBuilder str=new StringBuilder();
            str.append('0');
            for(int i=1;i<=24;i++)
            {
                map.put(i,str.toString());
                str.append('0');
            }
            for(int i[]: arr)
            {
                for(int j:i)
                {
                    int temp= ( j & 0xffffff );
                    String binstr=Integer.toBinaryString(temp);
                    if(binstr.length()<24) writer.append(map.get(24-binstr.length()));
                    writer.append(binstr);
                }
            }
        }
        catch(IOException e){
            System.out.println(e);
        }

    }
}
