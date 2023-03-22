package br.fiap.cp1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;


import br.fiap.cp1.model.entidade.Produto;
import br.fiap.modelo.dao.EmpregadoDAO;
import br.fiap.modelo.entidade.Departamento;
import br.fiap.modelo.entidade.Empregado;

/**
 * Servlet implementation class CadastroProdutoServlet
 */
@WebServlet("/CadastroProduto")
public class CadastroProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroProdutoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
				
		String nome = request.getParameter("nome");
		double preco = parseDouble(request.getParameter("idProd"));
		departamento.setId(Integer.parseInt(request.getParameter("departamento")));
		empregado.setDepartamento(departamento);

		Produto produto = new Produto();

		new EmpregadoDAO().inserir(empregado);

	}

}
