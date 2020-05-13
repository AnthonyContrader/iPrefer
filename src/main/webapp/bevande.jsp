<%@ page import ="it.contrader.dto.BevandaDTO" import ="java.util.*"%>

<html>
<head>
<meta charset="utf-8">
<meta name ="viewport"
	content ="width =device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Bevanda Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Bevanda Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp" %>
	
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href ="/bevanda/getall">Bevande</a>
	</div>
	<div class ="main">
	<%
		List<BevandaDTO> list = (List<BevandaDTO>) request.getSession().getAttribute("list");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Nome_bevanda</th>
			<th>Costo_bevanda</th>
			<th>Alcolico</th>
			<th>Descrizione</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for(BevandaDTO u:list) {
		%>
		<tr>
			<td><a href="/bevanda/read?id=<%=u.getId()%>"></a> <%=u.getNome_bevanda()%></td>
			<td><%=u.getCosto_bevanda ()%></td>
			<td><%=u.getAlcolico()%></td>
			<td><%=u.getDescrizione()%></td>
			<td><a href="/bevanda/preupdate?id=<%=u.getId()%>">Edit</a></td>
			<td><a href="/bevanda/delete?id=<%=u.getId()%>">Delete</a></td>
		
		</tr>
	<% 
		}
	%>
		</table>
		<form id="floatright" action="/bevanda/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="nome_bevanda">nome_bevanda</label>
				</div>
				<div class="col-75">
					<input type="text" id="nome_bevanda" name="nome_bevanda"
						placeholder="inserisci nome_bevanda">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="costo_bevanda">costo_bevanda</label>
				</div>
				<div class="col-75">
					<input type="text" id="costo_bevanda" name="costo_bevanda"
						placeholder="inserisci costo_bevanda">
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="alcolico">Alcolico</label>
				</div>
				<div class="col-75">
					<select id="alcolico" name="alcolico">
						<option value="TRUE">TRUE</option>
						<option value="FALSE">FALSE</option>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="descrizione">descrizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="descrizione" name="descrizione"
						placeholder="inserisci descrizione">
				</div>
			</div>
			
			<button type="submit">Insert</button>
			
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>