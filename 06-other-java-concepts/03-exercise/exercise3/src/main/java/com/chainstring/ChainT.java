package com.chainString;

import java.util.ArrayList;

public class ChainT {
	private ArrayList<Character> charList = new ArrayList<>();

	/**
	 * Checks if it has spaces at the ends and if it does it removes them.
	 * 
	 * @param textToCheck the string to check.
	 * @return the string without spaces.
	 */
	public String checkSpaces(String textToCheck) {
		String textToReturnLeft = "";
		String textToReturnFinal = "";
		boolean noSpaces = false;

		for (int i = 0; i < textToCheck.length(); i++) {
			if (textToCheck.charAt(i) != ' ' || noSpaces) {
				textToReturnLeft = textToReturnLeft + textToCheck.charAt(i);
				noSpaces = true;
			}
		}

		noSpaces = false;

		for (int i = textToReturnLeft.length() - 1; i >= 0; i--) {
			if (textToReturnLeft.charAt(i) != ' ' || noSpaces) {
				textToReturnFinal = textToReturnLeft.charAt(i) + textToReturnFinal;
				noSpaces = true;
			}
		}
		return textToReturnFinal;
	}

	/**
	 * Set the letters of an string into the arrayList charList.
	 * 
	 * @param text the string to add into the arrayList.
	 */
	public void setString(String text) {
		String textOutSpaces = checkSpaces(text);
		for (int i = 0; i < textOutSpaces.length(); i++) {
			charList.add(textOutSpaces.charAt(i));
		}
	}

	@Override
	/**
	 * Convert the charList to String.
	 */
	public String toString() {
		String textToReturn = "";
		for (int j = 0; j < charList.size(); j++) {
			textToReturn = textToReturn + charList.get(j);
		}
		return textToReturn;
	}

	/**
	 * Override equals(Object) so that it returns true if the object of type String
	 * being
	 * passed as a parameter contains the same characters as that of the class. As
	 * well
	 * will accept a String object or a vector of char as a parameter.
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj != null) {

			if (obj.getClass() == ChainT.class) {
				String string1 = this.charList.toString();
				String string2 = ((ChainT) obj).toString();

				if (string1.length() != string2.length()) {
					return false;
				}

				for (int i = 0; i < string1.length(); i++) {
					if (string1.charAt(i) != string2.charAt(i)) {
						return false;
					}
				}
				return true;

			} else {
				if (obj.getClass() == String.class) {
					if (this.charList.size() != ((String) obj).length()) {
						return false;
					}

					for (int i = 0; i < charList.size(); i++) {
						if (this.charList.get(i) != ((String) obj).charAt(i)) {
							return false;
						}
					}
					return true;

				} else {
					if (obj.getClass() == char[].class) {

						if (this.charList.size() != ((char[]) obj).length) {
							return false;
						}

						for (int i = 0; i < charList.size(); i++) {
							if (this.charList.get(i) != ((char[]) obj)[i]) {
								return false;
							}
						}
						return true;

					} else {
						throw new IllegalArgumentException();
					}
				}
			}

		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Delete the time that character appears into String.
	 * 
	 * @param cha the character to search into the String and delete.
	 * @return the string without the character.
	 */
	public int delete(char cha) {
		int cont = 0;

		for (int i = 0; i < this.charList.size(); i++) {

			if (this.charList.get(i) == cha) {
				this.charList.remove(i);
				i--;
				cont++;
			}
		}
		return cont;
	}
}
