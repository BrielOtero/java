public class Classroom {
	private int[][] notes;
	private String[] students;
	private String[] subjects;

	/**
	 * Sets the value of the property notes.
	 * @param valueSubject the value from subject.
	 * @param valueStudent the value from student.
	 * @param valueNote the value from notes.
	 */
	public void setNotes(int valueSubject, int valueStudent, int valueNote) {
		this.notes[valueSubject][valueStudent] = valueNote;
	}

	/**
	 * Returns the value of the property Notes.
	 * @return the notes.
	 */
	public int[][] getNotes() {
		return notes;
	}

	/**
	 * Returns the value of the property Students.
	 * @return the students.
	 */
	public String[] getStudents() {
		return students;
	}

	/**
	 * Returns the value of the property Subjects.
	 * @return the subjects.
	 */
	public String[] getSubjects() {
		return subjects;
	}

	/**
	 * Initialize classroom with random notes, students and subjects. 
	 */
	public Classroom() {
		int[][] notes = new int[4][15];
		String[] students = { "Andres", "Cristiano", "Gerard", "Mario", "Ana", "Enzo", "Eva", "Erika", "Hugo", "Juan",
				"Lara", "Ivan", "Luz", "Nora", "Ulises" };
		String[] subjects = { "Program", "Database", "Marcas", "Systems" };

		int numRandom;

		for (int i = 0; i < notes.length; i++) {
			for (int j = 0; j < notes[i].length; j++) {
				numRandom = (int) (Math.random() * 101 + 0);

				if (numRandom <= 14) {
					notes[i][j] = (int) (Math.random() * 3 + 0); // 0,1,2
				} else if (numRandom >= 15 && numRandom <= 24) {
					notes[i][j] = 3; // 3
				} else if (numRandom >= 25 && numRandom <= 69) {
					notes[i][j] = (int) (Math.random() * 3 + 4); // 4,5,6
				} else if (numRandom >= 70 && numRandom <= 90) {
					notes[i][j] = (int) (Math.random() * 2 + 7); // 7,8
				} else if (numRandom > 90) {
					notes[i][j] = (int) (Math.random() * 2 + 9); // 9,10
				}
			}
		}
		this.notes = notes;
		this.students = students;
		this.subjects = subjects;
	}
	/**
	 * Initialize classroom with three arrays.
	 * @param rowsNotes the the rows notes.
	 * @param columnsNotes the columns notes.
	 * @param sizeStudents the size of array students.
	 * @param sizeSubjects the size of array subjects.
	 */
	public Classroom(int rowsNotes, int columnsNotes, int sizeStudents, int sizeSubjects) {
		int[][] notes = new int[rowsNotes][columnsNotes];
		String[] students = new String[sizeStudents];
		String[] subjects = new String[sizeSubjects];

		this.notes = notes;
		this.students = students;
		this.subjects = subjects;
	}

	/**
	 * Calculates the average of notes.
	 * 
	 * @param notes the matrix with the notes to calculate the average.
	 * @return the average.
	 */
	public int averageNotes() {
		int total = 0;
		int cont = 0;
		for (int[] sub : notes) {
			for (int is : sub) {
				total = total + is;
			}
		}
		return total / notes[0].length;
	}

	/**
	 * Calculates the average of notes of one student.
	 * 
	 * @param notes   the matrix withe the notes.
	 * @param student the student to calculate the average.
	 * @return the average of the student.
	 */
	public int averageStudents(int student) {
		int total = 0;
		int cont = 0;
		for (int i = 0; i < notes.length; i++) {
			total = total + notes[i][student];
		}
		return total / notes.length;
	}

	/**
	 * Calculates the average of notes of one subject.
	 * 
	 * @param notes   the matrix with the notes.
	 * @param subject the subject to calculate the average.
	 * @return the average of the subject.
	 */
	public int averageSubjects(int subject) {
		int total = 0;
		int cont = 0;
		for (int i = 0; i < notes[subject].length; i++) {
			total = total + notes[subject][i];
		}
		return total / notes.length;
	}

	/**
	 * Calculates the maximum note of one subject.
	 * 
	 * @param notes   the matrix with the notes.
	 * @param subject the subject to calculates the maximun value.
	 * @return the maximun value of notes of one subject.
	 */
	public int maxSubject(int subject) {
		int max = 0;
		for (int i = 0; i < notes[subject].length; i++) {
			if (notes[subject][i] > max) {
				max = notes[subject][i];
			}
		}
		return max;
	}

	/**
	 * Calculates the minimum note of one subject.
	 * 
	 * @param notes   the matrix with the notes.
	 * @param subject the subject to calculates the minimum value.
	 * @return the minimum value of notes of one subject.
	 */
	public int minSubject(int subject) {
		int min = 11;
		for (int i = 0; i < notes[subject].length; i++) {
			if (notes[subject][i] < min) {
				min = notes[subject][i];
			}
		}
		return min;
	}
}
