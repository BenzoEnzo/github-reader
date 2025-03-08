# Github reader 

Github reader is a Quarkus application that integrates with the GitHub API
to fetch repositories and their branch information for a given GitHub user.

# Getting Started

## Prerequisites

    - Java 21
    - Maven 3.9.6
    - Internet Connection 

## Dependencies

### Quarkus Core

- quarkus-arc: For CDI (dependency injection).
- quarkus-rest: For exposing REST endpoints.
- quarkus-rest-client-jackson: For JSON serialization with the REST client.
- quarkus-rest-jackson: Provides Jackson integration for REST endpoints.
- quarkus-rest-client-reactive-jackson: For reactive REST client support.

### Testing Dependencies

- quarkus-junit5: For writing integration and unit tests with Quarkus.
- rest-assured: For fluent REST endpoint testing.
- assertj-core: For fluent assertion APIs in tests.

### Other Dependencies

- Lombok (provided scope): Reduces boilerplate code (getters, setters, etc.).
- MicroProfile REST Client API: Provides a type-safe way to invoke REST endpoints.
- MapStruct: A code generator that reduces boilerplate code when mapping.

## API Reference

### Repositories

#### Get user repositories

```http
  GET /api/repositories/{username}
```

| Parameter  | Type     |Required| Description                             |
|:-----------| :------- | :----- |:----------------------------------------|
| `username` | `string` | `YES`  | The username of an existing GitHub user |

### Responses
```
Success (200): Return a list of repositories for the specified user.
```

```
Error (404): If user not found, returns: 

{
  "statusCode": 404,
  "message": "User not found"
}

```

## Testing

```
The integration tests are designed to use the real GitHub API without using any mocks. 
These tests are unauthenticated, meaning that they rely on public endpoints and the GitHub api rate limts. 
```

