package model.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	final static int MAX_CNT = 16;

	public static void sample() {

		ArrayList<String> urls = makeUrls();
		ArrayList<String> category = new ArrayList<String>();
		category.add("food"); // 0
		category.add("treat"); // 1
		category.add("sand"); // 2  
		ProductDAO pdao = new ProductDAO();
		System.out.println(urls.size());

		for (int a = 0; a < category.size(); a++) {
			for (int i = a * MAX_CNT; i < MAX_CNT * (a + 1); i++) {

				Document doc = null;
				try {
					doc = Jsoup.connect(urls.get(i)).get(); // i 번째 url 연결
				} catch (IOException e) {
					e.printStackTrace();
				}
				Element ele1 = doc.getElementById("viewName"); // 상품명
				Element ele2 = doc.getElementById("photo_detail"); // 대표사진
				Element ele3 = doc.getElementById("goods_desc_img"); // 상세사진
				Element ele4 = doc.getElementById("cart_total_price_pc"); // 가격
				Elements eles2 = doc.select("#content_view_desc > dl:nth-child(1) > dt"); // 원산지 vs 상세설명
				String detail = " ";
				if (eles2.text().equals("상품설명")) {
					detail = doc.select("#content_view_desc > dl:nth-child(1) > dd").text(); // 상세 설명
				}

				String priceString = ele4.text();
				int price = Integer.parseInt(priceString.replaceAll("\\W", "")); // , 제외하고 가격만 저장

				ProductVO data = new ProductVO();
				data.setpName(ele1.text());
				data.setCategory(category.get(a));
				data.setPrice(price);
				data.setpAmt(new Random().nextInt(100) + 5);
				data.setpDetail(detail);
				data.setpImgUrl(ele2.attr("src"));
				data.setpImgUrl2(ele3.attr("src"));
				pdao.insert(data);
				System.out.println(i + "  크롤링 로그 : " + data.getpName() + data.getCategory());
			}
			
		}
	}

	// 크롤링
	public static ArrayList<String> makeUrls() {
		ArrayList<String> categoryUrls = new ArrayList<String>();
		categoryUrls.add(
				"https://www.catpang.com/shop/goods/goods_list.php?category=001001&searchOption%5B%5D=25&searchOption%5B%5D=7&scroll=0"); // 사료
		categoryUrls.add("https://www.catpang.com/shop/goods/goods_list.php?category=001002&scroll=0"); // 간식
		categoryUrls.add("https://www.catpang.com/shop/goods/goods_list.php?category=001003"); // 모래
		String url = null;

		ArrayList<String> urlDatas = new ArrayList<String>();

		for (int i = 0; i < categoryUrls.size(); i++) {
			url = categoryUrls.get(i);
			Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Elements eles = doc.select("#contents > div.list-container > div> div > div > a"); // a
			for (int j = 0; j < MAX_CNT; j++) {
				System.out.println("https://www.catpang.com" + eles.get(j).getElementsByAttribute("href").attr("href"));
				urlDatas.add("https://www.catpang.com" + eles.get(j).getElementsByAttribute("href").attr("href"));
			}
		}
		return urlDatas;
	}
	/*
	 * public static void main(String[] args) { sample(); }
	 */

}