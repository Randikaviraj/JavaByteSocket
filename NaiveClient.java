import java.io.DataInputStream;
import java.net.Socket;

public class NaiveClient {
    public static void main(String[] args) {
        try {
            String server_ip=args[0];
            int server_port=Integer.parseInt(args[1]); 
            Socket socket=new Socket(server_ip,server_port);
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            char c='\0';
            while (true) {
                try {
                    c=(char)dataInputStream.readByte(); //read byte and cast to char
                } catch (Exception e) {
                    //TODO: handle exception
                }
               
                if (c=='\n') { //check for new line char
                    break;
                }
                System.out.print(c);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Failed : use correct format ./client <server ip> <server port>");
        }
        
    }
}
