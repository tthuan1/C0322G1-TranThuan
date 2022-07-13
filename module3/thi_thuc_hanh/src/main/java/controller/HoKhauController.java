package controller;

import model.Customer;
import model.CustomerType;
import model.HoKhau;
import service.HoKhauService;
import service.CustomerTypeService;
import service.IHoKhauService;
import service.ICustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/hoKhau")
public class HoKhauController extends HttpServlet {
    private IHoKhauService hoKhauService = new HoKhauService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("view/create.jsp").forward(request, response);
                break;
            case "edit":
//                showFormEdit(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                findByName(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        request.setAttribute("customerList", hoKhauService.findByName(nameSearch));
        List<CustomerType> typeList = customerTypeService.findAll();
        request.setAttribute("typeList", typeList);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = customerService.findById(id);
//        request.setAttribute("customer", customer);
//        List<CustomerType> typeList = customerTypeService.findAll();
//        request.setAttribute("typeList", typeList);
//        try {
//            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        hoKhauService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<HoKhau> hoKhauList = hoKhauService.findAll();
        request.setAttribute("hoKhauList", hoKhauList);
//        List<CustomerType> typeList = customerTypeService.findAll();
//        request.setAttribute("typeList", typeList);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
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
                createCustomer(request, response);
                break;
            case "edit":
                editHoKhau(request, response);
                break;
        }
    }

    private void editHoKhau(HttpServletRequest request, HttpServletResponse response) {
        String maHoKhau = request.getParameter("maHoKhau");
        String tenChuHo = request.getParameter("tenChuHo");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String ngayLapHoKhau = request.getParameter("ngayLapHoKhau");
        String diaChiNha = request.getParameter("diaChiNha");
        HoKhau hoKhau = new HoKhau(maHoKhau,tenChuHo,soLuong,ngayLapHoKhau,diaChiNha);
        hoKhauService.edit(hoKhau);
        try {
            response.sendRedirect("/hoKhau");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(typeId, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        hoKhauService.create(customer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
