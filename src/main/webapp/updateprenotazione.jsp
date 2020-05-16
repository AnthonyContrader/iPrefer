<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PrenotazioneDTO" import="it.contrader.dto.ClienteDTO" import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Prenotazione Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Prenotazione</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/prenotazione/getall">Prenotazioni</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PrenotazioneDTO p = (PrenotazioneDTO) request.getSession().getAttribute("dto");%>

<%List<ClienteDTO> listC = (List<ClienteDTO>) request.getSession().getAttribute("listC"); %>


<form id="floatleft" action="/prenotazione/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="data_ora">Data e ora</label>
    </div>
    <div class="col-75">
      <input type="datetime" id="data_ora" name="data_ora" value=<%=p.getData_ora()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="tavolo">Tavolo</label>
    </div>
    <div class="col-75">
      <input type="number" id="tavolo" name="tavolo" value=<%=p.getTavolo()%>> 
    </div>
    <input type="hidden" name="id" value =<%=p.getId() %>>
  </div>
  <div class="row">
    <div class="col-100">
					<select id="cliente" name="id_cliente" required>
					<option value="" disabled selected>Seleziona Nome Cliente</option>
					<%
						for (ClienteDTO c : listC) {
					%>
					<option value="<%=c.getId()%>"><%=c.getNome_cliente() + " " + c.getCognome_cliente() %></option>
					<%
						}
					%>
					</select>
				</div>
				
    <input type="hidden" name="id" value =<%=p.getId() %>>
  </div>
 	
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>