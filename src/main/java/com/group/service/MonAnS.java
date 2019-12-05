package com.group.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.MonAn;
import com.group.model.MonAnNguyenLieu;
import com.group.model.QuocGia;
import com.group.model.TheLoai;
import com.group.repo.MonAnR;
import com.group.topsis.user.BoLoc;

@Service
public class MonAnS {

	@Autowired
	public MonAnR maR;

	public List<MonAn> timKiemKetQua(BoLoc boLoc) {
		TheLoai theLoai = boLoc.getTheLoai();
		QuocGia nguonGoc = boLoc.getNguonGoc();
		int giaNhoNhat = boLoc.getGiaNhoNhat();
		int giaLonNhat = boLoc.getGiaLonNhat();
		List<MonAn> ketQuaBanDau;

		boolean isAllTheLoai = theLoai.getTen().equals("ALL");
		boolean isAllNguonGoc = nguonGoc.getTen().equals("ALL");

		// Xet tung truong hop
		if (isAllTheLoai && isAllNguonGoc) {
			ketQuaBanDau = maR.findByGiaGreaterThanEqualAndGiaLessThanEqual(giaNhoNhat, giaLonNhat);
		} else if (isAllTheLoai && !isAllNguonGoc) {
			ketQuaBanDau = maR.findByNguonGocAndGiaGreaterThanEqualAndGiaLessThanEqual(nguonGoc, giaNhoNhat,
					giaLonNhat);
		} else if (!isAllTheLoai && isAllNguonGoc) {
			ketQuaBanDau = maR.findByTheLoaiAndGiaGreaterThanEqualAndGiaLessThanEqual(theLoai, giaNhoNhat, giaLonNhat);
		} else {
			ketQuaBanDau = maR.findByTheLoaiAndNguonGocAndGiaGreaterThanEqualAndGiaLessThanEqual(theLoai, nguonGoc,
					giaNhoNhat, giaLonNhat);
		}

		// loai bo cac mon bi di ung
		List<MonAn> ketQuaCuoi = new ArrayList<MonAn>();
		for (MonAn ma : ketQuaBanDau) {
			List<String> nguyenLieu = getNguyenLieu(ma);
			if (!nguyenLieu.contains(boLoc.getDiUng().getTen())) {
				ketQuaCuoi.add(ma);
			}
		}

		return ketQuaCuoi;
	}

	public static List<String> getNguyenLieu(MonAn ma) {
		List<String> nguyenLieus = new ArrayList<String>();
		for (MonAnNguyenLieu manl : ma.getMonAnNguyenLieus()) {
			nguyenLieus.add(manl.getNguyenLieu().getTen());
		}
		return nguyenLieus;
	}

	public static String toStringNguyenLieu(MonAn ma) {
		List<String> nguyenLieus = getNguyenLieu(ma);
		String result = "";
		for (String s : nguyenLieus) {
			result += s;
			result += ", ";
		}
		return result;
	}
	
	public static String getOrderFormat(List<MonAn> mas) {
		String result = "Bạn vừa order thành công các món:\n";
		for(MonAn ma : mas) {
			result += ma.getTen() + " - " + ma.getGia() + "\n"; 
		}
		return result;
	}
}
