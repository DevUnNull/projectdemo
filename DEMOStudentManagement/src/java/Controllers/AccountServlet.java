package controllers;

import dal.AccountDAO;
import models.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO accountDAO = new AccountDAO();
        List<Account> accountList = accountDAO.getAllAccounts();

        // Đặt dữ liệu vào request để hiển thị trên JSP
        request.setAttribute("accountList", accountList);
        request.setAttribute("contentPage", "accountList.jsp");
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}