package entity;

public class Fine {
	public String FID;
	public String reader_id;
	public String fine;
	/**
	 * @return the fID
	 */
	public String getFID() {
		return FID;
	}
	/**
	 * @param fID the fID to set
	 */
	public void setFID(String fID) {
		FID = fID;
	}
	/**
	 * @return the reader_id
	 */
	public String getReader_id() {
		return reader_id;
	}
	/**
	 * @param reader_id the reader_id to set
	 */
	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}
	/**
	 * @return the fine
	 */
	public String getFine() {
		return fine;
	}
	/**
	 * @param fine the fine to set
	 */
	public void setFine(String fine) {
		this.fine = fine;
	}

}
