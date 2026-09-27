package pe.edu.cibertec.t1feigngrupo1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterRM;
import pe.edu.cibertec.t1feigngrupo1.service.CharacterRMService;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterRMController {

    private final CharacterRMService characterRMService;

    @GetMapping("/alive-humans")
    public ResponseEntity<List<CharacterRM>> getAliveHumansCharacters(){
        List<CharacterRM> characters = characterRMService.getAliveHumanCharactersFromFirstPage();
        return ResponseEntity.ok(characters);
    }
}


