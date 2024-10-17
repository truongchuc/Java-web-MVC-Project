package chuc.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import chuc.dev.data.dao.CategoryDao;
import chuc.dev.data.dao.DatabaseDao;
import chuc.dev.data.dao.ProductDao;
import chuc.dev.data.model.Category;
import chuc.dev.data.model.Product;

public class CategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        
        // Get the categoryId from the request
        String categoryIdParam = request.getParameter("categoryId");
        if (categoryIdParam == null) {
            response.sendRedirect("error.jsp"); // Redirect if categoryId is not present
            return;
        }
        
        int categoryId = Integer.parseInt(categoryIdParam);
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = new ArrayList<>();

        // Check for filtering parameters
        String property = request.getParameter("property");
        String order = request.getParameter("order");
        
        // Filter products if sorting parameters are present
        if (property != null && order != null) {
            productList = productDao.filter(categoryId, property, order);
        } else {
            productList = productDao.findByCategory(categoryId); // Get all products in the category
        }

        // Fetch the category details
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);

        // Set attributes for JSP
        request.setAttribute("productList", productList);
        request.setAttribute("category", category);

        // Forward request to category.jsp
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests if necessary
    }
}
