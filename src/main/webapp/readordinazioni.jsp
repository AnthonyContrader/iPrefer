<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	 import="it.contrader.dto.PiattoDTO" import="it.contrader.dto.BevandaDTO"  import="it.contrader.dto.OrdinazioneDTO"
	import="it.contrader.dto.PrenotazioneDTO"  import="it.contrader.model.Piatto"    import="it.contrader.model.Bevanda"  import="it.contrader.model.Prenotazione" 
     import="java.util.*"
	
	
	%>
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
		<a href="/homeadmin.jsp">Home</a> <a href="/user/getall">Utenti</a> <a
			class="active" href="/ordinazione/getall">Ordinazioni</a> <a
			href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
		OrdinazioneDTO o = (OrdinazioneDTO) request.getSession().getAttribute("dto");
		%>
		<%
		List<OrdinazioneDTO> list = (List<OrdinazioneDTO>) request.getSession().getAttribute("list");
		List<PiattoDTO> listpiatto = (List<PiattoDTO>) request.getSession().getAttribute("listpiatto");
		List<BevandaDTO> listbevanda = (List<BevandaDTO>) request.getSession().getAttribute("listbevanda");
		List<PrenotazioneDTO> listprenotazione = (List<PrenotazioneDTO>) request.getSession().getAttribute("listprenotazione");
	%>
		


		<table>
			<tr>
				<th>ID</th>
				<th>nome piatto</th>
				<th>nome bevanda</th>
				<th>prenotazione</th>
				<th>costo totale</th>
			</tr>
			<%for (OrdinazioneDTO x : list) {
				for (Piatto p : x.getPiatto()){
					for(Bevanda b : x.getBevanda()){
						%>
			<tr>
				<td><%=x.getId()%></td>
				<td><%=p.getNome_piatto()%></td>
				<td><%=b.getNome_bevanda()%></td>
				<td><%=x.getPrenotazione().getCliente().getCognome_cliente()%></td>
				<td><%=x.getCosto_tot()%></td>
			</tr>
			<%	
					}
						}
							} 
				%>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>





</body>
</html>