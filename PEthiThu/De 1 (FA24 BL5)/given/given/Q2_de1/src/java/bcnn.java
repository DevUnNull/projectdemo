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
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet xử lý yêu cầu tính BCNN (Bội chung nhỏ nhất) từ form JSP
 * @author Admin
 */
public class bcnn extends HttpServlet {

    /**
     * Xử lý yêu cầu cho cả phương thức GET và POST
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // Thiết lập kiểu nội dung UTF-8

        HttpSession session = request.getSession(); // Lấy session hiện tại

        // Lấy danh sách các lần thực thi trước đó từ session
        List<Execute> list = (List<Execute>) session.getAttribute("list");
        
        if (list == null) { // Nếu chưa có danh sách, khởi tạo mới
            list = new ArrayList<>();
        }
        
        // Lấy 3 số nguyên từ request
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int c = Integer.parseInt(request.getParameter("c"));

        // Kiểm tra xem đã từng tính toán với bộ số này chưa
        for (Execute execute : list) {
            if (execute.getA() == a && execute.getB() == b && execute.getC() == c) {
                request.setAttribute("msg", "Execution existed!"); // Thông báo nếu đã tồn tại
                request.getRequestDispatcher("MyExam.jsp").forward(request, response); // chạy về MyExam.jsp
                return;
            }
        }

        // Tính BCNN của hai số đầu tiên
        int r1 = LCM(a, b);
        
        // Tính BCNN với số thứ ba
        int res = LCM(r1, c);

        request.setAttribute("res", res); // Gán kết quả vào request
        list.add(new Execute(a, b, c, res)); // Lưu kết quả vào danh sách
        session.setAttribute("list", list); // Cập nhật danh sách vào session

        // Chuyển hướng về trang JSP để hiển thị kết quả
        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
    }

    /**
     * Hàm tính BCNN của hai số nguyên dương
     */
    private int LCM(int a, int b) {
        int a1 = a, b1 = b;
        while (a != b) { // Lặp đến khi hai số bằng nhau
            if (a > b) {
                b = b + b1; // Tăng số nhỏ hơn lên
            } else {
                a = a + a1;
            }
        }
        return a; // Trả về BCNN
    }

    /**
     * Xử lý yêu cầu GET
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Xử lý yêu cầu POST
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Mô tả ngắn về servlet
     */
    @Override
    public String getServletInfo() {
        return "Servlet tính toán BCNN";
    }
}
