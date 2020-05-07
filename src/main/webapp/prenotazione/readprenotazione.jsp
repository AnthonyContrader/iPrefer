<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PrenotazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Prenotazione</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="PrenotazioneServlet?mode=prenotazionelist">Prenotazioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%PrenotazioneDTO p = (PrenotazioneDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Data_Ora</th>
		<th>Tavolo</th>
		<th>ID_Cliente</th>
	</tr>
	<tr>
		<td><%=p.getData_ora()%></td>
		<td> <%=p.getTavolo()%></td>
		<td> <%=p.getId_cliente()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>