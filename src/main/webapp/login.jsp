<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="nss" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>냥신사 | 로그인</title>

<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />

<!-- google Font -->
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/style_login.css" type="text/css">
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
            <li><a href="shoping_cart.jsp"><i class="fa fa-shopping-bag"></i> <span>${fn:length(cList)}</span></a></li>
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
         <a href="https://www.facebook.com/profile.php?id=100089405234926"><i class="fa fa-facebook"></i></a> <a href="https://www.instagram.com/nyangsinsa5/"><i class="fa fa-instagram"></i></a> <a href="https://twitter.com/nyangsinsa"><i class="fa fa-twitter"></i></a>
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
                        <a href="https://www.facebook.com/profile.php?id=100089405234926"><i class="fa fa-facebook"></i></a> <a href="https://www.instagram.com/nyangsinsa5/"><i class="fa fa-instagram"></i></a> <a href="https://twitter.com/nyangsinsa"><i class="fa fa-twitter"></i></a>
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
                     <li><a href="shoping_cart.jsp"><i class="fa fa-shopping-bag"></i> <span>${fn:length(cList)}</span></a></li>
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
   <section class="hero hero-normal">
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
                     <form action="search.do">
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

                        <span>상담 가능 시간<br>평일 09:00~18:00
                        </span>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
   <!-- Hero Section End -->

   <!-- ★★★★★여기에 페이지의 메인 코드를 넣어주세요★★★★★ -->

   <!--================Login Box Area =================-->
   <section class="login_box_area section-margin">
      <div class="container">
         <div class="row">
            <div class="col-lg-6">
               <div class="login_box_img">
                  <div class="hover">
                     <h4>냥신사가 처음이신가요?</h4>
                     <p>고양이를 사랑하는 당신! 환영합니다.</p>
                     <a class="button button-account" href="register.jsp">회원가입하기</a>
                  </div>
               </div>
            </div>
            <div class="col-lg-6">
               <div class="login_form_inner">
                  <h3>로그인하기</h3>
                  <form class="row login_form" action="login.do" id="contactForm" method="POST">
                     <div class="col-md-12 form-group">
                        <input type="text" class="form-control" id="id" name="id" placeholder="아이디 입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '아이디 입력'" required>
                     </div>
                     <div class="col-md-12 form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호 입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호 입력'" required>
                     </div>
                     <div class="col-md-12 form-group">
                        <button type="submit" value="submit" class="button button-login w-100">로그인</button>
                        <a id="kakao-login-btn" href="javascript:kakaoLogin()"><img src="img/kakao_login.png" alt="카카오 로그인 버튼" style="border-radius: 30px;" /></a> <br> <a href="find_id.jsp">아이디 찾기</a> &nbsp; / &nbsp; <a href="find_pw.jsp">패스워드 찾기</a>
                        <!-- &nbsp; / &nbsp;<a href="javascript:void(0)"
                           onclick="kakaoLogout();"
                        > <span>카카오 로그아웃</span>
                        </a> &nbsp; / &nbsp;<a href="javascript:void(0)"
                           onclick="kakaoDelete();"
                        > <span>카카오 회원탈퇴</span>
                        </a> -->
                        <br> <br>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
   </section>
   <!--================End Login Box Area =================-->

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
                     <a href="https://www.facebook.com/profile.php?id=100089405234926"><i class="fa fa-facebook"></i></a> <a href="https://www.instagram.com/nyangsinsa5/"><i class="fa fa-instagram"></i></a> <a href="https://twitter.com/nyangsinsa"><i class="fa fa-twitter"></i></a>
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
                        All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
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

   <!-- 카카오 스크립트 -->
   <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
   <!-- 카카오 스크립트 end -->

   <script>
      Kakao.init('a4736b83f633d7309942ec1e31da7d0f'); // SDK를 초기화함 / 발급 받은 키 중 javascript키를 사용해준다.
      console.log(Kakao.isInitialized()); // sdk초기화여부판단

      var name = ""; //  이름을 저장할 변수
      /* 카카오 로그인  */
      function kakaoLogin() { // 카카오 로그인 버튼 클릭시 실행되는 함수  
         Kakao.Auth
               .login({
                  success : function(response) { // 로그인에 성공하면 받아오는 데이터
                     console.log(Kakao.Auth.getAccessToken())
                     console.log(response)
                     Kakao.API
                           .request({
                              url : '/v2/user/me', // --> 로그인시 url
                              success : function(response) { // 로그인 성공시 받아올 데이터
                                 console.log(response)
                                 var name = response.kakao_account.profile.nickname;
                                 var id = response.id;
                                 var pw = response.id;
                                 location.href = "loginCheck.do?userName="
                                       + name + "&d=" + id;
                                 console.log(response)
                                 console
                                       .log(response.kakao_account.profile.nickname) // 로그인 성공한 유저 nickname
                                 name = response.kakao_account.profile.nickname //  로그인한 유저 이름 저장
                              },
                              fail : function(error) { // 로그인 실패시
                                 console.log(error)
                              },
                           })
                  },
                  fail : function(error) { // 로그인 실패시
                     console.log(error)
                  },
               })
      }
      /*  로그인 end */

      /*    로그아웃 */
      /*    function kakaoLogout() {
            console.log("너 뭐니?" + Kakao.Auth.getAccessToken())
            if (!Kakao.Auth.getAccessToken()) { // 로그인하지 않은 상태에서 로그아웃 시도
               console.log("너 뭐니?" + Kakao.Auth.getAccessToken())
               alert("로그인을 해주세요.");
               return;
            }
            console.log("로그아웃 성공 직전" + Kakao.Auth.getAccessToken())
            Kakao.Auth.logout(function() { //  로그인한 상태에서 로그아웃 시도
               /* alert("로그아웃 성공 -> " + Kakao.Auth.getAccessToken()); */
      /* alert("로그아웃되었습니다.");
      });
      }  */
      /* 로그아웃 end */

      /* 회원탈퇴...?*/
      /* function kakaoDelete() { //  탈퇴 버튼 클릭시 실행될 함수
         if (Kakao.Auth.getAccessToken()) {
            console.log(Kakao.Auth.getAccessToken())
            Kakao.API.request({
               url : '/v1/user/unlink', // --> 탈퇴시 url
               success : function(response) {
                  console.log(response)
                  alert("탈퇴되었습니다.");
               },
               fail : function(error) {
                  console.log(error)
                  alert("로그인 후 시도해주세요");
               },
            })
            Kakao.Auth.setAccessToken(undefined)
         }
      } */
      /*  회원탈퇴 end */
   </script>

   <!-- TOP 버튼 -->
   <div style="width: 120px; position: fixed; bottom: 80px; right: 100px; z-index: 1;">
      <a href="#"><button type="button" class="button-top">▲ 맨위로</button></a>
   </div>


</body>

</html>