package base.controller;

import base.dto.T001Form;
import base.entity.dept;
import base.service.T001Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class T001Controller {

    @Autowired
    protected T001Service t001Service;

    /**
     * 初期表示（http://localhost:8080/t001）
     * https://zenn.dev/developma/articles/548b9652b01131
     * @param model
     * @param form
     * @return
     */
    @GetMapping("/t001")
    public String init(
            Model model,
            T001Form form) {

        // DB取得処理
        List<dept> list = t001Service.selectDb();
        model.addAttribute("deptList", list);
        model.addAttribute("infoMessage", "初期処理完了");
        model.addAttribute(form);
        return "T001Input";
    }

    /**
     * 送信ボタン押下処理
     * @param model
     * @param form
     * @return
     */
    @PostMapping(value="/t001", params="send")
    public String input(
            Model model,
            @ModelAttribute T001Form form) {
        // DB登録処理
        t001Service.insertDb(form);

        // DB取得処理
        List<dept> list = t001Service.selectDb();
        model.addAttribute("deptList", list);

        model.addAttribute("infoMessage", "DB登録完了");
        model.addAttribute(form);
        return "T001Confirm";
    }

    /**
     * 送信ボタン押下処理
     * @param model
     * @param form
     * @return
     */
    @PostMapping(value="/t001", params="back")
    public String back(
            Model model,
            @ModelAttribute T001Form form) {
        model.addAttribute("infoMessage", "戻る処理完了");
        model.addAttribute(form);
        return "T001Input";
    }
}