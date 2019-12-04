package com.group.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DoDinhDuong {

	CAO("Cao", 2), TRUNG_BINH("Trung Bình", 1), THAP("Thấp", 0);

	private final String text;
	private final int value;

	@Override
	public String toString() {
		return text;
	}

}
