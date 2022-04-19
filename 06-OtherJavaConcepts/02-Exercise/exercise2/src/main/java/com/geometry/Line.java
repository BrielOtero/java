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

import com.iu.Library;

public class Line extends Figure {

	public Point finalPoint = new Point();

	@Override

	/**
	 * Ask the data of the Line.
	 */
	public void askData() {
		super.askData();
		System.out.println();
		System.out.println("Final Point x");
		finalPoint.x = Library.askReal();
		System.out.println("Final Point y");
		finalPoint.y = Library.askReal();
		System.out.println();
	}

	/**
	 * Show the data of the Line.
	 */
	public void showData() {
		super.showData();
		System.out.println();
		System.out.printf("Final Point \"x\"    is %f\n", finalPoint.x);
		System.out.printf("Final Point \"y\"    is %f\n", finalPoint.y);
		System.out.println();
	}

	/**
	 * Initialize Line with two points.
	 * 
	 * @param point1 The first point to initialize.
	 * @param point2 The second point to initialize.
	 */
	public Line() {
		this(new Point(0, 0), new Point(0, 0));

	}

	public Line(Point point1, Point point2) {
		super(point1, "line");

		this.finalPoint = point2;
	}
}
