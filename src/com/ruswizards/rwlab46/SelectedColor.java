/**
 * Copyright (C) 2014 Rus Wizards 
 */
package com.ruswizards.rwlab46;

/**
 * Enum for color codes
 * 
 * @author vfarafonov
 * 
 */
public enum SelectedColor {
	RED(1), GREEN(2), BLUE(3), YELLOW(4);

	private final int code_;

	SelectedColor(int color) {
		this.code_ = color;
	}

	/**
	 * Returns color code for enum
	 * 
	 * @return The color code
	 */
	public int getCode() {
		return code_;
	}
}
