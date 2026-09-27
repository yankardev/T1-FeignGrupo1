package pe.edu.cibertec.t1feigngrupo1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterRM;
import pe.edu.cibertec.t1feigngrupo1.dto.ProductStoreDto;
import pe.edu.cibertec.t1feigngrupo1.dto.UserPlaceHolder;
import pe.edu.cibertec.t1feigngrupo1.service.CharacterRMService;
import pe.edu.cibertec.t1feigngrupo1.service.ProductStoreService;
import pe.edu.cibertec.t1feigngrupo1.service.UserPlaceHolderService;

import java.util.List;

@RestController
@RequestMapping("/api/feign")
@RequiredArgsConstructor
public class FeignExerciseController {

    private final UserPlaceHolderService userService;
    private final ProductStoreService productService;
    private final CharacterRMService characterService;

    @GetMapping("/users")
    public List<UserPlaceHolder> getFilteredUsers() {
        return userService.getUsersWithEvenUserIdAndOddId();
    }

    @GetMapping("/products")
    public List<ProductStoreDto> getFilteredProducts() {
        return productService.getElectronicsWithPriceGreaterThanFifty();
    }

    @GetMapping("/characters")
    public List<CharacterRM> getFilteredCharacters() {
        return characterService.getAliveHumanCharactersFromFirstPage();
    }
}
