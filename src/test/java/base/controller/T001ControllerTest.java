package base.controller;

import base.dto.T001Form;
import base.service.T001Service;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestInstance(PER_CLASS) // テストクラスのインスタンスは再利用され、テストメソッド毎に作成されない　staticも不要
@AutoConfigureMockMvc
@SpringBootTest
class T001ControllerTest {

    /**
     * テスト対象クラス
     */
    @Autowired
    T001Controller t001Controller;

    @Autowired
    T001Service t001Service;

    /**
     * MockMvcオブジェクト
     */
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        // MockMvcオブジェクトにテスト対象メソッドを設定
        mockMvc = MockMvcBuilders.standaloneSetup(t001Controller).build();
    }

    @Test
    void init() throws Exception {
        mockMvc.perform(get("/t001"))
                .andExpect(status().isOk())
                // ステータスがOKであることを確認
                .andExpect(status().isOk())
                // 次画面の遷移先がindex.htmlであることを確認
                .andExpect(view().name("T001Input"))
                // modelに設定された値が正しいことを確認
                .andExpect(model().attribute("infoMessage", "初期処理完了"))
                // セッションに設定されたsesHashMapの値が正しいことを確認
//                .andExpect(request().sessionAttribute("sesHashMap", createHashMap()))
                // Modelオブジェクトにエラーが無いことを確認
                .andExpect(model().hasNoErrors());
    }

    @Nested
    class input_BeanValidator {

        /** Validatorオブジェクト */
        @Autowired
        private Validator validator;

        /** 検証結果を設定するBindingResult */
        private BindingResult bindingResult;

        /**
         * 各テストメソッドを実行する前に実行する処理
         */
        @BeforeEach
        public void setUp() {
            bindingResult = new BindException(new T001Form(), "t001Form");
        }

        @Test
        void input_NotBlank() {
            // Formオブジェクトを生成
            T001Form t001Form = new T001Form("", "");
            // 生成したFormオブジェクトを検証
            validator.validate(t001Form, bindingResult);
            // Validation結果を確認
            assertTrue(bindingResult.hasErrors());
            assertEquals("{0}は入力必須です"
                    , bindingResult.getFieldError("text1").getDefaultMessage());
            assertEquals("{0}は入力必須です"
                    , bindingResult.getFieldError("text2").getDefaultMessage());
        }

        @Test
        void input_Size() {
            // Formオブジェクトを生成
            T001Form t001Form = new T001Form("123456", "01");
            // 生成したFormオブジェクトを検証
            validator.validate(t001Form, bindingResult);
            // Validation結果を確認
            assertTrue(bindingResult.hasErrors());
            assertEquals("{0}は5桁を以下で入力してください"
                    , bindingResult.getFieldError("text1").getDefaultMessage());
        }

        @Test
        void input_Pattern() {
            // Formオブジェクトを生成
            T001Form t001Form = new T001Form("12345", "2");
            // 生成したFormオブジェクトを検証
            validator.validate(t001Form, bindingResult);
            // Validation結果を確認
            assertTrue(bindingResult.hasErrors());
            assertEquals("{0}の指定が不正です"
                    , bindingResult.getFieldError("text2").getDefaultMessage());
        }

    }
}