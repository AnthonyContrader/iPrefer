<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.OrdinazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Ordinazione Read</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="OrdinazioneServlet?mode=ordinazionelist">Ordinazioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%OrdinazioneDTO o = (OrdinazioneDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Id_piatto</th>
		<th>Id_bevanda</th>
		<th>Id_cliente</th>
		<th>Data_Ora</th>
		<th>Costo_tot</th>
	</tr>
	<tr>
		<td><%=o.GetId_Piatto()%></td>
		<td> <%=o.GetId_Bevanda()%></td>
		<td> <%=o.GetId_Cliente()%></td>
		<td> <%=o.GetData_ora()%></td>
		<td> <%=o.GetCosto_tot()%></td>
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