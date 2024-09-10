package kg.mega.vblindar.mega_test.exception;

import kg.mega.vblindar.mega_test.dto.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(basePackages = "kg.mega.vblindar.mega_test")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    ResponseEntity<ApiResponse> handleDomainException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, ex.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder errors = ex.getBindingResult().getFieldErrors().stream()
                .reduce(new StringBuilder(),
                        (builder, fieldError) -> builder.append(fieldError.getField())
                                .append(": ")
                                .append(fieldError.getDefaultMessage())
                                .append("; "),
                        StringBuilder::append);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, errors.toString()));
    }


}
