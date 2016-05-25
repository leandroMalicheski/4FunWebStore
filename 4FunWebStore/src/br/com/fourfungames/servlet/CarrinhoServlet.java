package br.com.fourfungames.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fourfungames.dao.ProdutoDAO;
import br.com.fourfungames.model.Produto;

@WebServlet({ "/carrinhoServlet" })
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "add":
				addProduto(request);
				request.setAttribute("produtoAdded", Integer.valueOf(0));
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			case "excluir":
				removeProduto(request);
				request.setAttribute("produtoRemovido", Integer.valueOf(0));
				request.getRequestDispatcher("content/pages/user/carrinho.jsp").forward(request, response);
				break;

			case "comprar":
				
				if(request.getParameter("destino").equals("index")){
					request.getSession().setAttribute("carrinho",null);	
					request.setAttribute("compraFinalizada", "Y");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}else{
					request.setAttribute("favorLogin", "Y");
					request.getRequestDispatcher("content/pages/product/finalizarCompra.jsp").forward(request, response);
				}
				break;
				
			default:
				request.setAttribute("erro", "Action não Mapeada");
				request.getRequestDispatcher("content/pages/error.jsp").forward(request, response);
				break;
			}

		} else {
			request.setAttribute("erro", "Nenhuma Action foi Recebida");
			request.getRequestDispatcher("content/pages/error.jsp").forward(request, response);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addProduto(HttpServletRequest request) {

		int produtoId = Integer.parseInt(request.getParameter("id"));
		ArrayList<Produto> produtosCarrinho = (ArrayList) request.getSession().getAttribute("carrinho");

		ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
		Produto produto = produtoDAO.listById(produtoId);

		if (produtosCarrinho != null) {
			produtosCarrinho.add(produto);
		} else {
			produtosCarrinho = new ArrayList<Produto>();
			produtosCarrinho.add(produto);
		}
		request.getSession().setAttribute("carrinho", produtosCarrinho);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void removeProduto(HttpServletRequest request) {
		ArrayList<Produto> produtosCarrinho = (ArrayList) request.getSession().getAttribute("carrinho");
		if (produtosCarrinho != null) {
			ArrayList<Produto> newProdutosCarrinho = new ArrayList();
			int produtoId = Integer.parseInt(request.getParameter("id"));
			for (Produto produto : produtosCarrinho) {
				if (produto.getId() != produtoId) {
					newProdutosCarrinho.add(produto);
				}
			}
			request.getSession().setAttribute("carrinho", newProdutosCarrinho);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
