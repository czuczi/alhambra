package ClientPackage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import View.FinalScorePage;
import View.GameTablePage;
import View.GiftCards;
import View.Login;
import View.RoomManagerPage;
import View.RoomPage;
import View.ScorePage;

public class Client {
	
	private Socket serverSocket;
	private DataOutputStream os = null;
	private InputStream is = null;
	private BufferedReader bf = null;
	private String serverMessage;
	private String serverRequest;
	private boolean isGiftBuild = false;
	private String giftMessage = "";
	
	private List<String> roomList;
	private List<String> playerListInRoom;
	
	private int numberOfEvaluation = 0;
	private GameTablePage gameTablePage = null;
	

	public void sendMessage(String message, DataOutputStream os) {
		try {
			os.writeBytes(message+"\n");
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void receiveMessage() {

		try {
			serverMessage = bf.readLine();
			if(serverMessage == null) {
				serverSocket.close();
				is.close();
				bf.close();
				os.close();
				System.exit(0);
			}
		} catch (IOException e) {
			try {
				serverSocket.close();
				is.close();
				bf.close();
				os.close();
				System.exit(0);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		Client client = new Client();

		try {
			client.serverSocket = new Socket("172.22.197.81", 9999);
			try {
				client.is = client.serverSocket.getInputStream();
				client.bf = new BufferedReader(new InputStreamReader(client.is));
				client.os = new DataOutputStream(client.serverSocket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			Login login = new Login(client);
			RoomManagerPage roomManagerPage = null;
			RoomPage roomPage = null;
			GameTablePage gameTablePage = null;
			ScorePage scorePage = null;
			GiftCards giftCards = null;
			FinalScorePage finalScorePage = null;
			boolean shouldBreak = false;
			
			while (true) {
	//			System.out.println("kliens várakozik üzenetre: "+client.serverMessage);
				client.receiveMessage();
				System.out.println("kliens üzenetet kapott a szervertől: "+client.serverMessage);
				String[] elements = client.serverMessage.split(";");
				client.serverRequest = elements[0];
				switch (client.serverRequest) {
				case "showLoginPage":													
					if(elements[1].equals("login")){									//LOGIN FAILED
						JOptionPane.showMessageDialog(null, "Már van ilyen felahsználó a rendszerben!", "Sikertelen bejelentkezés", 1);
					} else{																//LOGOUT
						if(elements[1].equals("RoomManagerPage")){
							System.out.println("logout success");
							roomManagerPage.getFrame().setVisible(false);
							roomManagerPage.getFrame().dispose();
						}else{
							if(elements[1].equals("RoomPage")){
								System.out.println("logout success");
								roomPage.getFrame().setVisible(false);
								roomPage.getFrame().dispose();
							}
						}
						System.exit(0);
						
					}
					break;
				case "showRoomManagerPage":												
					if(elements[1].equals("login")){									//LOGIN SUCCESS
						login.getFrame().setVisible(false);
						login.getFrame().dispose();
					} else{
						if(elements[1].equals("RoomManagerPage")){						//CREATE NEW ROOM FAILED  OR JOIN ROOM FAILED
							if(elements[2].equals("joinRoom")) {
								JOptionPane.showMessageDialog(null, "A szoba megtelt!", "Értesítés", 1);
								break;
							}
							JOptionPane.showMessageDialog(null, "A név foglalt!", "Értesítés", 1);
							break;
						} else{															//LEAVE ROOM
							if(elements[1].equals("RoomPage")){
								roomPage.getFrame().setVisible(false);
								roomPage.getFrame().dispose();
							}else{
								if(elements[1].equals("GameTablePage")){					
									gameTablePage.getFrame().setVisible(false);
									gameTablePage.getFrame().dispose();
									if(!elements[2].equals("forcedExit")){		//END OF A GAME
										finalScorePage.getFrame().setVisible(false);
										finalScorePage.getFrame().dispose();
									}
								}
							}
						}																
					}
					client.roomList = new ArrayList<>(); //szobalista init
					if(elements.length > 2){
						int startIndex = 2;
						if(elements[2].equals("forcedExit")){				//ha valaki kilépett és az akt kliens visszadobódik a roomManagerPage-re
							startIndex = 3;
						}
						for(int i=startIndex; i<elements.length; i++){
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
					if(elements[1].equals("RoomPage")) {
						roomPage.getFrame().setVisible(false);
						roomPage.getFrame().dispose();
					}
					client.sendMessage("amIActPlayer", client.getOs());
					gameTablePage = new GameTablePage(client);
					break;
					
				case "refreshRoomList":
					client.roomList.clear();
					if(elements.length > 1){
						for(int i = 1; i < elements.length; i++){
							client.roomList.add(elements[i]);
						}
					}
					roomManagerPage.roomListBeallito(client.roomList);
					roomManagerPage.revalidate();
					roomManagerPage.repaint();
					break;
					
				case "isActPlayer":						//AKT PLAYER E A KLIENS
					if(elements[1].equals("yes")){
						gameTablePage.setEnabledComponents(gameTablePage.getFrame(), true);
						gameTablePage.revalidate();
						gameTablePage.repaint();
					}else{
						gameTablePage.setEnabledComponents(gameTablePage.getFrame(), false);
						gameTablePage.revalidate();
						gameTablePage.repaint();
					}
					client.sendMessage("tableAttributesRefresh", client.getOs());		//TÁBLA ADATOK FRISSÍTÉSE
					break;
					
				case "yourMoneyCards":
					List<String> myMoneyCardsPictures = new LinkedList<>();
					String aktPic = "";
					if(elements.length > 1){
						for(int i=1; i<elements.length; i=i+2){
							aktPic = "/MoneyCards/"+elements[i]+"/"+elements[i+1]+"/image.jpg";
							myMoneyCardsPictures.add(aktPic);
						}
					}
					gameTablePage.playerMoneyCardBackgroundSetter(myMoneyCardsPictures);
					gameTablePage.revalidate();
					gameTablePage.repaint();
					break;
					
				case "moneyPickerViewCards":
					List<String> moneyPickerViewMoneyCardsPictures = new LinkedList<>();
					String aktPictures = "";
					if(elements.length > 1){
						for(int i=1; i<elements.length; i=i+2){
							aktPictures = "/MoneyCards/"+elements[i]+"/"+elements[i+1]+"/image.jpg";
							moneyPickerViewMoneyCardsPictures.add(aktPictures);
						}
						gameTablePage.moneyPickerCardBackgroundSetter(moneyPickerViewMoneyCardsPictures);
						gameTablePage.revalidate();
						gameTablePage.repaint();
					}
					break;
					
				case "buildingMarketCards":
					List<String> buildingMarketPictures = new LinkedList<>();
					if(elements.length > 1){
						for(int i=1; i<elements.length; i++){
							buildingMarketPictures.add(elements[i]+".jpg");
						}
					}
					gameTablePage.buildingMarketCardBackgroundSetter(buildingMarketPictures);
					gameTablePage.revalidate();
					gameTablePage.repaint();
					
					break;
					
				case "storageAreaCards":
					List<String> storageAreaPictures = new LinkedList<>();
					if(elements.length > 1){
						for(int i=1; i<elements.length; i++){
							storageAreaPictures.add(elements[i]+".jpg");
						}
					}
					gameTablePage.storageAreaCardBackgroundSetter(storageAreaPictures);
					gameTablePage.revalidate();
					gameTablePage.repaint();
					break;
					
				case "buildingAreaCards":
					String matrix[][] = new String[21][21];
					if(elements.length > 1){
						for(int i=1; i<elements.length-2; i = i+3){
							if(elements[i+2].equals("null")){
								matrix[Integer.parseInt(elements[i])][Integer.parseInt(elements[i+1])] = "null";
							}else{
								matrix[Integer.parseInt(elements[i])][Integer.parseInt(elements[i+1])] = elements[i+2]+".jpg";
							}
						}
						gameTablePage.buildingAreaCardBackgroundSetter(matrix);
						gameTablePage.revalidate();
						gameTablePage.repaint();
					}					
					
					break;
					
				case "pickMoneyCardsFailed":
					JOptionPane.showMessageDialog(null, "A húzott lapok értéke nem haladhatja meg az 5-öt!");
					gameTablePage.revalidate();
					gameTablePage.repaint();
					break;
					
				case "isEnoughMoney":
					if(elements[1].equals("no")){
						JOptionPane.showMessageDialog(null, "Túl kevés pénzt választottál ki!");
						gameTablePage.setBuy(false);
					}else{
						JOptionPane.showMessageDialog(null, "Válassz, hová szeretnéd elhelyezni. Kattints az alhambrádba, vagy a tartalékmező üres mezőjére!");
					}
					
					break;
					
				case "invalidBuyToAlhambra":
					JOptionPane.showMessageDialog(null, "Nem sikerült elhelyezni az épületet, az építési szabályok megsértése miatt!");
					client.sendMessage("tableAttributesRefresh", client.getOs());
					break;
					
				case "removeFailed":
					JOptionPane.showMessageDialog(null, "Nem sikerült eltávolítani az épületet, az építési szabályok megsértése miatt!");
					break;
					
				case "switchFailed":
					JOptionPane.showMessageDialog(null, "Nem sikerült megcserélni a két épületlapot, az építési szabályok megsértése miatt!");
					break;
				
				case "gifts":
					client.giftMessage = "";
					client.setGiftBuild(false);
					List<String> imageList = new LinkedList<String>();
					for(int i=1; i < elements.length; i++){
						imageList.add(elements[i]+".jpg");
					}
					if(giftCards == null){
						giftCards = new GiftCards(client);
						giftCards.setBackGrounds(imageList);
						giftCards.revalidate();
						giftCards.repaint();
					}else{
						giftCards.setBackGrounds(imageList);
						giftCards.setRadioButtonsToNull();
						giftCards.revalidate();
						giftCards.repaint();
					}
					
					break;
					
				case "giftClose":
					giftCards.getFrame().setVisible(false);
					giftCards.getFrame().dispose();
					
					break;
					
				case "evaluation":
					List<String> result = new LinkedList<>();
					String tmpString;
					client.numberOfEvaluation++;
					if(client.numberOfEvaluation < 3){
						for(int i=1; i<elements.length-1; i=i+2){
							tmpString = elements[i]+"              "+elements[i+1];
							result.add(tmpString);
						}
						scorePage = new ScorePage(client);
						scorePage.setPlayerListModell(result);
					}else{
						for(int i=1; i<elements.length-1; i=i+2){
							tmpString = elements[i]+"              "+elements[i+1];
							result.add(tmpString);
						}
						finalScorePage = new FinalScorePage(client);
						finalScorePage.setPlayerListModell(result);
					}
					
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

	public GameTablePage getGameTablePage() {
		return gameTablePage;
	}

	public void setGameTablePage(GameTablePage gameTablePage) {
		this.gameTablePage = gameTablePage;
	}

	public boolean isGiftBuild() {
		return isGiftBuild;
	}

	public void setGiftBuild(boolean isGiftBuild) {
		this.isGiftBuild = isGiftBuild;
	}

	public String getGiftMessage() {
		return giftMessage;
	}

	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}
	
	
	
}
