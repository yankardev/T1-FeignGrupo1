package pe.edu.cibertec.t1feigngrupo1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1feigngrupo1.client.CharacterClient;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterRM;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterRMService {

    private static final String REQUIRED_STATUS = "Alive";
    private static final String REQUIRED_SPECIES = "Human";

    private final CharacterClient characterClient;

    public List<CharacterRM> getAliveHumanCharactersFromFirstPage() {
        CharacterRM.ApiResponse response = characterClient.getFirstPage();

        if (response == null || response.getResults() == null) {
            return List.of();
        }

        return response.getResults().stream()
                .filter(character -> character.getStatus() != null
                        && REQUIRED_STATUS.equalsIgnoreCase(character.getStatus().trim()))
                .filter(character -> character.getSpecies() != null
                        && REQUIRED_SPECIES.equalsIgnoreCase(character.getSpecies().trim()))
                .toList();
    }
}
