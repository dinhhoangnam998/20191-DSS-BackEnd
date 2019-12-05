package com.group.utils;

import java.util.List;

import com.group.model.MonAn;
import com.group.topsis.BoTieuChiChuan;
import com.group.topsis.PhuongAn;
import com.group.topsis.monan.MonAnChuan;

public class Printer {

//	DecimalFormat df = new DecimalFormat("#.###");
//	df.setRoundingMode(RoundingMode.CEILING);
	public static void printPhuongAn(List<PhuongAn> pas) {
		for (PhuongAn pa : pas) {
			BoTieuChiChuan boTieuChiChuan = pa.getBoTieuChiChuan();
			System.out.println(
					boTieuChiChuan.getDoCay() + " " + boTieuChiChuan.getDoNgot() + " " + boTieuChiChuan.getDoDinhDuong()
							+ " " + boTieuChiChuan.getDoPhoBien() + " " + boTieuChiChuan.getGiaTien());
			System.out.println("\n");
		}
	}

	public static void printMonAnChuans(List<MonAnChuan> mas) {
		for (MonAnChuan ma : mas) {
			System.out.println(ma.getTen() + " " + ma.getBoTieuChiChuan().getDoCay() + " "
					+ ma.getBoTieuChiChuan().getDoNgot() + " " + ma.getBoTieuChiChuan().getDoDinhDuong() + " "
					+ ma.getBoTieuChiChuan().getDoPhoBien() + " " + ma.getBoTieuChiChuan().getGiaTien());
		}
	}

}
