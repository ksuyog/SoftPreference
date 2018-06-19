package reader;

public class Transaction {
	private String recordNumber;
	private String outDate;
	private String location;
	private String mateType;
	private String outLoc;
	private String callNumber;
	private String lang;

	public Transaction() {
		
	}
	
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMateType() {
		return mateType;
	}
	public void setMateType(String mateType) {
		this.mateType = mateType;
	}
	public String getOutLoc() {
		return outLoc;
	}
	public void setOutLoc(String outLoc) {
		this.outLoc = outLoc;
	}
	public String getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
}
