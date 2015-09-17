package tnp1client;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author misha
 */
public class IOMatrix {
    public static void saveMatrix(String fileName, String matrixS) throws IOException{
        FileWriter fw = new FileWriter(fileName);
        fw.write(matrixS, 0, matrixS.length());
        fw.close();
    }
    public static String loadMatrix(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        byte[] fileContent = new byte[in.available()];
        in.read(fileContent);
        in.close();
        return new String(fileContent);
    }
}
