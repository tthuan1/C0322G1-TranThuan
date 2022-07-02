package controller;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/user", "/"})
public class UserServlet extends HttpServlet {

    static List<User> userList = new ArrayList<>();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //nhận createUser.jsp điều phối yêu cầu
                request.getRequestDispatcher("user/createUser.jsp").forward(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            case "search":
                findByName(request, response);
                break;
            case "sort_by_name":
                sortByName(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        userList.clear();
        userList = userService.sortByName();
        request.setAttribute("userList", userList);// đặt thuộc tính o:userList vào name:userList
        try {
            //nhận listUser.jsp điều phối yêu cầu
            request.getRequestDispatcher("user/listUser.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        userList.clear();
        String name = request.getParameter("nameSearch");
        userList=userService.findByName(name);
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("user/listUser.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("/user/deleteUser.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("/user/editUser.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // tạo 1 list<User> gán dữ liệu bằng (findAll để truy xuất thông tin từ database)
        userList = userService.findAll();
        // gửi yêu cầu đặt thuộc tính o:userList -> name:"userList"
        request.setAttribute("userList", userList);
        // gửi yêu cầu  nhận listUser.jsp để điều phối yêu cầu
        request.getRequestDispatcher("user/listUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userService.edit(user);
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // gán name = yêu cầu lấy tham số tương tự email,country
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        // tạo đối tượng và thêm thông dữ liệu vào cho đối tượng
        User user = new User(name, email, country);
        // sử dụng phương thức create() để gửi cho service sử lí nghiệp vụ
        userService.create(user);
        // khi thực hiện hàm create() xong tạo 1 phản hồi gửi chuyển hướng tới "/user"
        response.sendRedirect("/user");
    }

}
