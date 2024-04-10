package com.de1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.de1.dao.ProductImpl;
import com.de1.entities.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		ProductImpl productImpl = new ProductImpl();
		
		if(action == null) {
			request.setAttribute("data", productImpl.getAll());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if(action.equals("add")) {
			request.getRequestDispatcher("add.jsp").forward(request, response);
		} else if(action.equals("edit")) {
			request.setAttribute("product", productImpl.getById(request.getParameter("productId")));
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} else if(action.equals("detail")) {
			request.setAttribute("product", productImpl.getById(request.getParameter("productId")));
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		} else if(action.equals("search")) {
			request.setAttribute("data", productImpl.getByPrice(Integer.parseInt(request.getParameter("from")), Integer.parseInt(request.getParameter("to"))));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if(action.equals("onadd") || action.equals("onedit")) {
			Product product = new Product(
						request.getParameter("productId"),
						request.getParameter("productName"),
						Integer.parseInt(request.getParameter("price")),
						Integer.parseInt(request.getParameter("quantity")),
						request.getParameter("description"),
						Boolean.parseBoolean(request.getParameter("status"))
					);
			if(action.equals("onadd")) {
				if(productImpl.insert(product)) request.setAttribute("success", "Add product successfully!");
				else request.setAttribute("error", "Add product unsuccessful!");
			} else {
				if(productImpl.update(product)) request.setAttribute("success", "Edit product successfully!");
				else request.setAttribute("error", "Edit product unsuccessful!");
			}
			request.setAttribute("data", productImpl.getAll());
			request.getRequestDispatcher("index.jsp").forward(request, response);				
		} else if(action.equals("delete")) {
			if(productImpl.delete(request.getParameter("productId"))) request.setAttribute("success", "Delete product successfully!");
			else request.setAttribute("error", "Delete product unsuccessful!");
			request.setAttribute("data", productImpl.getAll());
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
