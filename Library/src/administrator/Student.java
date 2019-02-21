/**
 * 
 */
package administrator;

/**
 * @author Administrator
 *
 */
public class Student {
	private String stuid;
	private String name;
	private String sex;
	private String depno;
	private String depname;
	private String grade;
	private String classNo;
	private String tel;
	private String addr;
	private int borrowBookNumber;

	/**
	 * @return the stuid
	 */
	public String getStuid() {
		return stuid;
	}

	/**
	 * @param stuid
	 *            the stuid to set
	 */
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the depno
	 */
	public String getDepno() {
		return depno;
	}

	/**
	 * @param depno the depno to set
	 */
	public void setDepno(String depno) {
		this.depno = depno;
	}

	/**
	 * @return the depname
	 */
	public String getDepname() {
		return depname;
	}

	/**
	 * @param depname
	 *            the depname to set
	 */
	public void setDepname(String depname) {
		this.depname = depname;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the classNo
	 */
	public String getClassNo() {
		return classNo;
	}

	/**
	 * @param classNo
	 *            the classNo to set
	 */
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr
	 *            the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setBorrowBookNumber(int borrowBookNumber) {
		this.borrowBookNumber = borrowBookNumber;
	}

	public int getBorrowBookNumber() {
		return borrowBookNumber;
	}
}
