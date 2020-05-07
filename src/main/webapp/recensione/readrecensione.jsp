<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.RecensioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Recensione</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="RecensioneServlet?mode=recensionelist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%RecensioneDTO r = (RecensioneDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Voto</th>
		<th>id_ordinazione</th>
		<th>testo</th>
	</tr>
	<tr>
		<td><%=r.getVoto()%></td>
		<td> <%=r.getId_ordinazione()%></td>
		<td> <%=r.getTesto()%></td>
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