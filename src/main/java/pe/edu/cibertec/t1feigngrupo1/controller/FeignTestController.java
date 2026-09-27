package pe.edu.cibertec.t1feigngrupo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterRM;
import pe.edu.cibertec.t1feigngrupo1.dto.ProductStoreDto;
import pe.edu.cibertec.t1feigngrupo1.dto.UserPlaceHolder;
import pe.edu.cibertec.t1feigngrupo1.service.CharacterService;
import pe.edu.cibertec.t1feigngrupo1.service.ProductService;
import pe.edu.cibertec.t1feigngrupo1.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeignTestController {

    private final UserService userService;
    private final ProductService productService;
    private final CharacterService characterService;

    public FeignTestController(UserService userService,
                                ProductService productService,
                                CharacterService characterService) {
        this.userService = userService;
        this.productService = productService;
        this.characterService = characterService;
    }

    @GetMapping("/users/filtered")
    public List<UserPlaceHolder> getFilteredUsers() {
        return userService.getFilteredUsers();
    }

    @GetMapping("/products/filtered")
    public List<ProductStoreDto> getFilteredProducts() {
        return productService.getFilteredProducts();
    }

    @GetMapping("/characters/filtered")
    public List<CharacterRM> getFilteredCharacters() {
        return characterService.getFilteredCharacters();
    }
}
