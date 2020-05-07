<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.BevandaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Bevanda Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="BevandaServlet?mode=bevandalist">Bevande</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<BevandaDTO> list = (List<BevandaDTO>) request.getAttribute("list");
	%>
<br>

	<table>
		<tr>
			<th>nome_bevanda</th>
			<th>costo_bevanda</th>
			<th>alcolico</th>
			<th>descrizione</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (BevandaDTO u : list) {
		%>
		<tr>
			<td><a href=BevandaServlet?mode=read&id_bevanda=<%=u.getId_Bevanda()%>>
					<%=u.getNome_Bevanda()%>
			</a></td>
			<td><%=u.getCosto_Bevanda()%></td>
			<td><%=u.getAlcolico()%></td>
			<td><%=u.getDescrizione()%></td>
			<td><a href=BevandaServlet?mode=read&update=true&id_bevanda=<%=u.getId_Bevanda()%>>Edit</a>
			</td>
			<td><a href=BevandaServlet?mode=delete&id_bevanda=<%=u.getId_Bevanda()%>>Delete</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
<form id="floatright" action="BevandaServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome_bevanda">nome_bevanda</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_bevanda" name="nome_bevanda" placeholder="inserisci nome_bevanda">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="costo_bevanda">costo_bevanda</label>
    </div>
    <div class="col-75">
      <input type="number" step="0.1" id="costo_bevanda" name="costo_bevanda" placeholder="inserisci costo_bevanda"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="alcolico">alcolico</label>
    </div>
    <div class="col-75">
      <input type="text" id="alcolico" name="alcolico" placeholder="inserisci se alcolico">
    </div>
    </div>
    <div class="row">
    <div class="col-25">
      <label for="descrizione">descrizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="descrizione" name="descrizione" placeholder="inserisci descrizione">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>