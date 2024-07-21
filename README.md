# Spring Tests

## Authorization Server

### Users

- user / 1234
- admin / 1234

### Authorization Code Flow

Get an authorization code from the authorization server : 

```
http://localhost:8080/oauth2/authorize?client_id=oidc-client&response_type=code&scope=openid&redirect_uri=http://localhost:4200/oauth2/callback
```

Get an access token from the authorization server using fetched authorization code :

```
POST http://localhost:8080/oauth2/token
Content-Type: application/x-www-form-urlencoded

client_id = oidc-client &
client_secret = secret &
grant_type = authorization_code &
redirect_uri = http://localhost:4200/oauth2/callback &
code = <code_in_url_after_redirection>
```

Refresh the access token using the refresh token fetch from the previous query :

```
POST http://localhost:8080/oauth2/token
Content-Type: application/x-www-form-urlencoded

client_id = oidc-client &
client_secret = secret &
grant_type = refresh_token &
refresh_token = <refresh_token_fetched_from_previous_query>
```