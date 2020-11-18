<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // 不想要暫存 Prevents caching at the proxy server
%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>留言板</title>
<style>
body {
	width: 100% auto;
	margin: 0;
	padding: 0;
}

.box {
	width: 100% auto;
}

.top_box1 {
	width: 100%;
	height: 94px;
	position: fixed;
	background-color: black;
	z-index: 100;
}

.top_box2 {
	margin-top: 90px;
	width: 100%;
	height: 64px;
	position: fixed;
	background-color: white;
	box-shadow: 0 0 5px 0 gray;
	z-index: 100;
}

.logo_box {
	margin-left: 10%;
	height: 184px;
	width: 80%;
}

.menu_box {
	margin-left: 10%;
	height: 64px;
	width: 80%;
}

.logo {
	margin-left: 40%;
	float: left;
	clear: both;
}

.other {
	float: left;
	height: 44px;
	width: 40%;
	font-weight: bold;
}

.other ul {
	float: right;
}

.other ul li {
	float: right;
	margin-left: 30px;
	color: white;
	list-style-type: none;
	font-size: 20px;
	cursor: pointer;
}

.menu {
	float: left;
	height: 64px;
	width: 80%;
	font-weight: bold;
}

.menu ul {
	float: left;
}

.menu ul li {
	float: left;
	margin-top: 5px;
	margin-right: 160px;
	color: black;
	list-style-type: none;
	font-size: 20px;
	cursor: pointer;
}

.search {
	float: right;
	height: 64px;
	width: 200px;
}

input {
	width: 20px;
	height: 35px;
	margin-top: 15px;
	padding: 0 25px 0 20px;
	font-size: 18px;
	font-weight: bold;
	outline: none;
}



* {
	margin: 0;
	padding: 0;
}

body, input {
	font-size: 14px;
	line-height: 24px;
	color: #333;
	font-family: Microsoft yahei, Song, Arial, Helvetica, Tahoma, Geneva;
	width: fit-content;
}

h1 {
	margin-bottom: 15px;
	height: 100px;
	line-height: 100px;
	text-align: center;
	font-size: 24px;
	color: #fff;
	background:	#FF8000;
}

#content #post, #comment p {
	zoom: 1;
}

#content #post:after, #comment p:after {
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
	overflow: hidden;
	content: '.';
}

.transition {
	-webkit-transition: all 0.5s linear;
	-moz-transition: all 0.5s linear;
	-o-transition: all 0.5s linear;
	-ms-transition: all 0.5s linear;
	transition: all 0.5s linear;
}

#content {
	margin: 0 auto;
	width: 960px;
	overflow: hidden;
	margin-left: 500px;
}

#content #post {
	margin-bottom: 15px;
	padding-bottom: 15px;
	border-bottom: 1px #d4d4d4 dashed;
	height: 556px;
}

#content #post textarea {
	display: block;
	margin-bottom: 10px;
	padding: 5px;
	width: 948px;
	height: 250px;
	border: 1px #d1d1d1 solid;
	border-radius: 5px;
	resize: none;
	outline: none;
}

#content #post textarea:hover {
	border: 1px #9bdf70 solid;
	background: #f0fbeb;
}

#content #post #postBt, #content #post #clearBt {
	margin-left: 5px;
	padding: 3px;
	float: right;
}

#comment {
	overflow: hidden;
}

#comment p {
	margin-bottom: 10px;
	padding: 10px;
	border-radius: 5px;
}

#comment p:nth-child(odd) {
	border: 1px solid #e3e197;
	background: #ffd;
}

#comment p:nth-child(even) {
	border: 1px solid #adcd3c;
	background: #f2fddb;
}
/*#comment p span{display:inline; float:left;}*/
#comment p .right {
	text-align: right;
}

#comment p .msg {
	width: 738px;
}

#comment p .datetime {
	width: 200px;
	color: #999;
	text-align: right;
}

#postBt, #clear{
	border: none;
	background-color:#adcd3c;
	color:white;
	border-radius: 5px;
	width: 80px;
	height: 30px;
	float: right
}

#shangtian,#ritian{
	border: none;
	background-color:#adcd3c;
 	color: white;
  	width: auto;
}
</style>
</head>

<header>
	<div class="box">
		<div id="top" class="top_box1">
			<div class="logo_box">
				<div class="logo">
					<a href="Home.html"><img src="images/2.png"></a>
				</div>
				<div class="other">
					<ul>
						<li>購物車</li>
						<li>登入/註冊</li>
					</ul>
				</div>
			</div>
		</div>
</header>
<nav>
	<div class="top_box2">
		<div class="menu_box">
			<div class="menu">
				<ul>
					<li>優惠活動</li>
					<li>熱銷產品</li>
					<li>保養品</li>
					<li>留言板</li>
					<li>預約活動</li>
				</ul>
			</div>
			<div class="search">
				<input type="search" placeholder="搜尋" autocomplete="off">
			</div>
		</div>
	</div>
	</div>
</nav>

<body>

	<h1>留言板</h1>

	<div id="content">
		<div id="post" style="margin-top: 60px;">

			<H1 style="border-radius:10px" ALIGN="CENTER">留言佈告欄</H1>

			<div style="background:#adcd3c; height: 60px; border-radius:10px">
				會員名稱：<input type="submit" id="shangtian" name="name"
					value="會員用戶點擊改變" onclick="prom()" /> 
					   <input type="text" id="ritian" onclick="prom()" />
			</div>
			<FORM ACTION="./ServletComment" method="Post">

				Gender: <input type="radio" id="male" name="gender" value="male">

				<label for="male"> Male</label> <input type="radio" id="female"
					name="gender" value="female"> <label for="female">Female</label>
				<input type="radio" id="other" name="gender" value="other"
					checked="checked"> <label for="other">Other</label><BR>

				Age:<label for="age">(between 0 and 100):</label> <input
					type="number" id="age" name="age" min="0" max="100">
					
					<label for="status"></label> 
					<input type="hidden" name="status"> 
					<input type="hidden" name="comment_time">
					<input type="hidden" name="content_box">
					


				<div>
					<textarea id="article" class="transition"></textarea>
				</div>
				<INPUT id="postBt" type="button" style="" value="發表留言" />
				<INPUT id="clear" NAME="clear" TYPE="RESET"  VALUE="清除" />
			</FORM>

		</div>

		<div id="comment"></div>
	</div>

	<script>
		var named = name;

		function delete1(id) {
			localStorage.removeItem(id);
			this.Storage.writeData();
		}
		function prom() {

			var name = prompt("請輸入您的名字");//將輸入的內容賦給變量 name ，
			named = name;

			//這里需要注意的是，prompt有兩個參數，前面是提示的話，后面是當對話框出來后，在對話框里的默認值
			console.log(`named:${named}`);
			if (named)//如果返回的有內容

			{

				alert("歡迎您：" + name)
				document.getElementById("shangtian").style.display = "none";
				document.getElementById("ritian").value = named;

			} else {
				document.getElementById("ritian").value = "匿名發言者";
			}

		}
		var Storage = {
			saveData : function()//保存數據
			{

				var data = document.querySelector("#post textarea");
				if (data.value != "") {
					console.log(data.value);
					console.log("exist");
					var time = new Date().getTime() + Math.random() * 5;//getTime是Date對象中的方法，作用是返回 1970年01月01日至今的毫秒數
					console.log(time);
					if (named) {

						localStorage.setItem(time, data.value + "|" + named
								+ "|" + this.getDateTime());//將毫秒數存入Key值中，可以降低Key值重復率
					} else {
						localStorage.setItem(time, data.value + "|" + "匿名發言者"
								+ "|" + this.getDateTime());//將毫秒數存入Key值中，可以降低Key值重復率
					}

					data.value = "";
					this.writeData();
				} else {
					alert("請填寫您的留言！");
				}
			},
			writeData : function()//輸出數據
			{
				var dataHtml = "", data = "";
				for (var i = localStorage.length - 1; i >= 0; i--)//效率更高的循環方法
				{
					data = localStorage.getItem(localStorage.key(i)).split("|");

					//dataHtml += "<p><span class=\"msg\">" + data[0] + "</span><span class=\"datetime\">" + data[1] + "</span><span>" + data[2]+"</span></p>";
					dataHtml += "<span style=>"
							+ data[1]
							+ "<span style=\"float:right\">"
							+ data[2]
							+ "</span><p><span class=\"msg\">"
							+ data[0]
							+ "<input style=\"float:right;border:none;border-radius:5px;\" id=\"clearBt\" type=\"button\" onclick=\"delete1("
							+ localStorage.key(i) + ");\" value=\"刪除\"/>"
							+ "</span></p>";
				}
				document.getElementById("comment").innerHTML = dataHtml;//dataHtml
			},
			clearData : function()//清空數據
			{
				if (localStorage.length > 0) {
					if (window.confirm("清空后不可恢復，是否確認清空？")) {
						localStorage.clear();
						this.writeData();
					}
				} else {
					alert("沒有需要清空的數據！");
				}
			},
			getDateTime : function()//獲取日期時間，例如 2012-03-08 12:58:58
			{
				var isZero = function(num)//私有方法，自動補零
				{
					if (num < 10) {
						num = "0" + num;
					}
					return num;
				}

				var d = new Date();
				return d.getFullYear() + "-" + isZero(d.getMonth() + 1) + "-"
						+ isZero(d.getDate()) + " " + isZero(d.getHours())
						+ ":" + isZero(d.getMinutes()) + ":"
						+ isZero(d.getSeconds());
			}
		}

		window.onload = function() {
			Storage.writeData();//當打開頁面的時候，先將localStorage中的數據輸出一邊，如果沒有數據，則輸出空
			document.getElementById("postBt").onclick = function() {
				Storage.saveData();
			}//發表評論按鈕添加點擊事件，作用是將localStorage中的數據輸出
			/*document.getElementById("clearBt").onclick = function() {
				Storage.clearData();
			}//清空所有已保存的數據*/
		}
	</script>
</body>

</html>