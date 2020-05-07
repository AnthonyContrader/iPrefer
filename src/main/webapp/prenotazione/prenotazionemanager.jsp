<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PrenotazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prenotazione Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="PrenotazioneServlet?mode=prenotazionelist">Prenotazioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<PrenotazioneDTO> list = (List<PrenotazioneDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Data_Ora</th>
			<th>Tavolo</th>
			<th>ID_Cliente</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (PrenotazioneDTO p : list) {
		%>
		<tr>
			<td><a href=PrenotazioneServlet?mode=read&id_prenotazione=<%=p.getId_prenotazione()%>>
					<%=p.getData_ora()%>
			</a></td>
			<td><%=p.getTavolo()%></td>
			<td><%=p.getId_cliente()%></td>
			<td><a href=PrenotazioneServlet?mode=read&update=true&id_prenotazione=<%=p.getId_prenotazione()%>>Edit</a>
			</td>
			<td><a href=PrenotazioneServlet?mode=delete&id_prenotazione=<%=p.getId_prenotazione()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="PrenotazioneServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="data_ora">Data_Ora</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_ora" name="data_ora" placeholder="inserisci Data e Ora">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="tavolo">Tavolo</label>
    </div>
    <div class="col-75">
      <input type="number" id="tavolo" name="tavolo" placeholder="inserisci il tavolo"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="id_cliente">ID_Cliente</label>
    </div>
   		 <div class="col-75">
 			<input type= "number" id= "id_cliente" name="id_cliente" placeholder= "inserisci ID Cliente">
  				
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>