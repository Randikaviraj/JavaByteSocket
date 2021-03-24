import java.io.DataInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Bufferclient {
    public static void main(String[] args) {
        try {
            List<Character> data_from_server = new ArrayList<Character>();

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
                data_from_server.add(c); //buffer to a char list
            }

            for (Character character : data_from_server) {// print buffered char
                System.out.print(character);
            }  

            System.out.println(); 

        } catch (Exception e) {
            System.out.println("Failed : use correct format ./client <server ip> <server port>");
        }
    }
}
