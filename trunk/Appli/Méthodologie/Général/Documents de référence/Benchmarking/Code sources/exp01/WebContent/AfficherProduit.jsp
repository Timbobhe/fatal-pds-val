<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="esisa.java.gs.Produit"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Produit p = (Produit)request.getAttribute("produit");
	%>
	<ul>
		<li> Ref : <%=p.getRef() %> </li>
		<li> Desig : <%=p.getDesig() %> </li>
		<li> Prix : <%=p.getPrix() %> </li>
		<li> QS : <%=p.getQ() %> </li>
	</ul>
</body>
</html>