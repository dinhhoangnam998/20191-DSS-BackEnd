package com.group.model;

import com.group.model.entity.DiUng;
import com.group.model.entity.QuocGia;
import com.group.model.entity.TheLoai;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoLoc {
	private TheLoai theLoai;
	private QuocGia nguonGoc;
	private DiUng diUng;
	private int giaNhoNhat;
	private int giaLonNhat;

}
