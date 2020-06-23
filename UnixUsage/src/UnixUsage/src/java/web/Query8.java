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
public class Query8 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try
        {
            List<IOfficeInfo> allOffices = OfficeInfoManager.getAllOffices();
            request.setAttribute("allOffices", allOffices);

            if (request.getParameterMap().containsKey("selectedOffices"))
            {
                String[] selectedOffices = request.getParameterValues("selectedOffices");
                List<Integer> officeIDs = new ArrayList<Integer>();

                for (int i = 0; i < selectedOffices.length; i++)
                    officeIDs.add(Integer.parseInt(selectedOffices[i]));



                Map<String, Integer> results = OfficeInfoManager.getUserWorkloadForOffices(officeIDs);

                request.setAttribute("results", results);
                request.setAttribute("selectedOffices", selectedOffices);
            }
        }
        catch (Exception e){
            request.setAttribute("errMsg", e.getMessage());
        }
        finally {
            RequestDispatcher view = request.getRequestDispatcher("8.jsp");
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
