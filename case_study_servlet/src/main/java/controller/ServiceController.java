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
                create(request, response);
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

    private void create(HttpServletRequest request, HttpServletResponse response) {
//        Integer idLK = Integer.parseInt(request.getParameter("type_customer"));
        String name = request.getParameter("name");
        Integer area = Integer.parseInt(request.getParameter("area"));
        Double chiPhiThue = Double.parseDouble(request.getParameter("chi_phi_thue"));
        Integer soNguoi = Integer.parseInt(request.getParameter("so_nguoi"));
        Integer maKieuThue = Integer.parseInt(request.getParameter("ma_kieu_thue"));
        Integer maLoaiDV = Integer.parseInt(request.getParameter("ma_loai_dich_vu"));
        String tieuChuan = request.getParameter("tieu_chuan");
        String moTa = request.getParameter("mo_ta");
        Double areaBeBoi=Double.parseDouble(request.getParameter("dien_tich_be_boi"));
        Integer soTang=Integer.parseInt(request.getParameter("so_tang"));
        Service service = new Service(name, area, chiPhiThue, soNguoi, maKieuThue, maLoaiDV, tieuChuan, moTa, areaBeBoi,soTang);
        iServiceService.save(service);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service_view/list.jsp");
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

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<TypeService> typeServiceList = iTypeService.subFindType();
        List<RentType> rentTypes=iRentService.subFindRent();
        request.setAttribute("rent_list",rentTypes);
        request.setAttribute("type_list", typeServiceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service_view/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
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
