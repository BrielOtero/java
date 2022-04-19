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
package com.exercise;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class TextBox extends JFrame implements ActionListener {
	JLabel lbl1;
	JLabel lbl2;

	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JTextField txt4;
	JTextField txt5;

	public TextBox() {
		super("Cajas de edición de texto");
		this.setLayout(new FlowLayout());

		lbl1 = new JLabel("Introduzca su DNI");
		add(lbl1);

		txt1 = new JTextField(9);
		txt1.addActionListener(this);
		add(txt1);

		txt2 = new JTextField("Programacion");
		txt2.addActionListener(this);
		add(txt2);

		txt3 = new JTextField("Información no editable", 23);
		txt3.setEditable(false);
		txt3.addActionListener(this);
		add(txt3);

		txt4 = new JTextField(2);
		txt4.addActionListener(this);
		add(txt4);

		txt5 = new JTextField(2);
		txt5.addActionListener(this);
		add(txt5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int value1=0;
		int value2=0;
		if (e.getSource() == txt5) {
			try {
					value1 = Integer.parseInt(txt4.getText());
					value2 = Integer.parseInt(txt5.getText());
					
					if(value1>txt2.getText().length() || value2>txt2.getText().length() || value2<value1){
						JOptionPane.showMessageDialog(null, "Fuera de indice", "Error", JOptionPane.INFORMATION_MESSAGE);
					} else {
						txt2.select(value1, value2);
					}
			} catch (java.lang.NumberFormatException p) {
				JOptionPane.showMessageDialog(null, "Introduce sólo numeros", "Error", JOptionPane.INFORMATION_MESSAGE);
			}

		}
		if (e.getSource() == txt1 || e.getSource() == txt3) {
			((JTextField) e.getSource()).selectAll();
			
			JOptionPane.showMessageDialog(null,
					((JTextField) e.getSource()).getSelectedText(),
					"Cajas de Texto", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
