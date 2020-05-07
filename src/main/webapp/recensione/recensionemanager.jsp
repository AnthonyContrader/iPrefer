<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.RecensioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Recensione Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="RecensioneServlet?mode=recensionelist">Recensioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<RecensioneDTO> list = (List<RecensioneDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Voto</th>
			<th>id_ordinazione</th>
			<th>Testo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (RecensioneDTO r : list) {
		%>
		<tr>
			<td><a href=RecensioneServlet?mode=read&id_recensione=<%=r.getId_recensione()%>>
					<%=r.getVoto()%>
			</a></td>
			<td><%=r.getId_ordinazione()%></td>
			<td><%=r.getTesto()%></td>
			<td><a href=RecensioneServlet?mode=read&update=true&id_recensione=<%=r.getId_recensione()%>>Edit</a>
			</td>
			<td><a href=RecensioneServlet?mode=delete&id_recensione=<%=r.getId_recensione()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<form id="floatright" action="RecensioneServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="voto">Voto</label>
    </div>
    <div class="col-75">
      <input type="number" id="voto" name="voto" min="1" max="5" placeholder="inserisci voto tra 1 e 5">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="id_ordinazione">Id_ordinazione</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_ordinazione" name="id_ordinazione" placeholder="inserisci l'id dell'ordinazione"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="testo">Testo</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="testo" name="testo" placeholder="inserisci il testo della recensione"> 
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>

</body>
</html>