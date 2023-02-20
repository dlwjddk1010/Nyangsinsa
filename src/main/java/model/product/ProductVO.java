package model.product;

// 1.16 최신화 
public class ProductVO {
	private int pNum; // PK
	private int price;
	private int pAmt;
	private int pDcPercent;
	private int searchLowPrice;
	private int searchHighPrice;
	private int total; // 총 금액 담을 임시변수
	private int dc_price;
	private int pCnt; // 장바구니용 임시 cnt
	private String pName; 
	private String category;
	private String pDetail;
	private String pImgUrl;
	private String pImgUrl2;
	private String pSearchCondition;
	private String pSearchContent;
	private String sort;
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getpAmt() {
		return pAmt;
	}
	public void setpAmt(int pAmt) {
		this.pAmt = pAmt;
	}
	public int getpDcPercent() {
		return pDcPercent;
	}
	public void setpDcPercent(int pDcPercent) {
		this.pDcPercent = pDcPercent;
	}
	public int getSearchLowPrice() {
		return searchLowPrice;
	}
	public void setSearchLowPrice(int searchLowPrice) {
		this.searchLowPrice = searchLowPrice;
	}
	public int getSearchHighPrice() {
		return searchHighPrice;
	}
	public void setSearchHighPrice(int searchHighPrice) {
		this.searchHighPrice = searchHighPrice;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getDc_price() {
		return dc_price;
	}
	public void setDc_price(int dc_price) {
		this.dc_price = dc_price;
	}
	public int getpCnt() {
		return pCnt;
	}
	public void setpCnt(int pCnt) {
		this.pCnt = pCnt;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getpDetail() {
		return pDetail;
	}
	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}
	public String getpImgUrl() {
		return pImgUrl;
	}
	public void setpImgUrl(String pImgUrl) {
		this.pImgUrl = pImgUrl;
	}
	public String getpImgUrl2() {
		return pImgUrl2;
	}
	public void setpImgUrl2(String pImgUrl2) {
		this.pImgUrl2 = pImgUrl2;
	}
	public String getpSearchCondition() {
		return pSearchCondition;
	}
	public void setpSearchCondition(String pSearchCondition) {
		this.pSearchCondition = pSearchCondition;
	}
	public String getpSearchContent() {
		return pSearchContent;
	}
	public void setpSearchContent(String pSearchContent) {
		this.pSearchContent = pSearchContent;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "ProductVO [pNum=" + pNum + ", price=" + price + ", pAmt=" + pAmt + ", pDcPercent=" + pDcPercent
				+ ", searchLowPrice=" + searchLowPrice + ", searchHighPrice=" + searchHighPrice + ", total=" + total
				+ ", dc_price=" + dc_price + ", pCnt=" + pCnt + ", pName=" + pName + ", category=" + category
				+ ", pDetail=" + pDetail + ", pImgUrl=" + pImgUrl + ", pImgUrl2=" + pImgUrl2 + ", pSearchCondition="
				+ pSearchCondition + ", pSearchContent=" + pSearchContent + ", sort=" + sort + "]";
	}
	
}