<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>ShopDetail</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../resources/css/styles.css" rel="stylesheet" />
        <link href="../resources/css/itemDetail.css" rel="stylesheet" />
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- Core theme JS-->
        <script src="../resources/js/cart.js"></script>
    </head>
    <body>
    	<!-- nav -->
        <%@ include file="../nav.jsp" %>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${detail.thumbnail}" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">${detail.publisher}</div>
                        <input type="text" class="gdsNum" name="gdsNum" value="${detail.gdsNum}">
                        <h1 class="display-5 fw-bolder">${detail.title}</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through"><fmt:formatNumber pattern="###,###,###" value="${detail.price}" />원</span>
                            <span><fmt:formatNumber pattern="###,###,###" value="${detail.salePrice}" />원</span>
                        </div>
                        <p class="lead">${detail.contents}</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3 numBox" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0 addCartBtn" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 상품 리뷰 -->
        <div id="reply" style="width:1200px; margin:0 auto;">
		 <c:if test="${login == null }">
		  <p>소감을 남기시려면 <a href="/login">로그인</a>해주세요</p>
		 </c:if>
		 
		 <c:if test="${login != null}">
		 <section class="replyForm">
		  <form role="form" method="post" action="/shop/registReview" autocomplete="off">
		  	<input type="hidden" name="gdsNum" value="${detail.gdsNum}">
		   <div class="input_area">
		    <textarea name="repCon" id="repCon"></textarea>
		   </div>
		   
		   <div class="input_area">
		    <button type="submit" id="reply_btn">소감 남기기</button>
		   </div>
		   
		  </form>
		 </section>
		 </c:if>
		 
		 <section class="replyList">
		  <ol>
		  <c:forEach items="${reviews}" var="reviews">
		   <li>
		       <div class="userInfo">
		        <span class="userName">${reviews.userId}</span>
		        <span class="date"><fmt:formatDate value="${reviews.repDate}" pattern="yyyy-MM-dd" /></span>
		       </div>
		       <div class="replyContent">${reviews.repCon}</div>
		     </li>
		    </c:forEach>
		   </ol>    
		 </section>
		</div>
        </section>
        
        <!-- Footer-->
        <%@ include file="../footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../resources/js/scripts.js"></script>
    </body>
</html>