package by.bsu.lab2.ui;
import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import by.bsu.lab2.controller.RequestController;

public class RequestForm extends JFrame{

	private JPanel contentPane;
	private JPanel reqListPanel;
	private JPanel reqInfPanel;
	private JPanel clientInfPanel;
	private JPanel merchInfPanel;
	private JPanel buttPanel;
	private JList<String> reqList;
	private JTextField clientName;
	private JTextField clientSurname;
	private JTextField clientCoord;
	private JTextField merchName;
	private JTextField merchAmount;
	private JTextField merchPrice;
	private JLabel clN;
	private JLabel clSn;
	private JLabel clC;
	private JLabel merchN;
	private JLabel merchAm;
	private JLabel merchPr;
	private JButton delReq;
	private JButton addMerch;
	private JButton delMerch;
	private JButton editMerch;
	
	public RequestController controller;

	public RequestForm(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
		controller = new RequestController(this);
		
		reqListPanel = new JPanel();
		reqListPanel.setLayout(new BorderLayout(0,0));
		reqInfPanel = new JPanel();
		reqInfPanel.setLayout(new BoxLayout(reqInfPanel, BoxLayout.X_AXIS));
		clientInfPanel = new JPanel();
		clientInfPanel.setLayout(new GridLayout(3, 2));
		clientInfPanel.setAlignmentX(CENTER_ALIGNMENT);
		merchInfPanel = new JPanel();
		merchInfPanel.setLayout(new GridLayout(3, 2));
		merchInfPanel.setAlignmentX(CENTER_ALIGNMENT);
		buttPanel = new JPanel();
		buttPanel.setLayout(new BoxLayout(buttPanel, BoxLayout.Y_AXIS));
		
		contentPane.add(reqInfPanel);
		contentPane.add(reqListPanel);
		
		reqInfPanel.add(clientInfPanel);
		reqInfPanel.add(merchInfPanel);
		reqInfPanel.add(buttPanel);
			
		
		clientName = new JTextField();
		clientName.setMaximumSize(new Dimension(170, 20));
		clientSurname= new JTextField();
		clientSurname.setMaximumSize(new Dimension(170, 20));
		clientCoord = new JTextField();
		clientCoord.setMaximumSize(new Dimension(170, 20));
		merchName = new JTextField();
		merchName.setMaximumSize(new Dimension(170, 20));
		merchAmount = new JTextField();
		merchAmount.setMaximumSize(new Dimension(170, 20));
		merchPrice = new JTextField();
		merchPrice.setMaximumSize(new Dimension(170, 20));
		
		delReq = new JButton("Delete Request");
		addMerch = new JButton("Add Item");
		delMerch = new JButton("Delete Item");
		editMerch = new JButton("Edit Item");
		
		clN = new JLabel("Client name");
		clSn = new JLabel("Client surname:");
		clC = new JLabel("Client coordinates:");
		merchN = new JLabel("Merchandise name");
		merchAm = new JLabel("Mercandise amount");
		merchPr = new JLabel("Merchandise price");		
		
		clientInfPanel.add(clN);
		clientInfPanel.add(clientName);
		clientInfPanel.add(clSn);
		clientInfPanel.add(clientSurname);
		clientInfPanel.add(clC);
		clientInfPanel.add(clientCoord);
		
		merchInfPanel.add(merchN);
		merchInfPanel.add(merchName);
		merchInfPanel.add(merchAm);
		merchInfPanel.add(merchAmount);
		merchInfPanel.add(merchPr);
		merchInfPanel.add(merchPrice);
		
		buttPanel.add(delReq);
		buttPanel.add(addMerch);
		buttPanel.add(delMerch);
		buttPanel.add(editMerch);
		
		String[] data = {"kfug", "akjfi","kefia"};
		reqList = new JList<String>(data);
		
		reqListPanel.add(reqList);
		
		
		delReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.deleteRequest();
				
			}
		});
		
		addMerch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addMerchandise();
			}
		});
		
		delMerch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.deleteMerchandise();
				
			}
		});
		
		editMerch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.editMerchandise();
				
			}
		});
		
		
	}
	

	public void addNewItem(){

	}

	public void deleteItem(){

	}

	public void editItem(){

	}

	public void getRequest(){

	}

	public void saveRequest(){

	}

}