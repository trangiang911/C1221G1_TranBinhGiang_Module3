package controller;

import model.service_model.RentType;
import model.service_model.Service;
import model.service_model.TypeService;
import service.IRentService;
import service.IServiceService;
import service.ITypeService;
import service.impl.RentService;
import service.impl.ServiceService;
import service.impl.TypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceController",urlPatterns = {"/service"})
public class ServiceController extends HttpServlet {
private IServiceService iServiceService= new ServiceService();
private ITypeService iTypeService=new TypeServiceImpl();
private IRentService iRentService=new RentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                create(request, response);
                break;
            case "edit":
//                edit(request, response);
                break;
            case "del":
//                delete(request,response);
                break;
            default:
                break;
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
//                showCreateForm(request, response);
                break;
            case "edit":
//                showEditFrom(request, response);
                break;
            case "search":
//                showSearchFrom(request,response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> customerList = iServiceService.findAll();
        List<TypeService> typeServiceList = iTypeService.subFindType();
        List<RentType> rentTypes=iRentService.subFindRent();
        request.setAttribute("rent_list",rentTypes);
        request.setAttribute("type_list", typeServiceList);
        request.setAttribute("list", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/service_view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
