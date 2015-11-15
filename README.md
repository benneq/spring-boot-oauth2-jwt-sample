# spring-boot-oauth2-jwt-sample
Spring Boot Oauth2 JWT Sample

### Available Users:
(defined in `UserDetailsService.java`)
```
username: admin
password: s3cr3t
roles: USER
```

### Getting an Access Token:
(provided by Spring Security OAuth2)
```
POST http://localhost:8080/oauth/token
                ?client_id=web
                &grant_type=password
                &username=admin
                &password=s3cr3t
```

### Accessing the Resources:
(defined in `MyRestController.java`)
```
GET http://localhost:8080/foo
Authorization: Bearer $$MY_ACCESS_TOKEN$$
```

```
GET http://localhost:8080/bar
Authorization: Bearer $$MY_ACCESS_TOKEN$$
```

```
GET http://localhost:8080/baz
Authorization: Bearer $$MY_ACCESS_TOKEN$$
```

The first resource is unsecured, the second one requires role USER, the third one required role ADMIN.

### JWT and Modifications:
(defined in `CustomUserAuthenticationConverter.java`)
The JWT Token will store an additional `user_id` field when getting created. And when accessing a resource this data will be read to create an instance of `UserDetailsImpl`, which then can be used with the `@AuthenticationPrincipal` annotation (see `MyRestController.java`).
