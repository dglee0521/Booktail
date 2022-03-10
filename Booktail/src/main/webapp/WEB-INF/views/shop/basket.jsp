<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width">
	<title>장바구니</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	<link href="../resources/css/basket.css" rel="stylesheet" />
	<link href="../resources/css/styles2.css" rel="stylesheet" /> 
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/basket2.js"></script>  
</head>
<body>

	<!-- nav -->
    <%@ include file="../nav.jsp" %>
    <!-- 장바구니 리스트 -->
    
    <div class="basketBox">
    <h2 style="margin-bottom:30px">장바구니 리스트</h2>
	    <form name="orderform" id="orderform" method="post" class="orderform" action="/Page" onsubmit="return false;">
	    
	            <input type="hidden" name="cmd" value="order">
	            <div class="basketdiv" id="basket">
	                <div class="row head">
	                    <div class="subdiv">
	                        <div class="check"><input type="checkbox" name="allCheck" id="allCheck" style="height:auto"/></div>
	                        <div class="img">이미지</div>
	                        <div class="pname">상품명</div>
	                    </div>
	                    <div class="subdiv">
	                        <div class="basketprice">가격</div>
	                        <div class="num">수량</div>
	                        <div class="sum">합계</div>
	                    </div>
	                    <div class="subdiv">
	    
	                        <div class="basketcmd">삭제</div>
	                    </div>
	                    <div class="split"></div>
	                </div>
	             	<c:set var="sum" value="0" />
	        		<c:forEach items="${cartList}" var="cartList">
	        		<c:set var="sumOne" value="0" />
		                <div class="row data">
		                    <div class="subdiv">
		                        <div class="check"><input type="checkbox" class="chBox" data-cartNum="${cartList.cartNum}" name="buy" value="" onclick="javascript:basket.checkItem();">&nbsp;</div>
		                        <div class="img"><img src="${cartList.thumbnail}"></div>
		                        <div class="pname">
		                            <span>${cartList.title}</span>
		                        </div>
		                    </div>
		                    <div class="subdiv">
		                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" fmt:formatNumber pattern="###,###,###" class="p_price" value="${cartList.salePrice}"> <fmt:formatNumber pattern="###,###,###" value="${cartList.salePrice}" />원</div>
		                        <div class="num">
		                            <div class="updown">
		                                <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" data-cartNum="${cartList.cartNum}" value="${cartList.cartStock}" onkeyup="">
		                                <span><i class="fas fa-arrow-alt-circle-up up"></i></span>
		                                <span><i class="fas fa-arrow-alt-circle-down down"></i></span>
		                            </div>
		                        </div>
		                        <!-- 합계 -->
		                        <c:set var="sumOne" value="${sumOne + (cartList.salePrice * cartList.cartStock)}" />
		                        <div class="sum"><fmt:formatNumber pattern="###,###,###" value="${sumOne}" />원</div>
		                    </div>
		                    <div class="subdiv delete">
		                        <div class="basketcmd"><a href="javascript:void(0)" data-cartNum="${cartList.cartNum}" class="abutton delete_${cartList.cartNum}_btn" onclick="javascript:basket.delItem();">삭제</a></div>
		                        <script>
		                      //개별 삭제
		                    	$(".delete_${cartList.cartNum}_btn").click(function(){
		                    	   var confirm_val = confirm("정말 삭제하시겠습니까?");
		                    	   
		                    	   if(confirm_val) {
		                    	    var checkArr = new Array();
		                    	    
		                    	    checkArr.push($(this).attr("data-cartNum"));
		                    	               
		                    	    $.ajax({
		                    	     url : "/shop/deleteCart",
		                    	     type : "post",
		                    	     data : { chbox : checkArr },
		                    	     dataType:"json",
		                    	     success : function(result){
		                    	      if(result == 1) {     
		                    	       location.href = "/shop/basket";
		                    	      } else {
		                    	       alert("삭제 실패");
		                    	      }
		                    	     }
		                    	    });
		                    	   } 
		                    	});
		                      </script>
		                    </div>
		                </div>
		            <c:set var="sum" value="${sum + (cartList.salePrice * cartList.cartStock)}" />
	                </c:forEach>
	                
	    		</div>
	    		<input type="button" value="선택삭제" class="selectDeleteBtn">
	    		
	    		<div class="listResult">
	            <div class="bigtext right-align box blue summoney sum" id="sum_p_price">합계금액: <fmt:formatNumber pattern="###,###,###" value="${sum}" />원</div>
	             <div class="orderOpne">
				  <button type="button" class="orderOpne_bnt">주문 정보 입력</button>
				 </div>
	            </div>
    			 

	        </form>
	        <div class="orderInfo">
			 <form role="form" method="post" autocomplete="off" action="/shop/cartList">
			    
			  <input type="hidden" name="amount" value="${sum}" />
			    
			  <div class="inputArea">
			   <label for="">수령인</label>
			   <input type="text" name="orderRec" id="orderRec" required="required" />
			  </div>
			  
			  <div class="inputArea">
			   <label for="orderPhon">수령인 연락처</label>
			   <input type="text" name="orderPhone" id="orderPhon" required="required" />
			  </div>
			  
			  <div class="inputArea">
			   <label for="userAddr1">우편번호</label>
			   <input type="text" name="userAddr1" id="userAddr1" required="required" />
			  </div>
			  
			  <div class="inputArea">
			   <label for="userAddr2">1차 주소</label>
			   <input type="text" name="userAddr2" id="userAddr2" required="required" />
			  </div>
			  
			  <div class="inputArea">
			   <label for="userAddr3">2차 주소</label>
			   <input type="text" name="userAddr3" id="userAddr3" required="required" />
			  </div>
			  
			  <div class="inputArea">
			   <button type="submit" class="order_btn">주문</button>
			   <button type="button" class="cancel_btn">취소</button> 
			  </div>
			  
			 </form> 
			</div>
        </div>
		<%@ include file="../footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../resources/js/scripts.js"></script>
</body>
</html>