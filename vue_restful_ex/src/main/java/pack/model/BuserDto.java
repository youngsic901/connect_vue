package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuserDto {
    @Id
    private int buserno;

    private String busername;
    private String buserloc;
    private String busertel;
}
