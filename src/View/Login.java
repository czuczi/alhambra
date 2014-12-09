package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField loginField;
	private String loginText = null;

	public Login() {	
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginText = loginField.getText();
			}
		});
		btnLogin.setBounds(315, 110, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		
		
		loginField = new JTextField();
		loginField.setBounds(120, 111, 166, 20);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(46, 114, 64, 14);
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
