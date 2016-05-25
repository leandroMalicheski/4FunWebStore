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
<div class="row">
	<span class="col-sm-3"></span>
	<div class="col-sm-6"> 
		<% if(request.getAttribute("produtoRemovido") != null){ %>
		<div class="alert alert-success">
			<strong><span class="glyphicon glyphicon-ok"></span> Produto Removido!</strong>
		</div>
		<%}%>
		<div class="row panel">
		<% if(session.getAttribute("carrinho") != null){
			ArrayList<Produto> listaProdutosCarrinho = (ArrayList<Produto>) request.getSession().getAttribute("carrinho");
			if(listaProdutosCarrinho.size() > 0){
		%>
		<table class="table table-striped my-table">
			<thead>
				<tr>
					<th>Imagem</th>
					<th>Nome</th>
					<th>Valor</th>
					<th style="text-align: center;">Remover da Lista</th>
				</tr>
			</thead>
			<tbody>
		<%	
		double total = 0;
		for (Produto produto : listaProdutosCarrinho){	
				total = total + produto.getValor();
		%>
				<tr >
					<td><img class="table-image" src="/4FunWebStore/<%=produto.getCaminhoImagem()%>"/> </td>
					<td style="vertical-align: middle;"><%=produto.getName()%></td>
					<td style="vertical-align: middle;"><%=produto.getValor()%></td>
					<td style="text-align: center; vertical-align: middle;"><a href="/4FunWebStore/carrinhoServlet?id=<%=produto.getId()%>&action=excluir"><span class="glyphicon glyphicon-remove"></span></a></td>
				</tr>
		<%}%>
			</tbody>
		</table>
		<div class="total-text">
			Total: <%= total %>
		</div>
		<div class="col-sm-12">
			<a href="../product/finalizarCompra.jsp" class="btn btn-default btn-block my-btn">Finalizar compra</a>
		</div>
		<%}else{%>
			<div class="alert alert-danger">
  				<strong>Opa!</strong> Todos os items foram removidos, vocêa não possui mais produtos no carrinho.
			</div>
		<%}
		}else{%>
			<div class="alert alert-danger">
  				<strong>Opa!</strong> Você ainda não possui produtos no carrinho.
			</div>
		<%} %>
	    </div>
	</div>
	<span class="col-sm-3"></span>
</div>
<%@ include file="/content/pages/bottom.jsp" %>
</body>
</html>