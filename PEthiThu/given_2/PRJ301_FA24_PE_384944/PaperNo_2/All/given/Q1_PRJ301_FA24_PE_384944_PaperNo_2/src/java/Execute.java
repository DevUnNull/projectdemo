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
public class Execute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = (req.getParameter("str"));
        String option = req.getParameter("option");
        if(!isValidInput(str)){
            resp.getWriter().println("Input string is invalid!");
            return;
        }
        if("length".equals(option)){
            resp.getWriter().println(getStringLength(str));
        }else{
            resp.getWriter().println(countVowels(str));
        }
        
    }
   
    public static boolean isValidInput(String str) {
        return str != null && !str.trim().isEmpty();
    }
    public static int getStringLength(String str) {
        return (str != null) ? str.length() : 0;
    }
    public static int countVowels(String str) {
        if (str == null) return 0;

        int count = 0;
        str = str.toLowerCase(); // Chuyển thành chữ thường
        for (char c : str.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) { // Kiểm tra nếu là nguyên âm
                count++;
            }
        }
        return count;
}

}
