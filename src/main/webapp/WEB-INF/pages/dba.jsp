<%--
  Created by IntelliJ IDEA.
  User: raghuramn
  Date: 6/22/16
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>DBA page</title>
</head>
<body>
Dear <strong>${user}</strong>, Welcome to DBA Page.
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>