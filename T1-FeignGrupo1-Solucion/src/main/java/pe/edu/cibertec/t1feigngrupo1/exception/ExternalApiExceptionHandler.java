package pe.edu.cibertec.t1feigngrupo1.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExternalApiExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ProblemDetail handleFeignException(FeignException exception) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_GATEWAY);
        detail.setTitle("No se pudo consultar la API externa");
        detail.setDetail("La API externa respondio con el estado " + exception.status() + ".");
        return detail;
    }
}
