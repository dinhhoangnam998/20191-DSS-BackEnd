package com.group.topsis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.model.MonAn;
import com.group.service.MonAnS;
import com.group.topsis.monan.ChuanHoaMonAn;
import com.group.topsis.monan.MonAnChuan;
import com.group.topsis.monan.TinhPhuongAnLyTuongTotXau;
import com.group.topsis.user.BoLoc;
import com.group.topsis.user.BoTieuChi;
import com.group.topsis.user.BoTrongSo;
import com.group.topsis.user.BoTrongSoChuan;
import com.group.topsis.user.UserInputChuanHoa;
import com.group.topsis.user.UserInputData;
import com.group.utils.Printer;

import lombok.Getter;

@Service
@Getter
public class TOPSIS {
	private UserInputData userInputData;
	private UserInputChuanHoa userInputChuanHoa;

	private List<MonAn> ketQuaLocMonAn;
	private List<MonAnChuan> monAnDaChuanHoa;

	private List<PhuongAn> bangGiaTriR;
	private List<PhuongAn> bangGiaTriV;

	private PhuongAn phuongAnLyTuongTot;
	private PhuongAn phuongAnLyTuongXau;

	private List<PhuongAn> khoangCachToiPhuongAnLyTuongTot;
	private List<PhuongAn> khoangCachToiPhuongAnLyTuongXau;

	private List<PhuongAn> doDoTuongTu;
	private List<MonAn> ketQuaCuoiCung;

	@Autowired
	private MonAnS maS;

	public void setup(BoLoc boLoc, BoTieuChi boTieuChi, BoTrongSo boTrongSo) {
		userInputData = new UserInputData(boLoc, boTieuChi, boTrongSo);
		userInputChuanHoa = new UserInputChuanHoa(userInputData);
		ketQuaLocMonAn = maS.locMonAn(boLoc);
		monAnDaChuanHoa = new ChuanHoaMonAn(ketQuaLocMonAn).getMonAnsDaChuanHoa();
		bangGiaTriR = tinhBangGiaTriR();
		bangGiaTriV = tinhBangGiaTriV();
		tinhPhuongAnLyTuongTotVaXau();
		tinhToanSAndC();
		tinhKetQuaCuoiCung();
	}

	private List<PhuongAn> tinhBangGiaTriR() {
		BoTieuChiChuan btccOfUser = userInputChuanHoa.getBoTieuChiChuan();
		List<PhuongAn> bangGiaTriR = new ArrayList<>();
		for (MonAnChuan mac : monAnDaChuanHoa) {
			BoTieuChiChuan btccOfMonAn = mac.getBoTieuChiChuan();
			double doPhuHopCay = f(btccOfMonAn.getDoCay(), btccOfUser.getDoCay());
			double doPhuHopNgot = f(btccOfMonAn.getDoNgot(), btccOfUser.getDoNgot());
			double doPhuHopDinhDuong = f(btccOfMonAn.getDoDinhDuong(), btccOfUser.getDoDinhDuong());
			double doPhuHopPhoBien = f(btccOfMonAn.getDoPhoBien(), btccOfUser.getDoPhoBien());
			double doPhuHopGiaTien = f(btccOfMonAn.getGiaTien(), btccOfMonAn.getGiaTien());

			BoTieuChiChuan boDoDoPhuHop = new BoTieuChiChuan(doPhuHopCay, doPhuHopNgot, doPhuHopDinhDuong,
					doPhuHopPhoBien, doPhuHopGiaTien);
			PhuongAn phuongAn = new PhuongAn(mac.getId(), mac.getTen(), boDoDoPhuHop);
			bangGiaTriR.add(phuongAn);
		}
		return bangGiaTriR;
	}

	private double f(double giaTriCuaUser, double giaTriCuaMonAn) {
		return 1 - Math.abs(giaTriCuaUser - giaTriCuaMonAn);
	}

	private List<PhuongAn> tinhBangGiaTriV() {
		List<PhuongAn> bangGiaTriV = new ArrayList<>();
		BoTrongSoChuan boTrongSoChuan = userInputChuanHoa.getBoTrongSoChuan();
		for (PhuongAn phuongAn : bangGiaTriR) {
			BoTieuChiChuan boDoDoPhuHop = phuongAn.getBoTieuChiChuan();
			double doCayV = boDoDoPhuHop.getDoCay() * boTrongSoChuan.getWDoCay();
			double doNgotV = boDoDoPhuHop.getDoNgot() * boTrongSoChuan.getWDoNgot();
			double doDinhDuongV = boDoDoPhuHop.getDoDinhDuong() * boTrongSoChuan.getWDoDinhDuong();
			double doPhoBienV = boDoDoPhuHop.getDoPhoBien() * boTrongSoChuan.getWDoPhoBien();
			double giaTienV = boDoDoPhuHop.getGiaTien() * boTrongSoChuan.getWGiaTien();

			BoTieuChiChuan boGiaTriV = new BoTieuChiChuan(doCayV, doNgotV, doDinhDuongV, doPhoBienV, giaTienV);
			PhuongAn phuongAnQD = new PhuongAn(phuongAn.getId(), phuongAn.getTen(), boGiaTriV);
			bangGiaTriV.add(phuongAnQD);
		}
		return bangGiaTriV;
	}

	public void tinhPhuongAnLyTuongTotVaXau() {
		TinhPhuongAnLyTuongTotXau tinhMaxMin = new TinhPhuongAnLyTuongTotXau(bangGiaTriV);
		phuongAnLyTuongTot = tinhMaxMin.getPhuongAnLyTuongTot();
		phuongAnLyTuongXau = tinhMaxMin.getPhuongAnLyTuongXau();
	}

	public void tinhToanSAndC() {
		for (PhuongAn pa : bangGiaTriV) {
			pa.setSTot(tinhKhoangCach(pa, phuongAnLyTuongTot));
			pa.setSXau(tinhKhoangCach(pa, phuongAnLyTuongXau));
			pa.setC(tinhC(pa));
		}
	}

	public double tinhKhoangCach(PhuongAn pa, PhuongAn pa2) {
		BoTieuChiChuan btccPa2 = pa2.getBoTieuChiChuan();
		BoTieuChiChuan btccPa = pa.getBoTieuChiChuan();
		double v1 = btccPa.getDoCay() - btccPa2.getDoCay();
		double v2 = btccPa.getDoNgot() - btccPa2.getDoNgot();
		double v3 = btccPa.getDoDinhDuong() - btccPa2.getDoDinhDuong();
		double v4 = btccPa.getGiaTien() - btccPa2.getGiaTien();
		double S = Math.sqrt(v1 * v1 + v2 * v2 + v3 * v3 + v4 * v4);
		return S;
	}

	public double tinhC(PhuongAn pa) {
		return pa.getSXau() / (pa.getSTot() + pa.getSXau());
	}

	public void tinhKetQuaCuoiCung() {
		List<PhuongAn> copyBangGiaTriV = bangGiaTriV.stream().collect(Collectors.toList());
		ketQuaCuoiCung = copyBangGiaTriV.stream().sorted(Comparator.comparing(PhuongAn::getC))
				.map(i -> maS.maR.getOne(i.getId())).collect(Collectors.toList());

	}
}
