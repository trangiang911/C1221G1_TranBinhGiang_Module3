package servlet;

import model.Calculator;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "CalcultatorServlet", urlPatterns = {"/calcultator"})
public class CalcultatorServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        double firstOperand = 0;
        double secondOperand = 0;
        String str=null;
        try {
            firstOperand = Integer.parseInt(request.getParameter("first-operand"));
            secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        }catch (NumberFormatException e){
            str="ko đc rỗng";
        }
        char operator = request.getParameter("operator").charAt(0);
        double result=0;
        try{
            result = Calculator.calculator(firstOperand, secondOperand, operator);
        }catch (Exception e){
             str=e.getMessage();
        }
        request.setAttribute("fOP",firstOperand);
        request.setAttribute("sOP",secondOperand);
        request.setAttribute("op",operator);
        request.setAttribute("result",result);
        request.setAttribute("mess",str);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
