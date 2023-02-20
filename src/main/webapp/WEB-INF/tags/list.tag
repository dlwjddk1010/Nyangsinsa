<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="category"%>
<%@ attribute name="sort"%>

<!-- 전체 신상품(홈 페이지) 페이지에 직접 넣었음 -->
<c:if test="${sort=='new'}">
	<c:forEach var="v" items="${newPList}" begin="0" varStatus="status">
		<div class="col-lg-3">
			<a href="shopDetails.do?pNum=${v.pNum}"><div class="categories__item set-bg" data-setbg="${v.pImgUrl}">
				<h5>
					${v.pName}
				</h5>
			</div></a>
		</div>
	</c:forEach>
</c:if>

<!-- 전체 인기상품(홈 페이지) 페이지에 직접 넣었음 -->
<c:if test="${sort=='popular'}">
	<c:forEach var="v" items="${popPList}" begin="0" end="14"
		varStatus="status">

		<div class="col-lg-3 col-md-4 col-sm-6 mix ${v.category}">
			<div class="featured__item">
				<div class="featured__item__pic set-bg" data-setbg="${v.pImgUrl}">
					<ul class="featured__item__pic__hover">
						<li><a href="javascript:void(0);"
							onclick="javascript:insertCart(${v.pNum});"><i
								class="fa fa-shopping-cart"></i></a></li>
					</ul>
				</div>
				<div class="featured__item__text">
					<h6>
						<a href="shopDetails.do?pNum=${v.pNum}">${v.pName}</a>
					</h6>
					<h5><fmt:formatNumber value="${v.dc_price}" pattern="#,###" />원</h5>
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>

<!-- 전체 할인상품(쇼핑 페이지) -->
<c:if test="${sort=='dc'}">
	<c:forEach var="v" items="${pList}" begin="0" varStatus="status">
		<c:if test="${v.pDcPercent>0}">
			<div class="col-lg-4">
				<div class="product__discount__item">
					<div class="product__discount__item__pic set-bg"
						data-setbg="${v.pImgUrl}">
						<div class="product__discount__percent">-${v.pDcPercent}%</div>
						<ul class="product__item__pic__hover">
							<li><a href="javascript:void(0);"
								onclick="javascript:insertCart(${v.pNum});"><i
									class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__discount__item__text">
						<h5>
							<a href="shopDetails.do?pNum=${v.pNum}">${v.pName}</a>
						</h5>
						<div class="product__item__price">
							<fmt:formatNumber value="${v.dc_price}" pattern="#,###" />원<span><fmt:formatNumber value="${v.price}" pattern="#,###" />원</span>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</c:forEach>
</c:if>

<!-- 관련 상품(상품 세부정보 페이지) 페이지에 직접 넣었음 -->
<c:if test="${sort=='related'}">
	<c:forEach var="v" items="${pList}" begin="0" end="9"
		varStatus="status">
		<div class="col-lg-3 col-md-4 col-sm-6">
			<div class="product__item">
				<div class="product__item__pic set-bg" data-setbg="${v.pImgUrl}">
					<ul class="product__item__pic__hover">
						<li><a href="javascript:void(0);"
							onclick="javascript:insertCart(${v.pNum});"><i
								class="fa fa-shopping-cart"></i></a></li>
					</ul>
				</div>
				<div class="product__item__text">
					<h6>
						<a href="shopDetails.do?pNum=${v.pNum}">${v.pName}</a>
					</h6>
					<h5><fmt:formatNumber value="${v.dc_price}" pattern="#,###" />원</h5>
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>

<!-- 관리자 홈 진입시 거래부분  -->
<c:if test="${sort=='adminhome'}">
	<c:forEach var="v" items="${oList}" begin="0" end="5"
		varStatus="status">
		<li class="d-flex mb-4 pb-1">
			<div class="avatar flex-shrink-0 me-3">
			<c:if test="${v.oPay=='카카오페이'}">
			<img src="assets/img/icons/unicons/kakaopay.png" alt="User"
					class="rounded" /></c:if>
			<c:if test="${v.oPay=='카드결제'}">
			<img src="assets/img/icons/unicons/card.png" alt="User"
					class="rounded" /></c:if>
			<c:if test="${v.oPay=='휴대폰결제'}">
			<img src="assets/img/icons/unicons/phone_pay.png" alt="User"
					class="rounded" /></c:if>
			
				
			</div>
			<div
				class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
				<div class="me-2">
					<small class="text-muted d-block mb-1">${v.oPay}</small>
					<h6 class="mb-0">입금</h6>
				</div>
				<div class="user-progress d-flex align-items-center gap-1">
					<h6 class="mb-0">+<fmt:formatNumber value="${v.oPrice}" pattern="#,###" /></h6>
					<span class="text-muted">원</span>
				</div>
			</div>
		</li>
	</c:forEach>
</c:if>