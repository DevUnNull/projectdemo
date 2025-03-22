import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Bcnn extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static List<LCMRecord> history = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nb1 = request.getParameter("number1");
        String nb2 = request.getParameter("number2");
        String nb3 = request.getParameter("number3");

        // Kiểm tra đầu vào hợp lệ
        if (!isNumeric(nb1) || !isNumeric(nb2) || !isNumeric(nb3)) {
            request.setAttribute("message", "You must input an integer for a, b, c.");
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
            return;
        }

        int a = Integer.parseInt(nb1);
        int b = Integer.parseInt(nb2);
        int c = Integer.parseInt(nb3);

        // Kiểm tra nếu đã tồn tại trong lịch sử
        for (LCMRecord record : history) {
            if (record.equals(a, b, c)) {
                request.setAttribute("message", "Execution existed!");
                request.setAttribute("history", history);
                request.getRequestDispatcher("MyExam.jsp").forward(request, response);
                return;
            }
        }

        // Tính BCNN
        int result = LCM(a, LCM(b, c));

        // Lưu lịch sử
        history.add(new LCMRecord(a, b, c, result));

        // Gửi kết quả về JSP
        request.setAttribute("message", "LCM of " + a + ", " + b + ", " + c + " is: " + result);
        request.setAttribute("history", history);
        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
    }

    // Kiểm tra chuỗi có phải số không
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Hàm tính BCNN của 2 số
    private int LCM(int a, int b) {
        int lcm = a > b ? a : b;
        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                return lcm;
            }
            lcm++;
        }
    }
}
