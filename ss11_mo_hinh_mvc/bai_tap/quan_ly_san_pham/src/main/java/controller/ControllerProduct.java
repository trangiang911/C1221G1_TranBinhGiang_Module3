package controller;

import model.Product;
import repository.IProductRepository;
import services.IProductService;
import services.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ControllerProduct", urlPatterns = {"/product", "/"})
public class ControllerProduct extends HttpServlet {

    private IProductService iProductService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                creat(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer index = null;
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String sumary = request.getParameter("sumary");
        String producer = request.getParameter("producer");
        for (int i = 0; i < this.iProductService.getListProduct().size(); i++) {
            if (this.iProductService.getListProduct().get(i).getId().equals(id)) {
                index = i;
            }
        }
        Product product = this.iProductService.getListProduct().get(index);
        Map<String, String> map = iProductService.edit(product);
        product.setName(name);
        product.setPrice(price);
        product.setSummary(sumary);
        product.setProducer(producer);
        if (map.isEmpty()) {
            response.sendRedirect("/product");
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        }
    }

    private void creat(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String sumary = request.getParameter("sumary");
        String producer = request.getParameter("producer");
        Product product = new Product(id, name, price, sumary, producer);
        Map<String, String> map = iProductService.save(product);
        if (map.isEmpty()) {
            response.sendRedirect("/product");
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            case "edit":
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            default:
                List<Product> productList = iProductService.getListProduct();
                request.setAttribute("products", productList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }
}
