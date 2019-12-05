package com.group.topsis.monan;

import java.util.Comparator;
import java.util.List;

import com.group.topsis.BoTieuChiChuan;

public class TinhMaxMin {
	private List<MonAnChuan> bangQuyetDinh;

	private double doCayLonNhat;
	private double doCayNhoNhat;

	private double doNgotLonNhat;
	private double doNgotNhoNhat;

	private double doDinhDuongLonNhat;
	private double doDinhDuongNhoNhat;

	private double doPhoBienLonNhat;
	private double doPhoBienNhoNhat;

	private double giaLonNhat;
	private double giaNhoNhat;

	public TinhMaxMin(List<MonAnChuan> bangQuyetDinh) {
		this.bangQuyetDinh = bangQuyetDinh;
		setupMaxMin();
	}

	public void setupMaxMin() {
		doCayLonNhat = bangQuyetDinh.stream().max(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoCay()))
				.get().getBoTieuChiChuan().getDoCay();
		doCayNhoNhat = bangQuyetDinh.stream().min(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoCay()))
				.get().getBoTieuChiChuan().getDoCay();
		doNgotLonNhat = bangQuyetDinh.stream().max(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoNgot()))
				.get().getBoTieuChiChuan().getDoNgot();
		doNgotNhoNhat = bangQuyetDinh.stream().min(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoNgot()))
				.get().getBoTieuChiChuan().getDoNgot();
		doDinhDuongLonNhat = bangQuyetDinh.stream()
				.max(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoDinhDuong())).get().getBoTieuChiChuan()
				.getDoDinhDuong();
		doDinhDuongNhoNhat = bangQuyetDinh.stream()
				.min(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoDinhDuong())).get().getBoTieuChiChuan()
				.getDoDinhDuong();
		doPhoBienLonNhat = bangQuyetDinh.stream()
				.max(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoPhoBien())).get().getBoTieuChiChuan()
				.getDoPhoBien();
		doPhoBienNhoNhat = bangQuyetDinh.stream()
				.min(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getDoPhoBien())).get().getBoTieuChiChuan()
				.getDoPhoBien();
		giaLonNhat = bangQuyetDinh.stream().max(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getGiaTien()))
				.get().getBoTieuChiChuan().getGiaTien();
		giaNhoNhat = bangQuyetDinh.stream().min(Comparator.comparingDouble(i -> i.getBoTieuChiChuan().getGiaTien()))
				.get().getBoTieuChiChuan().getGiaTien();
	}

	public MonAnChuan getPhuongAnLyTuongTot() {
		BoTieuChiChuan boTieuChiChuan = new BoTieuChiChuan(doCayLonNhat, doNgotLonNhat, doDinhDuongLonNhat,
				doPhoBienLonNhat, giaLonNhat);
		return new MonAnChuan(null, "A*", boTieuChiChuan);
	}

	public MonAnChuan getPhuongAnLyTuongXau() {
		BoTieuChiChuan boTieuChiChuan = new BoTieuChiChuan(doCayNhoNhat, doNgotNhoNhat, doDinhDuongNhoNhat,
				doPhoBienNhoNhat, giaNhoNhat);
		return new MonAnChuan(null, "A-", boTieuChiChuan);
	}

}
