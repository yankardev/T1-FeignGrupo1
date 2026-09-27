package pe.edu.cibertec.t1feigngrupo1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterApiResponse;

@FeignClient(name = "characterClient", url = "https://rickandmortyapi.com")
public interface CharacterClient {

    @GetMapping("/api/character")
    CharacterApiResponse getCharacters();
}
