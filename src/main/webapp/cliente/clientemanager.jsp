<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ClienteDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Cliente Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="ClienteServlet?mode=clientelist">Clienti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
<%
		List<ClienteDTO> list = (List<ClienteDTO>) request.getAttribute("list");
	%>
	
<br>

<table>
	<tr>
		<th>NomeCliente</th>
		<th>CognomeCliente</th>
		<th>Intolleranza</th>
		<th>Telefono</th>
		<th>Intollerante</th>
		<th></th>
		<th></th>
	</tr>
	<%
			for (ClienteDTO c : list) {
		%>
		<tr>
			<td><a href=ClienteServlet?mode=read&id_cliente=<%=c.getIdCliente()%>>
					<%=c.getNomeCliente()%>
			</a></td>
			<td><%=c.getCognomeCliente()%></td>
			<td><%=c.getIntolleranza()%></td>
			<td><%=c.getTelefono() %></td>
			<td><%=c.getIntollerante() %></td>
			<td><a href=ClienteServlet?mode=read&update=true&id_cliente=<%=c.getIdCliente()%>>Edit</a>
			</td>
			<td><a href=ClienteServlet?mode=delete&id_cliente=<%=c.getIdCliente()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<form id="floatright" action="ClienteServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome_cliente">nomeCliente</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_cliente" name="nome_cliente" placeholder="inserisci nome cliente">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="cognome_cliente">cognomeCliente</label>
    </div>
    <div class="col-75">
      <input type="text" id="cognome_cliente" name="cognome_cliente" placeholder="inserisci cognome cliente"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="intolleranza_bool">Intolleranza</label>
    </div>
   		 <div class="col-75">
 			<select id="intolleranza_bool" name="intolleranza_bool">
 				<option value="">seleziona</option>
  				<option value="true">si</option>
  				<option value="false">no</option>
 
			</select>
    	</div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="telefono">telefono</label>
    </div>
    <div class="col-75">
      <input type="text" id="telefono" name="telefono" placeholder="inserisci numero di telefono cliente">
    </div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="intollerante">intollerante</label>
    </div>
    <div class="col-75">
      <input type="text" id="intollerante" name="intollerante" placeholder="inserisci l'intolleranza del cliente">
    </div>
   </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>