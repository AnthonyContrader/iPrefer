<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="it.contrader.dto.BevandaDTO"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Bevanda Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Bevanda</title>
</head>
<body>
	<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a class ="active" href="/bevanda/getall">Bevanda</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%BevandaDTO u = (BevandaDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/bevanda/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="bevanda">nome_bevanda</label>
    </div>
    <div class="col-75">
      <input type="text" id="bevanda" name="nome_bevanda" value=<%=u.getNome_bevanda()%>>
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="costo_bevanda">costo_bevanda</label>
    </div>
    <div class="col-75">
      <input type="text" id="costo_bevanda" name="costo_bevanda" value=<%=u.getCosto_bevanda()%>> 
    </div>
  </div>
  
  <div class="row">
				<div class="col-25">
					<label for="alcolico">Alcolico</label>
				</div>
				<div class="col-75">
					<select id="alcolico" name="alcolico">
						<option value="TRUE">TRUE</option>
						<option value="FALSE">FALSE</option>
					</select>
				</div>
			</div>
  
  <div class="row">
    <div class="col-25">
      <label for="descrizione">descrizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="descrizione" name="descrizione" value=<%=u.getDescrizione()%>> 
    </div>
    <input type="hidden" name="id" value =<%=u.getId() %>>
  </div>
  
  
  
      <button type="submit" >Edit</button>
</form>
<br>

<%@ include file="./css/footer.jsp" %>	
</body>
</html>