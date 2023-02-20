<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="nss" tagdir="/WEB-INF/tags/" %>
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
</style>

</head>

<body>

   <script src="https://code.jquery.com/jquery-3.6.3.min.js"
      integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
      crossorigin="anonymous"
   ></script>
   <script type="text/javascript">
   function check(){
      console.log('로그 1 : check()라는 JS 함수가 연결되었음');
      var id=$('#id').val(); // $('id 속성이 id인 요소')의 값을 불러올래!
      $.ajax({
         type: 'POST',
         url: 'check',
         data: {id:id},
         success: function(result){
            if(result==1){
               $('#outputId').html('사용가능'); // $('id 속성이 checkmsg인 요소')에 텍스트 추가
            }
            else{
               $('#outputId').html('사용불가능');
            }
         }
      })
   }
</script>

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
                        
                        <span>상담 가능 시간<br>평일 09:00~18:00</span>
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
      <div class="container" align="center">
            
            <div class="col-lg-6">
               <div class="login_form_inner">
               
                  <form class="row login_form" action="changePw.do?userId=${memberId}" method="post" onsubmit="return register()" id="contactForm" >
                     <div class="col-md-12 form-group">
                     <p>새로운 비밀번호를 입력해 주세요.</p>
                        
                     </div>
                     <br><br><br><br>
                     <!-- 비밀번호 -->
                     <div class="col-md-12 form-group">
                        <input type="password" class="form-control" id="password"
                           name="userPw" placeholder="비밀번호 입력"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '비밀번호 입력'" required
                        >
                     </div>
                     <p class="checkre" id="outputPw">영어/숫자/특수문자를 혼합하여 8자리 이상
                        비밀번호를 입력해주세요</p>

                     <!-- 비밀번호 확인 -->
                     <div class="col-md-12 form-group">
                        <input type="password" class="form-control"
                           id="confirmPassword" name="confirmPassword"
                           placeholder="비밀번호 재입력" onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '비밀번호 재입력'" required
                        >
                     </div>
                     <p class="checkre" id="outputPw2">비밀번호를 다시 입력해주세요</p>
                     
                     <div class="col-md-12 form-group">
                        <button type="submit" value="submit" class="button button-login w-100">비밀번호 변경하기</button>
                        <div><br></div>
                        
                     </div>
                     <br><br><br><br>
                  </form>
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

fetch("tos1.html") /*해당 경로의 내용 가져옴 */
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

fetch("tos2.html") /*해당 경로의 내용 가져옴 */
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
   


   <!-- 마케팅 수신 정보 모달 끝 -->

   <!-- 정규표현식 검사 -->
   <script type="text/javascript">

    const inputPw = document.querySelector('#password')
    const inputPw2 = document.querySelector('#confirmPassword')

    const outputPw = document.querySelector('#outputPw')
    const outputPw2 = document.querySelector('#outputPw2')

    const rePw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/

    // 정규표현식 통과 boolean
    // var idValid = reId.test(inputId) 는 어떻게 사용할 지 모르겠음
    var pwValid = false;
    var pwSame = false; // 비밀번호 확인 일치 여부
    
    
  
    
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
    var isCorrect =  pwValid && pwSame;

    const signupBtn = document.querySelector('#signupBtn');


    signupBtn.addEventListener("submit", function () {
     if(!(pwValid && pwSame)){
       return false;
        }  
   })
   
    function register() {
        if (!(pwValid && pwSame)) {
          alert('다시확인해주세요');
          return false;
        }else{
           return true;
        }
      }

</script>
   <%--ajax 쓰기 위해 JQ연결 --%>
   
   
      <!-- TOP 버튼 -->
   <div style="width: 120px; position: fixed; bottom: 80px; right: 100px; z-index : 1;">
      <a href="#"><button type="button" class="button-top">▲ 맨위로</button></a>
   </div>
</body>

</html>