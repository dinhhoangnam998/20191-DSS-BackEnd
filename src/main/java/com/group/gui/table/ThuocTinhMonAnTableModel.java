package com.group.gui.table;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.group.model.MonAn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ThuocTinhMonAnTableModel extends AbstractTableModel {
	public List<MonAn> mas = new ArrayList<>();
	private String[] columns = { "Tên", "Độ Cay", "Độ Ngọt", "Độ Dinh Dưỡng", "Độ Phổ Biến", "Giá Tiền" };

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
		return mas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		MonAn ma = mas.get(rowIndex);
		if (columnIndex == 0) {
			return ma.getTen();
		} else if (columnIndex == 1) {
			return df.format(ma.getDoCay());
		} else if (columnIndex == 2) {
			return df.format(ma.getDoNgot());
		} else if (columnIndex == 3) {
			return df.format(ma.getDoDinhDuong());
		} else if (columnIndex == 4) {
			return df.format(ma.getDoPhoBien());
		} else if (columnIndex == 5) {
			return df.format(ma.getGia());
		} else {
			return "";
		}
	}
}
