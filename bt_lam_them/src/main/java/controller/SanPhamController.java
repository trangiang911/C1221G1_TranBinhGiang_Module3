package controller;

import model.Category;
import model.SanPham;
import service.CategoryService;
import service.SanPhamService;
import service.impl.CategoryServiceImpl;
import service.impl.SanPhamServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SanPhamController",urlPatterns = {"/san_pham","/"})
public class SanPhamController extends HttpServlet {
    private SanPhamService sanPhamService=new SanPhamServiceImpl();
    private CategoryService categoryService=new CategoryServiceImpl();
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
//                edit(request, response);
                break;
            case "del":
                delete(request, response);
                break;
            default:
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sanPhamService.findById(id);
        RequestDispatcher dispatcher;
        if (sanPham == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            sanPhamService.remove(id);
            request.setAttribute("mess","done");
           this.listSanPham(request,response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        Integer category = Integer.parseInt(request.getParameter("category"));
        SanPham sanPham = new SanPham(name, price, quantity, color, category);
        Map<String, String> map = sanPhamService.save(sanPham);
        RequestDispatcher requestDispatcher = null;
        if (map.isEmpty()) {
            request.setAttribute("mess", "Done");
            this.listSanPham(request,response);
        } else {
            List<Category> categoryList = categoryService.subFindAll();
            request.setAttribute("category", categoryList);
            request.setAttribute("error", map);
            requestDispatcher = request.getRequestDispatcher("/view/list.jsp");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                showCreateForm(request, response);
//                break;
            case "edit":
//                showEditFrom(request, response);
                break;
            case "search":
//                showSearchFrom(request, response);
                break;
            default:
                listSanPham(request, response);
                break;
        }
    }

//    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
//        List<Category> categoryList = categoryService.subFindAll();
//        request.setAttribute("category", categoryList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/create.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void listSanPham(HttpServletRequest request, HttpServletResponse response) {
        List<SanPham> sanPhamList = sanPhamService.findAll();
        List<Category> categoryList = categoryService.subFindAll();
        request.setAttribute("category", categoryList);
        request.setAttribute("list", sanPhamList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
