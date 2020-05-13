<%@ page import="it.contrader.dto.PrenotazioneDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Prenotazione Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/prenotazione/getall">Prenotazioni</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<PrenotazioneDTO> list = (List<PrenotazioneDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Data e ora</th>
				<th>Tavolo</th>
				<th>ID Cliente</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (PrenotazioneDTO p : list) {
			%>
			<tr>
				<td><a href="/prenotazione/read?id=<%=p.getId()%>"> <%=p.getData_ora()%>
				</a></td>
				<td><%=p.getTavolo()%></td>
				<td><%=p.getCliente()%></td>
				<td><a href="/prenotazione/preupdate?id=<%=p.getId()%>">Edit</a></td>


				<td><a href="/prenotazione/delete?id=<%=p.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/prenotazione/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="data_ora">Data e ora</label>
				</div>
				<div class="col-75">
					<input type="datetime" id="data_ora" name="data_ora"
						placeholder="inserisci la data e l'orario">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="tavolo">Tavolo</label>
				</div>
				<div class="col-75">
					<input type="number" id="tavolo" name="tavolo"
						placeholder="inserisci il numero del tavolo">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>