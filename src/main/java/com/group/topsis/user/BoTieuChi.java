package com.group.topsis.user;

import com.group.enums.DoCay;
import com.group.enums.DoDinhDuong;
import com.group.enums.DoNgot;
import com.group.enums.DoPhoBien;
import com.group.enums.GiaTien;
import com.group.topsis.BoTieuChiChuan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoTieuChi {
	private DoCay doCay;
	private DoNgot doNgot;
	private DoDinhDuong doDinhDuong;
	private DoPhoBien doPhoBien;
	private GiaTien giaTien;
}
