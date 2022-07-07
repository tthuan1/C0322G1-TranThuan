package controller;

import dto.EmployeeDTO;
import model.Customer;
import model.CustomerType;
import model.Employee;
import service.employee.EmployeeService;
import service.employee.IEmployeeDTOService;
import service.employee.EmployeeDTOService;
import service.employee.IEmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", value = "/employee")
public class EmployeeController extends HttpServlet {
    private IEmployeeDTOService employeeDTOService = new EmployeeDTOService();
    private IEmployeeService employeeService = new EmployeeService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String typeSearch = request.getParameter("typeSearch");
        String nameSearch = request.getParameter("nameSearch");
        System.out.println(nameSearch);
        System.out.println(typeSearch);
        switch (typeSearch) {
            case "name":
                request.setAttribute("employeeDTOList", employeeDTOService.findByName(nameSearch));
                break;
            case "division":
                request.setAttribute("employeeDTOList", employeeDTOService.findByDivision(nameSearch));
                break;
            case "position":
                request.setAttribute("employeeDTOList", employeeDTOService.findByPosition(nameSearch));
                break;
        }
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDTOService.delete(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);
        EmployeeDTO employeeDTO = employeeDTOService.findById(id);
        request.setAttribute("employeeDTO", employeeDTO);
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeDTO> employeeDTOList = employeeDTOService.findAll();
        request.setAttribute("employeeDTOList", employeeDTOList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        Integer educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        Integer divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId);
        employeeService.edit(employee);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer positionId = Integer.parseInt(request.getParameter("positionId"));
        Integer educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        Integer divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId);
        employeeService.create(employee);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
