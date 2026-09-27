package pe.edu.cibertec.t1feigngrupo1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.cibertec.t1feigngrupo1.client.UserClient;
import pe.edu.cibertec.t1feigngrupo1.dto.UserPlaceHolder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserPlaceHolderServiceTest {

    @Mock
    private UserClient userClient;

    @InjectMocks
    private UserPlaceHolderService service;

    @Test
    void shouldReturnOnlyUsersWithEvenUserIdAndOddId() {
        when(userClient.getUsers()).thenReturn(List.of(
                user(2L, 1L),
                user(2L, 2L),
                user(3L, 3L),
                user(null, 5L)
        ));

        List<UserPlaceHolder> result = service.getUsersWithEvenUserIdAndOddId();

        assertThat(result)
                .extracting(UserPlaceHolder::getId)
                .containsExactly(1L);
    }

    private UserPlaceHolder user(Long userId, Long id) {
        UserPlaceHolder user = new UserPlaceHolder();
        user.setUserId(userId);
        user.setId(id);
        return user;
    }
}
