package by.bsu.lab2.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import by.bsu.lab2.dao.MerchandiseAccessor;
import by.bsu.lab2.dao.RequestAccessor;
import by.bsu.lab2.entity.Merchandise;
import by.bsu.lab2.ui.InventoryForm;

public class InventoryController implements ActionListener{

	public InventoryForm m_InventoryForm;
	public MerchandiseAccessor merchandiseAccessor;
	private List<Merchandise> temp;
	private List<Merchandise> tempAdd;
	private List<Merchandise> tempDel;

	public InventoryController(InventoryForm invForm){
		m_InventoryForm = invForm;
		merchandiseAccessor = new MerchandiseAccessor();
		temp = new ArrayList<Merchandise>();
		tempAdd = new ArrayList<Merchandise>();
		tempDel = new ArrayList<Merchandise>();
	}

	public void addMerchandise(Merchandise merch) {
		//merchandiseAccessor.addMerchandise(merch);
		tempAdd.add(merch);
	}

	public List<Merchandise> createInventory() {
		temp = merchandiseAccessor.getMerchandise();
		return temp; 
	}

	
	public void printInventory()
	{
		String res = "";
		for(Merchandise i : m_InventoryForm.getListM())
		{
			res+= i.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, res);
	}
	
	public void deleteMerchandise(Merchandise merch) {
		tempDel.add(merch);
	}

	public void updateInventory() {
		for(int i = 0; i < tempAdd.size(); i++)
			merchandiseAccessor.addMerchandise(tempAdd.get(i));
		for(int i = 0; i < tempDel.size(); i++)
			merchandiseAccessor.deleteMerchandise(tempDel.get(i));
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}