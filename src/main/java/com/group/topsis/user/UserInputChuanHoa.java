package com.group.topsis.user;

import com.group.topsis.BoTieuChiChuan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInputChuanHoa {
	private UserInputData userInputData;
	private BoTieuChiChuan boTieuChiChuan;
	private BoTrongSoChuan boTrongSoChuan;

	public UserInputChuanHoa(UserInputData userInputData) {
		super();
		this.userInputData = userInputData;
		boTieuChiChuan = chuanHoaBoTieuChiUser(userInputData.getBoTieuChi());
		boTrongSoChuan = chuanHoaBoTrongSo(userInputData.getBoTrongSo());
	}

	public BoTieuChiChuan chuanHoaBoTieuChiUser(BoTieuChi btc) {
		double doCay = btc.getDoCay().getValue();
		double doNgot = btc.getDoNgot().getValue();
		double doDinhDuong = btc.getDoDinhDuong().getValue();
		double doPhoBien = btc.getDoPhoBien().getValue();
		double giaTien = btc.getGiaTien().getValue();
		return new BoTieuChiChuan(doCay / 4.0, doNgot / 4.0, doDinhDuong / 2.0, doPhoBien / 2.0, giaTien / 2.0);
	}

	public BoTrongSoChuan chuanHoaBoTrongSo(BoTrongSo bts) {
		int wDoCay = bts.getWDoCay();
		int wDoNgot = bts.getWDoNgot();
		int wDoDinhDuong = bts.getWDoDinhDuong();
		int wDoPhoBien = bts.getWDoPhoBien();
		int wGiaTien = bts.getWGiaTien();
		double sum = wDoCay + wDoNgot + wDoDinhDuong + wDoPhoBien + wGiaTien;
		return new BoTrongSoChuan(wDoCay / sum, wDoNgot / sum, wDoDinhDuong / sum, wDoPhoBien / sum, wGiaTien / sum);
	}

}
