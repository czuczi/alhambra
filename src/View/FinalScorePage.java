package View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import ClientPackage.Client;

public class FinalScorePage {

	private JFrame frame;
	private JList jListPlayers;
	private Client client;

	public FinalScorePage(Client aktClient) {
		
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Final Result");
		frame.setResizable(false);
		frame.setBounds(400, 300, 600, 400);
		frame.setContentPane(new JLabel(new ImageIcon("./resource/otherImages/backgroundScore.jpg")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScore = new JLabel("Final Score:");
		lblScore.setBounds(21, 21, 118, 14);
		frame.getContentPane().add(lblScore);
		
		jListPlayers = new JList();
		jListPlayers.setBounds(10, 48, 217, 203);
		//setPlayerListModell(client.getPlayerListInRoom(),jListPlayers);
		JScrollPane scrollPanePlayers = new JScrollPane(jListPlayers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanePlayers.setBounds(74, 57, 433, 232);
		frame.getContentPane().add(scrollPanePlayers);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(418, 317, 89, 23);
		frame.getContentPane().add(btnContinue);
	}

	
	public void setPlayerListModell(List<String> players, JList<String> list){
		
		DefaultListModel<String> modell = new DefaultListModel<>();
		
		for(String name : players){
			modell.addElement(name);
		}
		list.setModel(modell);
	}
}
