<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClienteDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Cliente Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/cliente/getall">Clienti</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ClienteDTO c = (ClienteDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/cliente/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="cognome_cliente">cognome_cliente</label>
    </div>
    <div class="col-75">
       <input
			type="text" id="cognome_cliente" name="cognome_cliente" value=<%=c.getCognome_cliente()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="intollerante">intollerante</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="intollerante" name="intollerante" value=<%=c.getIntollerante()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="intolleranza_bool">intolleranza_bool</label>
    </div>
   		 <div class="col-75">
 			<select id="intolleranza_bool" name="intolleranza_bool">
  				<option value=true <%if(c.isIntolleranza_bool()==true) {%>selected<%}%>>SI</option>
  				<option value=false <%if(c.isIntolleranza_bool()==false) {%>selected<%}%>>NO</option>
			</select>
    	</div>
    	<input type="hidden" name="id" value =<%=c.getId() %>>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="nome_cliente">NomeCliente</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_cliente" name="nome_cliente" value=<%=c.getNome_cliente()%>>
    </div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="telefono">Telefono</label>
    </div>
    <div class="col-75">
      <input type="text" id="telefono" name="telefono" value=<%=c.getTelefono()%>>
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

<br>
<%@ include file="./css/footer.jsp" %>

</body>
</html>