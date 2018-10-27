/**
 * imports scanner package.
 */
import java.util.Scanner;
/**
 * class for Solution.
 * @author Priyanka Maladi.
 */
final class Solution {
    /**
     * Constructs the object for Solution class.
     */
    private Solution() {
        //default constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> obj
        = new SeparateChainingHashST<String, Integer>();
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Student student = new Student(tokens[0],
                Integer.parseInt(tokens[1]),
            Double.parseDouble(tokens[2]));
        }
    }
}

/**
 * Class for student.
 */
class Student {
    /**
     * variable studentname of type string.
     */
    private String studentname;
    /**
     * variable rollnum of type int.
     */
    private int rollnum;
    /**
     * variable total of type double.
     */
    private double total;
    /**
     * Constructs the object for Student class.
     *
     * @param      name    The name
     * @param      num     The number
     * @param      tmarks  The tmarks
     */
    Student(final String name, final int num, final double tmarks) {
        this.studentname = name;
        this.rollnum = num;
        this.total = tmarks;
    }
    /**
     * Gets the student name.
     *
     * @return returns The student name.
     */
    public String getStudentName() {
        return this.studentname;
    }
    /**
     * Gets the roll number.
     *
     * @return returns The roll number.
     */
    public int getRollNum() {
        return this.rollnum;
    }
    /**
     * Gets the total.
     *
     * @return returns The total.
     */
    public double getTotal() {
        return this.total;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return returns 1 if this.studentname is gretaer
     * or -1 if that.studentname is gretaer otherwise returns 0.
     */
    public int compareTo(final Student that) {
        return this.getStudentName().compareTo(that.getStudentName());
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getStudentName();
    }
}
