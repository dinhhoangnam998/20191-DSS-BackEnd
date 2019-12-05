package com.group.topsis.monan;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.group.model.MonAn;
import com.group.topsis.BoTieuChiChuan;

public class ChuanHoaMonAn {
	List<MonAn> monAns;

	private double doCayLonNhat;
	private double doNgotLonNhat;
	private double doDinhDuongLonNhat;
	private double doPhoBienLonNhat;
	private double giaLonNhat;

	public ChuanHoaMonAn(List<MonAn> monAns) {
		this.monAns = monAns;
		setupMaxMin();
	}

	public void setupMaxMin() {
		doCayLonNhat = monAns.stream().max(Comparator.comparingDouble(MonAn::getDoCay)).get().getDoCay();
		doNgotLonNhat = monAns.stream().max(Comparator.comparingDouble(MonAn::getDoCay)).get().getDoNgot();
		doDinhDuongLonNhat = monAns.stream().max(Comparator.comparingDouble(MonAn::getDoCay)).get().getDoDinhDuong();
		doPhoBienLonNhat = monAns.stream().max(Comparator.comparingDouble(MonAn::getDoCay)).get().getDoPhoBien();
		giaLonNhat = monAns.stream().max(Comparator.comparingDouble(MonAn::getDoCay)).get().getGia();
	}

	public List<MonAnChuan> getMonAnChuan() {
//		DecimalFormat df = new DecimalFormat("#.###");
//		df.setRoundingMode(RoundingMode.CEILING);
		List<MonAnChuan> macs = new ArrayList<MonAnChuan>();
		for (MonAn ma : monAns) {
			double doCayChuan = ma.getDoCay() / doCayLonNhat;
			double doNgotChuan = ma.getDoNgot() / doNgotLonNhat;
			double doDinhDuongChuan = ma.getDoDinhDuong() / doDinhDuongLonNhat;
			double doPhoBienChuan = ma.getDoPhoBien() / doPhoBienLonNhat;
			double giaChuan = ma.getGia() / giaLonNhat;

			macs.add(new MonAnChuan(ma.getId(), ma.getTen(),
					new BoTieuChiChuan(doCayChuan, doNgotChuan, doDinhDuongChuan, doPhoBienChuan, giaChuan)));
		}
		return macs;
	}
}
