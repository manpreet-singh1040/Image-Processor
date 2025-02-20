package functions;
import java.io.*;
import java.util.TreeMap;
public class readTxt {
    public static void runLength(String path,String resultPath)
    {
        try{
            TreeMap <Integer,String> map=new TreeMap<>();
            StringBuilder str=new StringBuilder();
            str.append('0');
            for(int i=1;i<=7;i++)
            {
                map.put(i,str.toString());
                str.append('0');
            }
            FileReader reader=new FileReader(path);
            FileWriter writer=new FileWriter(resultPath,true);
            int maxz=0;
            int maxo=0;
            int prevVal=reader.read();
            int o=0;
            int z=0;
            int cur=1;
            int c=reader.read();
            // prevVal=c;
            // int x=0;
            while(c!=-1)
            {
                if(c==prevVal)
                {
                    cur++;
                }
                else{
                    writer.append((char)prevVal);
                    String binstr=Integer.toBinaryString(cur);
                    if(binstr.length()<7) writer.append(map.get(7-binstr.length()));
                    writer.append(binstr);
                    prevVal=c;
                    cur=1;
                }
                c=reader.read();
                // x=1;
            }
            writer.append((char)prevVal);
            String binstr=Integer.toBinaryString(cur);
            if(binstr.length()<9) writer.append(map.get(9-binstr.length()));
            writer.append(binstr);
            System.out.println("run length encoding done !!!");
            // System.out.println("the number of zeros are--> "+maxz);
            // System.out.println("the number of ones are--> "+maxo);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
