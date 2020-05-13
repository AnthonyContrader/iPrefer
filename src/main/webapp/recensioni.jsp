<%@ page import="it.contrader.dto.RecensioneDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Recensione Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Recensione Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/recensione/getall">Recensioni</a>
	</div>
	<div class="main">
		<%
			List<RecensioneDTO> list = (List<RecensioneDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Voto</th>
				<th>Testo</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (RecensioneDTO r : list) {
			%>
			<tr>
				<td><a href="/recensione/read?id=<%=r.getId()%>">
						<%=r.getVoto()%>
				</a></td>
				<td><%=r.getTesto()%></td>
				<td><a href="/recensione/preupdate?id=<%=r.getId()%>">Edit</a></td>
				
				<td><a href="/recensione/delete?id=<%=r.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<form id="floatright" action="/recensione/insert" method="post">
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
					<input type="text" id="testo" name="testo"
						placeholder="inserisci il testo della recensione">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>