/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Usuario;

/**
 *
 * @author anderson
 */
@WebServlet(urlPatterns = {"/Cadastrar"})
public class Cadastrar extends HttpServlet {

   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
                       
            Class.forName("com.mysql.jdbc.Driver");
            Connection c =  DriverManager.getConnection("jdbc:mysql://localhost/ultimotrabalhoanderson","root","");
            PreparedStatement  p =  c.prepareStatement("delete from funcionarios where id = ? ");
            p.setInt(1,  Integer.parseInt(request.getParameter("id")));
            p.execute() ;
            response.sendRedirect("listando.jsp");
        } catch (SQLException ex) {
          response.getWriter().print("Erro: " + ex.getMessage());
          Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        //response.sendRedirect("index.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           // Usuario l = new Usuario();
            
       // l.setNome(String.valueOf(request.getParameter("login")));
       // l.setStatus(String.valueOf(request.getParameter("senha")));
       //INSERT INTO `funcionarios` (`id`, `nome`, `status`, `nada`) VALUES (NULL, 'gg', 'gg', '1');
       //insert into funcionarios (nome,status) values (?,?)"
        
             Class.forName("com.mysql.jdbc.Driver");
             Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ultimotrabalhoanderson","root","");
            PreparedStatement  p =  c.prepareStatement("INSERT INTO `funcionarios` (`id`, `bmatricula`, `bnome`, `bsenha`, `bstatus`) VALUES (NULL, ?, ?,?,'Autenticado')");
            p.setString(1,request.getParameter("fmatricula"));
            p.setString(2, request.getParameter("fnome"));
            p.setString(3, request.getParameter("fsenha"));
            p.execute() ;
            //response.getWriter().println("Cadastro realizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("listando.jsp");
        
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
