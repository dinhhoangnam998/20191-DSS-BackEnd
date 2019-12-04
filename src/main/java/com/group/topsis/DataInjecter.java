package com.group.topsis;

import java.util.List;

import org.springframework.stereotype.Component;

import com.group.model.DiUng;
import com.group.model.QuocGia;
import com.group.model.TheLoai;

import lombok.Getter;

@Component
@Getter
public class DataInjecter {

	private List<TheLoai> theLoais;
	private List<QuocGia> nguonGocs;
	private List<DiUng> diUngs;
	private List<Integer> mucGias;
}
