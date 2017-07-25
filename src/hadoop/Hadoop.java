package hadoop;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hadoop {
    public static void main(String[] args) {
        round1_start();
        round2_start();
        round3_start();
    }
    
    public static void round1_start(){
        try {
            Round1 r1 = new Round1();
            r1.start("Round1_input.txt");
        } catch (IOException ex) {
            Logger.getLogger(Hadoop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void round2_start(){
        try {
            Round2 r2 = new Round2();
            r2.start_map("round1_out.txt");
            r2.start_reduce("round2_map_out.txt");
        } catch (IOException ex) {
            Logger.getLogger(Hadoop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void round3_start(){
        try {
            Round3 r3 = new Round3();
            r3.start_map("round2_reduce_out.txt");
            r3.start_reduce("round3_map_out.txt");
        } catch (IOException ex) {
            Logger.getLogger(Hadoop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
