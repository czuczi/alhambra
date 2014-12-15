package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClientPackage.Client;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class RoomPage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JList jListPlayers;
	
	private Client client;

	/**
	 * Launch the application.
	 */
	public RoomPage(Client aktClient) {
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
		frame.setTitle("Szoba Felület");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCsatlakozottJtkosok = new JLabel("Csatlakozott játékosok");
		lblCsatlakozottJtkosok.setBounds(10, 11, 131, 14);
		contentPane.add(lblCsatlakozottJtkosok);
		
		jListPlayers = new JList();
		jListPlayers.setBounds(10, 48, 217, 203);
		playerListBeallito(client.getPlayerListInRoom());
		JScrollPane scrollPane = new JScrollPane(jListPlayers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 48, 217, 203);
		contentPane.add(scrollPane);
		
		JButton buttonSzobaElhagyasa = new JButton("Szoba elhagyása");
		buttonSzobaElhagyasa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				client.sendMessage("leaveRoom;RoomPage", client.getOs());
				
			}
		});
		buttonSzobaElhagyasa.setBounds(277, 228, 147, 23);
		contentPane.add(buttonSzobaElhagyasa);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 414, 2);
		contentPane.add(separator);
	}
	
	public void playerListBeallito(List<String> playerNames){
		DefaultListModel<String> modell = new DefaultListModel<>();
		for(String name : playerNames){
			modell.addElement(name);
		}
		jListPlayers.setModel(modell);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	
}
