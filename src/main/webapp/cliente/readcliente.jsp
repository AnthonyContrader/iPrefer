<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClienteDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Cliente</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="ClienteServlet?mode=clientelist">Clienti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ClienteDTO c = (ClienteDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>nomeCliente</th>
		<th>cognomeCliente</th>
		<th>intolleranza</th>
		<th>telefono</th>
		<th>intollerante</th>
	</tr>
	<tr>
		<td><%=c.getNomeCliente()%></td>
		<td> <%=c.getCognomeCliente()%></td>
		<td> <%=c.getIntolleranza()%></td>
		<td> <%=c.getTelefono()%></td>
		<td> <%=c.getIntollerante()%></td>
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