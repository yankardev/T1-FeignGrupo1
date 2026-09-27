package pe.edu.cibertec.t1feigngrupo1.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1feigngrupo1.client.ProductClient;
import pe.edu.cibertec.t1feigngrupo1.dto.ProductStoreDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }

    /**
     * Devuelve los productos con precio mayor a 50.0 y categoría "electronics".
     */
    public List<ProductStoreDto> getFilteredProducts() {
        return productClient.getProducts().stream()
                .filter(product -> product.getPrice() != null && product.getPrice() > 50.0)
                .filter(product -> "electronics".equalsIgnoreCase(product.getCategory()))
                .collect(Collectors.toList());
    }
}
