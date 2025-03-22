/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class exe extends HttpServlet {

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

        HttpSession session = request.getSession();

        List<Execute> list = (List<Execute>) session.getAttribute("list");

        if (list == null || list.isEmpty()) {
            list = new ArrayList<>();
        }
        
        String str = request.getParameter("str");
        String opt = request.getParameter("opt");
        
        for (Execute exe : list) {// kiểm tra xem có dữ liệu đó trong bảng hay chưa
            
            if(exe.getStr().equals(str) && exe.getOpt().equals(opt)){
                request.setAttribute("msg", "Execution existed!");
                request.getRequestDispatcher("MyExam.jsp").forward(request, response);
                return;
            }       
        }
        
        if("Length of string".equals(opt)){
            int res = str.length();
            list.add(new Execute(str, opt, res));
            request.setAttribute("res", res);
            session.setAttribute("list", list);
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
            return;
        }
        
        if("Consonant characters".equals(opt)){
            int count = 0;
            for (char s : str.toLowerCase().toCharArray()) {
                
                if(!"aeuoi".contains(s+"") && Character.isAlphabetic(s) ){
                    count++;
                }
            }
            list.add(new Execute(str, opt, count));
            request.setAttribute("res", count);
            session.setAttribute("list", list);
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
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
