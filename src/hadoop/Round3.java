package hadoop;

import java.io.*;
import java.util.*;

public class Round3 {
    public void start_map(String str) throws FileNotFoundException, IOException{
        String s;
        BufferedReader bufr = new BufferedReader(new FileReader(str));
        BufferedWriter bufw = new BufferedWriter(new FileWriter("round3_map_out.txt"),20);
        while((s = bufr.readLine()) != null){
            String arr[] = s.split(" ");
            String movie_id[] = arr[0].split("-");
            bufw.write(movie_id[0]+"-"+movie_id[1]+" "+arr[1]);
            bufw.newLine();
            bufw.write(movie_id[1]+"-"+movie_id[0]+" "+arr[1]);
            bufw.newLine();
        }
        bufw.flush();
    }
    
    public void start_reduce(String str) throws FileNotFoundException, IOException{
        String s;
        BufferedReader bufr = new BufferedReader(new FileReader(str));
        BufferedWriter bufw = new BufferedWriter(new FileWriter("round3_reduce_out.txt"),20);
        TreeMap<String,String> treemap = new TreeMap<String,String>();
        TreeSet<String> treeset = new TreeSet<String>();
        while((s = bufr.readLine())!= null){
            treeset.add(s);
        }
        for (String set : treeset) {
            String arr[] = set.split(" ");
            String movie_id[] = arr[0].split("-");
            if(treemap.containsKey(movie_id[0])){
                String value = treemap.get(movie_id[0]);
                treemap.put(movie_id[0], value+","+movie_id[1]);
            }else{
                treemap.put(movie_id[0], movie_id[1]);
            }
        }
        for(Map.Entry entry : treemap.entrySet()){
            bufw.write(entry.getKey()+" ["+entry.getValue()+"]");
            bufw.newLine();
        }
        bufw.flush();
    }
}
