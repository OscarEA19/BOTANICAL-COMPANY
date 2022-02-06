package controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import botany.layer.IMethods;
import models.Cactus;
import models.Ornamental;

public class Methods_Data_Imple implements IMethods {

	private final ArrayList<String> plants;

	public Methods_Data_Imple() {
		plants = new ArrayList<String>();
	}

	public boolean createPlants(Object obj) {
		try {
			this.plants.add(obj.toString());
			return true;
		} catch (Exception e) {
			System.err.println("ERROR:OBJECT");
		}
		return false;
	}

	public void readPlantsCAC(JTable table, Cactus cac) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rows[] = new Object[5];

		rows[0] = cac.getCode();
		rows[1] = cac.getName();
		rows[2] = cac.getDescription();
		rows[3] = cac.breedingMethod();
		rows[4] = cac.flowerColor(null);
		model.addRow(rows);
		table.setModel(model);
	}

	public boolean deletePlants(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int n = table.getSelectedRow();
		if (n < 0) {
			JOptionPane.showMessageDialog(null, "Please select row");
		} else {
			int confir = JOptionPane.showConfirmDialog(null, "Sure you want to delete this row?");
			if (JOptionPane.OK_OPTION == confir) {
				model.removeRow(n);
				return true;
			}
		}
		return false;
	}

	public void readPlantsOrna(JTable table, Ornamental orn) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rows[] = new Object[5];

		rows[0] = orn.getCode();
		rows[1] = orn.getName();
		rows[2] = orn.getDescription();
		rows[3] = orn.breedingMethod();
		rows[4] = orn.flowerColor(orn.getColor());
		model.addRow(rows);
		table.setModel(model);
	}

	public void orderplants(JTable table, int index) {

		if (index == 0) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
			table.setRowSorter(order);
			order.setRowFilter(RowFilter.regexFilter("^T", 4));

			table.setModel(model);
		}
		if (index == 1) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
			table.setRowSorter(order);
			order.setRowFilter(RowFilter.regexFilter("^U", 3));

			table.setModel(model);
		}
		if (index == 2) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
			table.setRowSorter(order);
		}

	}

}
