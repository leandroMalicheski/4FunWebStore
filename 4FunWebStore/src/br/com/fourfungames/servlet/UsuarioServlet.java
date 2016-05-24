package br.com.fourfungames.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fourfungames.dao.UsuarioDAO;
import br.com.fourfungames.model.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if ((action != null) && (action.equalsIgnoreCase("login"))) {
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
			Usuario usuario = usuarioDAO.login(login,senha);
			
			if(usuario != null){
				request.getSession().setAttribute("usuario", usuario);
				request.getSession().setAttribute("login", "Y");
			}else{
				request.setAttribute("loginError", "Login ou Senha incorreto(s)!");
			}
			
			request.getRequestDispatcher("content/pages/user/conta.jsp").forward(request, response);
		
		} else if(action !=null && action.equals("logout")){
			
			request.getSession().setAttribute("usuario", null);
			request.getSession().setAttribute("login", null);
			request.getRequestDispatcher("content/pages/user/conta.jsp").forward(request, response);
		
		} else if(action !=null && action.equals("add")){
			String nome = request.getParameter("nome");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String email = request.getParameter("email");
			String sexo = request.getParameter("optradio");
			UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
			usuarioDAO.add(new Usuario(login,senha,nome,email,sexo));
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
