package pe.edu.cibertec.t1feigngrupo1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterRM;

@FeignClient(
        name = "rickAndMortyCharacterClient",
        url = "${external-api.rick-and-morty.url}"
)
public interface CharacterClient {

    @GetMapping("/character")
    CharacterRM.ApiResponse getFirstPage();
}
