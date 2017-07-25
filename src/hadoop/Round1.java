package hadoop;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Round1 {
    public void start(String str) throws FileNotFoundException, IOException{
        String str1;
        BufferedReader buf = new BufferedReader(new FileReader(str));
        TreeSet set = new TreeSet();
        while((str1 = buf.readLine()) != null){
            String arr[] = str1.split(" ");
            if(Integer.parseInt(arr[2]) < 3){
                continue;
            }
            set.add(arr[0]+" "+arr[1]);
        }
        Iterator<String> itr = set.iterator();
        BufferedWriter bufw = new BufferedWriter(new FileWriter("round1_out.txt"),20);
        while(itr.hasNext()){
            bufw.write(itr.next());
            bufw.newLine();
            
        }
        bufw.flush();
    }
}
