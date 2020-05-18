<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.OrdinazioneDTO"
	import="it.contrader.dto.PiattoDTO"
	import="it.contrader.dto.BevandaDTO"
	import="it.contrader.dto.PrenotazioneDTO"
	import="it.contrader.model.Piatto" import="it.contrader.model.Bevanda"
	import="it.contrader.model.Prenotazione" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordinazioni Manager</title>
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/ordinazione/getall">Ordinazioni</a> <a href="/user/logout"
			id="logout">Logout</a>
	</div>

	<div class="main">
		<%
			List<OrdinazioneDTO> list = (List<OrdinazioneDTO>) request.getSession().getAttribute("list");
			List<PiattoDTO> listpiatto = (List<PiattoDTO>) request.getSession().getAttribute("listpiatto");
			List<BevandaDTO> listbevanda = (List<BevandaDTO>) request.getSession().getAttribute("listbevanda");
			List<PrenotazioneDTO> listprenotazione = (List<PrenotazioneDTO>) request.getSession()
					.getAttribute("listprenotazione");
		%>

		<br>

		<table>
			<tr>
				<th>PIATTO</th>
				<th>BEVANDA</th>
				<th>PRENOTAZIONE</th>
				<th>COSTO TOTALE</th>
				<th>DATA ORA</th>
				<th></th>
				<th></th>
			</tr>

			<%
				for (OrdinazioneDTO o : list) {
					String nomepiatto = "";
					String nomebevanda = "";
					for (Piatto p : o.getPiatto()) {
						nomepiatto += (" " + p.getNome_piatto() + " ");
					}
					for (Bevanda b : o.getBevanda()) {
						nomebevanda = (" " + b.getNome_bevanda() + " ");
					}
			%>

			<tr>
				<td><a href="/ordinazione/read?id=<%=o.getId()%>"><%=nomepiatto%>
				</a></td>

				<td><%=nomebevanda%></td>
				<td><%=o.getPrenotazione().getCliente().getCognome_cliente()%></td>
				<td><%=o.getCosto_tot()%></td>
				<td><%=o.getData_ora()%></td>


				<td><a href="/ordinazione/preupdate?id=<%=o.getId()%>">Modifica</a></td>
				<td><a href="/ordinazione/delete?id=<%=o.getId()%>">Cancella</a></td>
			</tr>
			<%
				}
			%>


		</table>
		<form id="floatright" action="/ordinazione/insert" method="post">



			<div class="row">
				<div class="col-25">
					<label for="id_piatto">Inserisci Piatto</label>
				</div>
				<select id="id_piatto" multiple name="id_piatto">
					<option value="" disabled selected>choose your options</option>
					<%
						for (PiattoDTO a : listpiatto) {
					%>
					<option value="<%=a.getId()%>"><%=a.getNome_piatto()%></option>
					<%
						}
					%>
				</select>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="id_piatto">Inserisci Bevanda</label>
				</div>
				<select id="id_bevanda" multiple name="id_bevanda">
					<option value="" disabled selected>choose your options</option>
					<%
						for (BevandaDTO b : listbevanda) {
					%>
					<option value="<%=b.getId()%>"><%=b.getNome_bevanda()%></option>
					<%
						}
					%>
				</select>
			</div>


			<div class="row">
				<div class="col-25">
					<label for="id_piatto">Inserisci Prenotazione</label>
				</div>
				<select id="id_prenotazione" name="id_prenotazione" required>
					<option value="" disabled selected>choose your options</option>
					<%
						for (PrenotazioneDTO c : listprenotazione) {
					%>
					<option value="<%=c.getId()%>"><%=c.getId() + c.getClienteDTO().getCognome_cliente()%></option>
					<%
						}
					%>
				</select>
			</div>


			<div class="row">
				<div class="col-25">
					<label for="data_ora">Data e ora</label>
				</div>
				<div class="col-75">
					<input type="datetime" id="data_ora" name="data_ora"
						placeholder="inserisci la data e l'orario">
				</div>
			</div>




			<button type="submit">Inserisci</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>