package base.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class T001ControllerTest {

    //mockMvc TomcatサーバへデプロイすることなくHttpリクエスト・レスポンスを扱うためのMockオブジェクト
    @Autowired
    private MockMvc mockMvc;

    // https://qiita.com/a-pompom/items/3f834119c756e5286730で学習
    // getリクエストでviewを指定し、httpステータスでリクエストの成否を判定
    @Test
    void init処理を実行してOKを返す() throws Exception {
        // andDo(print())でリクエスト・レスポンスを表示
        // 実行しなさい(perform)
        // /hello/initへのGETリクエストを(get)
        // 結果を表示しなさい(andDo(print))
        // (結果を)期待します(andExpect)
        // HTTPステータスコードが200であることを(status().isOK())
        this.mockMvc.perform(get("/t001")).andDo(print())
                .andExpect(status().isOk());
    }
}