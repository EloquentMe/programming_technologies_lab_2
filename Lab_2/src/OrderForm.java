import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class OrderForm extends JFrame{

	private JPanel contentPane;
	public OrderController controller;

	public OrderForm(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		controller = new OrderController(this);

	}

	public void finalize() throws Throwable {

	}

	public void createOrder(){

	}

	public void saveOrder(){

	}

	public void selectMerchandise(){

	}

	public void selectRequest(){

	}

	public void showInventory(){

	}

	public void showMerchandise (){

	}

	public void showOrderForm(){

	}

	public void showRequestForm(){

	}

	public void showRequestList(){

	}

}