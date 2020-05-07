<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PrenotazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Prenotazione</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="PrenotazioneServlet?mode=prenotazionelist">Prenotazioni</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PrenotazioneDTO p = (PrenotazioneDTO) request.getAttribute("dto");%>


<form id="floatleft" action="PrenotazioneServlet?mode=update&id_prenotazione=<%=p.getId_prenotazione()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="data_ora">Data_Ora</label>
    </div>
    <div class="col-75">
      <input type="text" id="data_ora" name="data_ora" value=<%=p.getData_ora()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="tavolo">Tavolo</label>
    </div>
    <div class="col-75">
      <input
			type="number" id="tavolo" name="tavolo" value=<%=p.getTavolo()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="id_cliente">ID_Cliente</label>
    </div>
   		 <div class="col-75">
 			<input type="number" id="id_cliente" name="id_cliente" value=<%=p.getId_cliente()%>>
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>