<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.RecensioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Recensione</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a class="active"
			href="RecensioneServlet?mode=recensionelist">Recensioni</a> <a
			href="LogoutServlet" id="logout">Logout</a>
	</div>
	<br>
	<div class="main">

		<%
			RecensioneDTO r = (RecensioneDTO) request.getAttribute("dto");
		%>


		<form id="floatleft"
			action="RecensioneServlet?mode=update&id_recensione=<%=r.getId_recensione()%>"
			method="post">
			<div class="row">
				<div class="col-25">
					<label for="voto">Voto</label>
				</div>
				<div class="col-75">
					<input type="number" id="voto" name="voto" min="1" max="5"
						value=<%=r.getVoto()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="id_ordinazione">Id_ordinazione</label>
				</div>
				<div class="col-75">
					<input type="number" id="id_ordinazione" name="id_ordinazione"
						value=<%=r.getId_ordinazione()%>>
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
			<button type="submit">Edit</button>
		</form>


	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>

</body>
</html>