<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PiattoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Modifica Piatto</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="PiattoServlet?mode=piattolist">Piatti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PiattoDTO u = (PiattoDTO) request.getAttribute("dto");%>


<form id="floatleft" action="PiattoServlet?mode=update&id_piatto=<%=u.getIdPiatto()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome_piatto">Nome Piatto</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_piatto" name="nome_piatto" value=<%=u.getNomePiatto()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="ingredienti">Ingredienti</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="ingredienti" name="ingredienti" value=<%=u.getIngredienti()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="costo_piatto">Costo Piatto</label>
    </div>
   		 <div class="col-75">
 		<input type="text" id="costo_piatto" name="costo_piatto" value=<%=u.getCostoPiatto()%>>
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="descrizione_piatto">Descrizione Piatto</label>
    </div>
   		 <div class="col-75">
 		<input type="text" id="descrizione_piatto" name="descrizione_piatto" value=<%=u.getDescrizionePiatto()%>>
    	</div>
  </div>
      <button type="submit" >Modifica</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>