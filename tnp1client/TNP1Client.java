package tnp1client;
import java.io.IOException;
/**
 * @author misha
 */
public class TNP1Client {
    public static void main(String[] args) { 
        Client c1 = new Client();
        Client c2 = new Client();
        try {
            c1.run(null);
            c2.run(null);
        } catch (IOException ex) {
            System.out.println(ex);
        }        
    } 
}
