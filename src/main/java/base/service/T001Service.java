package base.service;

import base.dto.T001Form;
import base.entity.dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;

@Service
public class T001Service {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    Validator validator;

    public List<dept> selectDb(){
        // DB一覧取得処理
        return jdbcTemplate.query("SELECT * FROM TSET_TABLE", new BeanPropertyRowMapper<dept>(dept.class));
    }

    public boolean insertDb(T001Form form, BindingResult result){

        validator.validate(form, result);
        if (!result.hasErrors()){
            return false;
        }

        // DB挿入処理
        jdbcTemplate.update("INSERT INTO TSET_TABLE (text1, text2) VALUES (?, ?)", form.getText1() , form.getText2());

        return true;

    }
}
