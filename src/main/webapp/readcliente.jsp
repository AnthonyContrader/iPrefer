<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClienteDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cliente Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Cliente</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/cliente/getall">Clienti</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			ClienteDTO c = (ClienteDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>cognome_cliente</th>
				<th>intollerante</th>
				<th>intolleranza_bool</th>
				<th>nome_cliente</th>
				<th>telefono</th>
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td> <%=c.getCognome_cliente()%></td>
				<td> <%=c.getIntollerante()%></td>
				<td> <%=c.isIntolleranza_bool()%></td>
				<td><%=c.getNome_cliente()%></td>
				<td> <%=c.getTelefono()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>

</body>
</html>