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
