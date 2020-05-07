<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="it.contrader.dto.OrdinazioneDTO"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Ordinazione Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp" %>
	
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="OrdinazioneServlet?mode=ordinazionelist">Ordinazioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
	<%
		List<OrdinazioneDTO> list = (List<OrdinazioneDTO>) request.getAttribute("list");
	%>
<br>
	<table>
		<tr>
			<th>Id_Piatto</th>
			<th>Id_Bevanda</th>
			<th>Id_Cliente</th>
			<th>Data_Ora</th>
			<th>Costo_tot</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (OrdinazioneDTO o : list) {
		%>
			<tr>
				<td><a href=OrdinazioneServlet?mode=read&id_ordinazione=<%=o.GetId_Ordinazione()%>>
						<%=o.GetId_Piatto()%>
				</a></td>
				<td><%=o.GetId_Bevanda()%></td>
				<td><%=o.GetId_Cliente()%></td>
				<td><%=o.GetData_ora()%></td>
				<td><%=o.GetCosto_tot()%></td>
				<td><a href=OrdinazioneServlet?mode=read&update=true&id_ordinazione=<%=o.GetId_Ordinazione()%>>Edit</a>
				</td>
				<td><a href=OrdinazioneServlet?mode=delete&id_ordinazione=<%=o.GetId_Ordinazione()%>>Delete</a>
				</td>

			</tr>
		<%
			}
		%>
	</table>
<form id="floatright" action="OrdinazioneServlet?mode=insert" method="post">
<div class="row">
    <div class="col-25">
      <label for="ordinazione">ID_PIATTO</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_piatto" name="id_piatto" placeholder="inserisci ID_PIATTO">
    </div>
</div>

<div class="row">
    <div class="col-25">
      <label for="ordinazione">ID_BEVANDA</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_bevanda" name="id_bevanda" placeholder="inserisci ID_BEVANDA">
    </div>
</div>

<div class="row">
    <div class="col-25">
      <label for="ordinazione">ID_CLIENTE</label>
    </div>
    <div class="col-75">
      <input type="number" id="id_cliente" name="id_cliente" placeholder="inserisci ID_CLIENTE">
    </div>
</div>
    
<div class="row">
    <div class="col-25">
      <label for="ordinazione">DATA_ORA</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_ora" name="data_ora" placeholder="inserisci DATA_ORA">
    </div>
</div>
    
<div class="row">
    <div class="col-25">
      <label for="ordinazione">COSTO_TOT</label>
    </div>
    <div class="col-75">
      <input type="number" step="0.1" id="costo_tot" name="costo_tot" placeholder="inserisci COSTO_TOT">
    </div>
</div>
      <button type="submit" >Insert</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>