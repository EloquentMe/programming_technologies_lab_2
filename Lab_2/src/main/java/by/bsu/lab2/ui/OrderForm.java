package by.bsu.lab2.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import by.bsu.lab2.controller.OrderController;
import by.bsu.lab2.entity.Merchandise;
import by.bsu.lab2.entity.Order;
import by.bsu.lab2.entity.Person;
import by.bsu.lab2.entity.Request;

public class OrderForm extends JFrame implements ListSelectionListener {

	private JButton okButton;
	private JButton cancelButton;
	private JButton addButton;
	private JButton deleteButton;
	private JTextArea reqArea;
	private JFormattedTextField amountField;
	private JList<String> invList;
	private JList<String> orderList;
	private JList<String> reqList;
	private JLabel amountLabel;
	private JPanel buttonsPanel;
	private JPanel editPanel;
	private JPanel amountPanel;
	private JScrollPane reqScrollPane;
	private JScrollPane requestScrollPane;
	private JScrollPane invScrollPane;
	private JScrollPane orderScrollPane;
	private List<Merchandise> listM;
	private DefaultListModel dlmM;
	private List<Request> listR;
	private DefaultListModel dlmR;
	private Request r;
	private NumberFormat integerNumberInstance;
	private Order order;
	private List<Merchandise> listO;
	private List<Merchandise> listOAdd;
	private DefaultListModel dlmO;
	
	public OrderController controller;

	public OrderForm() {
		
		integerNumberInstance = NumberFormat.getIntegerInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		controller = new OrderController(this);
		listM = controller.createInventory();
		dlmM = new DefaultListModel();
		for(int i = 0; i < listM.size(); i++)
			dlmM.addElement(listM.get(i));
		invList = new JList(dlmM);
		invList.setLayoutOrientation(JList.VERTICAL);
		invList.setVisibleRowCount(0);
		invList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listR = controller.createRList();
		dlmR = new DefaultListModel();
		for(int i = 0; i < listR.size(); i++)
			dlmR.addElement(listR.get(i));
		reqList = new JList(dlmR);
		reqList.setLayoutOrientation(JList.VERTICAL);
		reqList.setVisibleRowCount(0);
		reqList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reqList.addListSelectionListener(this);
		
		listO = new ArrayList<Merchandise>();
		listOAdd = new ArrayList<Merchandise>();
		dlmO = new DefaultListModel();
		orderList = new JList(dlmO);
		orderList.setLayoutOrientation(JList.VERTICAL);
		orderList.setVisibleRowCount(0);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		invScrollPane = new JScrollPane(invList);
		requestScrollPane = new JScrollPane(reqList);
		orderScrollPane = new JScrollPane(orderList);
		
		reqArea = new JTextArea();
		reqScrollPane = new JScrollPane(reqArea);
		amountField = new JFormattedTextField(integerNumberInstance);
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
		add(requestScrollPane);
		add(reqScrollPane);
		add(invScrollPane);
		add(buttonsPanel);
		add(orderScrollPane);
		add(editPanel);
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = invList.getSelectedIndex();
				if(!amountField.getText().isEmpty() & (i != -1)) {
					Merchandise m = new Merchandise(listM.get(i).getName(), Integer.parseInt(amountField.getText()),listM.get(i).getPrice());
					dlmO.addElement(m.toStringReq());
					listOAdd.add(new Merchandise(listM.get(i).getName(), listM.get(i).getAmount() - Integer.parseInt(amountField.getText()),listM.get(i).getPrice()));
					listO.add(m);
					}
			} });
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int removeIndex = orderList.getSelectedIndex();
				if(removeIndex != -1) {
					dlmO.remove(removeIndex);
					listO.remove(removeIndex);
					listOAdd.remove(removeIndex);
				}
			} });
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(!dlmO.isEmpty()) {
				order = new Order(1, r.getClient(), listO);	
				//System.out.println(listO.toString());
				for(int i = 0; i < listOAdd.size(); i++) 
					controller.updMerch(listOAdd.get(i));
				controller.saveOrder(order, r);
				OrderForm.this.setVisible(false);
				}
			} });
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OrderForm.this.setVisible(false);
				
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int index = reqList.getSelectedIndex();
		if (index != -1) {
			r = listR.get(index);
			reqArea.setText(r.getDescription());
		}
	}

}