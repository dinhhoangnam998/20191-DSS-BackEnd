package com.group.gui.table;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.group.topsis.BoTieuChiChuan;
import com.group.topsis.monan.MonAnChuan;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MonAnChuanChuanTableModel extends AbstractTableModel {
	public List<MonAnChuan> macs = new ArrayList<>();
	private String[] columns = { "Tên", "Độ Cay", "Độ Ngọt", "Độ Dinh Dưỡng", "Độ Phổ Biến", "Giá Tiền" };

	public MonAnChuanChuanTableModel() {
		super();
	}

	public MonAnChuanChuanTableModel(List<MonAnChuan> macs) {
		super();
		this.macs = macs;
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
		return macs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		MonAnChuan ma = macs.get(rowIndex);
		BoTieuChiChuan b = ma.getBoTieuChiChuan();
		if (columnIndex == 0) {
			return ma.getTen();
		} else if (columnIndex == 1) {
			return df.format(b.getDoCay());
		} else if (columnIndex == 2) {
			return df.format(b.getDoNgot());
		} else if (columnIndex == 3) {
			return df.format(b.getDoDinhDuong());
		} else if (columnIndex == 4) {
			return df.format(b.getDoPhoBien());
		} else if (columnIndex == 5) {
			return df.format(b.getGiaTien());
		} else {
			return "";
		}
	}
}
