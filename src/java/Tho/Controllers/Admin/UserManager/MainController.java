/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Controllers.Admin.UserManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThoDT
 */
public class MainController extends HttpServlet {
    static private final String ERROR = "error.jsp",
            ADD = "UserManager.AddController",
            SEARCH = "UserManager.SearchController",
            VIEW_INFO = "UserManager.ViewInfoController",
            EDIT = "UserManager.EditController",
            UPDATE = "UserManager.UpdateController",
            RESET_PASSWORD = "admin/user/resetPassword.jsp",
            UPDATE_PASSWORD = "UserManager.UpdatePasswordController",
            UPDATE_IMAGE = "admin/user/uploadImage.jsp",
            INPUT_USER = "admin/user/addUser.jsp",
            CHECK_USERNAME = "UserManager.CheckUsernameController";

    /**
     * /**
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
            String action = request.getParameter("action");
            action = (action == null) ? "" : action;
            switch(action) {
                case "Add":
                    url = ADD;
                    break;
                case "Search":
                    url = SEARCH;
                    break;
                case "Edit":
                    url = EDIT; 
                    break;
                case "Update":
                    url = UPDATE;
                    break;
                case "ViewInfo":
                    url = VIEW_INFO;
                    break;
                case "Reset password":
                    url = RESET_PASSWORD;
                    break;
                case "Update password":
                    url = UPDATE_PASSWORD; 
                    break;
                case "Update avatar":
                    url = UPDATE_IMAGE;
                    break;
                case "Input Account":
                    url = INPUT_USER;
                    break;
                case "Check Username":
                    url = CHECK_USERNAME;
                    break;
                default:
                    request.setAttribute("ERROR", "Action is not supported");
            }
        } catch (Exception e) {
            log("Error at UserManager.MainController", e);
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
