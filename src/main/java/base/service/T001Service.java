package base.service;

import base.dto.T001Form;
import base.dto.deptDto;
import base.entity.dept;
import base.repository.DeptRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Service
public class T001Service {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    Validator validator;

    public List<deptDto> selectDb(){
        // DB一覧取得処理
        List<dept> list = deptRepository.selectAll();

        List<deptDto> result = new ArrayList<>();
        for (dept d : list){
            deptDto dto = new deptDto();
            BeanUtils.copyProperties(d, dto);
            dto.setText2(d.getText2());
            result.add(dto);
        }
        return result;
    }

    @Transactional
    public boolean insertDb(T001Form form, BindingResult result){

        validator.validate(form, result);
        if (result.hasErrors()){
            return false;
        }

        dept dept = new dept();
        dept.setText1(form.getText1());
        dept.setText2(form.getText2());

        // DB挿入処理
        deptRepository.update(dept);

        return true;

    }
}
