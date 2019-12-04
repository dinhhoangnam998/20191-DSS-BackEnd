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
import com.group.topsis.BoLoc;

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
			List<String> nguyenLieu = new ArrayList<String>();
			for (MonAnNguyenLieu manl : ma.getMonAnNguyenLieus()) {
				if(manl != null && manl.getNguyenLieu() != null) {
					nguyenLieu.add(manl.getNguyenLieu().getTen());
				}
			}

			if (!nguyenLieu.contains(boLoc.getDiUng().getTen())) {
				ketQuaCuoi.add(ma);
			}
		}

		return ketQuaCuoi;
	}
}
