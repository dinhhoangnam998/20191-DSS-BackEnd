package com.group.gui.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.group.model.MonAn;

public class ThuocTinhMonAnTablePanel extends JPanel {
	public JTable table;
	public ThuocTinhMonAnTableModel tableModel;

	public ThuocTinhMonAnTablePanel() {
		tableModel = new ThuocTinhMonAnTableModel();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void displayData(List<MonAn> mas) {
		tableModel.setMas(mas);
		tableModel.fireTableDataChanged();
	}
}
