package br.com.fourfungames.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fourfungames.dao.ProdutoDAO;
import br.com.fourfungames.model.Produto;

/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet("/produtoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action != null && action.equalsIgnoreCase("add")){
			addProduto(request);
			request.setAttribute("produtoCadastrado", Integer.valueOf(0));
			request.getRequestDispatcher("content/pages/product/cadastroProd.jsp").forward(request, response);
		}
		
	}

	private void addProduto(HttpServletRequest request) {
		
		ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
		String titulo = request.getParameter("titulo");
		double valor = Double.valueOf(request.getParameter("valor"));
		String imagePath = request.getParameter("imagemg");
	
		produtoDAO.add(new Produto(titulo,null,imagePath,valor));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
