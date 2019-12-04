package com.group.gui.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.group.model.MonAn;

public class MonAnTablePanel extends JPanel {
	public JTable table;
	public MonAnTableModel tableModel;

	public MonAnTablePanel() {
		tableModel = new MonAnTableModel();
		table = new JTable(tableModel);
		initColumnWidth();
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void initColumnWidth() {
		TableColumn column = null;
		for (int i = 0; i < 5; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 4) {
				column.setPreferredWidth(column.getWidth() + 150);
			} else if (i != 0) {
				column.setPreferredWidth(column.getWidth() - 50);
			}
		}
	}

	public void displayData(List<MonAn> monAns) {
		tableModel.setMonAns(monAns);
		tableModel.fireTableDataChanged();
	}

	public int getRowIndexVuaDuocChon() {
		return table.getSelectedRow();
	}
	
	public MonAn getMonAnVuaDuocChon() {
		int index = table.getSelectedRow();
		MonAn monAnDuocChon = tableModel.monAns.get(index);
		return monAnDuocChon;
	}

	public void addMonAn(MonAn ma) {
		tableModel.monAns.add(ma);
		tableModel.fireTableDataChanged();
	}

	public void removeMonAn(int index) {
		tableModel.monAns.remove(index);
		tableModel.fireTableDataChanged();
	}
	
}
