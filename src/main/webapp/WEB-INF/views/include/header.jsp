<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- style -->
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/include/header.css">

<!-- jquery -->
<script src="/resources/js/jquery.js"></script>
<script src="/js/subpage/menu_floting.js"></script>
<script src="/js/subpage/img_change.js"></script>

</head>
<body>

	<header id="header" class=<%=request.getParameter("class") %> >
		<div class="container">
			<div class="header">
				<div class="header_menu">
					<a href="#">MyPage</a> <a href="#">Login</a> <a href="#">Register</a>
				</div>
				<!-- //header_menu -->
				<div class="header_title">
					<a href="index">사이트 제목</a>
				</div>
				<!-- //header_title -->
			</div>
		</div>
	</header>
	<!-- //header -->

	<article id="title">
		<div class="container">
			<div class="title" id="menu">
				<ul class="category">
					<li><div>
							<a href="/cat/total_cat?class=cat&page=1" >고양이 분양</a>
						</div>
						<ul class="sub_category">
							<li><a href="#">고양이 분양 1</a></li>
							<li><a href="#">고양이 분양 2</a></li>
							<li><a href="#">고양이 분양 3</a></li>
							<li><a href="#">고양이 분양 4</a></li>
							<li><a href="#">고양이 분양 4</a></li>
							<li><a href="#">고양이 분양 4</a></li>
							<li><a href="#">고양이 분양 4</a></li>
							<li><a href="#">고양이 분양 4</a></li>
						</ul></li>
					<li><div>
							<a href="/dog/total_dog?class=dog" >강아지 분양</a>
						</div>
						<ul class="sub_category">
							<li><a href="#">강아지 분양 1</a></li>
							<li><a href="#">강아지 분양 2</a></li>
							<li><a href="#">강아지 분양 3</a></li>
							<li><a href="#">강아지 분양 4</a></li>
						</ul></li>
					<li><div>
							<a href="shop">SHOP</a>
						</div>
						<ul class="sub_category">
							<li><a href="#">SHOP 1</a></li>
							<li><a href="#">SHOP 2</a></li>
							<li><a href="#">SHOP 3</a></li>
							<li><a href="#">SHOP 4</a></li>
						</ul></li>
					<li><div>
							<a href="service_center">고객센터</a>
						</div>
						<ul class="sub_category">
							<li><a href="#">고객센터 1</a></li>
							<li><a href="#">고객센터 2</a></li>
							<li><a href="#">고객센터 3</a></li>
							<li><a href="#">고객센터 4</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</article>
