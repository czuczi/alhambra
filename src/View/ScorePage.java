package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import ClientPackage.Client;
import javax.swing.JButton;

public class ScorePage {

	private JFrame frame;
	private JList jListPlayers;
	private Client client;

	public ScorePage(Client aktClient) {
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
			
		frame = new JFrame("Score");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScore = new JLabel("Current Score:");
		lblScore.setBounds(10, 26, 78, 14);
		frame.getContentPane().add(lblScore);
		
		jListPlayers = new JList();
		jListPlayers.setBounds(10, 48, 217, 203);
		setPlayerListModell(client.getPlayerListInRoom(),jListPlayers);
		JScrollPane scrollPanePlayers = new JScrollPane(jListPlayers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanePlayers.setBounds(52, 65, 321, 130);
		frame.getContentPane().add(scrollPanePlayers);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(284, 228, 89, 23);
		frame.getContentPane().add(btnContinue);
	}
	
	public void setPlayerListModell(List<String> players, JList<String> list){
		
		DefaultListModel<String> modell = new DefaultListModel<>();
		
		for(String name : players){
			modell.addElement(name);
		}
		list.setModel(modell);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	
}
