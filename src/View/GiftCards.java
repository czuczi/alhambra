package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import ClientPackage.Client;


public class GiftCards extends JFrame {

	private Client client;
	private JFrame frame;
	private JRadioButton radioButtonMarket_1;
	private JRadioButton radioButtonMarket_2;
	private JRadioButton radioButtonMarket_3;
	private JRadioButton radioButtonMarket_4;
	private ButtonGroup bg = new ButtonGroup();;
	private List<JLabel> jLabelList = new LinkedList<JLabel>();

	/**
	 * Launch the application.
	 */
	public void init() {
		frame = new JFrame("Ajándék kártyák");
	    frame.setBounds(200, 20, 600, 400);
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setContentPane(new JLabel(new ImageIcon((URL)this.getClass().getResource("/otherImages/background.jpg"))));
		frame.getContentPane().setLayout(null);
		
		JLabel marketLabel = new JLabel();
		marketLabel.setBounds(120, 100, 360, 135);
	    frame.getContentPane().add(marketLabel);
	    marketLabel.setOpaque(true);
	    marketLabel.setIcon(new ImageIcon((URL)this.getClass().getResource("/otherImages/market.jpg")));
	    marketLabel.setLayout(null);
		
		JLabel jLabel1 = new JLabel("New label");
		jLabel1.setBounds(30, 26, 75, 75);
		marketLabel.add(jLabel1);
		jLabel1.setOpaque(true);
		jLabel1.setIcon(new ImageIcon((URL)this.getClass().getResource("/buildingCards/back.jpg")));
		
		JLabel jLabel2 = new JLabel("New label");
		jLabel2.setBounds(107, 26, 75, 75);
		marketLabel.add(jLabel2);
		jLabel2.setOpaque(true);
		jLabel2.setIcon(new ImageIcon((URL)this.getClass().getResource("/buildingCards/back.jpg")));
		
		JLabel jLabel3 = new JLabel("New label");
		jLabel3.setBounds(184, 26, 75, 75);
		marketLabel.add(jLabel3);
		jLabel3.setOpaque(true);
		jLabel3.setIcon(new ImageIcon((URL)this.getClass().getResource("/buildingCards/back.jpg")));
		
		JLabel jLabel4 = new JLabel("New label");
		jLabel4.setBounds(261, 26, 75, 75);
		marketLabel.add(jLabel4);
		jLabel4.setOpaque(true);
		jLabel4.setIcon(new ImageIcon((URL)this.getClass().getResource("/buildingCards/back.jpg")));
		
		jLabelList.add(jLabel1);
		jLabelList.add(jLabel2);
		jLabelList.add(jLabel3);
		jLabelList.add(jLabel4);
		
		
		radioButtonMarket_1 = new JRadioButton();
	    radioButtonMarket_1.setBounds(55, 106, 21, 16);
	    radioButtonMarket_1.setContentAreaFilled(false);
	    radioButtonMarket_1.setOpaque(false);
	    marketLabel.add(radioButtonMarket_1);
	    
	    radioButtonMarket_2 = new JRadioButton();
	    radioButtonMarket_2.setContentAreaFilled(false);
	    radioButtonMarket_2.setOpaque(false);
	    radioButtonMarket_2.setBounds(136, 106, 21, 16);
	    marketLabel.add(radioButtonMarket_2);

	    radioButtonMarket_3 = new JRadioButton();
	    radioButtonMarket_3.setContentAreaFilled(false);
	    radioButtonMarket_3.setOpaque(false);
	    radioButtonMarket_3.setBounds(211, 106, 21, 16);
	    marketLabel.add(radioButtonMarket_3);
	    
	    radioButtonMarket_4 = new JRadioButton();
	    radioButtonMarket_4.setContentAreaFilled(false);
	    radioButtonMarket_4.setOpaque(false);
	    radioButtonMarket_4.setBounds(292, 106, 21, 16);
	    marketLabel.add(radioButtonMarket_4);

	    bg.add(radioButtonMarket_1);
	    bg.add(radioButtonMarket_2);
	    bg.add(radioButtonMarket_3);
	    bg.add(radioButtonMarket_4);
	    
	    JButton btnBuyBuildingCard = new JButton();
	    btnBuyBuildingCard.setIcon(new ImageIcon((URL)this.getClass().getResource("/otherImages/buyButton.png")));
	    btnBuyBuildingCard.setOpaque(false);
	    btnBuyBuildingCard.setBounds(256, 245, 89, 89);
	    btnBuyBuildingCard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String message = "buildGift";
				if(!(radioButtonMarket_1.isSelected() || radioButtonMarket_2.isSelected() || radioButtonMarket_3.isSelected() || radioButtonMarket_4.isSelected())){
					JOptionPane.showMessageDialog(null, "Válassz egy épületlapot!");
				}else{
					if(radioButtonMarket_1.isSelected()){
						message += ";0";
					}
					if(radioButtonMarket_2.isSelected()){
						message += ";1";
					}
					if(radioButtonMarket_3.isSelected()){
						message += ";2";
					}
					if(radioButtonMarket_4.isSelected()){
						message += ";3";
					}
				}
				client.setGiftBuild(true);
				client.setGiftMessage(message);
				JOptionPane.showMessageDialog(null, "Válassz, hová szeretnéd elhelyezni. Kattints az alhambrádba, vagy a tartalékmező üres mezőjére!");
			}
		});
	    frame.getContentPane().add(btnBuyBuildingCard);
	    
	    JOptionPane.showMessageDialog(null, "Válassz egy lapot és építsd be az alhambrába, vagy tedd a tartalék mezőre");
	}

	/**
	 * Create the frame.
	 */
	public GiftCards(Client aktClient) {
		this.client = aktClient;
		init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void setBackGrounds(List<String> imageList){
		for(int i=0; i < 4; i++){
			jLabelList.get(i).setIcon(new ImageIcon((URL)this.getClass().getResource("/buildingCards/back.jpg")));
		}
		
		for(int i=0; i < imageList.size(); i++){
			jLabelList.get(i).setIcon(new ImageIcon((URL)this.getClass().getResource(imageList.get(i))));
		}
	}
	
	
	
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void setRadioButtonsToNull(){
			bg.clearSelection();
	}
	
	
}
