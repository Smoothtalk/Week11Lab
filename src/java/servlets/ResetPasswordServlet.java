/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 775653
 */
public class ResetPasswordServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService as = new AccountService();
        
        String url = request.getRequestURL().toString();
        String path = getServletContext().getRealPath("/WEB-INF");
        String email = request.getParameter("resetEmail");
        
        as.resetPassword(email, path, url);
        
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
    }
}
