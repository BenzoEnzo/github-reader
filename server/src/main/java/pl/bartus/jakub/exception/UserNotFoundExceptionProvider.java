package pl.bartus.jakub.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pl.bartus.jakub.model.ErrorResponse;

@Provider
public class UserNotFoundExceptionProvider implements ExceptionMapper<UserNotFoundException> {

    @Override
    public Response toResponse(UserNotFoundException exception) {
        ErrorResponse errorResponse = exception.getErrorResponse();

        return Response.status(errorResponse.statusCode())
                .entity(errorResponse)
                .build();
    }
}