import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_description = request.getParameter("product_description");
        float list_price = Float.parseFloat(request.getParameter("list_price"));
        int discount_percent = Integer.parseInt(request.getParameter("discount_percent"));
        float discount_amount = (float) (list_price * discount_percent * 0.01);
        float discount_price = list_price - discount_amount;
        request.setAttribute("description", product_description);
        request.setAttribute("discount_amount", discount_amount);
        request.setAttribute("discount_price", discount_price);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
