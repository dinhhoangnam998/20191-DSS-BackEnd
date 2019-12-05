package com.group.topsis.user;

import com.group.topsis.BoTieuChiChuan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInputChuanHoa {
	private UserInputData userInputData;
	private BoTieuChiChuan boTieuChiChuan;
	private BoTrongSoChuan boTrongSoChuan;

	public UserInputChuanHoa(UserInputData userInputData) {
		super();
		this.userInputData = userInputData;
		boTieuChiChuan = userInputData.getBoTieuChi().getBoTieuChiChuanForUser();
		boTrongSoChuan = userInputData.getBoTrongSo().getBoTrongSoChuan();
	}

}
