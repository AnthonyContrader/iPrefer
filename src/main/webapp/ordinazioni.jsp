<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OrdinazioneDTO"
     import="it.contrader.dto.PiattoDTO" import="it.contrader.dto.BevandaDTO"
	import="it.contrader.dto.PrenotazioneDTO"     
     import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

<%@ include file="./css/header.jsp"%>

<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/ordinazione/getall">Ordinazioni</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>

<div class="main">
		<%
			List<OrdinazioneDTO> list = (List<OrdinazioneDTO>) request.getSession().getAttribute("list");
			List<PiattoDTO> listpiatto = (List<PiattoDTO>) request.getSession().getAttribute("listpiatto");
			List<BevandaDTO> listbevanda = (List<BevandaDTO>) request.getSession().getAttribute("listbevanda");
			List<PrenotazioneDTO> listprenotazione = (List<PrenotazioneDTO>) request.getSession().getAttribute("listprenotazione");



		%>

	<br>

		<table>
			<tr>
				<th>ID_PIATTO</th>
				<th>ID_BEVANDA</th>
				<th>ID_PRENOTAZIONE</th>
				<th>COSTO_TOT</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			
			<%
				for (OrdinazioneDTO o : list) {
			%>
			<tr>
				<td><a href="/ordinazione/read?id=<%=o.getId_ordinazione()%>"> <%=o.getPiatto()%>
				</a></td>
				<td><%=o.getBevanda()%></td>
				<td><%=o.getPrenotazione()%></td>
				<td><%=o.getCosto_tot()%></td>
				
				<td><a href="/ordinazione/preupdate?id=<%=o.getId_ordinazione()%>">Modifica</a></td>
				<td><a href="/ordinazione/delete?id=<%=o.getId_ordinazione()%>">Cancella</a></td>
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
			<select id="id_piatto" multiple name="id_piatto" required>
            <option value="" disabled selected>choose your options</option>
            <%
                for (PiattoDTO a : listpiatto) {
            %>
            <option value="<%=a.getId()%>"><%=a.getNome_piatto() %></option>
            <%
                }
            %>
           </select>
		</div>
		
			<div class="row">
				<div class="col-25">
					<label for="id_piatto">Inserisci Bevanda</label>
				</div>
			<select id="id_bevanda" name="id_bevanda" required>
            <option value="" disabled selected>choose your options</option>
            <%
                for (BevandaDTO b : listbevanda) {
            %>
            <option value="<%=b.getId()%>"><%=b.getNome_bevanda() %></option>
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
            <option value="<%=c.getId()%>"><%=c.getId() %></option>
            <%
                }
            %>
           </select>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="costo">Costo_tot</label>
				</div>
				<div class="col-75">
					<input type="number" id="costo_tot" name="costo_tot"
						placeholder="inserisci costo">
				</div>
			</div>
			

			
			
			
			<button type="submit">Inserisci</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>

</body>
</html>