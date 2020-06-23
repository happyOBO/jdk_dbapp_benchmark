/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import app.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KTam
 */
public class AddUserInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {

            request.setAttribute("allDepts", DeptInfoManager.getAllDepartments());
            request.setAttribute("allRaces", RaceInfoManager.getAllRaces());
            request.setAttribute("allOffices", OfficeInfoManager.getAllOffices());

            if (request.getParameterMap().containsKey("firstname"))
            {
                request.setAttribute("userInfo",
                        UserInfoManager.addUserInfo(request.getParameter("firstname"),
                                                    request.getParameter("lastname"),
                                                    request.getParameter("selectedSex"),
                                                    Integer.parseInt(request.getParameter("selectedDept")),
                                                    Integer.parseInt(request.getParameter("selectedOffice")),
                                                    Integer.parseInt(request.getParameter("selectedGradLevel")),
                                                    Integer.parseInt(request.getParameter("selectedRace")),
                                                    request.getParameter("password"),
                                                    Integer.parseInt(request.getParameter("yearsUsingUnix")),
                                                    new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("enrollDate"))));
                request.setAttribute("msg", "Successfully Added");
            }
        }
        catch (Exception e){
            request.setAttribute("errMsg", e.getMessage());
        }
        finally {
            RequestDispatcher view = request.getRequestDispatcher("addUserInfo.jsp");
            view.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
