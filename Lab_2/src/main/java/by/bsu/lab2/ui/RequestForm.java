package by.bsu.lab2.ui;
import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import by.bsu.lab2.controller.RequestController;
import by.bsu.lab2.entity.Merchandise;
import by.bsu.lab2.entity.Person;
import by.bsu.lab2.entity.Request;

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
	private JFormattedTextField merchAmount;
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
	private List<Merchandise> listM;
	private DefaultListModel dlm;
	private NumberFormat integerNumberInstance;
	
	public RequestController controller;

	public RequestForm(){
		listM = new ArrayList<Merchandise>();
		
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
			
		clientName = new JTextField("");
		clientName.setMaximumSize(new Dimension(170, 20));
		clientSurname= new JTextField("");
		clientSurname.setMaximumSize(new Dimension(170, 20));
		clientCoord = new JTextField("");
		clientCoord.setMaximumSize(new Dimension(170, 20));
		merchName = new JTextField();
		merchName.setMaximumSize(new Dimension(170, 20));
		integerNumberInstance = NumberFormat.getIntegerInstance();
		merchAmount = new JFormattedTextField(integerNumberInstance);
		merchAmount.setMaximumSize(new Dimension(170, 20));
		
		delReq = new JButton("Delete Request");
		addMerch = new JButton("Add Item");
		delMerch = new JButton("Delete Item");
		saveReq = new JButton("Save");
		cancelReq = new JButton("Cancel");
		
		clN = new JLabel("Client name");
		clSn = new JLabel("Client surname");
		clC = new JLabel("Client coordinates");
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
		
		dlm = new DefaultListModel();
		reqList = new JList<String>(dlm);
		
		reqListPanel.add(reqList);
		
		
		delReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlm.clear();
				listM.removeAll(listM);
				merchName.setText("");
				merchAmount.setText("");
				clientName.setText("");
				clientSurname.setText("");
				clientCoord.setText("");
			}
		});
		
		addMerch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!merchName.getText().isEmpty() & !merchAmount.getText().isEmpty()) {
				Merchandise m = new Merchandise(merchName.getText(), 
						Integer.parseInt(merchAmount.getText()), 0);
				dlm.addElement(m.toStringReq());
				listM.add(m);
				}
			}
		});
		
		delMerch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!dlm.isEmpty()) {
				int removeIndex = reqList.getSelectedIndex();
				dlm.remove(removeIndex);
				listM.remove(removeIndex);
				}
			}
		});	
		
		saveReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!clientName.getText().isEmpty() & !clientSurname.getText().isEmpty() & !clientCoord.getText().isEmpty() & !dlm.isEmpty()) {
				Person p = new Person(clientName.getText(), clientSurname.getText(), clientCoord.getText());
				StringBuffer d = new StringBuffer();
				for(int i = 0; i < listM.size(); i++) {
					d.append(listM.get(i).toStringReq());
					d.append(", ");
				} 
				d.setCharAt(d.length() - 2, '.');
				System.out.println(d);
				Request r = new Request(p, d.toString());
			controller.addRequest(r);
			RequestForm.this.setVisible(false);	
			}
			}
		});
		
		cancelReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RequestForm.this.setVisible(false);
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