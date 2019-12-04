package com.group.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DoPhoBien {
	IT_PHO_BIEN("Ít phổ biến", 0), PHO_BIEN("Phổ biến", 1), RAT_PHO_BIEN("Rất phổ biến",2);
	
	private final String text;
	private final int value;

	@Override
	public String toString() {
		return text;
	}

}
