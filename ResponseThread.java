import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ResponseThread extends Thread
{
	private Socket s;
	private String hello = "<html><body><h1>Hello World</h1><img src=spongeBob.jpg/></body></html>";
	private String index = "<html><body><h1>Homepage</h1></body></html>";
	private String error = "<html><body><h1>404: Page Not Found</h1></body></html>";

	public ResponseThread(Socket s)
	{
		this.s = s;
	}
	
	public void run()
	{
		try
		{
			Scanner input = new Scanner(this.s.getInputStream());
			String req = input.nextLine();
			System.out.println(req);
			String[] parts = req.split(" ");
			String theFunction = parts[0];
			String thePage = parts[1];
			String theProtocol = parts[2];
			System.out.println(thePage);

			PrintWriter output = new PrintWriter(this.s.getOutputStream());
			if(thePage.equalsIgnoreCase("/index.html") || thePage.equalsIgnoreCase("/"))
			{
				output.println(index);
			}
			else if(thePage.equalsIgnoreCase("/hello.html"))
			{
				output.println(hello);
			}
			else
			{
				output.println(error);
			}
			output.flush();
			output.close();
			
			for(int i = 0; i < 1000000; i++)
			{
				System.out.println("Wasting Time");
			}
		}
		catch(Exception e)
		{
			//im sure nothing will ever go wrong :)
		}
	}
}