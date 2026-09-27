package pe.edu.cibertec.t1feigngrupo1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1feigngrupo1.client.UserClient;
import pe.edu.cibertec.t1feigngrupo1.dto.UserPlaceHolder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPlaceHolderService {

    private final UserClient userClient;

    public List<UserPlaceHolder> getUsersWithEvenUserIdAndOddId() {
        List<UserPlaceHolder> users = userClient.getUsers();

        if (users == null) {
            return List.of();
        }

        return users.stream()
                .filter(user -> user.getUserId() != null && user.getUserId() % 2 == 0)
                .filter(user -> user.getId() != null && user.getId() % 2 != 0)
                .toList();
    }
}
