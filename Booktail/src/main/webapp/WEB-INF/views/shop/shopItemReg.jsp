<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서 등록</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../resources/css/styles.css" rel="stylesheet" />
    <link href="../resources/css/productWrite.css" rel="stylesheet" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../resources/js/bookReg.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</head>

<body>
	<%@ include file="../nav.jsp" %>
	<div id="wrap">
		<div class="main1">
			<h2>도서 검색</h1>
			<div class="searchBox">
				<input id="bookName" type="text">
				<button id="search">검색</button>
			</div>
			<div id="coverimg"></div>

			<!-- 검색결과 -->
			<div class="productBox">
				<div class="innerBox">
				<form id="productForm" role="form" action="/shop/itemReg"
					method="post">

					<table class="type09">
						<thead>
							<tr>
								<th scope="cols"></th>
								<th scope="cols"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">책 이름</th>
								<td><input type="text" name="title"></td>
							</tr>
							<tr>
								<th scope="row">국제표준 도서번호</th>
								<td><input type="text" name="isbn"></td>
							</tr>
							<tr>
								<th scope="row">출판 날짜</th>
								<td><input type="text" name="datetime" maxlength='5'></td>
							</tr>
							<tr>
								<th scope="row">책 썸네일 주소</th>
								<td><input type="text" name="thumbnail"></td>
							</tr>	
							<tr>
								<th scope="row">책 저자</th>
								<td><input type="text" name="authors"></td>
							</tr>
							<tr>
								<th scope="row">책 번역자</th>
								<td><input type="text" name="translators"></td>
							</tr>
							<tr>
								<th scope="row">책 내용</th>
								<td><input type="text" name="contents"></td>
							</tr>
							<tr>
								<th scope="row">출판사</th>
								<td><input type="text" name="publisher"></td>
							</tr>
							<tr>
								<th scope="row">정가(원)</th>
								<td><input type="text" name="price"></td>
							</tr>
							<tr>
								<th scope="row">판매가(원)</th>
								<td><input type="text" name="salePrice"></td>
							</tr>
						</tbody>
						<tfoot>
							<th scope="cols"></th>
							<th scope="cols"></th>
						</tfoot>
					</table>
					<div id="pbutton">
						<button type="submit" class="pbtn">등록</button>
					</div>
				</form>
				</div>
			</div>
			<!-- .productBox -->
		</div>
		<!-- main1 끝 -->
		<%@ include file="../footer.jsp" %>
	</div> <!-- wrap -->
</body>

</html>