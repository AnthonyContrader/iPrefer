<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.BevandaDTO"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Bevanda</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="BevandaServlet?mode=bevandalist">Bevanda</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%BevandaDTO u = (BevandaDTO) request.getAttribute("dto");%>


<form id="floatleft" action="BevandaServlet?mode=update&id_bevanda=<%=u.getId_Bevanda()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome_bevanda">nome_bevanda</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_bevanda" name="nome_bevanda" value=<%=u.getNome_Bevanda()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="costo_bevanda">costo_bevanda</label>
    </div>
    <div class="col-75">
      <input type="number"step="0.1" id="costo_bevanda" name="costo_bevanda" value=<%=u.getCosto_Bevanda()%>> 
    </div>
    </div>
     <div class="row">
    <div class="col-25">
     <label for="alcolico">alcolico</label>
    </div>
    <div class="col-75">
      <input type="text" id="alcolico" name="alcolico" value=<%=u.getAlcolico()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="descrizione">descrizione</label>
    </div>
          <input type="text" id="descrizione" name="descrizione" value=<%=u.getDescrizione()%>> 
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>