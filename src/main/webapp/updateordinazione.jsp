<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.OrdinazioneDTO"
	import="it.contrader.dto.PiattoDTO"
	import="it.contrader.dto.BevandaDTO"
	import="it.contrader.dto.PrenotazioneDTO"
	import="it.contrader.model.Piatto" import="it.contrader.model.Bevanda"
	import="it.contrader.model.Prenotazione" import="java.util.*"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Ordinazione Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Ordinazione</title>
</head>
<body>
	<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a class ="active" href="/ordinazione/getall">Ordinazioni</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%
OrdinazioneDTO u = (OrdinazioneDTO) request.getSession().getAttribute("dto");
List<OrdinazioneDTO> list = (List<OrdinazioneDTO>) request.getSession().getAttribute("list");
List<PiattoDTO> listpiatto = (List<PiattoDTO>) request.getSession().getAttribute("listpiatto");
List<BevandaDTO> listbevanda = (List<BevandaDTO>) request.getSession().getAttribute("listbevanda");
List<PrenotazioneDTO> listprenotazione = (List<PrenotazioneDTO>) request.getSession()
		.getAttribute("listprenotazione");
%>


<form id="floatleft" action="/ordinazione/update" method="post">
<div class="row">

				<div class="col-25">
					<label for="id_piatto">Modifica Piatto</label>
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
					<label for="id_bevanda">Modifica Bevanda</label>
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
					<label for="id_prenotazione">Modifica Prenotazione</label>
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
 
  
  
  <input type="hidden" name="id" value=<%=u.getId() %>>
      <button type="submit" >Edit</button>
</form>
<br>

<%@ include file="./css/footer.jsp" %>	
</body>
</html>