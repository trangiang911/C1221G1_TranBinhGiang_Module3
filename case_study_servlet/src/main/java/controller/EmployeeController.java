package controller;

import model.customer.Customer;
import model.customer.TypeCustomer;
import model.employee.Division;
import model.employee.Education;
import model.employee.Employee;
import model.employee.Position;
import service.IDivisionService;
import service.IEducationService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionService;
import service.impl.EducationService;
import service.impl.EmployeeService;
import service.impl.PositionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController",urlPatterns = {"/employee"})
public class EmployeeController extends HttpServlet {
    private IEmployeeService iEmployeeService=new EmployeeService();
    private IDivisionService iDivisionService=new DivisionService();
    private IPositionService iPositionService=new PositionService();
    private IEducationService iEducationService=new EducationService();
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
//                    delete(request,response);
                    break;
                default:
                    break;
            }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        Integer id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String cmnd=request.getParameter("cmnd");
        String luong=request.getParameter("luong");
        String sdt=request.getParameter("sdt");
        String email=request.getParameter("email");
        String dia_chi=request.getParameter("dia_chi");
        Integer viTri=Integer.parseInt(request.getParameter("vi_tri"));
        Integer trinhDo=Integer.parseInt(request.getParameter("trinh_do"));
        Integer boPhan=Integer.parseInt(request.getParameter("bo_phan"));
        RequestDispatcher requestDispatcher;
        Employee employee = new Employee(id,name,date,cmnd,luong,sdt,email,dia_chi,viTri,trinhDo,boPhan);
        boolean check = iEmployeeService.update(employee);
        if (check) {
            request.setAttribute("mess", "done");
        } else {
            request.setAttribute("mess", "not");
        }
        requestDispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String cmnd = request.getParameter("cmnd");
        String luong=request.getParameter("luong");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        Integer viTri=Integer.parseInt(request.getParameter("vi_tri"));
        Integer trinhDo=Integer.parseInt(request.getParameter("trinh_do"));
        Integer boPhan=Integer.parseInt(request.getParameter("bo_phan"));
        Employee employee = new Employee(name, date, cmnd,luong, sdt, email, diaChi,viTri,trinhDo,boPhan);
        iEmployeeService.save(employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/create.jsp");
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
//                showSearchFrom(request,response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = iPositionService.findPosition();
        List<Division> divisionList = iDivisionService.findDivision();
        List<Education> educationList = iEducationService.findEducation();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployeeService.findById(id);
        request.setAttribute("education_list", educationList);
        request.setAttribute("division_list", divisionList);
        request.setAttribute("position_list", positionList);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("employee", employee);
            requestDispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = iPositionService.findPosition();
        List<Division> divisionList = iDivisionService.findDivision();
        List<Education> educationList = iEducationService.findEducation();
        request.setAttribute("education_list", educationList);
        request.setAttribute("division_list", divisionList);
        request.setAttribute("position_list", positionList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployeeService.findAll();
        List<Position> positionList = iPositionService.findPosition();
        List<Division> divisionList = iDivisionService.findDivision();
        List<Education> educationList = iEducationService.findEducation();
        request.setAttribute("education_list", educationList);
        request.setAttribute("division_list", divisionList);
        request.setAttribute("position_list", positionList);
        request.setAttribute("list", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
