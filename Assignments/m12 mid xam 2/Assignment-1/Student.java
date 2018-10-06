class Student implements Comparable<Student> {
	private String studentname;
	private int dateofbirth;
	private int s1;
	private int s2;
	private int s3;
	private int total;
	private String reserved;
	private String unreserved;

	Student(final String name, final int birth, final int sub1,
		final int sub2, final int sub3, final int tot, final String rese,
		final String unrese) {
		this.studentname = name;
		this.dateofbirth = birth;
		this.s1 = sub1;
		this.s2 = sub2;
		this.s3 = sub3;
		this.total = tot;
		this.reserved = rese;
		this.unreserved = unrese;
	}

	/**
	 * Gets the student name.
	 *
	 * @return     The student name.
	 */
	public String getStudentName() {
		return this.studentname;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return     The date of birth.
	 */
	public int getDateOfBirth() {
		return this.dateofbirth;
	}

	/**
	 * Gets the s 1.
	 *
	 * @return     The s 1.
	 */
	public int getS1() {
		return this.s1;
	}

	/**
	 * Gets the s 2.
	 *
	 * @return     The s 2.
	 */
	public int getS2() {
		return this.s2;
	}

	/**
	 * Gets the s 3.
	 *
	 * @return     The s 3.
	 */
	public int getS3() {
		return this.s3;
	}

	/**
	 * Gets the total.
	 *
	 * @return     The total.
	 */
	public int getTotal() {
		return this.total;
	}

	/**
	 * Gets the reserved.
	 *
	 * @return     The reserved.
	 */
	public String getReserved() {
		return this.reserved;
	}

	/**
	 * Gets the un reserved.
	 *
	 * @return     The un reserved.
	 */
	public String getUnReserved() {
		return this.unreserved;
	}

	/**
	 * Sets the student name.
	 *
	 * @param      name  The name
	 */
	public void setStudentName( final String name) {
		this.studentname = name;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param      birth  The birth
	 */
	public void setDateOfBirth( final int birth) {
		this.dateofbirth = birth;
	}

	/**
	 * Sets the s 1.
	 *
	 * @param      sub1  The sub 1
	 */
	public void setS1( final int sub1) {
		this.s1 = sub1;
	}

	/**
	 * Sets the s 2.
	 *
	 * @param      sub2  The sub 2
	 */
	public void setS2( final int sub2) {
		this.s2 = sub2;
	}

	/**
	 * Sets the s 3.
	 *
	 * @param      sub3  The sub 3
	 */
	public void setS3( final int sub3) {
		this.s3 = sub3;
	}

	/**
	 * Sets the total.
	 *
	 * @param      tot   The total
	 */
	public void setTotal( final int tot) {
		this.total = tot;
	}

	/**
	 * Sets the reserved.
	 *
	 * @param      rese  The rese
	 */
	public void setReserved( final String rese) {
		this.reserved = rese;
	}
	/**
	 * Sets the un reserved.
	 *
	 * @param      unrese  The unrese
	 */
	public void setUnReserved( final String unrese) {
		this.unreserved = unrese;
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.studentname;
	}

	/**
	 * { compares to comparable objects}.
	 *
	 * @param      that  The that
	 *
	 * @return     returns -1 and +1 based on comparision otherwise returns 0.
	 */
	public int compareTo(final Student that) {
		if (this.total > that.total) {
			return -1;
		}
		if (this.total < that.total) {
			return +1;
		}
		if (this.s3 > that.s3) {
			return -1;
		}
		if (this.s3 < that.s3) {
			return +1;
		}
		if (this.s2 > that.s2) {
			return -1;
		}
		if (this.s2 < that.s2) {
			return +1;
		}
		if (this.dateofbirth < that.dateofbirth) {
			return -1;
		}
		if (this.dateofbirth > that.dateofbirth) {
			return +1;
		}

		if (this.reserved.equals(that.reserved)) {
			return -1;
		}
		if (this.unreserved.equals(that.unreserved)) {
			return -1;
		}
		return 0;
	}
}
