package com.group.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.group.model.MonAn;

public class MonAnResultPanel extends JPanel {
	private JTable table;
	private MonAnTableModel searchResultTableModel;

	public MonAnResultPanel() {
		searchResultTableModel = new MonAnTableModel();
		table = new JTable(searchResultTableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void displayData(List<MonAn> monAns) {
		searchResultTableModel.setMonAns(monAns);
		searchResultTableModel.fireTableDataChanged();
	}
}
