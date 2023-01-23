package base.repository;

import base.entity.dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Configuration
public class DeptRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<dept> selectAll() {
        List<dept> list = jdbcTemplate.query("SELECT * FROM TSET_TABLE", new BeanPropertyRowMapper<dept>(dept.class));
        return list;
    }

    public void update(dept dept){
        jdbcTemplate.update("INSERT INTO TSET_TABLE (text1, text2) VALUES (?, ?)", dept.getText1() , dept.getText2());
    }


}
