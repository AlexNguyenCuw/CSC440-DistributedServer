import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ResponseThread extends Thread
{
	private Socket s;
	

	public ResponseThread(Socket s)
	{
		this.s = s;
	}
	
	public void run()
	{
		try
		{
			Scanner input = new Scanner(this.s.getInputStream());
			PrintWriter output = new PrintWriter(this.s.getOutputStream(), true);
			
			while(true)
			{
				String req = input.nextLine();
				System.out.println(req);
			}
			
		}
		catch(Exception e)
		{
			//im sure nothing will ever go wrong :)
		}
	}
}