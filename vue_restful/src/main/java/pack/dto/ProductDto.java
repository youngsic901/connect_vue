package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("productDto")
public class ProductDto {
    private String code;
    private String name;
    private String description;
    private int price;
    private String image;
}
