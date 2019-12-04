package com.group.topsis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.MonAn;
import com.group.service.MonAnS;

@Service
public class TOPSIS {
	private BoLoc boLoc;
	private BoTieuChi boTieuChi;
	private BoTieuChiChuan boTieuChiChuan;
	private BoTrongSo boTrongSo;
	private BoTrongSoChuan boTrongSoChuan;
	private List<MonAn> ketQuaTimKiem;

	@Autowired
	private MonAnS maS;
	
	public List<MonAn> userInputOccured(BoLoc boLoc, BoTieuChi boTieuChi, BoTrongSo boTrongSo) {
		this.boLoc = boLoc;
		this.boTieuChi = boTieuChi;
		this.boTrongSo = boTrongSo;
		chuanHoaBoTieuChi();
		chuanHoaBoTrongSo();
		setKetQuaTimKiem();
		return ketQuaTimKiem;
	}

	private void setKetQuaTimKiem() {
		ketQuaTimKiem = maS.timKiemKetQua(boLoc);
	}

	private void chuanHoaBoTieuChi() {
		boTieuChiChuan = boTieuChi.getBoTieuChiChuan();
	}

	private void chuanHoaBoTrongSo() {
		boTrongSoChuan = boTrongSo.getBoTrongSoChuan();
	}

}
