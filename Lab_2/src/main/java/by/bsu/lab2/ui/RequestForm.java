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
	private JPanel finishPanel;
	private JList<String> reqList;
	private JTextField clientName;
	private JTextField clientSurname;
	private JTextField clientCoord;
	private JTextField merchName;
	private JTextField merchAmount;
	private JLabel clN;
	private JLabel clSn;
	private JLabel clC;
	private JLabel merchN;
	private JLabel merchAm;
	private JButton delReq;
	private JButton addMerch;
	private JButton delMerch;
	private JButton saveReq;
	private JButton cancelReq;
	
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
		merchInfPanel.setLayout(new GridLayout(2, 2));
		merchInfPanel.setAlignmentX(CENTER_ALIGNMENT);
		buttPanel = new JPanel();
		buttPanel.setLayout(new BoxLayout(buttPanel, BoxLayout.Y_AXIS));
		finishPanel = new JPanel();
		finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.X_AXIS));
		
		contentPane.add(reqInfPanel);
		contentPane.add(reqListPanel);
		contentPane.add(finishPanel);
		
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
		
		delReq = new JButton("Delete Request");
		addMerch = new JButton("Add Item");
		delMerch = new JButton("Delete Item");
		saveReq = new JButton("Save");
		cancelReq = new JButton("Cancel");
		
		clN = new JLabel("Client name");
		clSn = new JLabel("Client surname:");
		clC = new JLabel("Client coordinates:");
		merchN = new JLabel("Merchandise name");
		merchAm = new JLabel("Mercandise amount");	
		
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
		
		buttPanel.add(delReq);
		buttPanel.add(addMerch);
		buttPanel.add(delMerch);
		
		finishPanel.add(saveReq);
		finishPanel.add(cancelReq);
		
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
		
		saveReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		
		cancelReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
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