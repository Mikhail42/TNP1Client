package tnp1client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
    public void run(String[] args) throws IOException {
        Socket s = null;
        try{
            s = new Socket(HOSTNAME,SOCKEDID);
            try{
                writeInOS(s);
                tnp1client.IOMatrix.saveMatrix(FILENAME3, readFromIS(s));
            } catch(IOException e) {
                System.out.println("Проверьте корректность данных в файлах. Выброшено исключение "+e.toString());
            } finally {
                s.getOutputStream().close();
                s.getInputStream().close();
            }
        } catch (UnknownHostException e){
            System.err.println("Проверьте имя хоста. Выброшено исключение "+e.toString());
        } catch (IOException e){
            System.err.println("Проверьте имена файлов, адрес порта, а также их доступность. Выброшено исключение "+e.toString());
        }  
    }
    private void writeInOS(Socket s) throws IOException{
        // id операции: 1 -- вычитание, 2 -- сложение, 3 -- умножение
        String out1 = "1"; 
        String out2 = tnp1client.IOMatrix.loadMatrix(FILENAME1); String out3 = "$\n";  
        String out4 = tnp1client.IOMatrix.loadMatrix(FILENAME2); String out5 = "$\n";
        
        OutputStream outStream = s.getOutputStream();
        outStream.write(out1.getBytes()); 
        outStream.write(out2.getBytes()); outStream.write(out3.getBytes());
        outStream.write(out4.getBytes()); outStream.write(out5.getBytes());
        outStream.flush(); 
    }
    private String readFromIS(Socket s) throws IOException{
        InputStream inStream = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
        StringBuilder sb = new StringBuilder();
        String curS; while ((curS = br.readLine())!=null) sb.append(curS).append('\n');
        return  sb.toString();
    }
    
    public static final String HOSTNAME = "localhost";
    private static final String FILENAME1 = "/home/misha/Рабочий стол/matrix1";
    private static final String FILENAME2 = "/home/misha/Рабочий стол/matrix2";
    private static final String FILENAME3 = "/home/misha/Рабочий стол/matrix3";
    public static final int SOCKEDID = 8070;
}
