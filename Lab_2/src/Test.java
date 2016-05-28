import java.awt.EventQueue;


public class Test {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm loginForm = new LoginForm();
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
