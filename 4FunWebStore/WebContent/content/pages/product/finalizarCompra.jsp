<%@page import="org.omg.PortableServer.POA"%>
<%@page import="br.com.fourfungames.model.Produto"%>
<%@page import="java.util.ArrayList"%>
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
	<div class="col-sm-6">
		<span class="col-sm-3"></span>
		<div class="panel col-sm-6">
			<div class="alert alert-warning">
				<strong><span class="glyphicon glyphicon-warning-sign"></span> Você não parece estar logado. Realize o Login ou seu Cadastro</strong>
			</div>
			<form action="/4FunWebStore/usuarioServlet" method="POST">
		  		<input type="text" class="form-control" name="login" id="login" placeholder="Login">		
		  		<input type="password" class="form-control" name="senha" id="senha" placeholder="Senha">
		  		<br>
		  		<input type="hidden" name="action" value="login">
		  		<input type="hidden" name="destino" value="finalizar">
				<button type="submit" class="btn btn-default btn-block my-btn">Login</button>
			</form>
			<br>
			<a type="button" class="btn btn-default btn-block my-btn-dark" href="cadastro.jsp">Cadastrar</a>
		</div>	
	</div>
	<div class="col-sm-6"> 
	<div class="panel">
	<% if(session.getAttribute("carrinho") != null){
			ArrayList<Produto> listaProdutosCarrinho = (ArrayList<Produto>) request.getSession().getAttribute("carrinho");
			if(listaProdutosCarrinho.size() > 0){
	%>	
	<div class="row">
	<table class="table table-striped my-table">
		<thead>
			<tr>
				<th>Imagem</th>
				<th>Nome</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tbody>
	<%	
		double total = 0;
		for (Produto produto : listaProdutosCarrinho){	
				total = total + produto.getValor();
	%>
			<tr>
				<td><img class="table-image" src="/4FunWebStore/<%=produto.getCaminhoImagem()%>"/> </td>
				<td style="vertical-align: middle;"><%=produto.getName()%></td>
				<td style="vertical-align: middle;"><%=produto.getValor()%></td>
			</tr>
		<%}%>
		</tbody>
		</table>
		</div>
		<div class="row total-text">
			Total: <%= total %>
		</div>
		<div class="row col-sm-12">
			<span class="col-sm-3"></span>
			<div class="col-sm-6">
				<a href="/4FunWebStore/carrinhoServlet?action=comprar&destino=finalizar" class="btn btn-default btn-block my-btn">Finalizar Compra</a>
			</div>
			<span class="col-sm-3"></span>
		</div>
		<%}%>
	<%}%>
	</div>
	</div>
	<span class="col-sm-3"></span>
</div>
<br>
<%}else{ %>
<div class="row">
	<div class="panel">
	<span class="col-sm-3"></span>
	<div class="col-sm-6">  
	<% if(session.getAttribute("carrinho") != null){
			ArrayList<Produto> listaProdutosCarrinho = (ArrayList<Produto>) request.getSession().getAttribute("carrinho");
			if(listaProdutosCarrinho.size() > 0){
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<div class="alert alert-info">
		<strong><span class="glyphicon glyphicon-info-sign"></span> <%=usuario.getNome()%> !</strong> Obrigado pela compra
	</div>
	<table class="table table-striped my-table">
		<thead>
			<tr>
				<th>Imagem</th>
				<th>Nome</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tbody>
	<%	
		double total = 0;
		for (Produto produto : listaProdutosCarrinho){	
				total = total + produto.getValor();
	%>
			<tr>
				<td><img class="table-image" src="/4FunWebStore/<%=produto.getCaminhoImagem()%>"/> </td>
				<td style="vertical-align: middle;"><%=produto.getName()%></td>
				<td style="vertical-align: middle;"><%=produto.getValor()%></td>
			</tr>
		<%}%>
		</tbody>
		</table>
		<div class="total-text">
			Total: <%= total %>
		</div>
		<div class="col-sm-12">
			<a href="/4FunWebStore/carrinhoServlet?action=comprar&destino=index" class="btn btn-default btn-block my-btn">Finalizar Compra</a>
			<br>
		</div>
		<%}%>
	<%}%>
	</div>
	</div>
	<span class="col-sm-3"></span>
	<%}%>
</div>
<%@ include file="/content/pages/bottom.jsp" %>
</body>
</html>