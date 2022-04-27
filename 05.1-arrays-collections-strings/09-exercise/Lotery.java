import java.util.ArrayList;

public class Lotery {
	private ArrayList<Integer> numbers;

	/**
	 * Sets the value of the property Numbers.
	 * 
	 * @param numbers the array to set in property numbers
	 */
	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}

	/**
	 * Returns the value of the property Numbers
	 * 
	 * @return the arraylist numbers
	 */
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	/**
	 * Clean and fill with 6 different random values between 1 and 49.
	 * 
	 * @param numbers Collection to fill with values.
	 * @return a collection with values.
	 */
	public ArrayList<Integer> fillCol(ArrayList<Integer> numbers) {
		int random;
		if (numbers.size() != 0) {
			numbers.clear();
		}
		for (int i = 0; i < 6; i++) {
			do {
				random = (int) (Math.random() * 49 + 1);
			} while (numbers.contains(random) == true);
			numbers.add(random);
		}
		return numbers;
	}

	/**
	 * Check how many elements of one collection are in the other.
	 * 
	 * @param col1 Collection to compare with another.
	 * @param col2 Another collection to compare with another.
	 * @return the amounts of items that are the same.
	 */
	public int compare(ArrayList<Integer> col1, ArrayList<Integer> col2) {
		int cont = 0;
		for (int i = 0; i < col1.size(); i++) {
			for (int j = 0; j < col2.size(); j++) {
				if (col1.get(i) == col2.get(j)) {
					cont++;
				}
			}
		}
		return cont;
	}
}
