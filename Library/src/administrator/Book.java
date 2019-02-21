/**
 * 
 */
package administrator;

/**
 * @author Administrator
 *
 */
public class Book {
	private String code;
	private String bookName;
	private String writer;
	private String publisher;
	private String buyDate;
	private int number;
	private byte isLoan;
	private String studentName=null;

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName
	 *            the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * @param writer
	 *            the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the buyDate
	 */
	public String getBuyDate() {
		return buyDate;
	}

	/**
	 * @param buyDate
	 *            the buyDate to set
	 */
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the isLoan
	 */
	public byte getIsLoan() {
		return isLoan;
	}

	/**
	 * @param isLoan
	 *            the isLoan to set
	 */
	public void setIsLoan(byte isLoan) {
		this.isLoan = isLoan;
	}
}
