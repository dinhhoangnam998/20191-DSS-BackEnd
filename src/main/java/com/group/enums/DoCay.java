package com.group.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DoCay {
	KHONG_CAY("Không cay", 0), HOI_CAY("Hơi cay", 1), CAY("Cay", 2), KHA_CAY("Khá cay", 3), RAT_CAY("Rất Cay", 4);

	private final String text;
	private final int value;

	@Override
	public String toString() {
		return text;
	}

}
