package by.bsu.lab2.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import by.bsu.lab2.controller.OrderController;

public class OrderForm extends JFrame{

	private JButton okButton;
	private JButton cancelButton;
	private JButton addButton;
	private JButton deleteButton;
	private JTextArea reqArea;
	private JTextField amountField;
	private JList<String> invList;
	private JList<String> orderList;
	private JLabel amountLabel;
	private JPanel buttonsPanel;
	private JPanel editPanel;
	private JPanel amountPanel;
	private JScrollPane reqScrollPane;
	private JScrollPane invScrollPane;
	private JScrollPane orderScrollPane;
	
	public OrderController controller;

	public OrderForm(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		controller = new OrderController(this);
		
		invList = new JList<String>();
		invList.setLayoutOrientation(JList.VERTICAL);
		invList.setVisibleRowCount(0);
		invList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		orderList = new JList<String>();
		orderList.setLayoutOrientation(JList.VERTICAL);
		orderList.setVisibleRowCount(0);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		invScrollPane = new JScrollPane(invList);
		orderScrollPane = new JScrollPane(orderList);
		
		reqArea = new JTextArea();
		reqScrollPane = new JScrollPane(reqArea);
		amountField = new JTextField();
		amountField.setMaximumSize(new Dimension(170, 20));
		okButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		addButton = new JButton("Add");
		deleteButton = new JButton("Delete");
		amountLabel = new JLabel("Amount");
		
		buttonsPanel = new JPanel();
		editPanel = new JPanel();
		amountPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.X_AXIS));
		amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.Y_AXIS));
		buttonsPanel.add(amountLabel);
		buttonsPanel.add(amountField);
		buttonsPanel.add(addButton);
		buttonsPanel.add(deleteButton);
		editPanel.add(okButton);
		editPanel.add(cancelButton);
		editPanel.add(buttonsPanel);
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		add(reqScrollPane);
		add(invScrollPane);
		add(buttonsPanel);
		add(orderScrollPane);
		add(editPanel);
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			} });
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			} });
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.saveOrder();
				
			} });
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			} });
		
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