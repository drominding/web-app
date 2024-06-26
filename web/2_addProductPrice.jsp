<%--
  Created by IntelliJ IDEA.
  User: Dromin
  Date: 2024/6/23
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<jsp:include page="index.jsp" />
<p>以下是添加内容：</p>

<form action="addProduct" method="post">
    <input type="text" name="name" placeholder="输入名称">
    <input type="text" name="mainID" placeholder="输入mainID">
    <input type="submit" value="提交">
</form>
</body>
</html>
