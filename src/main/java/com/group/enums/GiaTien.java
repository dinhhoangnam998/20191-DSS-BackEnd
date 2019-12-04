package com.group.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GiaTien {

	THAP("Thấp", 0), TRUNG_BINH("Trung Bình", 1), CAO("Cao", 2);

	private final String text;
	private int value;

	@Override
	public String toString() {
		return text;
	}

}
