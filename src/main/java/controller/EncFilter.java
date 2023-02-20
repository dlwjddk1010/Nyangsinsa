package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

// @ : Servlet류의 클래스들에게 자동으로 설정됨
// @WebFilter(".jsp") == URL이 호출되면 이 필터 클래스를 호출해줘
// == *.jsp가 호출되면 이 필터 클래스(doFilter() 메서드)를 호출해줘
// 매번 이 필터클래스(doFilter() 메서드)를 호출해줘
@WebFilter({"*.do","*.jsp"})
public class EncFilter extends HttpFilter implements Filter {
	private String encoding; // init()에서 가져온 파라미터 encoding
	public EncFilter() {
		// 기본 생성자 : 톰캣이 관리하기 때문에 잘 안 건드림
		super();
	}

	public void destroy() {
		// 필터가 소멸될 때 : 톰캣이 관리하기 때문에 잘 안 건드림
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// *.do가 호출되면
		// 이곳의 코드가 수행됨
		System.out.println("  로그 : 냥신사 필터 클래스의 doFilter() 메서드 수행됨");
		request.setCharacterEncoding(this.encoding); // 인코딩 설정은 WEB-INF/web.xml 에 존재
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 클래스 객체 최초 생성시 호출됨
		this.encoding = fConfig.getServletContext().getInitParameter("encoding");
	}

}