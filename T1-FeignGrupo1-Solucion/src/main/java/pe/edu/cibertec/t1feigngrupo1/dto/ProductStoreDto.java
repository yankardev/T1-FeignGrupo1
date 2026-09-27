package pe.edu.cibertec.t1feigngrupo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStoreDto {

    private Long id;
    private String title;
    private BigDecimal price;
    private String category;
}
