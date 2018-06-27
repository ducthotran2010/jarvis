/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Controllers.Admin.MissionManager;

import Tho.Models.MissionDTO;
import Tho.Models.MyDate;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThoDT
 */
public class GetStatusController extends HttpServlet {

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
        String JSON = "[ ";
        try {
            Date dateStart = MyDate.getDate(request.getParameter("txtDateStart"));
            Date dateEnd = MyDate.getDate(request.getParameter("txtDateEnd"));
            Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
            
            if (dateStart != null) {
                MissionDTO dto = new MissionDTO(dateStart, dateEnd);
                Vector<String> choose = dto.getChooseFromRealStatus(currentDate);
                for (String item : choose) {
                    JSON += "\"" + item + "\",";
                }
            }
        } catch (Exception e) {
            log("Error at MissionManager.GetStatusController", e);
        } finally {
            JSON = JSON.substring(0, JSON.length() - 1) + "]";
            response.getWriter().write(JSON);
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
