<%@page contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@page import="java.sql.ResultSet" %>
<html lang="ja">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
	
	<%=request.getAttribute("name") %>
	<% out.println("さん"); %>
	
    <h1>Blog</h1>
    <form method="post" action="blog">
    	<input type="checkbox" name="delete" value="delete" />DELETE<br>
		<input type="text" name="blog">
    	<input type="submit" value="送信">
    </form>
	<% 
    ResultSet rs = (ResultSet)request.getAttribute("BlogList");
    
    while(rs.next()){
	out.print(rs.getString("blog")+"<br/>");	
    }
    
    %>
</body>
</html>