package pe.edu.cibertec.t1feigngrupo1.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1feigngrupo1.client.CharacterClient;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterRM;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterClient characterClient;

    public CharacterService(CharacterClient characterClient) {
        this.characterClient = characterClient;
    }

    /**
     * Devuelve los personajes de la primera página de resultados
     * donde status = "Alive" y species = "Human".
     */
    public List<CharacterRM> getFilteredCharacters() {
        return characterClient.getCharacters().getResults().stream()
                .filter(character -> "Alive".equalsIgnoreCase(character.getStatus()))
                .filter(character -> "Human".equalsIgnoreCase(character.getSpecies()))
                .collect(Collectors.toList());
    }
}
