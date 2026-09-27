package pe.edu.cibertec.t1feigngrupo1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.cibertec.t1feigngrupo1.client.ProductClient;
import pe.edu.cibertec.t1feigngrupo1.dto.ProductStoreDto;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductStoreServiceTest {

    @Mock
    private ProductClient productClient;

    @InjectMocks
    private ProductStoreService service;

    @Test
    void shouldReturnOnlyElectronicsWithPriceGreaterThanFifty() {
        ProductStoreDto expected = product(1L, "Monitor", "50.01", "electronics");
        when(productClient.getProducts()).thenReturn(List.of(
                expected,
                product(2L, "Keyboard", "50.00", "electronics"),
                product(3L, "Jacket", "100.00", "men's clothing"),
                product(4L, "Cable", "10.00", "electronics")
        ));

        List<ProductStoreDto> result = service.getElectronicsWithPriceGreaterThanFifty();

        assertThat(result).containsExactly(expected);
    }

    private ProductStoreDto product(Long id, String title, String price, String category) {
        return new ProductStoreDto(id, title, new BigDecimal(price), category);
    }
}
