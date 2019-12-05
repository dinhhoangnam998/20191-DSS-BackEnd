package com.group.topsis.user;

import com.group.enums.DoCay;
import com.group.enums.DoDinhDuong;
import com.group.enums.DoNgot;
import com.group.enums.DoPhoBien;
import com.group.enums.GiaTien;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoTrongSoChuan {
	private double wDoCay;
	private double wDoNgot;
	private double wDoDinhDuong;
	private double wDoPhoBien;
	private double wGiaTien;
}
