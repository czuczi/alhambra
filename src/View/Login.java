package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import ClientPackage.Client;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField loginField;
	private String loginText = null;
	private Client client;

	public Login(Client aktClient) {
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
		frame = new JFrame("Bejelentkezési Felület");
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Bejelentkezés");									//LOGIN BUTTON
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!loginField.getText().isEmpty()){
					if(loginField.getText().equals("ro-bot")){
						JOptionPane.showMessageDialog(null, "Ez a felhasználónév a rendszer számára van fenntartva!");
					}else{
						client.sendMessage("login;login;" + loginField.getText(), client.getOs());
					}
					
				}
			}
		});
		btnLogin.setBounds(300, 112, 120, 23);
		frame.getContentPane().add(btnLogin);
		
		
		
		loginField = new JTextField();
		loginField.setBounds(120, 114, 166, 20);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Felhasználónév:");
		lblNewLabel.setBounds(15, 114, 90, 14);
		frame.getContentPane().add(lblNewLabel);
	}

	public String getLoginText() {
		return loginText;
	}

	public void setLoginText(String loginText) {
		this.loginText = loginText;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
}
