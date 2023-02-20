package model.review;

public class ReviewVO {
	private int rNum;
	private int pNum;
	private int rRate;
	private String rWriter;
	private String rContent;
	private String rDate;
	private String rSearchCondition;

	public String getrSearchCondition() {
		return rSearchCondition;
	}

	public void setrSearchCondition(String rSearchCondition) {
		this.rSearchCondition = rSearchCondition;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public int getrRate() {
		return rRate;
	}

	public void setrRate(int rRate) {
		this.rRate = rRate;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	@Override
	public String toString() {
		return "ReviewVO [rNum=" + rNum + ", pNum=" + pNum + ", rRate=" + rRate + ", rWriter=" + rWriter + ", rContent="
				+ rContent + ", rDate=" + rDate + ", rSearchCondition=" + rSearchCondition + "]";
	}

}
