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

import java.util.Scanner;

public class Polygon extends Figure {
	public Point[] points;

	/**
	 * Initialize Polygon with an Triangle with three points.
	 */
	public Polygon() {
		this("TRIANGLE", new Point(), 3);
		this.points[0] = new Point(1, 2);
		this.points[1] = new Point(1, 2);
		this.points[2] = new Point(1, 2);

	}

	/**
	 * Initialize Polygon with values for name , and point for origin and the length
	 * for array.
	 * 
	 * @param name        The value for name.
	 * @param origin      The value for origin point.
	 * @param arrayLength The value for the length of the array.
	 */
	public Polygon(String name, Point origin, int arrayLength) {
		this.setName(name);
		super.origin = origin;
		this.points = new Point[arrayLength];

		for (int i = 0; i < points.length; i++) {
			this.points[i] = new Point(1, 1);
		}
	}

	@Override

	/**
	 * Ask for the data of the Polygon.
	 */
	public void askData() {
		Scanner sc = new Scanner(System.in);
		int amountOfPoints;
		double value;

		super.askData();
		System.out.println("How many points you want?");
		amountOfPoints = sc.nextInt();

		points = new Point[amountOfPoints];

		for (int i = 0; i < points.length; i++) {
			System.out.printf("Introduce the value for x at position %2d: \n", i);
			System.out.print("--> ");
			value = sc.nextDouble();
			points[i].x = value;
			sc.nextLine();
			System.out.println();

			System.out.printf("Introduce the value for x at position %2d: \n", i);
			System.out.print("--> ");
			value = sc.nextDouble();
			points[i].y = value;
			sc.nextLine();
			System.out.println();
		}
	}

	/**
	 * Show the data of the Polygon.
	 */
	public void showData() {
		super.showData();
		System.out.printf("The Polygons has %2d points\n", points.length);

		for (int i = 0; i < points.length; i++) {
			System.out.printf("The value for X: %3.0f | Y: %3.0f at position %2d\n", points[i].x, points[i].y, i);
		}

	}

}
