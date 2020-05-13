<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.RecensioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Recensione Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Recensione</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/recensione/getall">Recensioni</a>
	</div>
	<br>
	<div class="main">

		<%
			RecensioneDTO r = (RecensioneDTO) request.getSession().getAttribute("dto");
		%>


		<form id="floatleft" action="/recensione/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="voto">Voto</label>
				</div>
				<div class="col-75">
					<input type="number" id="voto" name="voto" min="1" max="5"
						placeholder="inserisci voto tra 1 e 5">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="testo">Testo</label>
				</div>
				<div class="col-75">
					<input type="text" id="testo" name="testo" value=<%=r.getTesto()%>>
				</div>
			</div>
			<input type="hidden" name="id" value=<%=r.getId()%>>
			<button type="submit">Edit</button>
		</form>
	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>