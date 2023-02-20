package controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.product.ProductDAO;

/* 
 * 서버 시작 시, 타겟 사이트 크롤링한 데이터들을 DB에 저장하는 리스너
 **/
@WebListener
public class InitProduct implements ServletContextListener {
	
    public InitProduct() {
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	// ServletContext application = sce.getServletContext(); // application scope
    	ProductDAO pdao = new ProductDAO();
    	
    	// 크롤링한 데이터 set
    	if(pdao.selectAll(null).size() < 48) { // 전체 데이터 개수 < 48
    		model.product.Crawling.sample();
    	}
    }
	
}