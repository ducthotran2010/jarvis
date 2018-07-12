/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Controllers.User.UserViewer;

import Tho.Models.UserDAO;
import Tho.Models.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThoDT
 */
public class UpdateMyPasswordController extends HttpServlet {

    private static final String ERROR = "error.jsp",
            WRONG_PW = "user/profile/editMyPassword.jsp",
            SUCCESS = "UserViewer.ViewMyProfileController";

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
            UserDTO dto = (UserDTO) request.getSession().getAttribute("USER");
            String username = dto.getUsername();
            String currentPassword = request.getParameter("txtCurrentPassword");
            
            UserDAO dao = new UserDAO();
            String checkLogin = dao.checkLogin(username, currentPassword);
            if (!checkLogin.equals("failed")) {
                String newPassword = request.getParameter("txtPassword");

                
                if (dao.updatePasswordUser(username, newPassword)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Could not change your password");
                }
            } else {
                url = WRONG_PW;
                request.setAttribute("NOT_MATCH_PASSWORD", true);
            }
        } catch (Exception e) {
            log("Error at UserViewer.UpdateMyPasswordController", e);
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
