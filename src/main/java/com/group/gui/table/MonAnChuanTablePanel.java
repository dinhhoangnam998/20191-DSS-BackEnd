package com.group.gui.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.group.topsis.monan.MonAnChuan;

public class MonAnChuanTablePanel extends JPanel {
	public JTable table;
	public MonAnChuanChuanTableModel tableModel;

	public MonAnChuanTablePanel() {
		tableModel = new MonAnChuanChuanTableModel();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void displayData(List<MonAnChuan> macs) {
		tableModel.setMacs(macs);
		tableModel.fireTableDataChanged();
	}

}
