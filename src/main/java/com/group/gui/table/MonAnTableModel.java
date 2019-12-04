package com.group.gui.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.group.model.MonAn;
import com.group.service.MonAnS;

public class MonAnTableModel extends AbstractTableModel {
	public List<MonAn> monAns = new ArrayList<>();
	private String[] columns = { "Tên", "Thể loại", "Nguồn gốc", "Giá", "Thành phần" };

	public MonAnTableModel() {
		super();
	}

	public MonAnTableModel(List<MonAn> monAns) {
		super();
		this.monAns = monAns;
	}

	public void setMonAns(List<MonAn> monAns) {
		this.monAns = monAns;
	}

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return monAns.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		MonAn ma = monAns.get(rowIndex);
		if (columnIndex == 0) {
			return ma.getTen();
		} else if (columnIndex == 1) {
			return ma.getTheLoai().getTen();
		} else if (columnIndex == 2) {
			return ma.getNguonGoc().getTen();
		} else if (columnIndex == 3) {
			return ma.getGia();
		} else if (columnIndex == 4) {
			return MonAnS.toStringNguyenLieu(ma);
//		} else if (columnIndex == 5) {
//			return ;
		} else {
			return "";
		}
	}

}
