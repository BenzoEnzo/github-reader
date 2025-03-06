package pl.bartus.jakub.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.bartus.jakub.model.ErrorResponse;

@Getter
@RequiredArgsConstructor
public class UserNotFoundException extends RuntimeException{
    private final ErrorResponse errorResponse;
}