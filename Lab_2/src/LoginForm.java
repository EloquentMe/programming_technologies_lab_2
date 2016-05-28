import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame{
	
	private JPanel contentPane;
	private JPanel buttonsPanel;
	private JPanel fieldsPanel;
	private JPanel loginPanel;
	private JPanel passPanel;
	private JTextField loginField;
	private JPasswordField passField;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel loginLabel;
	private JLabel passLabel;

	public LoginController controller;

	public LoginForm(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		controller = new LoginController(this);

		loginField = new JTextField();
		loginField.setMaximumSize(new Dimension(200, 20));
		passField = new JPasswordField();
		passField.setMaximumSize(new Dimension(200, 20));
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		loginLabel = new JLabel("Login:");
		passLabel = new JLabel("Password:");
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.X_AXIS));
		loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel,BoxLayout.X_AXIS));
		passPanel = new JPanel();
		passPanel.setLayout(new BoxLayout(passPanel,BoxLayout.X_AXIS));
		fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new BoxLayout(fieldsPanel,BoxLayout.Y_AXIS));
		loginPanel.add(loginLabel);
		loginPanel.add(loginField);
		passPanel.add(passLabel);
		passPanel.add(passField);
		fieldsPanel.add(loginPanel);
		fieldsPanel.add(passPanel);
		buttonsPanel.add(okButton);
		buttonsPanel.add(cancelButton);
		contentPane.add(fieldsPanel, BorderLayout.CENTER);
		contentPane.add(buttonsPanel, BorderLayout.SOUTH);
		
		
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*if((loginField.getText().equals("User"))&&(String.valueOf(passField.getPassword()).equals("123")))
				{
					JOptionPane.showMessageDialog(null, "Yesssss");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Noooooooooooo");
				}*/
				
				
				controller.doLogin(loginField.getText(), String.valueOf(passField.getPassword()));
				
			}
		});
	}

	public void doLogin(){

	}

}