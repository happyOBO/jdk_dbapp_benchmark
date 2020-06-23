/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import app.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KTam
 */
public class AddRaceInfo extends HttpServlet {

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
            if (request.getParameterMap().containsKey("raceCode"))
            {
                int raceCode = Integer.parseInt(request.getParameter("raceCode"));
                String race = request.getParameter("race");
                
                RaceInfoManager.addRaceInfo(raceCode, race);

                request.setAttribute("raceInfo", RaceInfoManager.getRaceInfoByCode(raceCode));
                request.setAttribute("msg", "Successfully Added");
            }
        }
        catch (Exception e){
            request.setAttribute("errMsg", e.getMessage());
        }
        finally {
            RequestDispatcher view = request.getRequestDispatcher("addRaceInfo.jsp");
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
