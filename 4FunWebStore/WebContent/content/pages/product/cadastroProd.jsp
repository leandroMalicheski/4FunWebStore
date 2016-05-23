<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="/4FunWebStore/content/css/bootstrap.css">
<link rel="stylesheet" href="/4FunWebStore/content/css/main.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../menuHeader.jsp" %>
<div class="row">
	<span class="col-sm-3"></span>
	<div class="col-sm-6"> 
		<% if(request.getAttribute("produtoCadastrado") != null){ %>
		<div class="alert alert-success">
			<strong><span class="glyphicon glyphicon-ok"></span> Produto Cadastrado!</strong>
		</div>
		<%}%>
		<div class="row panel">
			<form role="form">
				<div class="input-group">
				  <span class="input-group-addon my-addon" id="tituloLabel">Titulo</span>
				  <input id="titulo" type="text" class="form-control my-input" placeholder="4Fun" aria-describedby="tituloLabel" required>
				</div>
				<div class="input-group">
				  <span class="input-group-addon my-addon" id="fileLabel">Selecione a Imagem</span>
				  <input id="file" type="file" class="form-control my-input" aria-describedby="fileLabel" required>
				</div>				
				<div class="input-group">
				  <span class="input-group-addon my-addon" id="valorLabel">Valor R$</span>
				  <input id="valor" type="number" class="form-control my-input" placeholder="300,99" aria-describedby="valorLabel" required>
				</div><br>
				<button type="submit" class="btn btn-default btn-block my-btn">Cadastrar</button>
			</form>
	    </div>
	</div>
	<span class="col-sm-3"></span>
</div>
<%@ include file="/content/pages/bottom.jsp" %>
</body>
</html>