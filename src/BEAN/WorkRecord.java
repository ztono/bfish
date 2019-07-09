package BEAN;

public class WorkRecord {

	private String record_no;
	private String staff_no;
	private String start_time;
	private String end_time;

	/**
	 * @return the record_no
	 */
	public String getRecord_no() {
		return record_no;
	}

	/**
	 * @param record_no
	 *            the record_no to set
	 */
	public void setRecord_no(String record_no) {
		this.record_no = record_no;
	}

	/**
	 * @return the staff_no
	 */
	public String getStaff_no() {
		return staff_no;
	}

	/**
	 * @param staff_no
	 *            the staff_no to set
	 */
	public void setStaff_no(String staff_no) {
		this.staff_no = staff_no;
	}

	/**
	 * @return the start_time
	 */
	public String getStart_time() {
		return start_time;
	}

	/**
	 * @param start_time
	 *            the start_time to set
	 */
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	/**
	 * @return the end_time
	 */
	public String getEnd_time() {
		return end_time;
	}

	/**
	 * @param end_time
	 *            the end_time to set
	 */
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	/**
	 * @param record_no
	 * @param staff_no
	 * @param start_time
	 * @param end_time
	 */
	public WorkRecord(String record_no, String staff_no, String start_time, String end_time) {
		super();
		this.record_no = record_no;
		this.staff_no = staff_no;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public WorkRecord() {

	}
}
