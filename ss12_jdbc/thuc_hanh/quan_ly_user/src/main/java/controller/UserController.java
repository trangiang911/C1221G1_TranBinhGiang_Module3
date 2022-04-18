package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController",urlPatterns = {"/user","/"})
public class UserController extends HttpServlet {
    private IUserService iUserService=new UserService();
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

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        Integer id= Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        RequestDispatcher requestDispatcher;
        User user=new User(id,name,email,country);
        boolean check=iUserService.update(user);
        if(check){
            request.setAttribute("mess","done");
        }else {
            request.setAttribute("mess","not");
        }
        requestDispatcher= request.getRequestDispatcher("edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
//        User user= iUserService.findById(id);
//        RequestDispatcher requestDispatcher;
//        if(user == null){
//            requestDispatcher= request.getRequestDispatcher("error.jsp");
//        }else {
//            user.setName(name);
//            user.setEmail(email);
//            user.setCountry(country);
//            iUserService.update(user);
//            request.setAttribute("user",user);
//            request.setAttribute("mess","Done");
//            requestDispatcher=request.getRequestDispatcher("/user");
//            try {
//                response.sendRedirect("/");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        Integer id=Integer.parseInt(request.getParameter("id"));
        User user=iUserService.findById(id);
        RequestDispatcher dispatcher;
        if(user==null){
            dispatcher=request.getRequestDispatcher("error.jsp");
        }else {
            iUserService.remove(id);
            request.setAttribute("product",user);
            request.setAttribute("mess","Done");
            dispatcher=request.getRequestDispatcher("/product");
            try{
                response.sendRedirect("/");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User user =new User(name,email,country);
        iUserService.save(user);
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
        List<User> userList=iUserService.search(request.getParameter("name"));
        request.setAttribute("list",userList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) {
        Integer id=Integer.parseInt(request.getParameter("id"));
        User user=iUserService.findById(id);
        RequestDispatcher requestDispatcher;
        if (user==null){
            requestDispatcher=request.getRequestDispatcher("error.jsp");
        }else {
            request.setAttribute("user",user);
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

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList= iUserService.findAll();
        request.setAttribute("list",userList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
