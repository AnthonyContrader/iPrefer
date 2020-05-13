<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PiattoDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Lettura del piatto">
<meta name="author" content="Ambrogio Santo">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Lettura del piatto</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Utenti</a>
		<a class="active" href="/piatto/getall">Piatti</a> 
			<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			PiattoDTO u = (PiattoDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>nome piatto</th>
				<th>ingredienti</th>
				<th>costo piatto</th>
				<th>descrizione piatto</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getNome_piatto()%></td>
				<td><%=u.getIngredienti()%></td>
				<td><%=u.getCosto_piatto()%></td>
				<td><%=u.getDescrizione_piatto()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>