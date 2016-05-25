package br.com.fourfungames.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fourfungames.dao.ProdutoDAO;
import br.com.fourfungames.model.Produto;

@WebServlet("/produtoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdutoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null){
			switch (action) {
			case "add":
				addProduto(request);
				request.setAttribute("produtoCadastrado", Integer.valueOf(0));
				request.getRequestDispatcher("content/pages/product/cadastroProd.jsp").forward(request, response);
				break;
				
			case "excluir":
				excluirProduto(request, Integer.valueOf(request.getParameter("id")));
				request.setAttribute("produtoRemovido", "Y");
				request.getRequestDispatcher("content/pages/product/editarProduto.jsp").forward(request, response);
				break;
			
			case "editar":
				Produto produto = ProdutoDAO.getInstance().listById(Integer.valueOf(request.getParameter("id")));
				request.setAttribute("produto", produto);
				request.getRequestDispatcher("content/pages/product/cadastroProd.jsp").forward(request, response);
				break;
				
			case "salvar":
				salvar(request);
				request.setAttribute("produtoAtualizado", "Y");
				request.getRequestDispatcher("content/pages/product/editarProduto.jsp").forward(request, response);
				break;

			default:
				request.setAttribute("erro", "Action não Mapeada");
				request.getRequestDispatcher("content/pages/error.jsp").forward(request, response);
				break;
			}
			
		}else{
			request.setAttribute("erro", "Nenhuma Action foi Recebida");
			request.getRequestDispatcher("content/pages/error.jsp").forward(request, response);
		}
		
	}

	private void salvar(HttpServletRequest request) {
		String titulo = request.getParameter("titulo");
		double valor = Double.valueOf(request.getParameter("valor"));
		
		Produto produto = ProdutoDAO.getInstance().listById(Integer.valueOf(request.getParameter("id")));
		produto.setName(titulo);
		produto.setValor(valor);
		
		ProdutoDAO.getInstance().update(produto);
	}

	private void excluirProduto(HttpServletRequest request, int id) {
		ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
		produtoDAO.remove(id);
		
	}

	private void addProduto(HttpServletRequest request) {
		
		ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
		String titulo = request.getParameter("titulo");
		double valor = Double.valueOf(request.getParameter("valor"));
		if(request.getParameter("imagemg") != null){
			String imagePath = request.getParameter("imagemg");
			produtoDAO.add(new Produto(titulo,imagePath,valor));
		}else{
			produtoDAO.add(new Produto(titulo,null,valor));
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
