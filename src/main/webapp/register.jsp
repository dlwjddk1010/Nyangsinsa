<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
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
<meta name="viewport"
   content="width=device-width, initial-scale=1.0"
>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>냥신사 | 회원가입</title>

<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />

<!-- google Font -->
<link
   href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
   rel="stylesheet"
>

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css"
   type="text/css"
>
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css"
   type="text/css"
>
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/style_login.css" type="text/css">

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
></script>

<style type="text/css">
#tos1 { /* 불러온내용*/
   padding-top: 5px;
   border: 1px solid black;
   overflow: scroll;
   width: 450px;
   height: 400px;
}

#tos2 { /* 불러온내용*/
   padding-top: 5px;
   border: 1px solid black;
   overflow: scroll;
   width: 450px;
   height: 400px;
}

#tos3 { /* 불러온내용*/
   padding-top: 5px;
   border: 1px solid black;
   overflow: scroll;
   width: 450px;
   height: 400px;
}

.btn-primary {
   color: #fff;
   background-color: white;
   border-color: white;
   color: #777;
   font-family: 'Roboto', sans-serif;
   font-size: 15px;
   font-weight: 400;
   line-height: 1.667;
   padding: 0px;
}

.btn-primary:hover {
   color: #fff;
   background-color: white;
   border-color: white;
}

.btn-primary:not(:disabled):not(.disabled).active, .btn-primary:not(:disabled):not(.disabled):active,
   .show>.btn-primary.dropdown-toggle {
   background-color: white;
   border-color: white;
   color: #fff;
}

.checkre {
   font-size: 8px;
   color: red;
   margin-left: 7%;
}

.check {
   color: white;
   border-radius: 20px;
}
</style>

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
            <li><a href="shoping_cart.jsp"><i
                  class="fa fa-shopping-bag"
               ></i> <span>${fn:length(cList)}</span></a></li>
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
         <a href="https://www.facebook.com/profile.php?id=100089405234926"><i
            class="fa fa-facebook"
         ></i></a> <a href="https://www.instagram.com/nyangsinsa5/"><i
            class="fa fa-instagram"
         ></i></a> <a href="https://twitter.com/nyangsinsa"><i
            class="fa fa-twitter"
         ></i></a>
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
                        <a
                           href="https://www.facebook.com/profile.php?id=100089405234926"
                        ><i class="fa fa-facebook"></i></a> <a
                           href="https://www.instagram.com/nyangsinsa5/"
                        ><i class="fa fa-instagram"></i></a> <a
                           href="https://twitter.com/nyangsinsa"
                        ><i class="fa fa-twitter"></i></a>
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
                     <li><a href="shoping_cart.jsp"><i
                           class="fa fa-shopping-bag"
                        ></i> <span>${fn:length(cList)}</span></a></li>
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
                        <input type="text" name="searchContent"
                           placeholder="필요한 거 있냥?" required
                        >
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

   <!--================Login Box Area =================-->
   <section class="login_box_area section-margin">
      <div class="container">
         <div class="row">
            <div class="col-lg-6">
               <div class="login_box_img">
                  <div class="hover">
                     <h4>이미 회원이신가요?</h4>
                     <p>냥신사를 다시 찾아주셔서 감사합니다!</p>
                     <a class="button button-account" href="login.jsp">로그인하기</a>
                  </div>
               </div>
            </div>
            <div class="col-lg-6">
               <div class="login_form_inner register_form_inner">
                  <h3>
                     회원가입하기 <br><br><a href="#kakao-login-btn" style="color: black;">
                     <small><u>카카오로 회원가입 바로가기</u></small></a>
                  </h3>

                  <form class="row login_form" action="signUp.do"
                     id="register_form" onsubmit="return registerCheck()"
                     method="POST">

                     <!-- 아이디 -->
                     <div class="col-md-12 form-group">
                        <input type="text" style="width: 60%;" id="id" name="id"
                           placeholder="&nbsp;아이디" onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '아이디 입력'" required>&nbsp;
                           <input style="color: white; border-radius: 7px;"
                           type="button" id="idCheckBtn" onclick="checkId()"
                           class="button button-register" value="아이디 중복체크">
                     </div>
                     <p class="checkre" align="left" id="outputId">영어/숫자가 혼합된
                        4~15자리 아이디를 입력해주세요.</p>


                     <!-- 이름 -->
                     <div class="col-md-12 form-group">
                        <input type="text" class="form-control" id="name"
                           name="name" placeholder="이름"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '이름 입력'" required>
                     </div>
                     <p class="checkre" id="outputName">한글 2~6자리 이름을 입력해주세요.</p>

                     <!-- 고양이 이름 -->
                     <div class="col-md-12 form-group">
                        <input type="text" class="form-control" id="cName"
                           name="cName" placeholder="고양이 이름"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '고양이 이름 입력'" required>
                     </div>
                     <p class="checkre" id="outputcName">한글 2~6자리 고양이 이름을
                        입력해주세요.</p>

                     <!-- 비밀번호 -->
                     <div class="col-md-12 form-group">
                        <input type="password" class="form-control" id="password"
                           name="password" placeholder="비밀번호 입력"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '비밀번호 입력'" required>
                     </div>
                     <p class="checkre" id="outputPw">영어/숫자/특수문자를 모두 혼합하여 8자리
                        이상 비밀번호를 입력해주세요.</p>

                     <!-- 비밀번호 확인 -->
                     <div class="col-md-12 form-group">
                        <input type="password" class="form-control"
                           id="confirmPassword" name="confirmPassword"
                           placeholder="비밀번호 재입력" onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '비밀번호 재입력'" required>
                     </div>

                     <p class="checkre" id="outputPw2">비밀번호를 다시 입력해주세요.</p>

                     <!-- 이메일 -->
                     <div class="col-md-12 form-group">
                        <input type="email" class="form-control" id="email_register"
                           name="email" placeholder="이메일 주소"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '이메일 주소 입력'" required>
                     </div>

                     <!-- 전화 번호 -->
                     <div class="col-md-12 form-group">
                        <input type="tel" style="width: 65%;" id="phone"
                           name="phone" placeholder="전화번호 입력"
                           oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
                           required>
                           <input type="button" class="button button-register"
                           style="color: white; border-radius: 7px;" value="인증번호 받기" onclick="sms()">
                        <div style="text-align: left; padding: 0px;">
                           <p class="checkre" id="outputPhone">본인 명의의 휴대폰 번호를 입력해주세요.</p>
                        </div>
                        <div>
                           <input type="text" style="width: 65%;"
                              placeholder="인증번호를 입력하세요" id="userCheck" required>
                              <input type="button" class="button button-register"
                              style="color: white; border-radius: 7px;" value="인증번호 확인" onclick="smsCheck()">
                        </div>
                     </div>
                     <!-- 인증번호 -->

                     <!-- 주소 -->
                     <div class="col-md-12 form-group">
                        <div>
                           <input type="text" style="width: 65%;" id="post"
                              placeholder="우편번호" onclick="sample6_execDaumPostcode()"
                              name="post" readonly>
                              <input type="button" style="color: white; border-radius: 7px;"
                              class="button button-register" value="우편번호 찾기"
                              onclick="sample6_execDaumPostcode()" readonly>
                        </div>
                        <input type="text" class="form-control" id="address"
                           name="address" placeholder="주소" readonly>
                           <input type="text" class="form-control" id="address_plus"
                           name="addressPlus" placeholder="참고항목" readonly>
                           <input type="text" class="form-control"
                           name="addressDetail" id="address_detail" placeholder="상세주소"
                           required>
                     </div>

                     <!-- 약관 동의 전체-->
                     <div class="checkbox_group">
                        <input type="checkbox" id="check_all"> <label
                           for="check_all">전체 동의</label> <br>

                        <!-- 약관 동의1 -->
                        <input type="checkbox" id="check_1" class="normal" required>
                        <label for="check_1"></label> 개인정보 처리방침 동의 
                        <a class="btn btn-primary" data-toggle="modal"
                           data-target="#exampleModal3" style="font-size: 5px;">자세히보기</a> <br>

                        <!-- 약관 동의2 -->
                        <input type="checkbox" id="check_2" class="normal" required>
                        <label for="check_2"></label>서비스 이용약관 동의
                        <a class="btn btn-primary" data-toggle="modal"
                           data-target="#exampleModal2" style="font-size: 5px;">자세히보기</a> <br>

                        <!-- 약관 동의3 -->
                        <input type="checkbox" id="check_3" class="normal">
                        <label for="check_3"></label>마케팅 수신 동의(선택)
                        <a class="btn btn-primary" data-toggle="modal"
                           data-target="#exampleModal1" style="font-size: 5px;">자세히보기 </a> <br> <br>
                     </div>

                     <!-- 회원 가입 버튼 -->
                     <div class="col-md-12 form-group">
                        <button id="signupBtn" type="submit" value="submit"
                           class="button button-register w-100"
                        >회원가입</button>
                        <br>
                     </div>

                     <!-- SNS 가입 -->
                     <div class="col-md-12 form-group">
                        <a id="kakao-login-btn" href="javascript:kakaoLogin()"><img
                           style="border-radius: 30px" src="img/kakao_join.png"
                           alt="카카오 로그인 버튼" width=100%
                        /></a><br> <br>
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
                     <a
                        href="https://www.facebook.com/profile.php?id=100089405234926"
                     ><i class="fa fa-facebook"></i></a> <a
                        href="https://www.instagram.com/nyangsinsa5/"
                     ><i class="fa fa-instagram"></i></a> <a
                        href="https://twitter.com/nyangsinsa"
                     ><i class="fa fa-twitter"></i></a>
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
                           class="fa fa-heart" aria-hidden="true"
                        ></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
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
   <%--ajax 쓰기 위해 JQ연결 --%>
   <script src="https://code.jquery.com/jquery-3.6.3.min.js"
      integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
      crossorigin="anonymous">
   </script>

   <!-- 아이디 중복확인 -->
   <script type="text/javascript">
      var smsTrue = false;
      var smsCheckTrue = false;
      var registerTrue = false;
      var idTrue = false;
      
      function checkId(){
         console.log('로그 1 : check()라는 JS 함수가 연결되었음');
         var id=$('#id').val(); // $('id 속성이 id인 요소')의 값을 불러올래!
         $.ajax({
            type: 'POST',
            url: 'check',
            data: {id:id},
            success: function(result){
               console.log(result)
               if(id == ""){
                  outputId.textContent = `영어/숫자가 혼합된 4~15자리 아이디를 입력해주세요.`;
               }
               else if(result == 1){
                  console.log(result)
                  outputId.textContent = `사용 가능합니다.`;
                  outputId.style.color = '#6667AB';
                  idTrue = true;
               }
               else{
                  outputId.textContent = `중복된 아이디가 있습니다.`;
                  idTrue = false;
               }
            }
         })
      }
   </script>
   <!-- 아이디 중복확인 end -->
   
   
   <!-- 전화번호 중복확인 -->
   <script type="text/javascript">
      var smsTrue = false;
      var smsCheckTrue = false;
      var registerTrue = false;
      var idTrue = false;
      
   </script>
   <!-- 아이디 중복확인 end -->


   <!-- 카카오 스크립트 -->
   <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
   <!-- 카카오 스크립트 end -->


   <!-- 카카오 로그인 -->
   <script>
      Kakao.init('a4736b83f633d7309942ec1e31da7d0f'); // SDK를 초기화함 / 발급 받은 키 중 javascript키를 사용해준다.
      console.log(Kakao.isInitialized()); // sdk초기화여부판단

      var name = ""; //  현재 로그인한 사람
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
                                 var name= response.kakao_account.profile.nickname;
                                 var id = response.id;
                                 var pw = response.id;
                                 /* window.open("loginCheck.do?action=loginCheck&userName="+name+"&userId="+id+"&userPw="+pw, "loginCheck", "width=500, height=570, left=400, top = 200"); */
                                 // 일치하는 회원 있는지 확인
                                 location.href = "loginCheck.do?userName="+name+"&d="+id;
                                 console.log(response)
                                 console.log(response.kakao_account.profile.nickname) // 로그인 성공한 유저 nickname
                                 name = response.kakao_account.profile.nickname  //  로그인한 유저 이름 저장
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
      </script>

   <!-- 개인정보 처리방침 동의 모달 시작 -->
   <div class="modal fade" id="exampleModal3" tabindex="-1"
      role="dialog" aria-labelledby="exampleModalLabel"
      aria-hidden="true"
   >
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">이용약관</h5>
               <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close"
               >
                  <span aria-hidden="true">&times;</span>
               </button>
            </div>
            <div class="modal-body">
               <div id=tos1></div>
            </div>
            <div class="modal-footer"></div>
         </div>
      </div>
   </div>
   <script type="text/javascript">
const loremIpsum = document.getElementById("tos1")

fetch("tos1.jsp") /*해당 경로의 내용 가져옴 */
    .then(response => response.text())
    .then(result => tos1.innerHTML = result)
  
</script>
   <!-- 개인정보 처리방침 동의 모달 끝 -->
   <!-- 서비스 이용약관 동의 모달 시작 -->
   <div class="modal fade" id="exampleModal2" tabindex="-1"
      role="dialog" aria-labelledby="exampleModalLabel"
      aria-hidden="true"
   >
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">서비스 이용약관</h5>
               <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close"
               >
                  <span aria-hidden="true">&times;</span>
               </button>
            </div>
            <div class="modal-body">
               <div id=tos2></div>
            </div>
            <div class="modal-footer"></div>
         </div>
      </div>
   </div>
   <script type="text/javascript">
const tos2 = document.getElementById("tos2")

fetch("tos2.jsp") /*해당 경로의 내용 가져옴 */
    .then(response => response.text())
    .then(result => tos2.innerHTML = result)
  
    
</script>
   <!-- 서비스 이용약관 동의 모달 끝 -->
   <!-- 마케팅 수신 정보 모달 시작 -->
   <div class="modal fade" id="exampleModal1" tabindex="-1"
      role="dialog" aria-labelledby="exampleModalLabel"
      aria-hidden="true"
   >
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">마케팅 수신동의</h5>
               <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close"
               >
                  <span aria-hidden="true">&times;</span>
               </button>
            </div>
            <div class="modal-body">
               <div id=tos3></div>
            </div>
            <div class="modal-footer"></div>
         </div>
      </div>
   </div>

   <script type="text/javascript">
const tos3 = document.getElementById("tos3")

fetch("tos3.jsp") /*해당 경로의 내용 가져옴 */
    .then(response => response.text())
    .then(result => tos3.innerHTML = result)
  
    
</script>


   <!-- 마케팅 수신 정보 모달 끝 -->


   <!-- 정규표현식 검사 -->
   <script type="text/javascript">
   
    const form = document.querySelector('#register_form')

    const inputId = document.querySelector('#id')
    const inputName = document.querySelector('#name')
    const inputPw = document.querySelector('#password')
    const inputPw2 = document.querySelector('#confirmPassword')
    
    const inputaddress = document.querySelector('#address')
    
    const inputPhoneNum = document.querySelector('#phone')
    
    const inputCnm = document.querySelector('#cName')

    const outputId = document.querySelector('#outputId')
    const outputName = document.querySelector('#outputName')
    const outputcName = document.querySelector('#outputcName')
    const outputPw = document.querySelector('#outputPw')
    const outputPw2 = document.querySelector('#outputPw2')
    const outputAddress = document.querySelector('#outputAddress')
    const outputPhoneNum = document.querySelector('#outputPhonNum')

    const reId = /^[a-z0-9]{4,15}$/
    const reName = /^[가-힣]{2,6}$/
    const reCname = /^[가-힣]{2,6}$/
    const rePw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/
    const rePhoneNum = /^01([0|1|6|7|8|9]{1})+([0-9]{3,4})+([0-9]{4})$/

    // 정규표현식 통과 boolean
    var idValid = false; // 아이디 정규식 일치 여부
    var nameValid = false; // 이름 정규식 일치 여부
    var cNameValid = false; // 고양이 이름 정규식 일치 여부
    var PhoneNumValid = false; // 휴대폰 번호 정규식 일치 여부
    var pwValid = false; // 비밀번호 정규식 일치 여부
    var pwSame = false; // 비밀번호 확인 일치 여부
    var isPhoneOnly = false; // 전화번호 중복 확인 통과 여부
    
    inputId.addEventListener('input', function () {
       idTrue = false;
       /* checkId() */
        const ok = reId.exec(this.value)
        if (!ok) {
           idTrue = false;
            outputId.textContent = `영어/숫자가 혼합된 4~15자리 아이디를 입력해주세요.`
            outputId.style.color = 'red'
            idValid = false; // id 플래그 false
        } else {
           idTrue = false;
            outputId.textContent = `아이디 중복체크를 진행해주세요.`
            outputId.style.color = 'red'
            idValid = true; // id 플래그 true
        }
        if (idValid) {
            console.log('idValid ooo', idValid);
        } else {
            console.log('idValid xxx', idValid);
        }
    })
    inputName.addEventListener('input', function () {
        const ok = reName.exec(this.value)
        if (!ok) {
            outputName.textContent = `한글 2~6자리 이름을 입력해주세요.`;
            outputName.style.color = 'red';
            nameValid = false;
        } else {
            outputName.textContent = `사용 가능합니다.`;
            outputName.style.color = '#6667AB';
            nameValid = true;
        }
    })
    inputCnm.addEventListener('input', function () {
        const ok = reCname.exec(this.value)
        if (!ok) {
            outputcName.textContent = `한글 2~6자리 고양이 이름을 입력해주세요.`;
            outputcName.style.color = 'red';
            cNameValid = false;
        } else {
            outputcName.textContent = `사용 가능합니다.`;
            outputcName.style.color = '#6667AB';
            cNameValid = true;
        }
    })
    
      inputPw.addEventListener('input', function () {
        const ok = rePw.exec(this.value)
        if (!ok) {
            outputPw.textContent = `영어/숫자/특수문자를 모두 혼합하여 8자리 이상 비밀번호를 입력해주세요.`;
            outputPw.style.color = 'red';
            pwValid = false;

        } else {
            outputPw.textContent = `사용 가능합니다.`;
            outputPw.style.color = '#6667AB';
            pwValid = true;
        }
    })
    
    inputPw2.addEventListener('input', function () {
        if (inputPw.value == inputPw2.value) {
            outputPw2.textContent = `일치합니다.`
            outputPw2.style.color = '#6667AB'
            inputPw.addEventListener('input', function () {
               if(inputPw.value==""){
                    outputPw2.textContent = `비밀번호를 다시 입력해주세요.`
                        outputPw2.style.color = 'red'
                        pwSame = false;
                  }else if (inputPw.value == inputPw2.value) {
                    outputPw2.textContent = `일치합니다.`
                    outputPw2.style.color = '#6667AB'
                    pwSame = true;
                   } else {
                    outputPw2.textContent = `비밀번호를 다시 입력해주세요.`
                    outputPw2.style.color = 'red'
                    pwSame = false;
                   }
            })
            pwSame = true;
        } else {
            outputPw2.textContent = `비밀번호를 다시 입력해주세요.`
            outputPw2.style.color = 'red'
            pwSame = false;
        }
    })

    
    function register(){
        if (!(idValid && nameValid && cNameValid && pwValid && pwSame)) {
           console.log('아이디'+idValid)
           console.log('이름'+nameValid)
           console.log('고양이 이름'+cNameValid)
           console.log('비번'+pwValid)
           console.log('비번재확인'+pwSame)
           registerTrue = false;
        }else{
           registerTrue = true;
           console.log(registerTrue)
        }
    }
   <!-- 정규식 스크립트 end -->

   <!-- 문자 인증 스크립트 -->
   var number=0;  //랜덤문자인증번호 저장할 변수   
   //  var phoneCheck=0;  //인증번호 일치, 불일치 변수
   // 인증번호 전송하기: sms()
   
   // 전화번호 형식 확인
   inputPhoneNum.addEventListener('input', function () {
        const ok = rePhoneNum.exec(this.value)
        if (!ok) {
           outputPhone.textContent = `휴대폰 번호를 확인해주세요.`;
           outputPhone.style.color = 'red';
            phoneNumValid = false;

        } else {
           outputPhone.textContent = `인증번호 전송버튼을 눌러주세요.`;
           outputPhone.style.color = '#6667AB';
           phoneNumValid = true;
        }
    })

   
   function sms(){
      
      // 전화번호 중복검사
      console.log('로그 1 : checkPhone()이라는 JS 함수가 연결되었음');
      var phone=$('#phone').val(); // $('id 속성이 phone인 요소')의 값을 불러올래!
      $.ajax({
         type: 'POST',
         url: 'check',
         data: {phone:phone},
           success: function(result){
              console.log("checkResult: "+result)
               if(result == 1){
               isPhoneOnly = true;
               }
               else if(result == -1){
                  outputPhone.textContent = `이미 등록된 번호입니다.`;
                  outputPhone.style.color = 'red';
               isPhoneOnly = false;
               }
               console.log("phoneNumValid: "+phoneNumValid)
               console.log("isPhoneOnly: "+isPhoneOnly);
         }
      }).then(function(){
         console.log("로그: 인증번호 발송 메서드 시작")
         if(!phoneNumValid){ // 전화번호 형식이 틀리다면
            outputPhone.textContent = `휴대폰 번호를 다시 한 번 확인해주세요.`;
              outputPhone.style.color = 'red';
         }
         else if(phoneNumValid && !isPhoneOnly){ // 전화번호 형식이 맞지만 중복이라면
            outputPhone.textContent = `다른 휴대폰 번호를 입력해주세요.`;
              outputPhone.style.color = 'red';
         }
         else if(phoneNumValid && isPhoneOnly){ // 전화번호 형식이 맞고 중복이 아니라면
            console.log('로그 1 : sms()라는 JS 함수가 연결되었음');
            var userPhoneNum = $("#phone").val();
            
            console.log('로그2 : userPhoneNum '+userPhoneNum);
            //Sms서블릿클래스로 이동함.
            $.ajax({
               type: 'POST',
               url: 'Sms',
               data: {userPhoneNum:userPhoneNum},
               success: function(randNum){
                      console.log("로그:인증번호["+randNum+"]")
                      console.log("로그:번호["+userPhoneNum+"]")
                      if(randNum != null){
                         number = randNum;  //랜덤문자인증번호
                         smsTrue = true;
                         console.log(smsTrue)
                         outputPhone.textContent = `인증번호가 전송되었습니다.`;
                           outputPhone.style.color = '#6667AB';
                      } 
                      else{
                         outputPhone.textContent = `인증번호 전송이 불가능합니다.`;
                           outputPhone.style.color = 'red';
                         smsTrue = false;
                      }
                   }
            })
         }
         console.log("로그: 인증번호 발송 메서드 끝")
      })
   }
       
     //인증번호 비교: sms()
       function smsCheck(){
          console.log('로그 : smsCheck()라는 JS 함수가 연결되었음');
          var checkNum = $("#userCheck").val();
          console.log('로그(사용자가 입력한 값) : checkNum '+checkNum);
          
          //SmsCheck서블릿클래스로 이동
          $.ajax({
             type: 'POST',
             url: 'SmsCheck',
             data: {randNum:number, checkNum:checkNum},
             success: function(result){
                console.log("로그 result:["+result+"]")
                console.log(typeof result);
                if(result == "1"){
                   alert("인증번호가 일치합니다!");
                   smsCheckTrue = true;
                   console.log(smsCheckTrue)
                   document.getElementById('phone').readOnly = true;
                } 
                else{
                   alert("인증번호가 일치하지 않습니다.다시 입력하세요!");  //인증번호 불일치
                   smsCheckTrue = false;
                }
             }
          })
       }
       
   <!-- 문자 인증 스크립트 end -->

   function registerCheck(){
      register()
      checkId()
      console.log('회원가입' + registerTrue)
      console.log('문자 전송' + smsTrue)
      console.log('인증번호' + smsCheckTrue)
      console.log('아이디 중복확인' + idTrue)
      if(registerTrue && smsTrue && smsCheckTrue && idTrue){
         return true;
      }else{
         if(!smsTrue){
            alert("휴대폰 인증을 진행해주세요"); 
         }else if(!smsCheckTrue){
            alert("인증번호를 확인해주세요"); 
         }else if(!registerTrue){
            alert("입력한 내용을 확인해주세요"); 
         }else if(!idTrue){
            alert("아이디 중복을 확인해주세요"); 
         }
         return false;
      }
   }
   </script>


   <!-- 주소 API 스크립트 -->
   <script
      src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("address_plus").value = extraAddr;
                
                } else {
                    document.getElementById("address_plus").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('post').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("address_detail").focus();
            }
        }).open();
    }
   </script>
    <!-- 주소 스클립트 end -->

   <!-- <!— TOP 버튼 —> --> -->
   <div style="width: 120px; position: fixed; bottom: 80px; right: 100px; z-index: 1;">
      <a href="#"><button type="button" class="button-top">▲맨위로</button></a>
   </div>


</body>

</html>