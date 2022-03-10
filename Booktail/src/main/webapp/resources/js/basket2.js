$(document).ready(function(){
	//모두 선택 버튼
	$("#allCheck").click(function(){
		 var chk = $("#allCheck").prop("checked");
		 if(chk) {
		  $(".chBox").prop("checked", true);
		 } else {
		  $(".chBox").prop("checked", false);
		 }
	});
	//개별 선택버튼을 취소하면 모두선택 꺼짐
	$(".chBox").click(function(){
		  $("#allCheck").prop("checked", false);
	 });
	
	//선택 삭제
	$(".selectDeleteBtn").click(function(){
	  var confirm_val = confirm("정말 삭제하시겠습니까?");
	  
	  if(confirm_val) {
	   var checkArr = new Array();
	   
	   $("input[class='chBox']:checked").each(function(){
	    checkArr.push($(this).attr("data-cartNum"));
	   });
	    
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
	
	//수량 변경
	$(".p_num").change(function(){
		$.ajax({
			url:"/shop/changeStock",
			type:"post",
			data:{cartStock:$(this).val(),cartNum:$(this).attr("data-cartNum")},
			dataType:"json",
			success:function(result){
				
			}
		})
	})
	
	$(".up").click(function(){
		
		var p_num = $(this).parents(".updown").children(".p_num");
		var num = p_num.val();
		num = parseInt(num) + 1;
		p_num.val(num);
		
		$.ajax({
			url:"/shop/changeStock",
			type:"post",
			data:{cartStock:p_num.val(),cartNum:p_num.attr("data-cartNum")},
			dataType:"json",
			success:function(result){
				
			}
		})
	})
	
	$(".down").click(function(){
		var p_num = $(this).parents(".updown").children(".p_num");
		var num = p_num.val();
		num = parseInt(num) - 1;
	
		p_num.val(num);
		
		$.ajax({
			url:"/shop/changeStock",
			type:"post",
			data:{cartStock:p_num.val(),cartNum:p_num.attr("data-cartNum")},
			dataType:"json",
			success:function(result){
				
			}
		})
	})
	
});

