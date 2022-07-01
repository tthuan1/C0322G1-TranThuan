package repository;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    static List<Student> studentList = new ArrayList<>();
    private static final String FIND_ALL = "SELECT * FROM student ";
    private static final String FIND_BY_NAME = "SELECT * FROM student where name like ? ";
    private static final String INSERT = " INSERT INTO student (name, class_name, gender, score) " +
            " values( ?, ?, ?, ?) ";

    @Override
    public List<Student> findAll() {
        studentList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_ALL);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                int gender = resultSet.getInt("gender");
                int score = resultSet.getInt("score");
                student = new Student(id, name, className, gender, score);
                studentList.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public void create(Student student) {
//      Tạo câu lệnh SQL
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getClassName());
            preparedStatement.setInt(3, student.getGender());
            preparedStatement.setInt(4, (int) student.getScore());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void edit() {

    }

    @Override
    public List<Student> findByName(String nameS) {
        studentList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
//          Tạo câu lệnh SQL
            PreparedStatement preparedStatement =
                    connection.prepareStatement(FIND_BY_NAME);
//          Dùng executeQuery/Update để thực thi.
//          ResultSet : Nhận kết quả từ DB trả về để xử lý
            preparedStatement.setString(1, "%" + nameS + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                int gender = resultSet.getInt("gender");
                int score = resultSet.getInt("score");
                student = new Student(id, name, className, gender, score);
                studentList.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public void delete() {

    }
}
