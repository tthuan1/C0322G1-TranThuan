package controller;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student", "/"})
public class StudentServlet extends HttpServlet {

    static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add( new Student(1, "Chien", "C0322G1", 1, 5));
        studentList.add( new Student(2, "Tien Dat", "C0222G1", 1, 7));
        studentList.add( new Student(3, "Hoan", "C0222G1", 0, 9));
        studentList.add( new Student(4, "Hai", "C0422G1", 0, 2));
        studentList.add( new Student(5, "Tuong", "C0322G1", 1, 7));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello C03!!!");
        request.setAttribute("studentList", studentList);
//      Gửi dữ liệu qua trang JSP.
        request.getRequestDispatcher("studentList.jsp").forward(request,response);
    }

}
