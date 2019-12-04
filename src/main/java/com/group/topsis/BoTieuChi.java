package com.group.topsis;

import com.group.enums.DoCay;
import com.group.enums.DoDinhDuong;
import com.group.enums.DoNgot;
import com.group.enums.DoPhoBien;
import com.group.enums.GiaTien;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoTieuChi {
	private DoCay doCay;
	private DoNgot doNgot;
	private DoDinhDuong doDinhDuong;
	private DoPhoBien doPhoBien;
	private GiaTien giaTien;

	public BoTieuChiChuan getBoTieuChiChuan() {
		return new BoTieuChiChuan(doCay.getValue() / 4.0, doNgot.getValue() / 4.0, doDinhDuong.getValue() / 2.0,
				doPhoBien.getValue() / 2.0, giaTien.getValue() / 2.0);
	}
}
