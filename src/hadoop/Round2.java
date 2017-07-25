package hadoop;

import java.io.*;
import java.util.*;

public class Round2 {
    public void start_map(String str) throws FileNotFoundException, IOException{
        int count = 0,sub_count;
        String str1,user_id="";
        ArrayList arraylist = new ArrayList();
        BufferedReader bufr = new BufferedReader(new FileReader(str));
        BufferedWriter bufw = new BufferedWriter(new FileWriter("round2_map_out.txt"),20);
        while((str1 = bufr.readLine()) != null){
            String arr[] = str1.split(" ");
            arraylist.add(arr[1]);
            if(arr[0].equals(user_id)){
                count++;
                sub_count = count;
                while(sub_count > 0){
                    sub_count--;
                    bufw.write(arraylist.get(sub_count)+"-"+arr[1]+" "+"1");
                    bufw.newLine();                    
                }
            }else {
                String last = (String)arraylist.get(arraylist.size()-1);
                arraylist.removeAll(arraylist);
                arraylist.add(last);
                count = 0;
            }
            user_id = arr[0];
        }
        bufw.flush();
    }
        
    public void start_reduce(String str) throws FileNotFoundException, IOException{
        String s;
        BufferedReader bufr = new BufferedReader(new FileReader(str));
        BufferedWriter bufw = new BufferedWriter(new FileWriter("round2_reduce_out.txt"),20);
        Map<String,String> treemap = new TreeMap<String,String>();
        while((s = bufr.readLine()) != null){
            String arr[] = s.split(" ");
            if(treemap.containsKey(arr[0])){
                int value = Integer.parseInt(treemap.get(arr[0])) +1;
                treemap.put(arr[0], value+"");
            }else{
                treemap.put(arr[0], arr[1]);
            }
        }
        for (Map.Entry entry : treemap.entrySet()) {
            
            bufw.write(entry.getKey()+" "+entry.getValue());
            bufw.newLine();
        }
        bufw.flush();
    }
    public void show(Object str){
        System.out.println(str);
    }
}
