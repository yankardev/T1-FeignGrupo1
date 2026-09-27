package pe.edu.cibertec.t1feigngrupo1.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.t1feigngrupo1.client.UserClient;
import pe.edu.cibertec.t1feigngrupo1.dto.UserPlaceHolder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    /**
     * Devuelve los users donde "userid sea par y id sea impar".
     *
     * IMPORTANTE: el endpoint https://jsonplaceholder.typicode.com/users NO
     * incluye ningún campo "userId" (ese campo solo existe en /posts). Es
     * decir, tal como está redactado el enunciado, "userId" e "id" serían
     * el mismo valor, y un mismo número no puede ser par e impar a la vez
     * (el resultado sería siempre una lista vacía).
     *
     * Mientras se confirma con el profesor cuál era el criterio real
     * esperado, esta implementación aplica el único filtro que sí tiene
     * sentido con los datos reales de la API: "id impar".
     */
    public List<UserPlaceHolder> getFilteredUsers() {
        return userClient.getUsers().stream()
                .filter(user -> user.getId() % 2 != 0) // id impar
                .collect(Collectors.toList());
    }
}
