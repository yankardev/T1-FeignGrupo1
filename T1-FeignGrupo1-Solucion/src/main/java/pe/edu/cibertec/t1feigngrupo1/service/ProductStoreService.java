package pe.edu.cibertec.t1feigngrupo1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1feigngrupo1.client.ProductClient;
import pe.edu.cibertec.t1feigngrupo1.dto.ProductStoreDto;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductStoreService {

    private static final BigDecimal MINIMUM_PRICE = new BigDecimal("50.0");
    private static final String REQUIRED_CATEGORY = "electronics";

    private final ProductClient productClient;

    public List<ProductStoreDto> getElectronicsWithPriceGreaterThanFifty() {
        List<ProductStoreDto> products = productClient.getProducts();

        if (products == null) {
            return List.of();
        }

        return products.stream()
                .filter(product -> product.getPrice() != null
                        && product.getPrice().compareTo(MINIMUM_PRICE) > 0)
                .filter(product -> product.getCategory() != null
                        && REQUIRED_CATEGORY.equalsIgnoreCase(product.getCategory().trim()))
                .toList();
    }
}
