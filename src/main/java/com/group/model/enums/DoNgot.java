package com.group.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DoNgot {
	KHONG_NGOT("Không ngọt", 0), HOI_NGOT("Hơi ngọt", 1), NGOT("Cay", 2), KHA_NGOT("Khá ngọt", 3),
	RAT_NGOT("Rất Cay", 4);

	private final String text;
	private final int value;

	@Override
	public String toString() {
		return text;
	}

}
