package View;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;





import javax.swing.ListSelectionModel;

import ClientPackage.Client;

import javax.swing.JList;

public class RoomManagerPage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textFieldNewRoomName;
	private Client client;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JButton buttonUjSzoba;
	private JLabel lblSzobaLista;
	private JSeparator separator_1;
	private JList listRoom;
	private JButton buttonCsatlakozas;
	
	private int maxFerohely;


	/**
	 * Launch the application.
	 */
	public RoomManagerPage(Client aktClient) {
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

	/**
	 * Create the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Room Manager");
		frame.setBounds(100, 100, 594, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewRoom = new JLabel("Új szoba");
		lblNewRoom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewRoom.setBounds(10, 11, 69, 27);
		contentPane.add(lblNewRoom);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 558, 2);
		contentPane.add(separator);

		JLabel lblNameOfThe = new JLabel("Szoba neve");
		lblNameOfThe.setBounds(10, 40, 101, 14);
		contentPane.add(lblNameOfThe);

		textFieldNewRoomName = new JTextField();
		textFieldNewRoomName.addKeyListener(new KeyListener() {			
			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!textFieldNewRoomName.getText().isEmpty() && (radioButton_2.isSelected() || radioButton_3.isSelected() || radioButton_4.isSelected() || radioButton_5.isSelected() || radioButton_6.isSelected())){
					buttonUjSzoba.setEnabled(true);
				}else {
					buttonUjSzoba.setEnabled(false);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textFieldNewRoomName.setBounds(10, 60, 229, 20);
		contentPane.add(textFieldNewRoomName);
		textFieldNewRoomName.setColumns(10);

		JLabel lblMaximumPlace = new JLabel("Maximum férőhely");
		lblMaximumPlace.setBounds(258, 40, 109, 14);
		contentPane.add(lblMaximumPlace);

		radioButton_2 = new JRadioButton("2");
		radioButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				maxFerohely = 2;
				if(!textFieldNewRoomName.getText().isEmpty()){
					buttonUjSzoba.setEnabled(true);
				}
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
			}
		});
		radioButton_2.setBounds(258, 59, 42, 23);
		contentPane.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("3");
		radioButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				maxFerohely = 3;
				if(!textFieldNewRoomName.getText().isEmpty()){
					buttonUjSzoba.setEnabled(true);
				}
				radioButton_2.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
			}
		});
		radioButton_3.setBounds(302, 59, 42, 23);
		contentPane.add(radioButton_3);

		radioButton_4 = new JRadioButton("4");
		radioButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				maxFerohely = 4;
				if(!textFieldNewRoomName.getText().isEmpty()){
					buttonUjSzoba.setEnabled(true);
				}
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_5.setSelected(false);
				radioButton_6.setSelected(false);
			}
		});
		radioButton_4.setBounds(346, 59, 42, 23);
		contentPane.add(radioButton_4);
		
		radioButton_5 = new JRadioButton("5");
		radioButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				maxFerohely = 5;
				if(!textFieldNewRoomName.getText().isEmpty()){
					buttonUjSzoba.setEnabled(true);
				}
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_6.setSelected(false);
			}
		});
		radioButton_5.setBounds(390, 59, 42, 23);
		contentPane.add(radioButton_5);

		radioButton_6 = new JRadioButton("6");
		radioButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				maxFerohely = 6;
				if(!textFieldNewRoomName.getText().isEmpty()){
					buttonUjSzoba.setEnabled(true);
				}
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);
			}
		});
		radioButton_6.setBounds(434, 59, 42, 23);
		contentPane.add(radioButton_6);

		buttonUjSzoba = new JButton("Új szoba");
		buttonUjSzoba.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				client.sendMessage("newRoom;RoomManagerPage;"+textFieldNewRoomName.getText()+";"+maxFerohely, client.getOs());
			}
		});
		buttonUjSzoba.setBounds(482, 57, 86, 27);
		buttonUjSzoba.setEnabled(false);
		contentPane.add(buttonUjSzoba);
		
		JButton buttonKijelentkezes = new JButton("Kijelentkezés");
		buttonKijelentkezes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.sendMessage("logout;RoomManagerPage", client.getOs());
			}
		});
		buttonKijelentkezes.setBounds(445, 335, 123, 23);
		contentPane.add(buttonKijelentkezes);
		
		lblSzobaLista = new JLabel("Szoba lista");
		lblSzobaLista.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSzobaLista.setBounds(10, 112, 69, 27);
		contentPane.add(lblSzobaLista);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 137, 558, 2);
		contentPane.add(separator_1);
		
		listRoom = new JList<String>();
		listRoom.setBounds(10, 145, 358, 177);
		roomListBeallito(client.getRoomList());		

		JScrollPane scrollpane = new JScrollPane(listRoom, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(10, 145, 358, 177);
		contentPane.add(scrollpane);

		
		buttonCsatlakozas = new JButton("Csatlakozás");
		buttonCsatlakozas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String roomName = (String) listRoom.getModel().getElementAt(listRoom.getSelectedIndex());
				client.sendMessage("connectRoom;RoomManagerPage;" + roomName, client.getOs());
			}
		});
		buttonCsatlakozas.setBounds(10, 333, 109, 27);
		contentPane.add(buttonCsatlakozas);
		
		
	}

	
	
	public void roomListBeallito(List<String> roomNames){
		DefaultListModel<String> modell = new DefaultListModel<>();
		for(String name : roomNames){
			modell.addElement(name);
		}
		listRoom.setModel(modell);
	}
	
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame form) {
		this.frame = form;
	}

	
}
