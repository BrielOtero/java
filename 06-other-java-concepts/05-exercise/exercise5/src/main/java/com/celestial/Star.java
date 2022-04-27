package com.celestial;

public class Star {
	private String name;
	private double radio;

	/**
	 * Sets the value of property Name. Without spaces on extremes and in Uppercase.
	 * 
	 * @param name the value to set in the property name.
	 */
	public void setName(String name) {
		this.name = name.trim().toUpperCase();
	}

	/**
	 * Sets the value of property radio. If it's negative show error.
	 * 
	 * @param radio the value to set in the radio.
	 */
	public void setRadio(double radio) {
		if (radio > 0) {
			this.radio = radio;
		} else {
			throw new NegativeRadioException("Radio is Negative");
		}
	}

	/**
	 * @return the value of the property Name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the value of the property Radio.
	 */
	public double getRadio() {
		return radio;
	}

	/**
	 * Return the value name with an character between letters of name.
	 * 
	 * @param cha the character to set into the name.
	 * @return the name with the characters between letters.
	 */
	public String getName(char cha) {
		String stringToReturn = "";
		for (int i = 0; i < name.length(); i++) {
			if (i == name.length() - 1) {
				stringToReturn = stringToReturn + name.charAt(i);
			} else {
				stringToReturn = stringToReturn + name.charAt(i) + cha;
			}
		}
		return stringToReturn;
	}

	/**
	 * Initialize Star with parameters.
	 * 
	 * @param name  the parameter to initialize Star
	 * @param radio the parameter to initialize Star
	 */
	public Star(String name, double radio) {
		this.name = name;
		this.radio = radio;
	}

	@Override
	/**
	 * If two stars are equals and have the same class return true else return
	 * false.
	 */
	public boolean equals(Object obj) {
		if (this.getClass() == obj.getClass() && this.getName().equals(((Star) obj).getName())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * Return the name of the star a her radio with two decimal.
	 */
	public String toString() {
		return String.format("%s %.2f", getName(), getRadio());
	}

}
