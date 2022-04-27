package com.celestial;


import java.util.ArrayList;

public class Planet extends Star {
	private boolean gaseous;
	public ArrayList<Star> satellites;

	/**
	 * Sets the value of the property gaseous;
	 * 
	 * @param gaseous the value to set in the property gaseous;
	 */
	public void setGaseous(boolean gaseous) {
		this.gaseous = gaseous;
	}

	/**
	 * @return the value of the property gaseous;
	 */
	public boolean getGaseous() {
		return this.gaseous;
	}

	/**
	 * Initialize Planet with basic values.
	 */
	public Planet() {
		this("", 0, false);
	}

	/**
	 * Initialize Planet with parameters.
	 * 
	 * @param name    the value for initialize name.
	 * @param radio   the value for initialize radio.
	 * @param gaseous the value for initialize gaseous.
	 */
	public Planet(String name, double radio, boolean gaseous) {
		super(name, radio);
		this.gaseous = gaseous;
		this.satellites = new ArrayList<>();
	}
}
