<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="it.contrader.dto.ClienteDTO" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Cliente Manager</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/cliente/getall">Clienti</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ClienteDTO> list = (List<ClienteDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>cognome_cliente</th>
				<th>intollerante</th>
				<th>intolleranza_bool</th>
				<th>nome_cliente</th>
				<th>telefono</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ClienteDTO c : list) {
			%>
			<tr>
				<td><a href="/cliente/read?id=<%=c.getId()%>"> <%=c.getCognome_cliente()%> 
				</a></td>
				
				<td><%=c.getIntollerante()%></td>
				<td><%=c.isIntolleranza_bool()%></td>
				<td><%=c.getNome_cliente()%></td>
				<td><%=c.getTelefono()%></td>
				<td><a href="/cliente/preupdate?id=<%=c.getId()%>">Edit</a></td>


				<td><a href="/cliente/delete?id=<%=c.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/cliente/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="cognome_cliente">cognome_cliente</label>
				</div>
				<div class="col-75">
					<input type="text" id="cognome_cliente" name="cognome_cliente"
						placeholder="inserisci cognome_cliente">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="intollerante">intollerante</label>
				</div>
				<div class="col-75">
					<input type="text" id="intollerante" name="intollerante"
						placeholder="inserisci l'intolleranza">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="intolleranza_bool">intolleranza_bool</label>
				</div>
				<div class="col-75">
					<select id="intolleranza_bool" name="intolleranza_bool">
						<option value=true>SI</option>
						<option value=false>NO</option>

					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="nome_cliente">nome_cliente</label>
				</div>
				<div class="col-75">
					<input type="text" id="nome_cliente" name="nome_cliente"
						placeholder="inserisci il nome del cliente">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="telefono">telefono</label>
				</div>
				<div class="col-75">
					<input type="text" id="telefono" name="telefono"
						placeholder="inserisci numero di telefono del cliente">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>