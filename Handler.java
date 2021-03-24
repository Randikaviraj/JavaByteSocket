import java.io.PrintStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Handler extends Thread {

    private Socket cliSocket;
    private String word;
    private int no_of_data_sending;

    public Handler(Socket cliSocket,String word,int no_of_data_sending){
        this.cliSocket=cliSocket;
        this.word=word;
        this.no_of_data_sending=no_of_data_sending;
    }

    public void run(){
        sendDataToClient();
    }

    public void sendDataToClient(){
        try {
            // printstream object for print stream to the client
            PrintStream ps=new PrintStream(this.cliSocket.getOutputStream());
            byte[] dataInBytes = this.word.getBytes(StandardCharsets.UTF_8); //string convert to byte array
            for (int i = 0; i < this.no_of_data_sending-1; i++) {
                for (int j = 0; j < dataInBytes.length; j++) {
                    synchronized (dataInBytes){
                        ps.write(dataInBytes[j]); //write bytes to stream
                        Thread.sleep(1000);//wait for 1 second
                    }
                    
                }
            }
            ps.write('\n'); //write new line character to stream
            ps.close();
            this.cliSocket.close();    

        } catch (Exception e) {
            System.out.println("client data sending failed"+e);
        }
        
    }
    
}
