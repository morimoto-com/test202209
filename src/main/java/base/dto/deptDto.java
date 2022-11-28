package base.dto;

import lombok.Data;

@Data
public class deptDto {
    private Integer id;
    private String text1;
    private String text2;
    public void setText2(String status) {
        text2 = "1".equals(status) ? "ON" : "OFF";
    }
}