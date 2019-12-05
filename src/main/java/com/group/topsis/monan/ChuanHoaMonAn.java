package com.group.topsis.monan;

import java.util.ArrayList;
import java.util.List;

import com.group.model.MonAn;
import com.group.topsis.BoTieuChiChuan;

import lombok.Getter;

@Getter
public class ChuanHoaMonAn {
	private double doCayLonNhat;
	private double doNgotLonNhat;
	private double doDinhDuongLonNhat;
	private double doPhoBienLonNhat;
	private double giaLonNhat;
	List<MonAnChuan> monAnsDaChuanHoa;

	public ChuanHoaMonAn(List<MonAn> monAns) {
		findMaxValue(monAns);
		chuanHoaMonAn(monAns);
	}

	public void findMaxValue(List<MonAn> monAns) {
		for (MonAn ma : monAns) {
			doCayLonNhat = ma.getDoCay() > doCayLonNhat ? ma.getDoCay() : doCayLonNhat;
			doNgotLonNhat = ma.getDoNgot() > doNgotLonNhat ? ma.getDoNgot() : doNgotLonNhat;
			doDinhDuongLonNhat = ma.getDoDinhDuong() > doDinhDuongLonNhat ? ma.getDoDinhDuong() : doDinhDuongLonNhat;
			doPhoBienLonNhat = ma.getDoPhoBien() > doPhoBienLonNhat ? ma.getDoPhoBien() : doPhoBienLonNhat;
			giaLonNhat = ma.getGia() > giaLonNhat ? ma.getGia() : giaLonNhat;
		}
	}

	public void chuanHoaMonAn(List<MonAn> monAns) {
		monAnsDaChuanHoa = new ArrayList<MonAnChuan>();
		for (MonAn ma : monAns) {
			double doCayChuan = ma.getDoCay() / doCayLonNhat;
			double doNgotChuan = ma.getDoNgot() / doNgotLonNhat;
			double doDinhDuongChuan = ma.getDoDinhDuong() / doDinhDuongLonNhat;
			double doPhoBienChuan = ma.getDoPhoBien() / doPhoBienLonNhat;
			double giaChuan = ma.getGia() / giaLonNhat;

			monAnsDaChuanHoa.add(new MonAnChuan(ma.getId(), ma.getTen(),
					new BoTieuChiChuan(doCayChuan, doNgotChuan, doDinhDuongChuan, doPhoBienChuan, giaChuan)));
		}
	}
}
