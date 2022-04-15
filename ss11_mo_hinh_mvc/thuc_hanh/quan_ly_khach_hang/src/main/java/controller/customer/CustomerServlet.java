package controller.customer;

import model.Customer;
import services.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String str=request.getParameter("select");
        switch (str){
            case "add":
                add(request, response);
                break;
            case "del":
                delete(request, response);
                break;
            case "display":
                display(request, response);
                break;
            default:
                break;
        }

    }
    private void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService=new CustomerService();
        Integer id= Integer.parseInt(request.getParameter("id"));
        for (int i = 0; i < CustomerService.customerList.size() ; i++)
        {
                if(CustomerService.customerList.get(i).getId().equals(id)){
                    CustomerService.customerList.remove(i);
                }
        }
        request.setAttribute("list", CustomerService.customerList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    private void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService=new CustomerService();
        Integer id=Integer.parseInt(request.getParameter("id1"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String addre=request.getParameter("address");
        Customer customer=new Customer(id,name,email,addre);
        customerService.add(customer);
        request.setAttribute("list", CustomerService.customerList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    private void display(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService=new CustomerService();
        List<Customer> customerList=customerService.display();
        request.setAttribute("list",customerList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }
}
