/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Controllers.Admin.UserManager;

import Tho.Models.MyDate;
import Tho.Models.UserDAO;
import Tho.Models.UserDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ThoDT
 */

public class AddController extends HttpServlet {
    
    private static final String ERROR = "error.jsp", SEARCH = "UserManager.SearchController";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String getFileUpload(HttpServletRequest request) {
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            try {
                items = upload.parseRequest((RequestContext) request);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Iterator iter = items.iterator();
            Hashtable params = new Hashtable();
            String fileName = null;
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    params.put(item.getFieldName(), item.getString());
                } else {
                    try {
                        String itemName = item.getName();
                        fileName = itemName.substring(itemName.indexOf("\\"));
                        System.out.println("Path:" + fileName);
                        String realPath = getServletContext().getRealPath("/");
                        System.out.println("Real Path:" + realPath);
                        File savedFile = new File(realPath);
                        item.write(savedFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return fileName;
            }
        } else {
            System.out.println("Single path");
        }
        return null;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String role = request.getParameter("txtRole");
            String fullname = request.getParameter("txtFullname");
            String abilities = request.getParameter("txtAbilities");
            String powers = request.getParameter("txtPowers");
            String height = request.getParameter("txtHeight");
            String weight = request.getParameter("txtWeight");
            Date dateJoined = MyDate.getDate(request.getParameter("txtdateJoined"));
            UserDTO dto = new UserDTO(username, password, role, fullname, abilities, powers, height, weight, dateJoined);
            UserDAO dao = new UserDAO();
            if (dao.addUser(dto)) {
                getFileUpload(request);
                url = SEARCH;
            } else {
                request.setAttribute("ERROR", "Could not add new user");
            }
        } catch (Exception e) {
            log("Error at UserManager.AddController", e);
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
