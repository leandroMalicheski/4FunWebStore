<%@page import="java.awt.geom.CubicCurve2D"%>
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
<%if (request.getSession().getAttribute("login") == null){ %>
		<div class="row">
			<span class="col-sm-3"></span>
			<div class="col-sm-6">    
				<div class="row">
				<% if(request.getAttribute("loginError") != null){%>
				  	<div class="alert alert-danger">
						<strong><span class="glyphicon glyphicon-remove"></span><%=request.getAttribute("loginError") %></strong>
					</div>
				<%}else{ %>				
					<div class="alert alert-warning">
						<strong><span class="glyphicon glyphicon-warning-sign"></span> Você não parece estar logado. Realize o Login ou seu Cadastro</strong>
					</div>
				<%} %>
				</div>
				<div class="row panel">
			   		<form action="/4FunWebStore/usuarioServlet" method="POST">
				  		<input type="text" class="form-control" name="login" id="login" placeholder="Login">		
				  		<input type="password" class="form-control" name="senha" id="senha" placeholder="Senha">
				  		<input type="hidden" name="action" value="login">
						<button type="submit" class="btn btn-default btn-block my-btn">Login</button>
					</form>
					<a type="button" class="btn btn-default btn-block my-btn-dark" href="cadastro.jsp">Cadastrar</a>
		    	</div>
		    </div>
		    <span class="col-sm-3"></span>
	    </div>
<%}else{ 
	Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
%>
<div class="row">
<span class="col-sm-3"></span>
<span class="col-sm-6">
	<div class="alert alert-info">
		Bem Vindo <strong><%= usuario.getNome() %> !</strong> Aproveite nossas ofertas.
	</div>	
	  <div class="panel panel-default my-panel">
   		<div class="panel-heading">Seus Dados</div>
   		<div class="panel-body">
     		<span class="col-sm-12"><strong>Login:</strong> <%= usuario.getLogin() %></span>
     		<span class="col-sm-12"><strong>Password:</strong> <%= usuario.getSenha().substring(0, usuario.getSenha().length()-4) %>****</span>
     		<span class="col-sm-12"><strong>Email:</strong> <%= usuario.getEmail() %></span>
     		<span class="col-sm-12"><strong>Pefil:</strong> <%= usuario.getPerfil() %></span>
   		</div>
     		<a class="btn btn-default btn-block my-btn-dark" href="/4FunWebStore/usuarioServlet?action=logout">Logout </a>
  	</div>
</span>
</div>
<%} %>
<%@ include file="/content/pages/bottom.jsp" %>
</html>