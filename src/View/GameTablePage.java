package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ClientPackage.Client;

public class GameTablePage extends JFrame{

	private JFrame frame;
	private Client client;
	private JRadioButton pickMoneyCard_1;
	private JRadioButton pickMoneyCard_2;
	private JRadioButton pickMoneyCard_3;
	private JRadioButton pickMoneyCard_4;
	ButtonGroup bg;
	
	private JRadioButton radioButtonMarket_1;
	private JRadioButton radioButtonMarket_2;
	private JRadioButton radioButtonMarket_3;
	private JRadioButton radioButtonMarket_4;
	
	private JLabel storageBuildingCard_2;
	private JLabel storageBuildingCard_3;
	private JLabel storageBuildingCard_4;
	private JLabel storageBuildingCard_5;
	private JLabel storageBuildingCard_6;
	private JLabel storageBuildingCard_7;
	private JLabel storageBuildingCard_8;
	private JLabel storageBuildingCard_9;
	
	private  JLabel [][] table;
	
	
	private List<JLabel> moneyCardJlabelList = new LinkedList<>();
	private List<JRadioButton> moneyCardJRadioButtonList = new LinkedList<>();
	private List<JLabel> moneyPickerJlabelList = new LinkedList<>();
	private List<JLabel> buildingMarketJlabelList = new LinkedList<>();
	private List<JRadioButton> buildingMarketJRadioButtonList = new LinkedList<>();
	private List<JRadioButton> playerMoneyCardsJRadioButtonList = new LinkedList<>();
	private List<JLabel> storageAreaCardsJlabelList = new LinkedList<>();
	
	private boolean buy;
	private boolean alhambraFirst;
	private boolean storageFirst;
	private int selectedStorage;
	
	private int matrixX, matrixY;

	private int tmp;
	
	public GameTablePage(Client aktClient) {
		
		client = aktClient;
		initialize();
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
	
	public void setEnabledComponents(Object object, boolean state) {
		if (object instanceof Container) {
	        Container c = (Container)object;
	        Component[] components = c.getComponents();
	        for (Component component : components) {
	        	setEnabledComponents(component, state);
	            component.setEnabled(state);
	        }
	    }
	    else {
	        if (object instanceof Component) {
	            Component component = (Component)object;
	            component.setEnabled(state);
	        }
	    }
	}

	private void initialize() {
		
	    frame = new JFrame("Alhambra Játék Felület");
	    frame.setBounds(200, 20, 1000, 600);
	    frame.setResizable(false);
	    frame.setContentPane(new JLabel(new ImageIcon("./resource/otherImages/background.jpg")));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
	    JLabel labelMoneyCards = new JLabel();
	   
	    JScrollPane spMoneyCards = new JScrollPane(labelMoneyCards,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    labelMoneyCards.setPreferredSize(new Dimension(880,(int)(labelMoneyCards.getPreferredSize().getHeight())));
	    labelMoneyCards.setIcon(new ImageIcon("./resource/otherImages/playerMoney.jpg"));
	    labelMoneyCards.setOpaque(true);
	    spMoneyCards.setBounds(476, 400, 383, 151);
	    frame.getContentPane().add(spMoneyCards);
	    labelMoneyCards.setLayout(null);
	   
	    
	    JLabel moneyCard_1 = new JLabel();
	    moneyCard_1.setBounds(15, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_1);
	    moneyCard_1.setOpaque(true);
	    moneyCard_1.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCardJlabelList.add(moneyCard_1);
	    
	    JLabel moneyCard_2 = new JLabel();
	    moneyCard_2.setOpaque(true);
	    moneyCard_2.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_2.setBounds(77, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_2);
	    moneyCardJlabelList.add(moneyCard_2);
	    
	    JLabel moneyCard_3 = new JLabel();
	    moneyCard_3.setOpaque(true);
	    moneyCard_3.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_3.setBounds(139, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_3);
	    moneyCardJlabelList.add(moneyCard_3);
	    
	    JLabel moneyCard_4 = new JLabel();
	    moneyCard_4.setOpaque(true);
	    moneyCard_4.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_4.setBounds(201, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_4);
	    moneyCardJlabelList.add(moneyCard_4);
	    
	    JLabel moneyCard_5 = new JLabel();
	    moneyCard_5.setOpaque(true);
	    moneyCard_5.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_5.setBounds(263, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_5);
	    moneyCardJlabelList.add(moneyCard_5);
	    
	    JLabel moneyCard_6 = new JLabel();
	    moneyCard_6.setOpaque(true);
	    moneyCard_6.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_6.setBounds(325, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_6);
	    moneyCardJlabelList.add(moneyCard_6);
	    
	    JLabel moneyCard_7 = new JLabel();
	    moneyCard_7.setOpaque(true);
	    moneyCard_7.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_7.setBounds(387, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_7);
	    moneyCardJlabelList.add(moneyCard_7);
	    
	    JLabel moneyCard_8 = new JLabel();
	    moneyCard_8.setOpaque(true);
	    moneyCard_8.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_8.setBounds(449, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_8);
	    moneyCardJlabelList.add(moneyCard_8);
	    
	    JLabel moneyCard_9 = new JLabel();
	    moneyCard_9.setOpaque(true);
	    moneyCard_9.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_9.setBounds(513, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_9);
	    moneyCardJlabelList.add(moneyCard_9);
	    
	    JLabel moneyCard_10 = new JLabel();
	    moneyCard_10.setOpaque(true);
	    moneyCard_10.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_10.setBounds(575, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_10);
	    moneyCardJlabelList.add(moneyCard_10);
	    
	    JLabel moneyCard_11 = new JLabel();
	    moneyCard_11.setOpaque(true);
	    moneyCard_11.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_11.setBounds(637, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_11);
	    moneyCardJlabelList.add(moneyCard_11);

	    JLabel moneyCard_12 = new JLabel();
	    moneyCard_12.setOpaque(true);
	    moneyCard_12.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_12.setBounds(699, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_12);
	    moneyCardJlabelList.add(moneyCard_12);
	    
	    JLabel moneyCard_13 = new JLabel();
	    moneyCard_13.setOpaque(true);
	    moneyCard_13.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_13.setBounds(761, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_13);
	    moneyCardJlabelList.add(moneyCard_13);

	    JLabel moneyCard_14 = new JLabel();
	    moneyCard_14.setOpaque(true);
	    moneyCard_14.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyCard_14.setBounds(823, 19, 52, 88);
	    labelMoneyCards.add(moneyCard_14);
	    moneyCardJlabelList.add(moneyCard_14);
	    
	    JRadioButton radioButtonPlayerMoney_1 = new JRadioButton();
	    radioButtonPlayerMoney_1.setContentAreaFilled(false);
	    radioButtonPlayerMoney_1.setOpaque(false);
	    radioButtonPlayerMoney_1.setBounds(31, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_1);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_1);
	    
	    JRadioButton radioButtonPlayerMoney_2 = new JRadioButton();
	    radioButtonPlayerMoney_2.setContentAreaFilled(false);
	    radioButtonPlayerMoney_2.setOpaque(false);
	    radioButtonPlayerMoney_2.setBounds(93, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_2);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_2);
	    
	    JRadioButton radioButtonPlayerMoney_3 = new JRadioButton();
	    radioButtonPlayerMoney_3.setContentAreaFilled(false);
	    radioButtonPlayerMoney_3.setOpaque(false);
	    radioButtonPlayerMoney_3.setBounds(155, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_3);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_3);
	    
	    JRadioButton radioButtonPlayerMoney_4 = new JRadioButton();
	    radioButtonPlayerMoney_4.setContentAreaFilled(false);
	    radioButtonPlayerMoney_4.setOpaque(false);
	    radioButtonPlayerMoney_4.setBounds(217, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_4);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_4);
	    
	    JRadioButton radioButtonPlayerMoney_5 = new JRadioButton();
	    radioButtonPlayerMoney_5.setContentAreaFilled(false);
	    radioButtonPlayerMoney_5.setOpaque(false);
	    radioButtonPlayerMoney_5.setBounds(279, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_5);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_5);
	    
	    JRadioButton radioButtonPlayerMoney_6 = new JRadioButton();
	    radioButtonPlayerMoney_6.setContentAreaFilled(false);
	    radioButtonPlayerMoney_6.setOpaque(false);
	    radioButtonPlayerMoney_6.setBounds(341, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_6);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_6);
	    
	    JRadioButton radioButtonPlayerMoney_7 = new JRadioButton();
	    radioButtonPlayerMoney_7.setContentAreaFilled(false);
	    radioButtonPlayerMoney_7.setOpaque(false);
	    radioButtonPlayerMoney_7.setBounds(405, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_7);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_7);
	    
	    JRadioButton radioButtonPlayerMoney_8 = new JRadioButton();
	    radioButtonPlayerMoney_8.setContentAreaFilled(false);
	    radioButtonPlayerMoney_8.setOpaque(false);
	    radioButtonPlayerMoney_8.setBounds(467, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_8);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_8);
	    
	    JRadioButton radioButtonPlayerMoney_9 = new JRadioButton();
	    radioButtonPlayerMoney_9.setContentAreaFilled(false);
	    radioButtonPlayerMoney_9.setOpaque(false);
	    radioButtonPlayerMoney_9.setBounds(529, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_9);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_9);
	    
	    JRadioButton radioButtonPlayerMoney_10 = new JRadioButton();
	    radioButtonPlayerMoney_10.setContentAreaFilled(false);
	    radioButtonPlayerMoney_10.setOpaque(false);
	    radioButtonPlayerMoney_10.setBounds(591, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_10);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_10);
	    
	    JRadioButton radioButtonPlayerMoney_11 = new JRadioButton();
	    radioButtonPlayerMoney_11.setContentAreaFilled(false);
	    radioButtonPlayerMoney_11.setOpaque(false);
	    radioButtonPlayerMoney_11.setBounds(653, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_11);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_11);
	    
	    JRadioButton radioButtonPlayerMoney_12 = new JRadioButton();
	    radioButtonPlayerMoney_12.setContentAreaFilled(false);
	    radioButtonPlayerMoney_12.setOpaque(false);
	    radioButtonPlayerMoney_12.setBounds(715, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_12);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_12);
	    
	    JRadioButton radioButtonPlayerMoney_13 = new JRadioButton();
	    radioButtonPlayerMoney_13.setContentAreaFilled(false);
	    radioButtonPlayerMoney_13.setOpaque(false);
	    radioButtonPlayerMoney_13.setBounds(777, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_13);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_13);
	    
	    JRadioButton radioButtonPlayerMoney_14 = new JRadioButton();
	    radioButtonPlayerMoney_14.setContentAreaFilled(false);
	    radioButtonPlayerMoney_14.setOpaque(false);
	    radioButtonPlayerMoney_14.setBounds(839, 111, 21, 16);
	    labelMoneyCards.add(radioButtonPlayerMoney_14);
	    playerMoneyCardsJRadioButtonList.add(radioButtonPlayerMoney_14);
	    
	    JLabel labelMoneyPicker = new JLabel();
	    labelMoneyPicker.setBounds(469, 11, 390, 150);
	    labelMoneyPicker.setIcon(new ImageIcon("./resource/otherImages/moneyPicker.jpg"));
	    labelMoneyPicker.setOpaque(true);
	    frame.getContentPane().add(labelMoneyPicker);
	    labelMoneyPicker.setLayout(null);
	    
	    JLabel moneyPickerCard_1 = new JLabel();
	    moneyPickerCard_1.setOpaque(true);
	    moneyPickerCard_1.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyPickerCard_1.setBounds(35, 27, 52, 88);
	    labelMoneyPicker.add(moneyPickerCard_1);
	    moneyPickerJlabelList.add(moneyPickerCard_1);
	    
	    
	    JLabel moneyPickerCard_2 = new JLabel();
	    moneyPickerCard_2.setOpaque(true);
	    moneyPickerCard_2.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyPickerCard_2.setBounds(93, 27, 52, 88);
	    labelMoneyPicker.add(moneyPickerCard_2);
	    moneyPickerJlabelList.add(moneyPickerCard_2);
	    
	    JLabel moneyPickerCard_3 = new JLabel();
	    moneyPickerCard_3.setOpaque(true);
	    moneyPickerCard_3.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyPickerCard_3.setBounds(151, 27, 52, 88);
	    labelMoneyPicker.add(moneyPickerCard_3);
	    moneyPickerJlabelList.add(moneyPickerCard_3);
	    
	    JLabel moneyPickerCard_4 = new JLabel();
	    moneyPickerCard_4.setOpaque(true);
	    moneyPickerCard_4.setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
	    moneyPickerCard_4.setBounds(209, 27, 52, 88);
	    labelMoneyPicker.add(moneyPickerCard_4);
	    moneyPickerJlabelList.add(moneyPickerCard_4);
	    
	    pickMoneyCard_1 = new JRadioButton();
	    pickMoneyCard_1.setBounds(51, 117, 21, 23);
		pickMoneyCard_1.setContentAreaFilled(false);
	    pickMoneyCard_1.setOpaque(false);
	    labelMoneyPicker.add(pickMoneyCard_1);
	    moneyCardJRadioButtonList.add(pickMoneyCard_1);
	    
	    pickMoneyCard_2 = new JRadioButton();
	    pickMoneyCard_2.setBounds(111, 117, 21, 23);
	    pickMoneyCard_2.setContentAreaFilled(false);
	    pickMoneyCard_2.setOpaque(false);
	    labelMoneyPicker.add(pickMoneyCard_2);
	    moneyCardJRadioButtonList.add(pickMoneyCard_2);
	    
	    pickMoneyCard_3 = new JRadioButton();
	    pickMoneyCard_3.setBounds(169, 117, 21, 23);
	    pickMoneyCard_3.setContentAreaFilled(false);
	    pickMoneyCard_3.setOpaque(false);
	    labelMoneyPicker.add(pickMoneyCard_3);
	    moneyCardJRadioButtonList.add(pickMoneyCard_3);
	    
	    pickMoneyCard_4 = new JRadioButton();
	    pickMoneyCard_4.setBounds(227, 117, 21, 23);
	    pickMoneyCard_4.setContentAreaFilled(false);
	    pickMoneyCard_4.setOpaque(false);
	    labelMoneyPicker.add(pickMoneyCard_4);
	    moneyCardJRadioButtonList.add(pickMoneyCard_4);
	    
	    JButton pickButton = new JButton();
	    pickButton.setIcon(new ImageIcon("./resource/otherImages/pickButton.png"));
	  //  pickButton.setBorderPainted(false);
	    pickButton.setOpaque(true);
	    pickButton.setBounds(270, 27, 89, 89);
	    pickButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedMoneyCards = "";
				if(pickMoneyCard_1.isSelected()){
					selectedMoneyCards += ";0";
				}
				if(pickMoneyCard_2.isSelected()){
					selectedMoneyCards += ";1";
				}
				if(pickMoneyCard_3.isSelected()){
					selectedMoneyCards += ";2";
				}
				if(pickMoneyCard_4.isSelected()){
					selectedMoneyCards += ";3";
				}
				client.sendMessage("pickMoneyCards"+selectedMoneyCards, client.getOs());
			}
		});
	    labelMoneyPicker.add(pickButton);
	    
	    JLabel labelStorageArea = new JLabel();
	    
	    JScrollPane spStorageArea = new JScrollPane(labelStorageArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    labelStorageArea.setPreferredSize(new Dimension( (int)(labelStorageArea.getPreferredSize().getWidth()), 785));
	    labelStorageArea.setIcon(new ImageIcon("./resource/otherImages/storageBack.jpg"));
	    labelStorageArea.setOpaque(true);
	    spStorageArea.setBounds(869, 11, 115, 525);
	    frame.getContentPane().add(spStorageArea);
	    labelStorageArea.setLayout(null);
	    
	    JLabel storageBuildingCard_1 = new JLabel();
	    storageBuildingCard_1.setOpaque(true);
	    storageBuildingCard_1.setIcon(new ImageIcon("./resource/otherImages/storageTop.jpg"));
	    storageBuildingCard_1.setBounds(0, 0, 97, 97);
	    storageBuildingCard_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(client.isGiftBuild()){						
					String[] tomb = client.getGiftMessage().split(";");				//ajándék építése a tartalékmezőre
					String message = tomb[0] +";" + "buildToStorageArea;" + tomb[1];
					client.sendMessage(message, client.getOs());
				}else{
					if(buy){
						client.sendMessage("buyToStorageArea", client.getOs());
						buy = false;
					}else{
						if(alhambraFirst){
							System.out.println("remove");
							client.sendMessage("removeToStorage;"+matrixX+";"+matrixY, client.getOs());
							alhambraFirst = false;
							storageFirst = false;
						}else{
							;
						}
					}
				}
				
			}
		});
	    labelStorageArea.add(storageBuildingCard_1);
	    
	    storageBuildingCard_2 = new JLabel();
	    storageBuildingCard_2.setOpaque(true);
	    storageBuildingCard_2.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_2.setBounds(12, 103, 75, 75);
	    labelStorageArea.add(storageBuildingCard_2);
	    storageAreaCardsJlabelList.add(storageBuildingCard_2);
	    
	    storageBuildingCard_3 = new JLabel();
	    storageBuildingCard_3.setOpaque(true);
	    storageBuildingCard_3.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_3.setBounds(12, 189, 75, 75);
	    labelStorageArea.add(storageBuildingCard_3);
	    storageAreaCardsJlabelList.add(storageBuildingCard_3);
	    
	    storageBuildingCard_4 = new JLabel();
	    storageBuildingCard_4.setOpaque(true);
	    storageBuildingCard_4.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_4.setBounds(12, 275, 75, 75);
	    labelStorageArea.add(storageBuildingCard_4);
	    storageAreaCardsJlabelList.add(storageBuildingCard_4);
	    
	    storageBuildingCard_5 = new JLabel();
	    storageBuildingCard_5.setOpaque(true);
	    storageBuildingCard_5.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_5.setBounds(12, 361, 75, 75);
	    labelStorageArea.add(storageBuildingCard_5);
	    storageAreaCardsJlabelList.add(storageBuildingCard_5);
	    
	    storageBuildingCard_6 = new JLabel();
	    storageBuildingCard_6.setOpaque(true);
	    storageBuildingCard_6.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_6.setBounds(12, 447, 75, 75);
	    labelStorageArea.add(storageBuildingCard_6);
	    storageAreaCardsJlabelList.add(storageBuildingCard_6);
	    
	    storageBuildingCard_7 = new JLabel();
	    storageBuildingCard_7.setOpaque(true);
	    storageBuildingCard_7.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_7.setBounds(12, 533, 75, 75);
	    labelStorageArea.add(storageBuildingCard_7);
	    storageAreaCardsJlabelList.add(storageBuildingCard_7);
	    
	    storageBuildingCard_8 = new JLabel();
	    storageBuildingCard_8.setOpaque(true);
	    storageBuildingCard_8.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_8.setBounds(12, 619, 75, 75);
	    labelStorageArea.add(storageBuildingCard_8);
	    storageAreaCardsJlabelList.add(storageBuildingCard_8);
	    
	    storageBuildingCard_9 = new JLabel();
	    storageBuildingCard_9.setOpaque(true);
	    storageBuildingCard_9.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    storageBuildingCard_9.setBounds(12, 705, 75, 75);
	    labelStorageArea.add(storageBuildingCard_9);
	    storageAreaCardsJlabelList.add(storageBuildingCard_9);
	    
	    bg = new ButtonGroup();
	    
	    JPanel panelBuildingArea = new JPanel();
	  
	    JScrollPane spBuildingArea = new JScrollPane(panelBuildingArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	    
	    panelBuildingArea.setPreferredSize(new Dimension( 1615, 1615));
	    panelBuildingArea.setBackground(Color.WHITE);
	    panelBuildingArea.setOpaque(true);
	    spBuildingArea.setBounds(0, 0, 444, 408);
	    frame.getContentPane().add(spBuildingArea);
	    panelBuildingArea.setLayout(null);
	    
	    table = new JLabel[21][21];
	    
	    for(int i = 0; i < 21; i++)
	    {
	    	for(int j = 0; j < 21; j++)
	    	{
	    		matrixX = i;
	    		matrixY = j;
	    		table[i][j] = new JLabel();
	    		if(i==10 && j==10)
	    			table[i][j].setIcon(new ImageIcon("./resource/buildingCards/start.jpg"));
	    		else
	    			table[i][j].setBackground(new Color(199,153,116));
	    		table[i][j].setOpaque(true);
	    		table[i][j].setBounds(i*77, j*77, 75, 75);
	    		table[i][j].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						JLabel label = (JLabel)e.getSource();
						if(label.isEnabled()) {
							for(int i = 0; i < 21; i++)
						    {
						    	for(int j = 0; j < 21; j++)
						    	{
						    		if(table[i][j].equals(label)) {
						    			if(buy){
						    				client.sendMessage("buyToAlhambra;"+j+";"+i, client.getOs());
						    				buy = false;
						    			}else{
						    				if(label.getIcon() == null){
						    					if(storageFirst){
						    						System.out.println("rebuildAddToAlhambra");
						    						client.sendMessage("rebuildAddToAlhambra;"+j+";"+i+";"+selectedStorage, client.getOs());
						    						storageFirst = false;
						    					}else{
						    						;
						    					}
						    				}else{
						    					if(storageFirst){
						    						System.out.println("switchBuilding");
						    						client.sendMessage("switchBuilding;"+j+";"+i+";"+selectedStorage, client.getOs());
						    						storageFirst = false;
						    						alhambraFirst = false;
						    					}else {
						    						System.out.println("alhambra first");
													alhambraFirst = true;
													matrixX = j;
													matrixY = i;
												}
						    				}
						    			}
						    		}
						    	}
						    }
						}
					}
				});
	    		panelBuildingArea.add(table[i][j]);
	    	}
	    }
	    
	    spBuildingArea.getVerticalScrollBar().setMaximum(1212);
	    
	    int max_vertical = spBuildingArea.getVerticalScrollBar().getMaximum();
	    int min_vertical = spBuildingArea.getVerticalScrollBar().getMinimum();

	    int middle_vertical = (int)(max_vertical + min_vertical)/2;
	    spBuildingArea.getVerticalScrollBar().setValue(middle_vertical);
	    
	    spBuildingArea.getHorizontalScrollBar().setMaximum(1180);
	    
	    int max_horizontal = spBuildingArea.getHorizontalScrollBar().getMaximum();
	    int min_horizontal = spBuildingArea.getHorizontalScrollBar().getMinimum();

	    int middle_horizontal = (int)(max_horizontal + min_horizontal)/2;
	    spBuildingArea.getHorizontalScrollBar().setValue(middle_horizontal);
	    
	    JLabel helpLabel = new JLabel();
	    helpLabel.setBounds(492, 186, 367, 150);
	    frame.getContentPane().add(helpLabel);
	    helpLabel.setIcon(new ImageIcon("./resource/evaluationCards/evaluationTable.png"));
	    
	        
	    JLabel labelBuildingMarket = new JLabel();
	    labelBuildingMarket.setBounds(10, 420, 360, 135);
	    frame.getContentPane().add(labelBuildingMarket);
	    labelBuildingMarket.setOpaque(true);
	    labelBuildingMarket.setIcon(new ImageIcon("./resource/otherImages/market.jpg"));
	    labelBuildingMarket.setLayout(null);
	    
	    JLabel marketBuildingCard_1 = new JLabel();
	    marketBuildingCard_1.setBounds(30, 26, 75, 75);
	    labelBuildingMarket.add(marketBuildingCard_1);
	    marketBuildingCard_1.setOpaque(true);
	    marketBuildingCard_1.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    buildingMarketJlabelList.add(marketBuildingCard_1);

	    
	    JLabel marketBuildingCard_2 = new JLabel();
	    marketBuildingCard_2.setBounds(107, 26, 75, 75);
	    labelBuildingMarket.add(marketBuildingCard_2);
	    marketBuildingCard_2.setOpaque(true);
	    marketBuildingCard_2.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    buildingMarketJlabelList.add(marketBuildingCard_2);
	    
	    JLabel marketBuildingCard_3 = new JLabel();
	    marketBuildingCard_3.setOpaque(true);
	    marketBuildingCard_3.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    marketBuildingCard_3.setBounds(184, 26, 75, 75);
	    labelBuildingMarket.add(marketBuildingCard_3);
	    buildingMarketJlabelList.add(marketBuildingCard_3);
	    
	    JLabel marketBuildingCard_4 = new JLabel();
	    marketBuildingCard_4.setOpaque(true);
	    marketBuildingCard_4.setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
	    marketBuildingCard_4.setBounds(261, 26, 75, 75);
	    labelBuildingMarket.add(marketBuildingCard_4);
	    buildingMarketJlabelList.add(marketBuildingCard_4);
    
	    radioButtonMarket_1 = new JRadioButton();
	    radioButtonMarket_1.setBounds(55, 106, 21, 16);
	    radioButtonMarket_1.setContentAreaFilled(false);
	    radioButtonMarket_1.setOpaque(false);
	    labelBuildingMarket.add(radioButtonMarket_1);
	    buildingMarketJRadioButtonList.add(radioButtonMarket_1);
	    
	    radioButtonMarket_2 = new JRadioButton();
	    radioButtonMarket_2.setContentAreaFilled(false);
	    radioButtonMarket_2.setOpaque(false);
	    radioButtonMarket_2.setBounds(136, 106, 21, 16);
	    labelBuildingMarket.add(radioButtonMarket_2);
	    buildingMarketJRadioButtonList.add(radioButtonMarket_2);
	    
	    radioButtonMarket_3 = new JRadioButton();
	    radioButtonMarket_3.setContentAreaFilled(false);
	    radioButtonMarket_3.setOpaque(false);
	    radioButtonMarket_3.setBounds(211, 106, 21, 16);
	    labelBuildingMarket.add(radioButtonMarket_3);
	    buildingMarketJRadioButtonList.add(radioButtonMarket_3);
	    
	    radioButtonMarket_4 = new JRadioButton();
	    radioButtonMarket_4.setContentAreaFilled(false);
	    radioButtonMarket_4.setOpaque(false);
	    radioButtonMarket_4.setBounds(292, 106, 21, 16);
	    labelBuildingMarket.add(radioButtonMarket_4);
	    buildingMarketJRadioButtonList.add(radioButtonMarket_4);
	    bg.add(radioButtonMarket_1);
	    bg.add(radioButtonMarket_2);
	    bg.add(radioButtonMarket_3);
	    bg.add(radioButtonMarket_4);
	    
	    JButton btnBuyBuildingCard = new JButton();
	    btnBuyBuildingCard.setIcon(new ImageIcon("./resource/otherImages/buyButton.png"));
	   // btnBuyBuildingCard.setBorderPainted(false);
	    btnBuyBuildingCard.setOpaque(false);
	    btnBuyBuildingCard.setBounds(377, 440, 89, 89);
	    btnBuyBuildingCard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String message = "";
				if(!(radioButtonMarket_1.isSelected() || radioButtonMarket_2.isSelected() || radioButtonMarket_3.isSelected() || radioButtonMarket_4.isSelected())){
					JOptionPane.showMessageDialog(null, "Válassz egy épületlapot az építőudvarról(balra)!");
				}else{
					if(radioButtonMarket_1.isSelected()){
						message += ";Blue";
					}
					if(radioButtonMarket_2.isSelected()){
						message += ";Green";
					}
					if(radioButtonMarket_3.isSelected()){
						message += ";Orange";
					}
					if(radioButtonMarket_4.isSelected()){
						message += ";Yellow";
					}
						
					for(int i=0; i<playerMoneyCardsJRadioButtonList.size(); i++){
						if(playerMoneyCardsJRadioButtonList.get(i).isSelected()){
							message += ";"+i;
						}
					}
					client.sendMessage("buyBuildingCard"+message, client.getOs());
					buy = true;
				}
			}
		});
	    frame.getContentPane().add(btnBuyBuildingCard);
	    
	    JLabel labelCurrency_1 = new JLabel();
	    labelCurrency_1.setIcon(new ImageIcon("./resource/otherImages/blueMarket.png"));
	    labelCurrency_1.setOpaque(false);
	    labelCurrency_1.setBounds(56, 0, 23, 23);
	    labelBuildingMarket.add(labelCurrency_1);
	    
	    JLabel labelCurrency_2 = new JLabel();
	    labelCurrency_2.setIcon(new ImageIcon("./resource/otherImages/greenMarket.png"));
	    labelCurrency_2.setOpaque(false);
	    labelCurrency_2.setBounds(132, 0, 23, 23);
	    labelBuildingMarket.add(labelCurrency_2);
	    
	    JLabel labelCurrency_3 = new JLabel();
	    labelCurrency_3.setIcon(new ImageIcon("./resource/otherImages/orangeMarket.png"));
	    labelCurrency_3.setOpaque(false);
	    labelCurrency_3.setBounds(208, 0, 23, 23);
	    labelBuildingMarket.add(labelCurrency_3);
	    
	    JLabel labelCurrency_4 = new JLabel();
	    labelCurrency_4.setIcon(new ImageIcon("./resource/otherImages/yellowMarket.png"));
	    labelCurrency_4.setOpaque(false);
	    labelCurrency_4.setBounds(285, 0, 23, 23);
	    labelBuildingMarket.add(labelCurrency_4);
	      	    
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public void playerMoneyCardBackgroundSetter(List<String> backgrounds){
		for(int i=0; i<backgrounds.size(); i++){
			moneyCardJlabelList.get(i).setIcon(new ImageIcon(backgrounds.get(i)));
			playerMoneyCardsJRadioButtonList.get(i).setSelected(false);
		}
		for(int i=backgrounds.size(); i<moneyCardJlabelList.size(); i++){
			moneyCardJlabelList.get(i).setIcon(new ImageIcon("./resource/moneyCards/backCard.jpg"));
			playerMoneyCardsJRadioButtonList.get(i).setSelected(false);
			playerMoneyCardsJRadioButtonList.get(i).setEnabled(false);
		}
	}
	
	public void moneyPickerCardBackgroundSetter(List<String> backgrounds){
		for(int i=0; i<backgrounds.size(); i++){
			moneyPickerJlabelList.get(i).setIcon(new ImageIcon(backgrounds.get(i)));
			moneyCardJRadioButtonList.get(i).setSelected(false);
		}
	}
	
	public void buildingMarketCardBackgroundSetter(List<String> backgrounds){
		bg.clearSelection();
		for(int i=0; i<backgrounds.size(); i++){
			tmp = i;
			buildingMarketJlabelList.get(i).setIcon(new ImageIcon(backgrounds.get(i)));
			
			if(backgrounds.get(i).equals("./resource/buildingCards/back.jpg")) {
				buildingMarketJRadioButtonList.get(i).setEnabled(false);
			}
		}
	}
	
	public void storageAreaCardBackgroundSetter(List<String> backgrounds){
		for(int i=0; i<backgrounds.size(); i++){
			storageAreaCardsJlabelList.get(i).setIcon(new ImageIcon(backgrounds.get(i)));
			storageAreaCardsJlabelList.get(i).addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel label = (JLabel)e.getSource();
					if(label.isEnabled()) {
						if(alhambraFirst){
							for(int j=0; j<storageAreaCardsJlabelList.size(); j++){
								if(storageAreaCardsJlabelList.get(j).equals(label)){
									selectedStorage = j;
								}
							}
							client.sendMessage("switchBuilding;"+matrixX+";"+matrixY+";"+selectedStorage, client.getOs());
							alhambraFirst = false;
						}else{
							storageFirst = true;
							for(int j=0; j<storageAreaCardsJlabelList.size(); j++){
								if(storageAreaCardsJlabelList.get(j).equals(label)){
									selectedStorage = j;
								}
							}
						}
						
					}
				}
			});
		}
		for(int i = backgrounds.size(); i < storageAreaCardsJlabelList.size(); i++) {
			storageAreaCardsJlabelList.get(i).setIcon(new ImageIcon("./resource/buildingCards/back.jpg"));
		}
	}
	
	public void buildingAreaCardBackgroundSetter(String[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j].equals("null")){
					table[i][j].setBackground(new Color(199,153,116));
					table[i][j].setIcon(null);
				}else{
					table[i][j].setIcon(new ImageIcon(matrix[i][j]));
				}
			}
		}
		table[10][10].setIcon(new ImageIcon("./resource/buildingCards/start.jpg"));
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	
	
}
