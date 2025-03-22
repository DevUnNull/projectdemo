import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Bcnn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nb1 = req.getParameter("number1");
        String nb2 = req.getParameter("number2");
        String nb3 = req.getParameter("number3");

        if (!isNumeric(nb1) || !isNumeric(nb2) || !isNumeric(nb3)) {
            resp.getWriter().println("You must input an integer for a, b, c");
            return;
        }

        int a = Integer.parseInt(nb1);
        int b = Integer.parseInt(nb2);
        int c = Integer.parseInt(nb3);

        int lcm = LCM(LCM(a, b), c);

        resp.getWriter().println("LCM: " + lcm);
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int LCM(int a, int b) {
        int lcm = a * (b / GCD(a, b));
        return lcm;
    }

    private static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
