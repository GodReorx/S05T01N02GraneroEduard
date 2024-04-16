package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FlowerNotFoundException.class)
    public ResponseEntity<String> handleFlowerNotFoundException(FlowerNotFoundException ex){
        return new ResponseEntity<>("ERROR: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlowerNotCreated.class)
    public ResponseEntity<String> handleFlowerNotCreated(FlowerNotCreated ex){
        return new ResponseEntity<>("ERROR: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlowerIsNull.class)
    public ResponseEntity<String> handleFlowerIsNull(FlowerIsNull ex){
        return new ResponseEntity<>("ERROR: " + ex.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(FlowerNotGetAll.class)
    public ResponseEntity<String> handleFlowerNotGetAll(FlowerNotGetAll ex){
        return new ResponseEntity<>("ERROR: " + ex.getMessage(), HttpStatus.NO_CONTENT);
    }
}