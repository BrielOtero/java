package exercise;

public class Format {

	
	private String centerString(String text, int len) {
		len = len - 4;
		if (len <= text.length()) {
			return text.substring(0, len);
		}

		int before = (len - text.length()) / 2;

		if (before == 0) {
			return String.format("%-" + len + "s", text);
		}

		int rest = len - before;

		return String.format("| %" + before + "s%-" + rest + "s |", "", text);
	}

	public void printString(String text, int len) {
		System.out.println(centerString(text, len));
	}

	private String line(int len) {
		String separator = "-";
		String line = "";

		for (int i = 0; i < len; i++) {
			if (i == 0 || i == len - 1) {
				line += "+";
			} else {
				line += separator;
			}
		}
		return line;
	}

	public void printLine(int len) {
		System.out.println(line(len));
	}

	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
