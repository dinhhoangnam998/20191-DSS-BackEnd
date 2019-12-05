package com.group.topsis.monan;

import java.util.List;

import com.group.topsis.BoTieuChiChuan;
import com.group.topsis.PhuongAn;

public class TinhPhuongAnLyTuongTotXau {

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

	public TinhPhuongAnLyTuongTotXau(List<PhuongAn> bangQuyetDinh) {
		setupMaxMin(bangQuyetDinh);
	}

	public void setupMaxMin(List<PhuongAn> pas) {
		if(pas.size() > 0) {
			PhuongAn pa = pas.get(0);
			BoTieuChiChuan b = pa.getBoTieuChiChuan();
			doCayNhoNhat = b.getDoCay();
			doNgotNhoNhat = b.getDoNgot();
			doDinhDuongNhoNhat = b.getDoDinhDuong();
			doPhoBienNhoNhat = b.getDoPhoBien();
			giaNhoNhat = b.getGiaTien();
		}
		for (PhuongAn pa : pas) {
			BoTieuChiChuan b = pa.getBoTieuChiChuan();
			doCayLonNhat = b.getDoCay() > doCayLonNhat ? b.getDoCay() : doCayLonNhat;
			doCayNhoNhat = b.getDoCay() < doCayNhoNhat ? b.getDoCay() : doCayNhoNhat;

			doNgotLonNhat = b.getDoNgot() > doNgotLonNhat ? b.getDoNgot() : doNgotLonNhat;
			doNgotNhoNhat = b.getDoNgot() < doNgotNhoNhat ? b.getDoNgot() : doNgotNhoNhat;

			doDinhDuongLonNhat = b.getDoDinhDuong() > doDinhDuongLonNhat ? b.getDoDinhDuong() : doDinhDuongLonNhat;
			doDinhDuongNhoNhat = b.getDoDinhDuong() < doDinhDuongNhoNhat ? b.getDoDinhDuong() : doDinhDuongNhoNhat;

			doPhoBienLonNhat = b.getDoPhoBien() > doPhoBienLonNhat ? b.getDoPhoBien() : doPhoBienLonNhat;
			doPhoBienNhoNhat = b.getDoPhoBien() < doPhoBienNhoNhat ? b.getDoPhoBien() : doPhoBienNhoNhat;

			giaLonNhat = b.getGiaTien() > giaLonNhat ? b.getGiaTien() : giaLonNhat;
			giaNhoNhat = b.getGiaTien() < giaNhoNhat ? b.getGiaTien() : giaNhoNhat;
		}
	}

	public PhuongAn getPhuongAnLyTuongTot() {
		BoTieuChiChuan boTieuChiChuan = new BoTieuChiChuan(doCayLonNhat, doNgotLonNhat, doDinhDuongLonNhat,
				doPhoBienLonNhat, giaLonNhat);
		return new PhuongAn(null, "A*", boTieuChiChuan);
	}

	public PhuongAn getPhuongAnLyTuongXau() {
		BoTieuChiChuan boTieuChiChuan = new BoTieuChiChuan(doCayNhoNhat, doNgotNhoNhat, doDinhDuongNhoNhat,
				doPhoBienNhoNhat, giaNhoNhat);
		return new PhuongAn(null, "A-", boTieuChiChuan);
	}

}
