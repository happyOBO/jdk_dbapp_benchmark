/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import app.DeptInfoManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KTam
 */
public class EditDeptInfo extends HttpServlet {
   
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
            if (request.getParameterMap().containsKey("findDeptId"))
            {
                int deptId = Integer.parseInt(request.getParameter("findDeptId"));
                request.setAttribute("deptInfo", DeptInfoManager.getDeptInfo(deptId));
            }
            else if (request.getParameterMap().containsKey("deptId"))
            {
                int deptId = Integer.parseInt(request.getParameter("deptId"));
                String deptName = request.getParameter("deptName");

                DeptInfoManager.editDepartment(deptId, deptName);

                request.setAttribute("deptInfo", DeptInfoManager.getDeptInfo(deptId));
                request.setAttribute("msg", "Successfully Edited");
            }
        }
        catch (Exception e){
            request.setAttribute("errMsg", e.getMessage());
        }
        finally {
            RequestDispatcher view = request.getRequestDispatcher("editDeptInfo.jsp");
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
