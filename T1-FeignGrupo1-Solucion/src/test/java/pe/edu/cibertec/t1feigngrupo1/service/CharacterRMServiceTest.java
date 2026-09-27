package pe.edu.cibertec.t1feigngrupo1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.cibertec.t1feigngrupo1.client.CharacterClient;
import pe.edu.cibertec.t1feigngrupo1.dto.CharacterRM;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharacterRMServiceTest {

    @Mock
    private CharacterClient characterClient;

    @InjectMocks
    private CharacterRMService service;

    @Test
    void shouldReturnOnlyAliveHumanCharactersFromFirstPage() {
        CharacterRM expected = character(1L, "Rick Sanchez", "Alive", "Human");
        CharacterRM.ApiResponse response = new CharacterRM.ApiResponse();
        response.setResults(List.of(
                expected,
                character(2L, "Alien", "Alive", "Alien"),
                character(3L, "Human", "Dead", "Human"),
                character(4L, "Unknown", "unknown", "Human")
        ));
        when(characterClient.getFirstPage()).thenReturn(response);

        List<CharacterRM> result = service.getAliveHumanCharactersFromFirstPage();

        assertThat(result).containsExactly(expected);
    }

    private CharacterRM character(Long id, String name, String status, String species) {
        CharacterRM character = new CharacterRM();
        character.setId(id);
        character.setName(name);
        character.setStatus(status);
        character.setSpecies(species);
        return character;
    }
}
