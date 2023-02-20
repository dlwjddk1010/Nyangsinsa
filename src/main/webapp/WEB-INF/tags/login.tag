<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty memberId}">
	<c:if test="${memberId!='admin'}">
			<div class="header__top__right__auth">
				<a href="mypage.do"><i class="fa fa-user"></i> 마이페이지</a>
			</div>
			<div class="header__top__right__auth">
				<a href="logout.do"> | 로그아웃</a>
			</div>
	</c:if>
	
	<c:if test="${memberId=='admin'}">
			<div class="header__top__right__auth">
				<a href="adminIndex.do"><i class="fa fa-user"></i>관리자홈</a>
			</div>
			<div class="header__top__right__auth">
				<a href="logout.do"> | 로그아웃</a>
			</div>
	</c:if>
	
</c:if>

<c:if test="${empty memberId}">
		<div class="header__top__right__auth">
			<a href="login.jsp"><i class="fa fa-user"></i>로그인</a>
		</div>
		<div class="header__top__right__auth">
			<a href="register.jsp"> | 회원가입</a>
		</div>
</c:if>