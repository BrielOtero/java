/*-
 * =====LICENSE-START=====
 * Java 11 Application
 * ------
 * Copyright (C) 2020 - 2022 Organization Name
 * ------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * =====LICENSE-END=====
 */
package com.geometry;

import java.util.*;
import com.iu.*;

public class Figure implements IUInterface {
	public Point origin = new Point();
	private String name;

	/**
	 * Sets the value of the property name in Uppercase and without the spaces from
	 * extremes.
	 * 
	 * @param name the value from name.
	 */
	public void setName(String name) {
		this.name = name.toUpperCase().trim();
	}

	/**
	 * Gets the value of the property for name and return it.
	 * 
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Initialize Figure with origin at 0,0 and name "".
	 */
	public Figure() {
		this(0, 0, "");
	}

	/**
	 * Initialize Figure with a value for x, y and name.
	 * 
	 * @param x    value for x.
	 * @param y    value for y.
	 * @param name value for name.
	 */
	public Figure(double x, double y, String name) {
		origin.x = x;
		origin.y = y;
		setName(name);
	}

	/**
	 * Initialize Figure with a point and a name.
	 * 
	 * @param point value for point.
	 * @param name  value for name.
	 */
	public Figure(Point point, String name) {
		origin = point;
		setName(name);
	}

	@Override

	/**
	 * Ask for the data of the figure.
	 */
	public void askData() {
		Scanner sc = new Scanner(System.in);
		String name;

		System.out.println();
		System.out.println("Origin Point x");
		origin.x = Library.askInt();
		System.out.println("Origin Point y");
		origin.y = Library.askInt();
		System.out.println();

		System.out.println("Introduce a value for name");
		System.out.print("--> ");
		name = sc.nextLine();
		System.out.println();

		setName(name);
	}

	@Override
	/**
	 * Show the data of the figure.
	 */
	public void showData() {
		System.out.println();
		System.out.printf("Origin      \"x\"    is %f\n", origin.x);
		System.out.printf("Origin      \"y\"    is %f\n", origin.y);
		System.out.printf("Origin      \"name\" is %s\n", this.name);
		System.out.println();
	}

}
