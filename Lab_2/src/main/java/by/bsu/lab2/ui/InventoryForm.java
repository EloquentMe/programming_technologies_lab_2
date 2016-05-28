package by.bsu.lab2.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import by.bsu.lab2.controller.InventoryController;

public class InventoryForm extends JFrame {
	private JPanel contentPane;
	private JScrollPane merchPanel;
	private JScrollPane invPanel;
	private JButton addItem;
	private JButton delItem;
	private JList<String> merchList;
	private JList<String> invList;
	public InventoryController controller;

	public InventoryForm(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		controller = new InventoryController(this);
		
		String[] data = {"skb","awfija","awlg"};
		merchList = new JList<String>(data);
		merchList.setLayoutOrientation(JList.VERTICAL);
		merchList.setVisibleRowCount(0);
		invList = new JList<String>(data);
		invList.setLayoutOrientation(JList.VERTICAL);
		invList.setVisibleRowCount(0);
		merchPanel = new JScrollPane(merchList);
		merchPanel.setPreferredSize(new Dimension(100, 100));
		invPanel = new JScrollPane(invList);
		invPanel.setPreferredSize(new Dimension(100, 100));
		addItem = new JButton(">  (Add Item to Inventory)");
		delItem = new JButton("<  (Delete Item from Inventory)");
		
		
		contentPane.add(merchPanel, BorderLayout.WEST);
		contentPane.add(invPanel, BorderLayout.EAST);
		contentPane.add(addItem, BorderLayout.NORTH);
		contentPane.add(delItem, BorderLayout.SOUTH);
		
		
		
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.addMerchandise();
				
				
			}
		});
		
		delItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.deleteMerchandise();
				
			}
		});


	}

	public void finalize() throws Throwable {

	}

	public void addMerchndise(){

	}

	public void createInventory(){

	}

	public void deleteMerchandise(){

	}

	public void showInventory(){

	}

	public void updateInventory(){

	}

}