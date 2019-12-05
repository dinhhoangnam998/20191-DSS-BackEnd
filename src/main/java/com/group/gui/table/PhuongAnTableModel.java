package com.group.gui.table;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.group.topsis.PhuongAn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhuongAnTableModel extends AbstractTableModel {
	public List<PhuongAn> pas = new ArrayList<>();
	private String[] columns = { "Tên", "Độ Cay", "Độ Ngọt", "Độ Dinh Dưỡng", "Độ Phổ Biến", "Giá Tiền", "S*", "S-",
			"C*" };
	

	public PhuongAnTableModel() {
		super();
	}

	public PhuongAnTableModel(List<PhuongAn> pas) {
		super();
		this.pas = pas;
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
		return pas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		PhuongAn pa = pas.get(rowIndex);
		if (columnIndex == 0) {
			return pa.getTen();
		} else if (columnIndex == 1) {
			return df.format(pa.getBoTieuChiChuan().getDoCay());
		} else if (columnIndex == 2) {
			return df.format(pa.getBoTieuChiChuan().getDoNgot());
		} else if (columnIndex == 3) {
			return df.format(pa.getBoTieuChiChuan().getDoDinhDuong());
		} else if (columnIndex == 4) {
			return df.format( pa.getBoTieuChiChuan().getDoPhoBien());
		} else if (columnIndex == 5) {
			return df.format(pa.getBoTieuChiChuan().getGiaTien());
		} else if (columnIndex == 6) {
			return df.format(pa.getSTot());
		} else if (columnIndex == 7) {
			return df.format(pa.getSXau());
		} else {
			return df.format(pa.getC());
		}
	}
}
