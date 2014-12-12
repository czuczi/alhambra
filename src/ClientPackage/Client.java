package ClientPackage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import View.Login;
import View.RoomManagerPage;
import View.RoomPage;

public class Client {

	private DataOutputStream os = null;
	private InputStream is = null;
	private BufferedReader bf = null;
	private String serverMessage;
	private String serverRequest;
	
	private List<String> roomList;
	private List<String> playerListInRoom;

	public void sendMessage(String message, DataOutputStream os) {
		try {
			os.writeBytes(message+"\n");
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void recieveMessage() {

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
			serverSocket = new Socket("localhost", 9993);
			try {
				client.is = serverSocket.getInputStream();
				client.bf = new BufferedReader(new InputStreamReader(client.is));
				client.os = new DataOutputStream(serverSocket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			Login login = new Login(client);
			RoomManagerPage roomManagerPage = null;
			RoomPage roomPage = null;
			boolean shouldBreak = false;
			
			while (true) {
	//			System.out.println("kliens várakozik üzenetre: "+client.serverMessage);
				client.recieveMessage();
				System.out.println("kliens üzenetet kapott a szervertől: "+client.serverMessage);
				String[] elements = client.serverMessage.split(";");
				client.serverRequest = elements[0];
				switch (client.serverRequest) {
				case "showLoginPage":													
					if(elements[1].equals("login")){									//LOGIN FAILED
						JOptionPane.showMessageDialog(null, "Már van ilyen felahsználó!");
					} else{																//LOGOUT
						System.out.println("logout success");
						roomManagerPage.getFrame().setVisible(false);
						roomManagerPage.getFrame().dispose();
						login = new Login(client);
					}
					break;
				case "showRoomManagerPage":												
					if(elements[1].equals("login")){									//LOGIN SUCCESS
						login.getFrame().setVisible(false);
						login.getFrame().dispose();
					} else{
						if(elements[1].equals("RoomManagerPage")){						//CREATE NEW ROOM FAILED  OR JOIN ROOM FAILED
							if(elements[2].equals("joinRoom")) {
								JOptionPane.showMessageDialog(null, "A szoba megtelt!");
								break;
							}
							JOptionPane.showMessageDialog(null, "A név foglalt!");
							break;
						} else{															//LEAVE ROOM
							
						}
																						
					}
					client.roomList = new ArrayList<>(); //szobalista init
					if(elements.length > 2){
						for(int i=2; i<elements.length; i++){
							client.roomList.add(elements[i]);
						}
					}
					roomManagerPage = new RoomManagerPage(client);
					break;
					
				case "showRoomPage":
					if(elements[1].equals("RoomManagerPage")){							//JOIN ROOM SUCCESS
						roomManagerPage.getFrame().setVisible(false);
						roomManagerPage.getFrame().dispose();
					} else{
						if(elements[1].equals("RoomPage")){								//SZOBÁBAN LÉVŐKNEK ÜZENETSZÓRÁS ÉRKEZIK
							client.playerListInRoom = new ArrayList<>();	//jatekoslista firssítés
							if(elements.length > 2){
								for(int i=2; i<elements.length; i++){
									client.playerListInRoom.add(elements[i]);
								}
							}
							System.out.println(client.playerListInRoom.size());
							roomPage.playerListBeallito(client.playerListInRoom);
							roomPage.revalidate();
							roomPage.repaint();
							break;
						}
					}
					client.playerListInRoom = new ArrayList<>();	//jatekoslista init
					if(elements.length > 2){
						for(int i=2; i<elements.length; i++){
							client.playerListInRoom.add(elements[i]);
						}
					}
					roomPage = new RoomPage(client);
					break;
					
				case "showGameTablePage":
					//TODO
					break;
					
				case "refreshRoomList":
					client.roomList.add(elements[1]);
					roomManagerPage.roomListBeallito(client.roomList);
					roomManagerPage.revalidate();
					roomManagerPage.repaint();
					break;
					
				default:
					shouldBreak = true;
					break;
				}

				if (shouldBreak) {
					break;
				}
			}

			while (true)
				;

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public DataOutputStream getOs() {
		return os;
	}

	public void setOs(DataOutputStream os) {
		this.os = os;
	}

	public List<String> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<String> roomList) {
		this.roomList = roomList;
	}

	public List<String> getPlayerListInRoom() {
		return playerListInRoom;
	}

	public void setPlayerListInRoom(List<String> playerListInRoom) {
		this.playerListInRoom = playerListInRoom;
	}
	
	
	
}
