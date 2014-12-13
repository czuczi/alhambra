package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ClientPackage.Client;

public class GameTablePage {

	private JFrame frame;
	private Client client;

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

	private void initialize() {
		
	    JFrame frame = new JFrame("Alhambra");
	    frame.setBounds(200, 20, 1000, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
	    JPanel panelMoneyCards = new JPanel();
	   
	    JScrollPane spMoneyCards = new JScrollPane(panelMoneyCards,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    panelMoneyCards.setPreferredSize(new Dimension(880,(int)(panelMoneyCards.getPreferredSize().getHeight())));
	    panelMoneyCards.setBackground(Color.GRAY);
	    panelMoneyCards.setOpaque(true);
	    spMoneyCards.setBounds(476, 400, 383, 151);
	    frame.getContentPane().add(spMoneyCards);
	    panelMoneyCards.setLayout(null);
	   
	    
	    JLabel moneyCard_1 = new JLabel();
	    moneyCard_1.setBounds(10, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_1);
	    moneyCard_1.setOpaque(true);
	    moneyCard_1.setBackground(Color.RED);
	    
	    JLabel moneyCard_2 = new JLabel();
	    moneyCard_2.setOpaque(true);
	    moneyCard_2.setBackground(Color.RED);
	    moneyCard_2.setBounds(72, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_2);
	    
	    JLabel moneyCard_3 = new JLabel();
	    moneyCard_3.setOpaque(true);
	    moneyCard_3.setBackground(Color.RED);
	    moneyCard_3.setBounds(134, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_3);
	    
	    JLabel moneyCard_4 = new JLabel();
	    moneyCard_4.setOpaque(true);
	    moneyCard_4.setBackground(Color.RED);
	    moneyCard_4.setBounds(196, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_4);
	    
	    JLabel moneyCard_5 = new JLabel();
	    moneyCard_5.setOpaque(true);
	    moneyCard_5.setBackground(Color.RED);
	    moneyCard_5.setBounds(258, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_5);
	    
	    JLabel moneyCard_6 = new JLabel();
	    moneyCard_6.setOpaque(true);
	    moneyCard_6.setBackground(Color.RED);
	    moneyCard_6.setBounds(320, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_6);
	    
	    JLabel moneyCard_7 = new JLabel();
	    moneyCard_7.setOpaque(true);
	    moneyCard_7.setBackground(Color.RED);
	    moneyCard_7.setBounds(382, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_7);
	    
	    JLabel moneyCard_8 = new JLabel();
	    moneyCard_8.setOpaque(true);
	    moneyCard_8.setBackground(Color.RED);
	    moneyCard_8.setBounds(444, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_8);
	    
	    JLabel moneyCard_9 = new JLabel();
	    moneyCard_9.setOpaque(true);
	    moneyCard_9.setBackground(Color.RED);
	    moneyCard_9.setBounds(508, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_9);
	    
	    JLabel moneyCard_10 = new JLabel();
	    moneyCard_10.setOpaque(true);
	    moneyCard_10.setBackground(Color.RED);
	    moneyCard_10.setBounds(570, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_10);
	    
	    JLabel moneyCard_11 = new JLabel();
	    moneyCard_11.setOpaque(true);
	    moneyCard_11.setBackground(Color.RED);
	    moneyCard_11.setBounds(632, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_11);

	    JLabel moneyCard_12 = new JLabel();
	    moneyCard_12.setOpaque(true);
	    moneyCard_12.setBackground(Color.RED);
	    moneyCard_12.setBounds(694, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_12);
	    
	    JLabel moneyCard_13 = new JLabel();
	    moneyCard_13.setOpaque(true);
	    moneyCard_13.setBackground(Color.RED);
	    moneyCard_13.setBounds(756, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_13);

	    JLabel moneyCard_14 = new JLabel();
	    moneyCard_14.setOpaque(true);
	    moneyCard_14.setBackground(Color.RED);
	    moneyCard_14.setBounds(818, 11, 52, 88);
	    panelMoneyCards.add(moneyCard_14);
	    
	    JRadioButton radioButtonPlayerMoney_1 = new JRadioButton();
	    radioButtonPlayerMoney_1.setOpaque(true);
	    radioButtonPlayerMoney_1.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_1.setBounds(26, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_1);
	    
	    JRadioButton radioButtonPlayerMoney_2 = new JRadioButton();
	    radioButtonPlayerMoney_2.setOpaque(true);
	    radioButtonPlayerMoney_2.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_2.setBounds(88, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_2);
	    
	    JRadioButton radioButtonPlayerMoney_3 = new JRadioButton();
	    radioButtonPlayerMoney_3.setOpaque(true);
	    radioButtonPlayerMoney_3.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_3.setBounds(150, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_3);
	    
	    JRadioButton radioButtonPlayerMoney_4 = new JRadioButton();
	    radioButtonPlayerMoney_4.setOpaque(true);
	    radioButtonPlayerMoney_4.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_4.setBounds(212, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_4);
	    
	    JRadioButton radioButtonPlayerMoney_5 = new JRadioButton();
	    radioButtonPlayerMoney_5.setOpaque(true);
	    radioButtonPlayerMoney_5.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_5.setBounds(274, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_5);
	    
	    JRadioButton radioButtonPlayerMoney_6 = new JRadioButton();
	    radioButtonPlayerMoney_6.setOpaque(true);
	    radioButtonPlayerMoney_6.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_6.setBounds(336, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_6);
	    
	    JRadioButton radioButtonPlayerMoney_7 = new JRadioButton();
	    radioButtonPlayerMoney_7.setOpaque(true);
	    radioButtonPlayerMoney_7.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_7.setBounds(400, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_7);
	    
	    JRadioButton radioButtonPlayerMoney_8 = new JRadioButton();
	    radioButtonPlayerMoney_8.setOpaque(true);
	    radioButtonPlayerMoney_8.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_8.setBounds(462, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_8);
	    
	    JRadioButton radioButtonPlayerMoney_9 = new JRadioButton();
	    radioButtonPlayerMoney_9.setOpaque(true);
	    radioButtonPlayerMoney_9.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_9.setBounds(524, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_9);
	    
	    JRadioButton radioButtonPlayerMoney_10 = new JRadioButton();
	    radioButtonPlayerMoney_10.setOpaque(true);
	    radioButtonPlayerMoney_10.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_10.setBounds(586, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_10);
	    
	    JRadioButton radioButtonPlayerMoney_11 = new JRadioButton();
	    radioButtonPlayerMoney_11.setOpaque(true);
	    radioButtonPlayerMoney_11.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_11.setBounds(648, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_11);
	    
	    JRadioButton radioButtonPlayerMoney_12 = new JRadioButton();
	    radioButtonPlayerMoney_12.setOpaque(true);
	    radioButtonPlayerMoney_12.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_12.setBounds(710, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_12);
	    
	    JRadioButton radioButtonPlayerMoney_13 = new JRadioButton();
	    radioButtonPlayerMoney_13.setOpaque(true);
	    radioButtonPlayerMoney_13.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_13.setBounds(772, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_13);
	    
	    JRadioButton radioButtonPlayerMoney_14 = new JRadioButton();
	    radioButtonPlayerMoney_14.setOpaque(true);
	    radioButtonPlayerMoney_14.setBackground(Color.GRAY);
	    radioButtonPlayerMoney_14.setBounds(834, 106, 21, 16);
	    panelMoneyCards.add(radioButtonPlayerMoney_14);
	    
	    JPanel panelMoneyPicker = new JPanel();
	    panelMoneyPicker.setBounds(492, 11, 352, 129);
	    panelMoneyPicker.setBackground(Color.GRAY);
	    panelMoneyPicker.setOpaque(true);
	    frame.getContentPane().add(panelMoneyPicker);
	    panelMoneyPicker.setLayout(null);
	    
	    JLabel moneyPickerCard_1 = new JLabel();
	    moneyPickerCard_1.setOpaque(true);
	    moneyPickerCard_1.setBackground(Color.RED);
	    moneyPickerCard_1.setBounds(10, 11, 52, 88);
	    panelMoneyPicker.add(moneyPickerCard_1);
	    
	    JLabel moneyPickerCard_2 = new JLabel();
	    moneyPickerCard_2.setOpaque(true);
	    moneyPickerCard_2.setBackground(Color.RED);
	    moneyPickerCard_2.setBounds(72, 11, 52, 88);
	    panelMoneyPicker.add(moneyPickerCard_2);
	    
	    JLabel moneyPickerCard_3 = new JLabel();
	    moneyPickerCard_3.setOpaque(true);
	    moneyPickerCard_3.setBackground(Color.RED);
	    moneyPickerCard_3.setBounds(134, 11, 52, 88);
	    panelMoneyPicker.add(moneyPickerCard_3);
	    
	    JLabel moneyPickerCard_4 = new JLabel();
	    moneyPickerCard_4.setOpaque(true);
	    moneyPickerCard_4.setBackground(Color.RED);
	    moneyPickerCard_4.setBounds(196, 11, 52, 88);
	    panelMoneyPicker.add(moneyPickerCard_4);
	    
	    JRadioButton pickMoneyCard_1 = new JRadioButton();
	    pickMoneyCard_1.setBounds(25, 105, 21, 23);
	    pickMoneyCard_1.setBackground(Color.GRAY);
	    pickMoneyCard_1.setOpaque(true);
	    panelMoneyPicker.add(pickMoneyCard_1);
	    
	    JRadioButton pickMoneyCard_2 = new JRadioButton();
	    pickMoneyCard_2.setBounds(87, 105, 21, 23);
	    pickMoneyCard_2.setBackground(Color.GRAY);
	    pickMoneyCard_2.setOpaque(true);
	    panelMoneyPicker.add(pickMoneyCard_2);
	    
	    JRadioButton pickMoneyCard_3 = new JRadioButton();
	    pickMoneyCard_3.setBounds(149, 105, 21, 23);
	    pickMoneyCard_3.setBackground(Color.GRAY);
	    pickMoneyCard_3.setOpaque(true);
	    panelMoneyPicker.add(pickMoneyCard_3);
	    
	    JRadioButton pickMoneyCard_4 = new JRadioButton();
	    pickMoneyCard_4.setBounds(211, 105, 21, 23);
	    pickMoneyCard_4.setBackground(Color.GRAY);
	    pickMoneyCard_4.setOpaque(true);
	    panelMoneyPicker.add(pickMoneyCard_4);
	    
	    JButton pickButton = new JButton("Pick");
	    pickButton.setBounds(258, 50, 89, 23);
	    panelMoneyPicker.add(pickButton);
	    
	    JPanel panelStorageArea = new JPanel();
	    
	    JScrollPane spStorageArea = new JScrollPane(panelStorageArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    panelStorageArea.setPreferredSize(new Dimension( (int)(panelStorageArea.getPreferredSize().getWidth()), 785));
	    panelStorageArea.setBackground(Color.GRAY);
	    panelStorageArea.setOpaque(true);
	    spStorageArea.setBounds(869, 11, 115, 540);
	    frame.getContentPane().add(spStorageArea);
	    panelStorageArea.setLayout(null);
	    
	    JLabel storageBuildingCard_1 = new JLabel();
	    storageBuildingCard_1.setOpaque(true);
	    storageBuildingCard_1.setBackground(Color.BLUE);
	    storageBuildingCard_1.setBounds(12, 11, 75, 75);
	    panelStorageArea.add(storageBuildingCard_1);
	    
	    JLabel storageBuildingCard_2 = new JLabel();
	    storageBuildingCard_2.setOpaque(true);
	    storageBuildingCard_2.setBackground(Color.GREEN);
	    storageBuildingCard_2.setBounds(12, 97, 75, 75);
	    panelStorageArea.add(storageBuildingCard_2);
	    
	    JLabel storageBuildingCard_3 = new JLabel();
	    storageBuildingCard_3.setOpaque(true);
	    storageBuildingCard_3.setBackground(Color.GREEN);
	    storageBuildingCard_3.setBounds(12, 183, 75, 75);
	    panelStorageArea.add(storageBuildingCard_3);
	    
	    JLabel storageBuildingCard_4 = new JLabel();
	    storageBuildingCard_4.setOpaque(true);
	    storageBuildingCard_4.setBackground(Color.GREEN);
	    storageBuildingCard_4.setBounds(12, 269, 75, 75);
	    panelStorageArea.add(storageBuildingCard_4);
	    
	    JLabel storageBuildingCard_5 = new JLabel();
	    storageBuildingCard_5.setOpaque(true);
	    storageBuildingCard_5.setBackground(Color.GREEN);
	    storageBuildingCard_5.setBounds(12, 355, 75, 75);
	    panelStorageArea.add(storageBuildingCard_5);
	    
	    JLabel storageBuildingCard_6 = new JLabel();
	    storageBuildingCard_6.setOpaque(true);
	    storageBuildingCard_6.setBackground(Color.GREEN);
	    storageBuildingCard_6.setBounds(12, 441, 75, 75);
	    panelStorageArea.add(storageBuildingCard_6);
	    
	    JLabel storageBuildingCard_7 = new JLabel();
	    storageBuildingCard_7.setOpaque(true);
	    storageBuildingCard_7.setBackground(Color.GREEN);
	    storageBuildingCard_7.setBounds(12, 527, 75, 75);
	    panelStorageArea.add(storageBuildingCard_7);
	    
	    JLabel storageBuildingCard_8 = new JLabel();
	    storageBuildingCard_8.setOpaque(true);
	    storageBuildingCard_8.setBackground(Color.GREEN);
	    storageBuildingCard_8.setBounds(12, 613, 75, 75);
	    panelStorageArea.add(storageBuildingCard_8);
	    
	    JLabel storageBuildingCard_9 = new JLabel();
	    storageBuildingCard_9.setOpaque(true);
	    storageBuildingCard_9.setBackground(Color.GREEN);
	    storageBuildingCard_9.setBounds(12, 699, 75, 75);
	    panelStorageArea.add(storageBuildingCard_9);
	    
	    ButtonGroup bg = new ButtonGroup();
	    
	    JPanel panelBuildingArea = new JPanel();
	  
	    JScrollPane spBuildingArea = new JScrollPane(panelBuildingArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	    
	    panelBuildingArea.setPreferredSize(new Dimension( 1615, 1615));
	    panelBuildingArea.setBackground(Color.GREEN);
	    panelBuildingArea.setOpaque(true);
	    spBuildingArea.setBounds(10, 11, 454, 419);
	    frame.getContentPane().add(spBuildingArea);
	    panelBuildingArea.setLayout(null);
	    
	    JLabel [][] table = new JLabel[21][21];
	    
	    for(int i = 0; i < 21; i++)
	    {
	    	for(int j = 0; j < 21; j++)
	    	{
	    		table[i][j] = new JLabel();
	    		if(i==10 && j==10)
	    			table[i][j].setBackground(Color.BLUE);
	    		else
	    			table[i][j].setBackground(Color.GRAY);
	    		table[i][j].setOpaque(true);
	    		table[i][j].setBounds(i*77, j*77, 75, 75);
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
	    helpLabel.setBounds(492, 186, 352, 180);
	    frame.getContentPane().add(helpLabel);
	    helpLabel.setIcon(new ImageIcon("./resource/ertektabla.jpg"));
	    helpLabel.setOpaque(true);
	        
	    JPanel panelBuildingMarket = new JPanel();
	    panelBuildingMarket.setBounds(10, 441, 352, 110);
	    frame.getContentPane().add(panelBuildingMarket);
	    panelBuildingMarket.setOpaque(true);
	    panelBuildingMarket.setBackground(Color.GRAY);
	    panelBuildingMarket.setLayout(null);
	    
	    JLabel marketBuildingCard_1 = new JLabel();
	    marketBuildingCard_1.setBounds(10, 11, 75, 75);
	    panelBuildingMarket.add(marketBuildingCard_1);
	    marketBuildingCard_1.setOpaque(true);
	    marketBuildingCard_1.setBackground(Color.GREEN);
	    
	    JLabel marketBuildingCard_2 = new JLabel();
	    marketBuildingCard_2.setBounds(95, 11, 75, 75);
	    panelBuildingMarket.add(marketBuildingCard_2);
	    marketBuildingCard_2.setOpaque(true);
	    marketBuildingCard_2.setBackground(Color.GREEN);
	    
	    JLabel marketBuildingCard_3 = new JLabel();
	    marketBuildingCard_3.setOpaque(true);
	    marketBuildingCard_3.setBackground(Color.GREEN);
	    marketBuildingCard_3.setBounds(180, 11, 75, 75);
	    panelBuildingMarket.add(marketBuildingCard_3);
	    
	    JLabel marketBuildingCard_4 = new JLabel();
	    marketBuildingCard_4.setOpaque(true);
	    marketBuildingCard_4.setBackground(Color.GREEN);
	    marketBuildingCard_4.setBounds(265, 11, 75, 75);
	    panelBuildingMarket.add(marketBuildingCard_4);
	    
	    JRadioButton radioButtonMarket_1 = new JRadioButton();
	    radioButtonMarket_1.setBounds(38, 91, 21, 16);
	    radioButtonMarket_1.setOpaque(true);
	    radioButtonMarket_1.setBackground(Color.GRAY);
	    panelBuildingMarket.add(radioButtonMarket_1);
	    
	    JRadioButton radioButtonMarket_2 = new JRadioButton();
	    radioButtonMarket_2.setOpaque(true);
	    radioButtonMarket_2.setBackground(Color.GRAY);
	    radioButtonMarket_2.setBounds(124, 91, 21, 16);
	    panelBuildingMarket.add(radioButtonMarket_2);
	    
	    JRadioButton radioButtonMarket_3 = new JRadioButton();
	    radioButtonMarket_3.setOpaque(true);
	    radioButtonMarket_3.setBackground(Color.GRAY);
	    radioButtonMarket_3.setBounds(209, 91, 21, 16);
	    panelBuildingMarket.add(radioButtonMarket_3);
	    
	    JRadioButton radioButtonMarket_4 = new JRadioButton();
	    radioButtonMarket_4.setOpaque(true);
	    radioButtonMarket_4.setBackground(Color.GRAY);
	    radioButtonMarket_4.setBounds(294, 91, 21, 16);
	    panelBuildingMarket.add(radioButtonMarket_4);
	    bg.add(radioButtonMarket_1);
	    bg.add(radioButtonMarket_2);
	    bg.add(radioButtonMarket_3);
	    bg.add(radioButtonMarket_4);
	    
	    JButton btnBuyBuildingCard = new JButton("Buy");
	    btnBuyBuildingCard.setBounds(377, 528, 89, 23);
	    frame.getContentPane().add(btnBuyBuildingCard);
	      	    
	}
}
