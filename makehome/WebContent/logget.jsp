<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인되었습니다.</title>
<style>
a { text-decoration:none }
@font-face{
font-family:'DXKPMB';
src:url('DXKPMB.woff');
}
body, div, table,input {
 font-family: 'DXKPMB';
 font-size:14pt;
}
.frame{
	width:1300px;
	margin: 0 auto;
	
}
.header {
	
	text-align: center;
	
	
	
}
.logo{
	font-size: 2em;
	font-weight: bold;
	
	float: left;
	margin-left: 100px;
}
.container01{
	overflow:hidden;
}
.nav{
	float: left;
	width:400px;
	
	margin-left: 50px;
}
.log{
	float: right;
	width:300px;
	
	margin-right: 50px;
}
.navlist{
	width: 80px;
	
	
	font-size:12px;
	font-weight:bold;
	text-align: center;
	padding: 15px 0;
	float: left;
}
.loglist{
	width: 80px;
	
	
	font-size:12px;
	font-weight:bold;
	text-align: center;
	padding: 15px 0;
	float: right;


}
.nav-item{
	margin:4px 0;
	float: left;
}
.nav-link{
	display: block;
	text-decoration: none;
	padding: 4px 10px;
	color: #fff;
}
.nav-link:hover{
	background: #5457de;
}
.section{
	width:1300px;
	margin: 0 auto;
	border: 1px solid #aaa;
	height:800px;
}
.head{

height: 100px;
width: 1298px;
float: left;
text-align: center;

}
.memb{
	border: 1px solid #aaa;
	width: 508px;
	height: 560px;
	margin: 50px 396px;
	float: left;
}
.footer{
	text-align: center;
	
	font-size: 10px;
	width: 1300px;
	height:70px;
}

</style>
</head>
<body>
	<div class='frame'>
		<div class='header'>
			<div class='container01'>
				<div class='nav'>
					<div class='navlist'><a href='main.html'>HOME</a></div>
					<div class='navlist'><a href='set.html'>SET</a></div>
					<div class='navlist'><a href='cus.html'>CUSTOM</a></div>
					<div class='navlist'><a href='ran.html'>RANDOM</a></div>
				</div>
				<div class='logo'><a href='main.html'>치킨,오졌다!</a></div>
				<div class='log'>
					
					<div class='loglist'><a href='mem.html'>membership</a></div>
					<div class='loglist'><a href='log.html'>login</a></div>
		
		
				</div>
			</div>
		</div>
		<!--  header -->
		<div class='section'>
			<div class='head'>
					<hr><br>
					M E M B E R S H I P<br>
					<br>
					<hr>
				</div>
			
				<div class='memb' style='text-align:center'>
<% 
request.setCharacterEncoding("UTF-8");
String strid=request.getParameter("id");
out.println("아이디 :" + strid + "<br/>");
String strpsw=request.getParameter("psw");
out.println("비밀번호 :" + strpsw + "<br/>");

%>

<a href="set.html" target="_self">주문하러가기</a>
</div>
		</div>
			<!-- section -->
		<div class='footer'>
		상호명: 치킨,오졌다! | 대표: 김성규 | 개인정보관리책임자: 임수용 | 전화: 010-2565-9988 | 이메일: makehome11@mail.com <br>
주소: 대전광역시 중구 선화서로 24번길 14 | 사업자등록번호: 322-68-467708 <br>
Copyright © 2018 SKHOME
		</div>
		<!-- footer -->
	</div>
		
</body>
</html>