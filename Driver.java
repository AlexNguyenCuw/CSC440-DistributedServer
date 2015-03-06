import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;


public class Driver 
{
	public static void main(String[] args) throws Exception
	{
			ServerSocket ss = new ServerSocket(1234);
			int count = 0;
			
			
			while(true)
			{
				System.out.println("Waiting...");
				Socket connection = ss.accept();
				ResponseThread rt = new ResponseThread(connection);
				System.out.println("Connected!");
				rt.start();
			}
	}
}
