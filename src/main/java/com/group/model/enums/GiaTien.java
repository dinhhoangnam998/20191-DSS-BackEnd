package com.group.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GiaTien {

	CAO("Cao", 2), TRUNG_BINH("Trung Bình", 1), THAP("Thấp", 0);

	private final String text;
	private int value;

	@Override
	public String toString() {
		return text;
	}

}
