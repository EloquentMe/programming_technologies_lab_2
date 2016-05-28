package by.bsu.lab2;
import java.awt.EventQueue;

import by.bsu.lab2.dao.AccountingAccessor;
import by.bsu.lab2.ui.LoginForm;


public class Starter {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm loginForm = new LoginForm();
					new AccountingAccessor().getLog();
					loginForm.setVisible(true);
					//InventoryForm invForm = new InventoryForm();
					//invForm.setVisible(true);
					//RequestForm reqForm = new RequestForm();
					//reqForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
