import java.util.ArrayList;

public class Dni {
	/**
	 * Calculates the letter of a DNI number and check that the value is correct.
	 * 
	 * @param dni the string with the numbers of the DNI.
	 * @return The letter of the dni or "*" if the value is incorrect.
	 */
	public char letter(String dni) {
		int rest;
		String lettersDni;
		boolean check = true;

		if (dni.length() == 8 || dni.length() == 10 && dni.charAt(2) == '.' && dni.charAt(6) == '.'
				&& dni.charAt(0) != '.' && dni.charAt(1) != '.' && dni.charAt(3) != '.' && dni.charAt(4) != '.'
				&& dni.charAt(5) != '.' && dni.charAt(7) != '.' && dni.charAt(8) != '.' && dni.charAt(9) != '.') {
			for (int i = 0; i < dni.length(); i++) {
				if (dni.charAt(i) >= '0' && dni.charAt(i) <= '9' || dni.charAt(i) == '.') {
				} else {
					check = false;
				}
			}

			if (check) {
				if (dni.charAt(2) == '.' && dni.charAt(6) == '.') {

					dni = dni.replace(".", "");
				}
				rest = Integer.parseInt(dni);
				rest = rest % 23;
				lettersDni = "TRWAGMYFPDXBNJZSQVHLCKE";

				return lettersDni.charAt(rest);
			} else {
				return '*';
			}
		} else {
			return '*';
		}

	}

}
