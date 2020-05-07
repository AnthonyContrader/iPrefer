<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BevandaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Bevanda</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="BevandaServlet?mode=bevandalist">Bevande</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%BevandaDTO u = (BevandaDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>nome_bevanda</th>
		<th>costo_bevanda</th>
		<th>alcolico</th>
		<th>descrizione</th>
	</tr>
	<tr>
		<td><%=u.getNome_Bevanda()%></td>
		<td><%=u.getCosto_Bevanda()%></td>
		<td><%=u.getAlcolico()%></td>
		<td><%=u.getDescrizione()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>