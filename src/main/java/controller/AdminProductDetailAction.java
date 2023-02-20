package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product.ProductDAO;
import model.product.ProductVO;

public class AdminProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("product_manage_detail.jsp");
		forward.setRedirect(false);

		int pNum = Integer.parseInt(request.getParameter("pNum"));

		ProductVO pvo = new ProductVO();
		pvo.setpNum(pNum);
		ProductDAO pdao = new ProductDAO();
		ProductVO product = pdao.selectOne(pvo);

		request.setAttribute("pvo", product);
		return forward;
	}

}
