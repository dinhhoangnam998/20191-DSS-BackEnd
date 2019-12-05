package com.group.topsis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhuongAn {
	private Integer id;
	private String ten;
	private BoTieuChiChuan boTieuChiChuan;
	private double STot;
	private double SXau;
	private double C;

	public PhuongAn(Integer id, String ten, BoTieuChiChuan boTieuChiChuan) {
		super();
		this.id = id;
		this.ten = ten;
		this.boTieuChiChuan = boTieuChiChuan;
	}

}
