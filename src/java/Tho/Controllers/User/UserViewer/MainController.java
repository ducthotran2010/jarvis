/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Controllers.User.UserViewer;

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
            SEARCH = "UserViewer.SearchController",
            VIEW_INFO = "UserViewer.ViewInfoController",
            VIEW_MY_PROFILE = "UserViewer.ViewMyProfileController",
            EDIT_MY_PROFILE = "UserViewer.EditMyProfileController",
            EDIT_MY_PASSWORD = "user/profile/editMyPassword.jsp",
            UPDATE_MY_PROFILE = "UserViewer.UpdateMyProfileController",
            UPDATE_AVATAR = "user/profile/uploadAvatar.jsp",
            UPDATE_MY_PASSWORD = "UserViewer.UpdateMyPasswordController";
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
            String action = request.getParameter("action");
            action = (action == null) ? "" : action;
            switch (action) {
                case "Search":
                    url = SEARCH;
                    break;
                case "ViewInfo":
                    url = VIEW_INFO;
                    break;
                case "ViewMyProfile":
                    url = VIEW_MY_PROFILE;
                    break;
                case "EditMyProfile":
                    url = EDIT_MY_PROFILE;
                    break;
                case "EditMyPassword":
                    url = EDIT_MY_PASSWORD;
                    break;
                case "UpdateMyProfile":
                    url = UPDATE_MY_PROFILE;
                    break;
                case "Update avatar":
                    url = UPDATE_AVATAR;
                    break;
                case "UpdateMyPassword":
                    url = UPDATE_MY_PASSWORD;
                    break;
                default:
                    request.setAttribute("ERROR", "Action is not supported");
            }
        } catch (Exception e) {
            log("Error at UserViewer.MainController", e);
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
