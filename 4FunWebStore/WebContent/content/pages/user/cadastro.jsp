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
		<% if(request.getAttribute("cadastroFlag") != null){ %>
		<div class="alert alert-success">
			<strong><span class="glyphicon glyphicon-ok"></span> Você foi Cadastrado com Sucesso!</strong> Realize o Login para comprar
		</div>
		<%}%>
		<div class="row panel">
			<form method="POST" action="/4FunWebStore/usuarioServlet" role="form">
				<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" required>
				<input type="text" class="form-control" id="login" name="login" placeholder="Login" required>
			  	<input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required>
			  	<input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
				<div class="form-control">
					<label class="radio-inline"><input type="radio" name="optradio">Masculino</label>
					<label class="radio-inline"><input type="radio" name="optradio">Feminino</label>
				</div>
				<input type="hidden" name="action" value="add">
				<button type="submit" class="btn btn-default btn-block my-btn">Cadastrar</button>
			</form>
	    </div>
	</div>
	<span class="col-sm-3"></span>
</div>
<%@ include file="/content/pages/bottom.jsp" %>
</body>
</html>