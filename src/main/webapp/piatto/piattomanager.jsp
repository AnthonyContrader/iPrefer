<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PiattoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Piatto Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="PiattoServlet?mode=piattolist">Piatti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<PiattoDTO> list = (List<PiattoDTO>)request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			
			<th>nome piatto</th>
			<th>ingredienti</th>
			<th>costo piatto</th>
			<th>descrizione piatto</th>
			<th>Op1</th>
			<th>Op2</th>
		</tr>
		<%
			for (PiattoDTO u : list) {
		%>
		<tr>
			<td>
			<a href=PiattoServlet?mode=read&id_piatto=<%=u.getIdPiatto()%>><%=u.getNomePiatto()%></a></td>
			
			
			<td><%=u.getIngredienti()%></td>
			<td><%=u.getCostoPiatto()%></td>
			<td><%=u.getDescrizionePiatto()%></td>
			<td>
			<a href=PiattoServlet?mode=read&update=true&id_piatto=<%=u.getIdPiatto()%>>Modifica</a>
			</td>
			<td>
			<a href=PiattoServlet?mode=delete&id_piatto=<%=u.getIdPiatto()%>>Cancella</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="PiattoServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome_piatto">Nome piatto</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_piatto" name="nome_piatto" placeholder="inserisci il nome del piatto">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="ingredienti">Ingredienti</label>
    </div>
    <div class="col-75">
      <input type="text" id="ingredienti" name="ingredienti" placeholder="inserisci gli ingredienti del piatto">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="costo_piatto">Costo Piatto</label>
    </div>
    <div class="col-75">
      <input type="text" id="costo_piatto" name="costo_piatto" placeholder="inserisci il costo del piatto"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="descrizione_piatto">Descrizione Piatto</label>
    </div>
    <div class="col-75">
      <input type="text" id="descrizione_piatto" name="descrizione_piatto" placeholder="inserisci la descrizione del piatto"> 
    </div>
  </div>
      <button type="submit" >Inserisci piatto</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>