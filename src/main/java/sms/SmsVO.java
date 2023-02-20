package sms;

public class SmsVO {
	
	private String memberPhone; //사용자 전화번호
	private String randNum;  //랜덤인증번호
	private String checknum;  //사용자가 입력한 번호
	
	
	
	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getRandNum() {
		return randNum;
	}

	public void setRandNum(String randNum) {
		this.randNum = randNum;
	}

	public String getChecknum() {
		return checknum;
	}

	public void setChecknum(String checknum) {
		this.checknum = checknum;
	}
	
	
	
	
	

}
