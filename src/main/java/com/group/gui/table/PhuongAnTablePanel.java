package com.group.gui.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.group.topsis.PhuongAn;

public class PhuongAnTablePanel extends JPanel {
	public JTable table;
	public PhuongAnTableModel tableModel;

	public PhuongAnTablePanel() {
		tableModel = new PhuongAnTableModel();
		table = new JTable(tableModel);
		initColumnWidth();
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void initColumnWidth() {
		TableColumn column = null;
		column = table.getColumnModel().getColumn(0);
		column.setPreferredWidth(column.getWidth() + 50);
	}

	public void displayData(List<PhuongAn> pas) {
		tableModel.setPas(pas);
		tableModel.fireTableDataChanged();
	}

	public int getRowIndexVuaDuocChon() {
		return table.getSelectedRow();
	}

	public PhuongAn getPhuongAnVuaDuocChon() {
		int index = table.getSelectedRow();
		PhuongAn monAnDuocChon = tableModel.pas.get(index);
		return monAnDuocChon;
	}

	public void addPhuongAn(PhuongAn ma) {
		tableModel.pas.add(ma);
		tableModel.fireTableDataChanged();
	}

	public void removePhuongAn(int index) {
		tableModel.pas.remove(index);
		tableModel.fireTableDataChanged();
	}
}
