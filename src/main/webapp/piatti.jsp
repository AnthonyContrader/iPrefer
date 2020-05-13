<%@ page import="it.contrader.dto.PiattoDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Gestione dei Piatti">
<meta name="author" content="Ambrogio Santo">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Gestione dei piatti</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/piatto/getall">Piatti</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<PiattoDTO> list = (List<PiattoDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Nome Piatto</th>
				<th>Ingredienti</th>
				<th>Costo Piatto</th>
				<th>Descrizione Piatto</th>
				<th>Op1</th>
				<th>Op2</th>
			</tr>
			<%
				for (PiattoDTO u : list) {
			%>
			<tr>
				<td><a href="/piatto/read?id=<%=u.getId()%>"> <%=u.getNome_piatto()%>
				</a></td>
				<td><%=u.getIngredienti()%></td>
				<td><%=u.getCosto_piatto()%></td>
				<td><%=u.getDescrizione_piatto()%></td>
				<td><a href="/piatto/preupdate?id=<%=u.getId()%>">Modifica</a></td>


				<td><a href="/piatto/delete?id=<%=u.getId()%>">Cancella</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/piatto/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="nome_piatto">Nome Piatto</label>
				</div>
				<div class="col-75">
					<input type="text" id="piatto" name="nome_piatto"
						placeholder="inserisci il nome del piatto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="ingredienti">Ingredienti</label>
				</div>
				<div class="col-75">
					<input type="text" id="indredienti" name="ingredienti"
						placeholder="inserisci ingredienti">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="costo_piatto">Costo Piatto</label>
				</div>
				<div class="col-75">
				<input type="text" id="costo_piatto" name="costo_piatto"
						placeholder="inserisci il costo del piatto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="descrizione_piatto">Descrizione Piatto</label>
				</div>
				<div class="col-75">
				<input type="text" id="descrizione_piatto" name="descrizione_piatto"
						placeholder="inserisci la descrizione del piatto">
				</div>
			</div>
			
			<button type="submit">Inserisci</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>