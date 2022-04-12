import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "ProductDiscountCalculatorServlet", urlPatterns = "/display-discount")
public class ProductDiscountCalculatorServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        double listPrice = Double.parseDouble(request.getParameter("list-price"));
        double discount = Double.parseDouble(request.getParameter("discount-percent"));
        String str=request.getParameter("product-description");
        double result = listPrice * discount * 0.01;
        double resultPri=listPrice-result;
        request.setAttribute("result", result);
        request.setAttribute("product", str);
        request.setAttribute("discount", discount);
        request.setAttribute("resultPrice",resultPri);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
