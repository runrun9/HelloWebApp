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
		String item = "�悤������JSP!";
	%>
<h2>
<%=item%>
<h2/>

	<button id="add">���e</button>
	<script>

		document.getElementById("add").addEventListener('click',function(){
			var tweet=prompt("���͂����");
			if(tweet){
				var d = new Date();
				var month=d.getMonth()+1;
				var greet=document.createElement('p'),
				text=document.createTextNode(tweet+" <"+d.getFullYear()+"�N,"+month+"��"+d.getDate()+"��,"+d.getSeconds()+"�b>");
				document.body.appendChild(greet).appendChild(text);
			}

		});
	</script>
	<a href="/HelloWebApp/form.html">���̓t�H�[��</a>
</body>
</html>