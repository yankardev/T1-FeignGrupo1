package pe.edu.cibertec.t1feigngrupo1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.t1feigngrupo1.dto.ProductStoreDto;

import java.util.List;

@FeignClient(name = "productClient", url = "https://fakestoreapi.com")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductStoreDto> getProducts();
}
