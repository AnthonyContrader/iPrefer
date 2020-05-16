<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PrenotazioneDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/prenotazione/getall">Prenotazioni</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			PrenotazioneDTO p = (PrenotazioneDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID Prenotazione</th>
				<th>Data e ora</th>
				<th>Tavolo</th>
				<th>Nome Cliente</th>
			</tr>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getData_ora()%></td>
				<td><%=p.getTavolo()%></td>
				<td><%=p.getClienteDTO().getNome_cliente() + " " + p.getClienteDTO().getCognome_cliente()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>