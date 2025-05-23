package pack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buser {
    @Id
    private int buserno;

    private String busername;
    private String buserloc;
    private String busertel;

    @OneToMany(mappedBy = "buser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // 순환 참조 방지. 해당 어노테이션이 적용된 필드는 JSON 데이터를 반환하거나 객체 변환할 때 포함하지 않음
    private List<Jikwon> jikwons;
}
