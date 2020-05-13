<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.RecensioneDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Recensione Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Recensione</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/recensione/getall">Recensioni</a> <a href="/user/logout"
			id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			RecensioneDTO r = (RecensioneDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Voto</th>
				<th>Testo</th>
				<th>prenotazione</th>
			</tr>
			<tr>
				<td><%=r.getId()%></td>
				<td><%=r.getVoto()%></td>
				<td><%=r.getTesto()%></td>
				<td><%=r.getPrenotazione()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>