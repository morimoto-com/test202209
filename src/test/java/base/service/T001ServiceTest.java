package base.service;

import base.dto.T001Form;
import base.dto.deptDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class T001ServiceTest {

    @Autowired T001Service t001Service;

    @Test
    void selectDb() {
        List<deptDto> list = t001Service.selectDb();
        assertEquals(4, list.size());
    }

    @Test
    void insertDb() {
        List<deptDto> list1 = t001Service.selectDb();
        assertEquals(4, list1.size());
        T001Form t001Form = new T001Form();
        BindingResult bindingResult = new BindException(new T001Form(), "t001Form");
        t001Form.setText1("test1");
        t001Form.setText2("0");
        t001Service.insertDb(t001Form, bindingResult);
        List<deptDto> list2 = t001Service.selectDb();
        assertEquals(4, list2.size());
    }
}