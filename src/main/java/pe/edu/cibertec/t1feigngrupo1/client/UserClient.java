package pe.edu.cibertec.t1feigngrupo1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.t1feigngrupo1.dto.UserPlaceHolder;

import java.util.List;

@FeignClient(name = "userClient", url = "https://jsonplaceholder.typicode.com")
public interface UserClient {

    @GetMapping("/users")
    List<UserPlaceHolder> getUsers();
}
