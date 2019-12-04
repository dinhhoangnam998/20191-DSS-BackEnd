package com.group.topsis;

import java.util.List;

import com.group.model.MonAn;

public class TOPSIS {
	private BoLoc boLoc;
	private BoTieuChi boTieuChi;
	private BoTieuChiChuan boTieuChiChuan;
	private BoTrongSo boTrongSo;
	private BoTrongSoChuan boTrongSoChuan;
	private List<MonAn> ketQuaTimKiem;

	public void setUserInputData(BoLoc boLoc, BoTieuChi boTieuChi, BoTrongSo boTrongSo) {
		this.boLoc = boLoc;
		this.boTieuChi = boTieuChi;
		this.boTrongSo = boTrongSo;
	}

	private void setKetQuaTimKiem() {

	}

	private void chuanHoaBoTieuChi() {
		boTieuChiChuan = boTieuChi.getBoTieuChiChuan();
	}

	private void chuanHoaBoTrongSo() {
		boTrongSoChuan = boTrongSo.getBoTrongSoChuan();
	}

}
