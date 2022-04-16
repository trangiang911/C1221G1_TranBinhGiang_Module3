package controller;

import model.Product;
import repository.IProductRepository;
import services.IProductService;
import services.impl.ProductService;

import javax.servlet.RequestDispatcher;
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
    private IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "del":
                delete(request,response);
                break;
            default:
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Product product=productService.findById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher=request.getRequestDispatcher("error.jsp");
        }else {
            productService.remove(id);
            request.setAttribute("product",product);
            request.setAttribute("mess","Done");
            dispatcher=request.getRequestDispatcher("/product");
            try{
                response.sendRedirect("/");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        Integer id= Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        Double price=Double.parseDouble(request.getParameter("price"));
        String sumary=request.getParameter("sumary");
        String producer=request.getParameter("producer");
        Product product= productService.findById(id);
        RequestDispatcher requestDispatcher;
        if(product == null){
            requestDispatcher= request.getRequestDispatcher("error.jsp");
        }else {
            product.setName(name);
            product.setPrice(price);
            product.setSummary(sumary);
            product.setProducer(producer);
            productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("mess","Done");
            requestDispatcher=request.getRequestDispatcher("/product");
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        Double price=Double.parseDouble(request.getParameter("price"));
        String sumary=request.getParameter("sumary");
        String producer=request.getParameter("producer");
        Product product =new Product(id,name,price,sumary,producer);
        productService.save(product);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
        request.setAttribute("mess","Done");
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditFrom(request,response);
                break;
            case "search":
                showSearchFrom(request,response);
                break;
            default:
                listProduct(request,response);
                break;      
        }
    }

    private void showSearchFrom(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList=productService.search(request.getParameter("name"));
        request.setAttribute("list",productList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList= productService.findAll();
        request.setAttribute("list",productList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Product product=productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("error.jsp");
        }else {
            request.setAttribute("product",product);
            requestDispatcher=request.getRequestDispatcher("edit.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
