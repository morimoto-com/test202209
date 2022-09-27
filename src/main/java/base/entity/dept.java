package base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dept")	//クラス名と同じ場合は指定しなくてもよい
public class dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "text1", nullable = false)
    private String text1;
    @Column(name = "text2", nullable = false)
    private String text2;
}