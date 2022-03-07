$(document).ready(function(){
	$("#search").click(function(){
		$.ajax({
	        method: "GET",
	        url: "https://dapi.kakao.com/v3/search/book",
	        data: {query:$("#bookName").val()},
	        headers: {
	            Authorization: "KakaoAK e28cac004f67900358cf5bd49631b0f3"
	        }
	    })
	    .done(function (msg) {
	    	let data=msg.documents[0];
	    	$("#coverimg").append("<img src='" + data.thumbnail + "'/>");
	    	$("[name='thumbnail']").val(data.thumbnail);
	    	$("[name='isbn']").val(data.isbn);
	    	$("[name='title']").val(data.title);
	    	$("[name='datetime']").val(data.datetime);
	    	$("[name='contents']").val(data.contents);
	    	$("[name='authors']").val(data.authors);
	    	$("[name='translators']").val(data.translators);
	    	$("[name='publisher']").val(data.publisher);
	    	$("[name='price']").val(data.price);
	    	$("[name='salePrice']").val(data.sale_price);
	    });
	});
	
});