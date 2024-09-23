package com.amey.SpringJDBC.repo;

import com.amey.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository // (DATABASE LAYER TO SAVE DATA TO DB)
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){
        String sql = "insert into student (rollNo, name, marks) values (?,?,?);";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(),s.getMarks());
        System.out.println("Rows...."+ rows);
    }

    public List<Student> findAll() {
        String sql = "select * from student";
//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s = new Student();
//                s.setRollNo(rs.getInt(1));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt(3));
//
//                return s;
//            }
//        };

        // LAMBDA EXPRESSION FOR ABOVE CODE

        RowMapper<Student> mapper = (rs, rowNum) -> {
                Student s = new Student();
                s.setRollNo(rs.getInt(1));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt(3));

                return s;
        };

        return jdbc.query(sql,mapper);
    }
}
