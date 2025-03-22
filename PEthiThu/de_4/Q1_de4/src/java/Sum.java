/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Sum extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("nb"));
        String opt = req.getParameter("opt");
        PrintWriter out = resp.getWriter();
        int total =0;
        if(n<5){
            out.print("You must input an integer > 5");
        }
        if (opt == null) {
            out.print("You must choose an option");
            return;
        }
        
        if("even".equals(opt)){
            for (int i=0;i<n;i++) {
                if(i%2 == 0){
                    total+=i;
                }
            }
            out.print(total);
            return;
        }
        
        if("odd".equals(opt)){
            for (int i=0;i<n;i++) {
                if(i%2 != 0){
                    total+=i;
                }
            }
            out.print(total);
        }
    }
    
}
