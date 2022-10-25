package base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
public class deptDto {
    private Integer id;
    private String text1;
    private String text2;
    public void setText2(String status) {
        text2 = "1".equals(status) ? "ON" : "OFF";
    }
}