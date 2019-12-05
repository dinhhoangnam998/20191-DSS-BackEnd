package com.group.topsis.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoTrongSo {

	private int wDoCay;
	private int wDoNgot;
	private int wDoDinhDuong;
	private int wDoPhoBien;
	private int wGiaTien;

	public BoTrongSoChuan getBoTrongSoChuan() {
		return new BoTrongSoChuan(wDoCay / 4.0, wDoNgot / 4.0, wDoDinhDuong / 4.0, wDoPhoBien / 4.0, wGiaTien / 4.0);
	}
}
