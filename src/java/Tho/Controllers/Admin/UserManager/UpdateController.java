/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Controllers.Admin.UserManager;

import Tho.Models.MyDate;
import Tho.Models.UserDAO;
import Tho.Models.UserDTO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThoDT
 */

public class UpdateController extends HttpServlet {
    private static final String ERROR = "error.jsp", SUCCESS_USER = "UserManager.ViewInfoController";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String role = request.getParameter("txtRole");
            String fullname = request.getParameter("txtFullname");
            String abilities = request.getParameter("txtAbilities");
            String powers = request.getParameter("txtPowers");
            String height = request.getParameter("txtHeight");
            String weight = request.getParameter("txtWeight");
            Date dateJoined = MyDate.getDate(request.getParameter("txtdateJoined"));
            UserDTO dto = new UserDTO(username, role, fullname, abilities, powers, height, weight, dateJoined);
            UserDAO dao = new UserDAO();
            if (dao.updateUser(dto)) {
                String BackTo = request.getParameter("BackTo");
                if (BackTo != null) {
                    url = BackTo;
                    request.getSession().setAttribute("USER", dao.findByUsername(username));
                } else {
                    url = SUCCESS_USER;
                }
            } else {
                request.setAttribute("ERROR", "Could not update information's user");
            }
        } catch (Exception e) {
            log("Error at UserManager.UpdateController", e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
