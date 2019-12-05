package com.group.topsis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.MonAn;
import com.group.service.MonAnS;
import com.group.topsis.monan.ChuanHoaMonAn;
import com.group.topsis.monan.MonAnChuan;
import com.group.topsis.monan.TinhMaxMin;
import com.group.topsis.user.BoLoc;
import com.group.topsis.user.BoTieuChi;
import com.group.topsis.user.BoTrongSo;
import com.group.topsis.user.BoTrongSoChuan;
import com.group.topsis.user.UserInputChuanHoa;
import com.group.topsis.user.UserInputData;

import lombok.Getter;

@Service
@Getter
public class TOPSIS {
	private UserInputData userInputData;
	private UserInputChuanHoa userInputChuanHoa;

	private List<MonAn> ketQuaTimKiemMonAn;
	private List<MonAnChuan> monAnDaChuanHoa;

	private List<MonAnChuan> bangDoDoPhuHop;
	private List<MonAnChuan> bangQuyetDinh;

	private MonAnChuan phuongAnLyTuongTot;
	private MonAnChuan phuongAnLyTuongXau;

	private List<Double> khoangCachToiPhuongAnLyTuongTot;
	private List<Double> khoangCachToiPhuongAnLyTuongXau;

	private List<Double> doDoTuongTu;

	@Autowired
	private MonAnS maS;

	public void setup(BoLoc boLoc, BoTieuChi boTieuChi, BoTrongSo boTrongSo) {
		userInputData = new UserInputData(boLoc, boTieuChi, boTrongSo);
		userInputChuanHoa = new UserInputChuanHoa(userInputData);
		ketQuaTimKiemMonAn = maS.timKiemKetQua(boLoc);
		monAnDaChuanHoa = new ChuanHoaMonAn(ketQuaTimKiemMonAn).getMonAnChuan();
		bangDoDoPhuHop = tinhBangDoDoPhuHop();
		bangQuyetDinh = tinhBangQuyetDinh();
		tinhPhuongAnLyTuongTotVaXau();
		tinhKhoangCach();
		tinhDoDoTuongTu();
	}

	private List<MonAnChuan> tinhBangDoDoPhuHop() {
		List<MonAnChuan> bangDoDoPhuHop = new ArrayList<MonAnChuan>();
		for (MonAnChuan mac : monAnDaChuanHoa) {
			BoTieuChiChuan boTieuChiChuanOfMonAn = mac.getBoTieuChiChuan();
			BoTieuChiChuan boTieuChiChuanOfUser = userInputChuanHoa.getBoTieuChiChuan();
			double doCay = f(boTieuChiChuanOfUser.getDoCay(), boTieuChiChuanOfMonAn.getDoCay());
			double doNgot = f(boTieuChiChuanOfUser.getDoNgot(), boTieuChiChuanOfMonAn.getDoNgot());
			double doDinhDuong = f(boTieuChiChuanOfUser.getDoDinhDuong(), boTieuChiChuanOfMonAn.getDoDinhDuong());
			double doPhoBien = f(boTieuChiChuanOfUser.getDoPhoBien(), boTieuChiChuanOfMonAn.getDoPhoBien());
			double giaTien = f(boTieuChiChuanOfUser.getGiaTien(), boTieuChiChuanOfUser.getGiaTien());

			BoTieuChiChuan doPhuHop = new BoTieuChiChuan(doCay, doNgot, doDinhDuong, doPhoBien, giaTien);
			MonAnChuan doPhuHopCuaMonAn = new MonAnChuan(mac.getId(), mac.getTen(), doPhuHop);
			bangDoDoPhuHop.add(doPhuHopCuaMonAn);
		}
		return bangDoDoPhuHop;
	}

	private double f(double giaTriCuaUser, double giaTriCuaMonAn) {
		return 1 - Math.abs(giaTriCuaUser - giaTriCuaMonAn);
	}

	private List<MonAnChuan> tinhBangQuyetDinh() {
		List<MonAnChuan> bangQuyetDinh = new ArrayList<MonAnChuan>();
		for (MonAnChuan phuongAn : bangQuyetDinh) {
			BoTieuChiChuan boGiaTriR = phuongAn.getBoTieuChiChuan();
			BoTrongSoChuan boTrongSoChuan = userInputChuanHoa.getBoTrongSoChuan();
			double doCay = boGiaTriR.getDoCay() * boTrongSoChuan.getWDoCay();
			double doNgot = boGiaTriR.getDoNgot() * boTrongSoChuan.getWDoNgot();
			double doDinhDuong = boGiaTriR.getDoDinhDuong() * boTrongSoChuan.getWDoDinhDuong();
			double doPhoBien = boGiaTriR.getDoPhoBien() * boTrongSoChuan.getWDoPhoBien();
			double giaTien = boGiaTriR.getGiaTien() * boTrongSoChuan.getWGiaTien();

			BoTieuChiChuan boGiaTri = new BoTieuChiChuan(doCay, doNgot, doDinhDuong, doPhoBien, giaTien);
			MonAnChuan boGiaTriV = new MonAnChuan(phuongAn.getId(), phuongAn.getTen(), boGiaTri);
			bangQuyetDinh.add(boGiaTriV);
		}
		return bangQuyetDinh;
	}

	public void tinhPhuongAnLyTuongTotVaXau() {
		TinhMaxMin tinhMaxMin = new TinhMaxMin(bangQuyetDinh);
		phuongAnLyTuongTot = tinhMaxMin.getPhuongAnLyTuongTot();
		phuongAnLyTuongXau = tinhMaxMin.getPhuongAnLyTuongXau();
	}

	public void tinhKhoangCach() {

	}

	public void tinhDoDoTuongTu() {

	}

}
