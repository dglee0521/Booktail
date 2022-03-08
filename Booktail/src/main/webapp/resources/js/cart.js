$(document).ready(function(){
	$(".addCartBtn").click(function(){
		  var gdsNum = $(".gdsNum").val();
		  var cartStock = $(".numBox").val();
		           
		  var data = {
		    gdsNum : gdsNum,
		    cartStock : cartStock
		    };
		  
		  $.ajax({
		   url : "/shop/addCart",
		   type : "post",
		   data : data,
		   dataType: "json",
		   success : function(result){
			console.log(result);
		    if(result == 1) {
		     alert("카트 담기 성공");
		     $(".numBox").val("1");
		    } else {
		     alert("회원만 사용할 수 있습니다.")
		     $(".numBox").val("1");
		    }
		   },
		   error : function(){
		    alert("카트 담기 실패");
		   }
		  });
	 });
})