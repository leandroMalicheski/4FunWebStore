<%@page import="java.awt.Point"%>
<%@page import="br.com.fourfungames.dao.ProdutoDAO"%>
<%@page import="br.com.fourfungames.servlet.CarrinhoServlet"%>
<%@page import="br.com.fourfungames.model.Produto"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
	<%@ include file="content/pages/menuHeader.jsp" %> 
	<div class="container">    
	<% 
		ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
		ArrayList<Produto> listaProdutos = produtoDAO.list();
		if(request.getAttribute("produtoAdded") != null){ %>
		<div class="alert alert-success">
  			<strong>Adicionado!</strong> Produto adicionado ao seu carrinho.
		</div>
	<%} %>
	<% for(Produto produto : listaProdutos){%>
	    <div class="col-sm-4">
	      <div class="panel panel-default my-panel" >
	        <div class="panel-heading"><%=produto.getName()%></div>
	        <div class="panel-body"><img src=/4FunWebStore/<%=produto.getCaminhoImagem() %> class="img-responsive" style="width:100%" alt="Image"></div>
	        <div class="panel-footer">
	        	<span class="footer-text"><%=produto.getValor()%></span>
	        	<button type="button" class="btn btn-block my-btn">
	        		<a href="/4FunWebStore/carrinhoServlet?id=<%=produto.getId()%>&action=add">Adicionar 
	        			<span class="glyphicon glyphicon-shopping-cart"></span>
	        		</a> 
	        	</button>
	        </div>
	      </div>
	    </div>
	<%}%>
	  </div>
	<%@ include file="/content/pages/bottom.jsp" %> 
</body>
</html>