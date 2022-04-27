import java.util.*;

public class Menu {

    /**
     * Clean the screen.
     */
    public void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Shorten an String
     * 
     * @param text the String to be shorter
     * @return the original String cutted
     */
    public static String shorten(String text) {
        if (text.length() > 8) {
            return text.substring(0, 7) + ".";
        } else {
            return text;
        }
    }

    /**
     * A menu for the user select an value and check that's is in the lenght.
     * 
     * @param typeValue the type of the value to show for the user.
     * @param extension the lenght of array.
     * @return a number with the selected number.
     */
    public int select(String typeValue, int extension) {
        Scanner sc = new Scanner(System.in);
        int position;
        boolean error = false;
        do {
            if (error) {
                System.out.println("+---------------------------------------------+");
                System.out.println("|       Please select a correct value         |");
                System.out.println("+---------------------------------------------+");
                System.out.println();
            }
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.printf("|        Select the number of %-9s       |\n", typeValue);
            System.out.println("+---------------------------------------------+");
            System.out.println();
            System.out.print("--> ");
            position = sc.nextInt();
            sc.nextLine();
            error = true;
        } while (position >= extension ||position<0);

        return position;

    }

    /**
     * Show all the Students, Subjects and notes.
     */
    public void table() {
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
        System.out.print("|          | ");
        for (int i = 0; i < classroom.getStudents().length; i++) {
            System.out.printf("%-8s | ", shorten(classroom.getStudents()[i]));
        }
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
        for (int i = 0; i < classroom.getNotes().length; i++) {
            System.out.printf("| %-8s |", shorten(classroom.getSubjects()[i]));
            for (int j = 0; j < classroom.getNotes()[i].length; j++) {
                System.out.printf(" %-8d |", classroom.getNotes()[i][j]);
            }
            System.out.println();
            System.out.println(
                    "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
        }
        System.out.println();
    }

    /**
     * Show the average of Notes.
     */
    public void notesAverage() {
        System.out.println();
        System.out.println("+---------------------------------+");
        System.out.printf("| The average of the notes is: %2d |\n", classroom.averageNotes());
        System.out.println("+---------------------------------+");
        System.out.println();
    }

    /**
     * Show the list of all Students with her number.
     */
    public void students() {
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
        System.out.print("| ");
        for (int i = 0; i < classroom.getStudents().length; i++) {
            System.out.printf("%-8s | ", shorten(classroom.getStudents()[i]));
        }
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
        System.out.print("| ");
        for (int i = 0; i < classroom.getStudents().length; i++) {
            System.out.printf("%-8d | ", i);
        }
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
    }

    /**
     * Show the list of all Subjects with her number.
     */
    public void subjects() {
        System.out.println();
        System.out.println("+----------+----------+----------+----------+");
        System.out.print("| ");
        for (int i = 0; i < classroom.getSubjects().length; i++) {
            System.out.printf("%-8s | ", shorten(classroom.getSubjects()[i]));
        }
        System.out.println();
        System.out.println("+----------+----------+----------+----------+");

        System.out.print("| ");
        for (int i = 0; i < classroom.getSubjects().length; i++) {
            System.out.printf("%-8d | ", i);
        }
        System.out.println();
        System.out.println("+----------+----------+----------+----------+");

    }

    /**
     * Show a student's notes.
     * 
     * @param position the number of a student.
     */
    public void studentNotes(int position) {
        System.out.println();
        System.out.println("+----------+----------+");
        System.out.print("|          | ");
        System.out.printf("%-8s | ", shorten(classroom.getStudents()[position]));
        System.out.println();

        System.out.println("+----------+----------+");
        for (int i = 0; i < classroom.getNotes().length; i++) {
            System.out.printf("| %-8s |", shorten(classroom.getSubjects()[i]));
            System.out.printf(" %8d |", classroom.getNotes()[i][position]);
            System.out.println();
            System.out.println("+----------+----------+");
        }
        System.out.println();
    }

    /**
     * Show a subject's notes.
     * 
     * @param position the number of a subject.
     */
    public void subjectNotes(int position) {
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
        System.out.print("|          | ");
        for (int i = 0; i < classroom.getStudents().length; i++) {
            System.out.printf("%-8s | ", shorten(classroom.getStudents()[i]));
        }
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");

        System.out.printf("| %-8s |", shorten(classroom.getSubjects()[position]));
        for (int j = 0; j < classroom.getNotes()[position].length; j++) {
            System.out.printf(" %-8d |", classroom.getNotes()[position][j]);
        }
        System.out.println();
        System.out.println(
                "+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+");
        System.out.println();
    }

    /**
     * Formats the averages.
     * 
     * @param value     the average to show.
     * @param typeValue initial text to show.
     * @param nameValue name for the value.
     */
    public void avgFormat(int value, String typeValue, String nameValue) {
        System.out.println();
        System.out.println("+---------------------------------------------+");
        System.out.printf("|        %15s %-8s", typeValue, shorten(nameValue));
        System.out.printf(" is %2d       |\n", value);
        System.out.println("+---------------------------------------------+");
        System.out.println();
    }

    /**
     * Show the minimum and maximum note of a subject.
     * 
     * @param position the number of subject.
     */
    public void minMax(int position) {
        System.out.println();
        System.out.println("+----------+----------+----------+");
        System.out.println("|          | Minimun  | Maximum  |");
        System.out.println("+----------+----------+----------+");
        System.out.printf("| %-8s | %-8d | %-8d |\n", classroom.getSubjects()[position],
                classroom.minSubject(position),
                classroom.maxSubject(position));
        System.out.println("+----------+----------+----------+");
        System.out.println();

    }

    /**
     * Replace an note from an Student/Subject
     */
    public void replace() {
        Scanner sc = new Scanner(System.in);

        int valueNote;
        boolean error = false;

        students();
        int valueStudent = select("Student", classroom.getStudents().length);
        subjects();
        int valueSubject = select("Subject", classroom.getSubjects().length);

        do {
            if (error) {
                System.out.println("+---------------------------------------------+");
                System.out.println("|       Please select a correct value         |");
                System.out.println("+---------------------------------------------+");
                System.out.println();
            }
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.printf("|   Enter the new %-8s note for %-8s  |\n",
                    shorten(classroom.getSubjects()[valueSubject]), shorten(classroom.getStudents()[valueStudent]));
            System.out.println("+---------------------------------------------+");
            System.out.println();
            System.out.print("--> ");
            valueNote = sc.nextInt();
            error = true;
        } while (valueNote > 10 || valueNote < 0);
        classroom.setNotes(valueSubject, valueStudent, valueNote);

        System.out.println();
        System.out.println("+---------------------------------------------+");
        System.out.printf("|   Nice! Now %-8s has an %-2d on %-8s  |\n", shorten(classroom.getStudents()[valueStudent]),
                valueNote, shorten(classroom.getSubjects()[valueSubject]));
        System.out.println("+---------------------------------------------+");
        System.out.println();

    }

    Classroom classroom = new Classroom();

    /**
     * An menu with all the options to manage classroom.
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);

        int menu;
        int position;
        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Choose an option               |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  1. See table of notes                      |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  2. View a student's notes                  |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  3. View notes for a subject                |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  4. Calculate the global grade average      |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  5. Average of a student                    |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  6. Average of a subject                    |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  7. Maximum and minimum mark of a subject   |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  8. Modification of a note                  |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  9. Exit                                    |");
            System.out.println("+---------------------------------------------+");
            System.out.println();
            System.out.print("--> ");

            menu = sc.nextInt();

            sc.nextLine();

            switch (menu) {

                case 1:
                    clean();
                    table();
                    break;
                case 2:
                    clean();
                    students();
                    studentNotes(select("Student", classroom.getStudents().length));
                    break;
                case 3:
                    clean();
                    subjects();
                    subjectNotes(select("Subject", classroom.getSubjects().length));
                    break;
                case 4:
                    clean();
                    notesAverage();
                    break;
                case 5:
                    clean();
                    students();
                    position = select("Student", classroom.getStudents().length);
                    avgFormat(classroom.averageStudents(position), "The average for",
                            classroom.getStudents()[position]);
                    break;
                case 6:
                    clean();
                    subjects();
                    position = select("Subject", classroom.getSubjects().length);
                    avgFormat(classroom.averageSubjects(position), "The average for",
                            classroom.getSubjects()[position]);
                    break;
                case 7:
                    clean();
                    subjects();
                    position = select("Subject", classroom.getSubjects().length);
                    minMax(position);
                    break;
                case 8:
                    clean();
                    replace();
                    break;
                case 9:
                    break;
                default:
                    System.out.println();
                    System.out.println("+---------------------------------------------+");
                    System.out.println("|               Invalid Option                |");
                    System.out.println("+---------------------------------------------+");
                    System.out.println();
                    break;
            }
        } while (menu != 9);
    }
}
