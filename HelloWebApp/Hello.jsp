<%@ page contentType="text/html; charset=Shift_JIS" %>
<%@ page import="role.Character" %>
<html>
<head>
<title>Hello! JSP</title>
</head>
<body>
	<style>
		body{text-align: center;}
	</style>
	<%
		String item = "ようこそ＠JSP!";
	%>
<h2>
<%=item%>
<h2/>

	<button id="add">投稿</button>
	<script>

		document.getElementById("add").addEventListener('click',function(){
			var tweet=prompt("文章を入力");
			if(tweet){
				var d = new Date();
				var month=d.getMonth()+1;
				var greet=document.createElement('p'),
				text=document.createTextNode(tweet+" <"+d.getFullYear()+"年,"+month+"月"+d.getDate()+"日,"+d.getSeconds()+"秒>");
				document.body.appendChild(greet).appendChild(text);
			}

		});
	</script>
	<a href="/HelloWebApp/form.html">入力フォーム</a>
</body>
</html>