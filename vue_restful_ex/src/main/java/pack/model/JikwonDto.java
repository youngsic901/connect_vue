package pack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jikwon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JikwonDto {
    @Id
    private int jikwonno;

    private String jikwonname;
    private String jikwonjik;

    @ManyToOne
    @JoinColumn(name = "busernum")
    private BuserDto buser;
}
