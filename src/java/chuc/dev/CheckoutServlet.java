package chuc.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import chuc.dev.data.dao.DatabaseDao;
import chuc.dev.data.dao.OrderDao;
import chuc.dev.data.dao.OrderItemDao;
import chuc.dev.data.model.Order;
import chuc.dev.data.model.OrderItem;
import chuc.dev.data.model.User;
import chuc.dev.util.StringHelper;

public class CheckoutServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // If user is not logged in, redirect to login
        if (user == null) {
            response.sendRedirect("LoginServlet");
        } else {
            // Process checkout for logged-in user
            processCheckout(request, user);

            // After checkout, redirect to cart with success message
            session.setAttribute("message", "Checkout Success!");
            response.sendRedirect("CartServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void processCheckout(HttpServletRequest request, User user) {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        String code = StringHelper.randomString(10);

        Order order = new Order(code, "pending", user.getId());
        orderDao.insert(order);

        order = orderDao.findByCode(code);

        if (order == null) {
            HttpSession session = request.getSession();
            session.setAttribute("message", "Order could not be processed.");
            return;
        }

        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();

        if (cart != null) {
            for (OrderItem orderItem : cart) {
                orderItem.setOrderId(order.getId()); 
                orderItemDao.insert(orderItem);
            }
        }
        session.removeAttribute("cart");
    }
}
