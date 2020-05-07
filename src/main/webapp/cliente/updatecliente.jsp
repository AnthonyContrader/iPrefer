<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClienteDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Cliente</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="ClienteServlet?mode=clientelist">Clienti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ClienteDTO c = (ClienteDTO) request.getAttribute("dto");%>

<form id="floatleft" action="ClienteServlet?mode=update&id_cliente=<%=c.getIdCliente()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome_cliente">NomeCliente</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome_cliente" name="nome_cliente" value=<%=c.getNomeCliente()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="cognome_cliente">CognomeCliente</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="cognome_cliente" name="cognome_cliente" value=<%=c.getCognomeCliente()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="intolleranza_bool">Intolleranza</label>
    </div>
   		 <div class="col-75">
 			<select id="intolleranza_bool" name="intolleranza_bool">
  				<option value="true" <%if(c.getIntolleranza()) {%>selected<%}%>>SI</option>
  				<option value="false" <%if(c.getIntolleranza()==false) {%>selected<%}%>>NO</option>
			</select>
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
  <div class="row">
    <div class="col-25">
     <label for="intollerante">Intollerante</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="intollerante" name="intollerante" value=<%=c.getIntollerante()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	

</body>
</html>