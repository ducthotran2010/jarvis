/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Controllers.Admin.MissionManager;

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
    private static final String ERROR = "error.jsp",
            ADD = "MissionManager.AddController",
            ADD_USER_TO_MISSION = "MissionManager.AddUserToMissionController",
            INPUT = "admin/mission/addMission.jsp",
            GET_STATUS = "MissionManager.GetStatusController",
            REMOVE = "MissionManager.RemoveController",
            SEARCH = "MissionManager.SearchController",
            EDIT = "MissionManager.EditController",
            UPDATE = "MissionManager.UpdateController",
            UPDATE_IMAGE = "admin/mission/uploadImage.jsp",
            CHECK_ID = "MissionManager.CheckIdController",
            VIEW_INFO = "MissionManager.ViewInfoController",
            QUIT_MISSION = "MissionManager.QuitMissionController";
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
            switch(action) {
                case "Add":
                    url = ADD;
                    break;
                case "AddUserToMission":
                    url = ADD_USER_TO_MISSION;
                    break;
                case "QuitMission":
                    url = QUIT_MISSION;
                    break;
                case "Input Mission":
                    url = INPUT;
                    break;
                case "Remove":
                    url = REMOVE;
                    break;
                case "Search":
                    url = SEARCH;
                    break;
                case "Get Status":
                    url = GET_STATUS;
                    break;
                case "Edit":
                    url = EDIT;
                    break;
                case "Update":
                    url = UPDATE;
                    break;
                case "Update image":
                    url = UPDATE_IMAGE;
                    break;
                case "Check Id":
                    url = CHECK_ID;
                    break;
                case "ViewInfo":
                    url = VIEW_INFO;
                    break;
                default:
                    request.setAttribute("ERROR", "Your action is not support");
            }
        } catch (Exception e) {
            log("Error at MissionManager.MainController", e);
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
