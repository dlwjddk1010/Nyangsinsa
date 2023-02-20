<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="nss" tagdir="/WEB-INF/tags/" %>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>냥신사 | 홈</title>

<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />

<!-- google Font -->
<link
   href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
   rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
   <!-- Page Preloder -->
   <div id="preloder">
      <div class="loader"></div>
   </div>

   <!-- Humberger Begin -->
   <div class="humberger__menu__overlay"></div>
   <div class="humberger__menu__wrapper">
      <div class="humberger__menu__logo">
         <a href="main.do"><img src="img/logo.png" alt="홈으로 가기"></a>
      </div>
      <div class="humberger__menu__cart">
         <ul>
            <li><a href="shoping_cart.jsp"><i class="fa fa-shopping-bag"></i> <span id="cartCnt2"></span></a></li>
         </ul>
      </div>

   <div class="humberger__menu__widget">
      <!-- 로그인 -->
      <nss:login />
   </div>

      <nav class="humberger__menu__nav mobile-menu">
         <ul>
            <li class="active"><a href="main.do">홈</a></li>
            <li><a href="shop.do?category=all&sort=sellDesc">쇼핑</a></li>
            <li><a href="contact.jsp">Contact</a></li>
         </ul>
      </nav>
      <div id="mobile-menu-wrap"></div>
         <div class="header__top__right__social">
            <a href="https://www.facebook.com/profile.php?id=100089405234926"><i class="fa fa-facebook"></i></a>
            <a href="https://www.instagram.com/nyangsinsa5/"><i class="fa fa-instagram"></i></a>
            <a href="https://twitter.com/nyangsinsa"><i class="fa fa-twitter"></i></a>
         </div>
         <div class="humberger__menu__contact">
            <ul>
               <li><i class="fa fa-envelope"></i>nyangsinsa@gmail.com</li>
               <li>대한민국 최고의 반려묘 용품 쇼핑몰</li>
            </ul>
         </div>
   </div>
   <!-- Humberger End -->

   <!-- Header Section Begin -->
   <header class="header">
      <div class="header__top">
         <div class="container">
            <div class="row">
               <div class="col-lg-6 col-md-6">
                  <div class="header__top__left">
                     <ul>
                        <li><i class="fa fa-envelope"></i>nyangsinsa@gmail.com</li>
                        <li>대한민국 최고의 반려묘 용품 쇼핑몰</li>
                     </ul>
                  </div>
               </div>
               <div class="col-lg-6 col-md-6">
                  <div class="header__top__right">
                     <div class="header__top__right__social">
                        <a href="https://www.facebook.com/profile.php?id=100089405234926"><i class="fa fa-facebook"></i></a>
                        <a href="https://www.instagram.com/nyangsinsa5/"><i class="fa fa-instagram"></i></a>
                        <a href="https://twitter.com/nyangsinsa"><i class="fa fa-twitter"></i></a>
                     </div>
                     
                     <!-- 로그인 -->
                     <nss:login />
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="container">
         <div class="row">
            <div class="col-lg-3">
               <div class="header__logo">
                  <a href="main.do"><img src="img/logo.png" alt="홈으로 가기"></a>
               </div>
            </div>
            <div class="col-lg-6">
               <nav class="header__menu">
                  <ul>
                     <li class="active"><a href="main.do">홈</a></li>
                     <li><a href="shop.do?category=all&sort=sellDesc">쇼핑</a></li>
                     <li><a href="contact.jsp">Contact</a></li>
                  </ul>
               </nav>
            </div>
            <div class="col-lg-3">
               <div class="header__cart">
                  <ul>
                     <li><a href="shoping_cart.jsp"><i class="fa fa-shopping-bag"></i> <span id="cartCnt"></span></a></li>
                  </ul>
               </div>
            </div>
         </div>
         <div class="humberger__open">
            <i class="fa fa-bars"></i>
         </div>
      </div>
   </header>
   <!-- Header Section End -->

   <!-- Hero Section Begin index는 아래줄 section class="hero" -->
   <section class="hero">
      <div class="container">
         <div class="row">
            <div class="col-lg-3">
               <div class="hero__categories">
                  <div class="hero__categories__all">
                     <i class="fa fa-bars"></i> <span>메뉴</span>
                  </div>
                  <ul>
                     <li><a href="shop.do?category=all">전체</a></li>
                     <li><a href="shop.do?category=food">사료</a></li>
                     <li><a href="shop.do?category=treat">간식</a></li>
                     <li><a href="shop.do?category=sand">모래</a></li>
                  </ul>
               </div>
            </div>
            <div class="col-lg-9">
               <div class="hero__search">
                  <div class="hero__search__form">
                     <form action="search.do" method="post">
                        <!-- <input type="hidden" name="searchCondition" value="pName">  -->
                        <input type="text" name="searchContent" placeholder="필요한 거 있냥?" required>
                        <button type="submit" class="site-btn">검색</button>
                     </form>
                  </div>
                  <div class="hero__search__phone">
                     <div class="hero__search__phone__icon">
                        <i class="fa fa-phone"></i>
                     </div>
                     <div class="hero__search__phone__text">
                        <h5>02-0202-0202</h5>
                        
                        <span>상담 가능 시간<br>평일 09:00~18:00</span>
                     </div>
                  </div>
               </div>
               <!-- 광고 이미지 -->
               <c:set var="addImgUrl" value="https://cdnimg.catpang.com/catpang/data/event/banner/sno_maintopnew_2022062315024111.jpg" />
               <a href = "shop.do?category=treat"><div class="hero__item set-bg" data-setbg="${addImgUrl}"></div></a>
                    <%--  <div class="hero__text">
                        <span>최상급 집사가 되는 빠른 길</span>
                        <h2>
                           ${popPList[0].pName}
                        </h2>
                        <p>무료 픽업 및 배송 가능</p>
                        <a href="shopDetails.do?pNum=${popPList[0].pNum}" class="primary-btn">바로 구매하러 가기</a>
                     </div> --%>
                  </div>
            </div>
         </div>
      </div>
   </section>
   <!-- Hero Section End -->

   <!-- Categories Section Begin -->
   <section class="categories">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="section-title">
                  <h2>신상품</h2>
               </div>
               <div class="categories__slider owl-carousel">
               <!-- 신상품 리스트 -->
                  <nss:list sort="new" />
                  
               </div>
            </div>
         </div>
      </div>
   </section>
   <!-- Categories Section End -->

   <!-- Featured Section Begin -->
   <section class="featured spad">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="section-title">
                  <h2>인기 상품</h2>
               </div>
               <div class="featured__controls">
                  <ul>
                     <li class="active" data-filter="*">전체</li>
                     <li data-filter=".food">사료</li>
                     <li data-filter=".treat">간식</li>
                     <li data-filter=".sand">모래</li>
                  </ul>
               </div>
            </div>
         </div>
         <div class="row featured__filter">
         
         <!-- 인기상품 리스트 -->
            <nss:list sort="popular" />
            
         </div>
      </div>
   </section>
   <!-- Featured Section End -->

   <!-- Footer Section Begin -->
   <footer class="footer spad">
      <div class="container">
         <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6">
               <div class="footer__about">
                  <div class="footer__about__logo">
                     <a href="main.do"><img src="img/logo.png" alt="로고"></a>
                  </div>

               </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
               <div class="footer__widget">
                  <ul>
                     <li>주소: 서울 강남구 역삼동 골목길</li>
                     <li>전화: +82 02-0202-0202</li>
                     <li>이메일: nyangsinsa@gmail.com</li>
                  </ul>
               </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
               <div class="footer__widget">
                  <div class="footer__widget__social">
                     <a href="https://www.facebook.com/profile.php?id=100089405234926"><i class="fa fa-facebook"></i></a>
                     <a href="https://www.instagram.com/nyangsinsa5/"><i class="fa fa-instagram"></i></a>
                     <a href="https://twitter.com/nyangsinsa"><i class="fa fa-twitter"></i></a>
                  </div>
               </div>
            </div>
         </div>
         <div class="row">
            <div class="col-lg-12">
               <div class="footer__copyright">
                  <div class="footer__copyright__text">
                     <p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright 냥신사&copy;
                        <script>
                           document.write(new Date().getFullYear());
                        </script>
                        All rights reserved | This template is made with <i
                           class="fa fa-heart" aria-hidden="true"></i> by <a
                           href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                     </p>
                  </div>
                  <div class="footer__copyright__payment">
                     <img src="img/payment-item.png" alt="결제수단">
                  </div>
               </div>
            </div>
         </div>
      </div>
   </footer>
   <!-- Footer Section End -->

   <!-- Js Plugins -->
   <script src="js/jquery-3.3.1.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/jquery.nice-select.min.js"></script>
   <script src="js/jquery-ui.min.js"></script>
   <script src="js/jquery.slicknav.js"></script>
   <script src="js/mixitup.min.js"></script>
   <script src="js/owl.carousel.min.js"></script>
   <script src="js/main.js"></script>

   <script type="text/javascript">
      $(document).ready(function(){
         $.ajax({ // ajax로 데이터 가져오기
            type: 'POST',
            url: 'getCartCnt',
            success: function(data) {
               let cartCnt = '';
               cartCnt += data; // 장바구니 상품 개수
               $('#cartCnt').text(cartCnt); 
               $('#cartCnt2').text(cartCnt); 
            },
            error: function(){
               alert('error');
            }
           })
      })
      
      function insertCart(pNum){
         console.log(pNum);
         window.location.href="insertCart.do?pNum="+pNum;
         
         setTimeout(function() {
            $.ajax({ // ajax로 데이터 가져오기
               type: 'POST',
               url: 'getCartCnt',
               success: function(data) {
                  console.log("data: "+data);
                  let cartCnt = '';
                  cartCnt += data; // 장바구니 상품 개수
                  console.log("cartCnt 새로고침: "+cartCnt);
                  $('#cartCnt').text(cartCnt); 
                  $('#cartCnt2').text(cartCnt); 
               },
               error: function(){
                  alert('error');
               }
            })
         }, 300);
      }
      
   </script>

   <!-- TOP 버튼 -->
   <div style="width: 120px; position: fixed; bottom: 80px; right: 100px; z-index : 1;">
      <a href="#"><button type="button" class="button-top">▲ 맨위로</button></a>
   </div>

</body>

</html>