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

	public String getStudentName() {
		return this.studentname;
	}

	public int getDateOfBirth() {
		return this.dateofbirth;
	}

	public int getS1() {
		return this.s1;
	}

	public int getS2() {
		return this.s2;
	}

	public int getS3() {
		return this.s3;
	}

	public int getTotal() {
		return this.total;
	}

	public String getReserved() {
		return this.reserved;
	}

	public String getUnReserved() {
		return this.unreserved;
	}

	public void setStudentName( final String name) {
		this.studentname = name;
	}

	public void setDateOfBirth( final int birth) {
		this.dateofbirth = birth;
	}

	public void setS1( final int sub1) {
		this.s1 = sub1;
	}

	public void setS2( final int sub2) {
		this.s2 = sub2;
	}

	public void setS3( final int sub3) {
		this.s3 = sub3;
	}

	public void setTotal( final int tot) {
		this.total = tot;
	}

	public void setReserved( final String rese) {
		this.reserved = rese;
	}
	public void setUnReserved( final String unrese) {
		this.unreserved = unrese;
	}

	public String toString() {
		return this.studentname;
	}

	public int compareTo(Student that) {
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
