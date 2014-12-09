import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import View.Login;


public class Client {
	
	private DataOutputStream os = null;	
	private InputStream is = null;
	private BufferedReader bf = null;
	private String serverMessage;
	private String serverRequest;
	
	public void sendMessage(String message, DataOutputStream os){
		try {
			os.writeBytes(message);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void recieveMessage(){
		
		try {
			while(bf == null)
				;
			System.out.println("kaptam uzenetet");
			serverMessage = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Socket serverSocket = null;
		Client client = new Client();
		
		try {
			serverSocket = new Socket("localhost" , 9997);
			try 
			{
				client.is = serverSocket.getInputStream();
				client.bf = new BufferedReader(new InputStreamReader(client.is));
				client.os = new DataOutputStream(serverSocket.getOutputStream());
			} 
		catch (IOException e) 
			{
				e.printStackTrace();
			}
			Login login = new Login();
			boolean shouldBreak = false;
			while(true)
			{
				if(login.getLoginText() == null) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					client.sendMessage("login;" + login.getLoginText() + "\n", client.os);
					client.recieveMessage();
					String[] elements = client.serverMessage.split(";");
					client.serverRequest = elements[0];
					switch (client.serverRequest) {
					case "showLoginPage":
						login.getFrame().setVisible(false);
						login.getFrame().dispose();
						login = new Login();
						break;
					case "showRoomManagerPage":
						//TODO
						shouldBreak = true;
						break;
					default:
						break;
					}
				}
				if(shouldBreak) {
					break;
				}
			}
			
			while(true)
				;
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
