import java.io.IOException;
import java.util.Scanner;
import java.net.*;

public class Server{
    public static void main(String[] args) {
        int server_port;
        int max_clients;
        ServerSocket serverSocket=null;

        try {
            server_port=Integer.parseInt(args[0]);
            max_clients=Integer.parseInt(args[1]); 
            //  server socket created with max xlient allowed simultaniously
            serverSocket=new ServerSocket(server_port,max_clients);

        }catch(IOException e){
            System.out.println("Server Error :"+e);
            System.exit(-1);
        }
        catch (Exception e) {
            System.out.println("Enter  port and max number of of clients : ./server <server port> <max client>");
            System.exit(-1);
        }

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        String word;
        int  no_of_data_sending;

        try {
            System.out.println("Enter your string :");
            word= in.nextLine();

            System.out.println("Enter your integer :");
            no_of_data_sending= in.nextInt();
        if (no_of_data_sending<0) {
            System.out.println("Enter positive integer !");
            return;
        }
        } catch (Exception e) {
            System.out.println("Enter positive integer and string!");
            return;
        }

        Socket clientSocket;

        while (true) {
            
            try {
                // waiting for client connections
                clientSocket=serverSocket.accept();
                // new thread for the client
                new Handler(clientSocket,word,no_of_data_sending).start();
            } catch (Exception e) {
                System.out.println("Serever stoped..");
            }
            
        }

        
        
    }

    
}
