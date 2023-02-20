package model.orderDetail;

public class OrderDetailVO {
	private int odNum;
	private int oNum;
	private int pNum;
	private int odCnt;
	private int odPrice;
	private String pName;
	private String pImgUrl;
	private int cnt;
	private int sum;
	private String category;

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCnt() {
		return cnt;
	}

	public String getCategory() {
		return category;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getpImgUrl() {
		return pImgUrl;
	}

	public void setpImgUrl(String pImgUrl) {
		this.pImgUrl = pImgUrl;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getOdPrice() {
		return odPrice;
	}

	public void setOdPrice(int odPrice) {
		this.odPrice = odPrice;
	}

	public int getOdNum() {
		return odNum;
	}

	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public int getOdCnt() {
		return odCnt;
	}

	public void setOdCnt(int odCnt) {
		this.odCnt = odCnt;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [odNum=" + odNum + ", oNum=" + oNum + ", pNum=" + pNum + ", odCnt=" + odCnt + ", odPrice="
				+ odPrice + ", pName=" + pName + ", pImgUrl=" + pImgUrl + ", cnt=" + cnt + ", sum=" + sum
				+ ", category=" + category + "]";
	}

}