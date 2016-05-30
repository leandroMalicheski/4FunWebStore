package br.com.fourfungames.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.fourfungames.dao.UsuarioDAO;
import br.com.fourfungames.model.Usuario;

@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action != null){
			switch (action) {
			case "login":
				login(request);
				
				if(request.getParameter("destino").equals("conta")){
					request.getRequestDispatcher("content/pages/user/conta.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("content/pages/product/finalizarCompra.jsp").forward(request, response);
				}
				break;
				
			case "logout":
				request.getSession().setAttribute("usuario", null);
				request.getSession().setAttribute("login", null);
				request.getRequestDispatcher("content/pages/user/conta.jsp").forward(request, response);
				break;
			
			case "add":
				add(request);	
				request.setAttribute("cadastroFlag", "Y");
				request.getRequestDispatcher("content/pages/user/cadastro.jsp").forward(request, response);
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

	private void add(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String sexo = request.getParameter("optradio");
		
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		usuarioDAO.add(new Usuario(nome,login,"default",email,senha,sexo));
		
	}

	private void login(HttpServletRequest request) {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = UsuarioDAO.getInstance().login(login,senha);
		
		if(usuario != null){
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("login", "Y");
		}else{
			request.setAttribute("loginError", "Login ou Senha incorreto(s)!");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
