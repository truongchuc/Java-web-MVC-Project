/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package chuc.dev.admin.order;

import chuc.dev.admin.BaseAdminServlet;
import chuc.dev.data.dao.CategoryDao;
import chuc.dev.data.dao.DatabaseDao;
import chuc.dev.data.dao.OrderDao;
import chuc.dev.data.model.Category;
import chuc.dev.data.model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author truon
 */
public class EditOrderServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);

        request.setAttribute("order", order);
        request.getRequestDispatcher("admin/order/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);

        String status = request.getParameter("status");
        order.setStatus(status);

        orderDao.update(order);
        response.sendRedirect("IndexOrderServlet");

    }
}
