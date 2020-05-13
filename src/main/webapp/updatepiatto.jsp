<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PiattoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Modifica del piatto">
<meta name="author" content="Ambrogio Santo">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Modifica del piatto</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Utenti</a>
  <a class="active" href="/piatto/getall">Piatti</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PiattoDTO u = (PiattoDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/piatto/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome_piatto">nome piatto</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_piatto" name="nome_piatto" value=<%=u.getNome_piatto()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="ingredienti">ingredienti</label>
    </div>
    <div class="col-75">
      <input type="text" id="ingredienti" name="ingredienti" value=<%=u.getIngredienti()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="costo_piatto">costo piatto</label>
    </div>
   		 <div class="col-75">
 	<input type="text" id="costo_piatto" name="costo_piatto" value=<%=u.getCosto_piatto()%>>		
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="descrizione_piatto">descrizione piatto</label>
    </div>
    <div class="col-75">
      <input type="text" id="descrizione_piatto" name="descrizione_piatto" value=<%=u.getDescrizione_piatto()%>> 
    </div>
    <input type="hidden" name="id" value =<%=u.getId() %>>
  </div>
  
      <button type="submit" >Modifica</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>