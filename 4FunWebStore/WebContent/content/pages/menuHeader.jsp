<%@page import="br.com.fourfungames.model.Usuario"%>
<img src="/4FunWebStore/content/images/headerStore.png" class="img-responsive center-block" alt="Responsive image">
<nav class="navbar navbar-default" style="background-color: #262626">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand brand-text" href="/4FunWebStore/index.jsp">
        		4FUN
      		</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"	id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav my-dropdown">
			<%
				if(session.getAttribute("login") != null){
					Usuario usuario = (Usuario) session.getAttribute("usuario");
					if("adm".equalsIgnoreCase(usuario.getPerfil())){
			%>
				<li class="dropdown">
	          		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Produtos <span class="caret"></span></a>
	          		<ul class="dropdown-menu">
	            		<li><a href="/4FunWebStore/content/pages/product/cadastroProd.jsp">Cadastrar</a></li>
	            		<li><a href="/4FunWebStore/content/pages/product/editarProduto.jsp">Editar</a></li>
	          		</ul>
	        	</li>
			<%		}
				} %>			
	        </ul>
			<ul class="nav navbar-nav navbar-right">
        		<li><a href="/4FunWebStore/content/pages/user/conta.jsp"><span class="glyphicon glyphicon-user"></span> Sua Conta</a></li>
        		<li><a href="/4FunWebStore/content/pages/user/carrinho.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
			</ul>
		</div>
	</div>
</nav>