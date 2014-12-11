package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClientPackage.Client;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class RoomPage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCsatlakozottJtkosok = new JLabel("Csatlakozott játékosok");
		lblCsatlakozottJtkosok.setBounds(10, 11, 131, 14);
		contentPane.add(lblCsatlakozottJtkosok);
		
		JList list = new JList();
		list.setBounds(195, 48, -185, 203);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Szoba elhagyása");
		btnNewButton.setBounds(302, 228, 122, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 30, 414, 2);
		contentPane.add(separator);
	}
}
