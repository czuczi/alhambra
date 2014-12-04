import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import View.Login;


public class Client {
	
	private static DataOutputStream os = null;	
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
			serverMessage = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Socket serverSocket = null;
		Client client = new Client();
		
		try {
			serverSocket = new Socket("192.168.0.19" , 9997);
			os = new DataOutputStream(serverSocket.getOutputStream());
			Login login = new Login();
			while(login.getLoginText() == null)
			{
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			client.sendMessage("login;" + login.getLoginText() + "\n", os);
			while(true);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
