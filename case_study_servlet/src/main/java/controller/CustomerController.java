package controller;

import model.customer.Customer;
import model.customer.TypeCustomer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/", "/customer"})
public class CustomerController extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();

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
        Customer customer=iCustomerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer==null){
            dispatcher=request.getRequestDispatcher("error.jsp");
        }else {
            iCustomerService.remove(id);
            request.setAttribute("customer",customer);
            request.setAttribute("mess","Done");
            dispatcher=request.getRequestDispatcher("/customer");
            try{
                response.sendRedirect("/customer");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        Integer id= Integer.parseInt(request.getParameter("id"));
        Integer type = Integer.valueOf(request.getParameter("type_customer"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd=request.getParameter("cmnd");
        String sdt=request.getParameter("sdt");
        String email=request.getParameter("email");
        String dia_chi=request.getParameter("dia_chi");
        RequestDispatcher requestDispatcher;
        Customer customer = new Customer(id,type,name,date,gender,cmnd,sdt,email,dia_chi);
        boolean check = iCustomerService.update(customer);
        if (check) {
            request.setAttribute("mess", "done");
        } else {
            request.setAttribute("mess", "not");
        }
        requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        Integer idLK = Integer.parseInt(request.getParameter("type_customer"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd = request.getParameter("cmnd");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        Customer customer = new Customer(idLK, name, date, gender, cmnd, sdt, email, diaChi);
        iCustomerService.save(customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/create.jsp");
        request.setAttribute("mess", "Done");
        try {
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditFrom(request, response);
                break;
            case "search":
                showSearchFrom(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showSearchFrom(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String diaChi=request.getParameter("dia_chi");
        String type=request.getParameter("type");
        List<Customer> customerList=iCustomerService.search(name,diaChi,type);
        List<TypeCustomer> typeCustomerList = iCustomerService.subFindAll();
        request.setAttribute("list",customerList);
        request.setAttribute("sub_list", typeCustomerList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) {
        List<TypeCustomer> typeCustomerList = iCustomerService.subFindAll();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.findById(id);
        request.setAttribute("sub_list", typeCustomerList);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("customer", customer);
            requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<TypeCustomer> typeCustomerList = iCustomerService.subFindAll();
        request.setAttribute("sub_list", typeCustomerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomerService.findAll();
        List<TypeCustomer> typeCustomerList = iCustomerService.subFindAll();
        request.setAttribute("sub_list", typeCustomerList);
        request.setAttribute("list", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
