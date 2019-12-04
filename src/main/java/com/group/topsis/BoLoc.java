package com.group.topsis;

import com.group.model.DiUng;
import com.group.model.QuocGia;
import com.group.model.TheLoai;

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
