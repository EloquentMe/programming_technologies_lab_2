package by.bsu.lab2.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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

import by.bsu.lab2.controller.InventoryController;
import by.bsu.lab2.controller.RequestController;
import by.bsu.lab2.entity.Merchandise;

public class InventoryForm extends JFrame {
	private JPanel contentPane;
	private JPanel invListPanel;
	private JPanel invInfPanel;
	private JPanel merchInfPanel;
	private JPanel buttPanel;
	private JPanel finishPanel;
	private JList<String> invList;
	private JTextField merchName;
	private JFormattedTextField merchAmount;
	private JFormattedTextField merchPrice;
	private JLabel merchN;
	private JLabel merchAm;
	private JLabel merchPr;
	private JButton addMerch;
	private JButton delMerch;
	private JButton saveInv;
	private JButton cancelInv;
	private NumberFormat integerNumberInstance;
	private List<Merchandise> listM;
	private DefaultListModel dlm;
	
	public InventoryController controller;

	public InventoryForm() {
		
		integerNumberInstance = NumberFormat.getIntegerInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
		controller = new InventoryController(this);
		
		invListPanel = new JPanel();
		invListPanel.setLayout(new BorderLayout(0, 0));
		invInfPanel = new JPanel();
		invInfPanel.setLayout(new BoxLayout(invInfPanel, BoxLayout.X_AXIS));
		merchInfPanel = new JPanel();
		merchInfPanel.setLayout(new GridLayout(3, 2));
		merchInfPanel.setAlignmentX(CENTER_ALIGNMENT);
		buttPanel = new JPanel();
		buttPanel.setLayout(new BoxLayout(buttPanel, BoxLayout.Y_AXIS));
		finishPanel = new JPanel();
		finishPanel.setLayout(new BoxLayout(finishPanel, BoxLayout.X_AXIS));
		
		contentPane.add(invInfPanel);
		contentPane.add(invListPanel);
		contentPane.add(finishPanel);
		
		invInfPanel.add(merchInfPanel);
		invInfPanel.add(buttPanel);
			
		merchName = new JTextField();
		merchName.setMaximumSize(new Dimension(170, 20));
		merchAmount = new JFormattedTextField(integerNumberInstance);
		merchAmount.setMaximumSize(new Dimension(170, 20));
		merchPrice = new JFormattedTextField(integerNumberInstance);
		merchPrice.setMaximumSize(new Dimension(170, 20));

		addMerch = new JButton("Add Item");
		delMerch = new JButton("Delete Item");
		saveInv = new JButton("Save");
		cancelInv = new JButton("Cancel");
		

		merchN = new JLabel("Merchandise name");
		merchAm = new JLabel("Mercandise amount");	
		merchPr = new JLabel("Merchandise price");
		
		merchInfPanel.add(merchN);
		merchInfPanel.add(merchName);
		merchInfPanel.add(merchAm);
		merchInfPanel.add(merchAmount);
		merchInfPanel.add(merchPr);
		merchInfPanel.add(merchPrice);
		
		buttPanel.add(addMerch);
		buttPanel.add(delMerch);
		
		finishPanel.add(saveInv);
		finishPanel.add(cancelInv);
		
		listM = controller.createInventory();
		dlm = new DefaultListModel();
		for(int i = 0; i < listM.size(); i++)
			dlm.addElement(listM.get(i));
		invList = new JList(dlm);
		invListPanel.add(invList);
		
		
		addMerch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!merchName.getText().isEmpty() & !merchAmount.getText().isEmpty() & !merchPrice.getText().isEmpty()) {
				Merchandise m = new Merchandise(merchName.getText(), 
						Integer.parseInt(merchAmount.getText()), Integer.parseInt(merchPrice.getText()));
				controller.addMerchandise(m);
				dlm.addElement(m.toString());
				listM.add(m);
				}
			}
		});
		
		delMerch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int removeIndex = invList.getSelectedIndex();
				if(removeIndex != -1) {
				dlm.remove(removeIndex);
				controller.deleteMerchandise(listM.get(removeIndex));
				listM.remove(removeIndex);
				}
			}
		});	
		
		saveInv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateInventory();
				InventoryForm.this.setVisible(false);
			}
		});
		
		cancelInv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InventoryForm.this.setVisible(false);
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