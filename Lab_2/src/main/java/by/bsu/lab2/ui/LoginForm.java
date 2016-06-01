package by.bsu.lab2.ui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import by.bsu.lab2.controller.FormController;
import by.bsu.lab2.controller.LoginController;
import by.bsu.lab2.dao.UserAccessor.Role;

public class LoginForm extends JFrame{
	
	private JPanel contentPane;
	private JComboBox<Role> loginField;
	private JPasswordField passField;
	private JButton okButton;
	private JLabel loginLabel;
	private JLabel passLabel;
	public FormController formController;
	public LoginController controller;

	public LoginForm(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());
		setContentPane(contentPane);
		
		controller = new LoginController(this);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.2;
		loginLabel = new JLabel("Login:");
		contentPane.add(loginLabel, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 0.8;
		loginField = new JComboBox<>(Role.values());
		loginField.setMaximumSize(new Dimension(200, 20));
		contentPane.add(loginField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		passLabel = new JLabel("Password:");
		contentPane.add(passLabel, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 0.8;
		passField = new JPasswordField();
		passField.setMaximumSize(new Dimension(200, 20));
		contentPane.add(passField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.CENTER;
		okButton = new JButton("OK");
		contentPane.add(okButton, gbc);

		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Role role = controller.doLogin((Role)loginField.getSelectedItem(), String.valueOf(passField.getPassword()));
					if (role == null) {
						JOptionPane.showMessageDialog(null, "Password is not correct");
						passField.setText("");
					} else {
						JOptionPane.showMessageDialog(null, String.format("%s logged in", role.name()));
						formController = new FormController();
						LoginForm.this.setVisible(false);
							formController.showForm(role);
							
					}
				}
				catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(null, "Username is not correct");
					passField.setText("");
				}
			}
		});
	}

}