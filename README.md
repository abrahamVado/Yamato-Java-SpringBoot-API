# Yamato Auth — Spring Boot Scaffold

**Decisions (locked):**
- IDs: **BIGINT**
- JWT: **HS256** (`JWT_SECRET`)
- Cookies: **cross-site** (`SameSite=None; Secure`), CORS with credentials
- Contract routes are wired as **501** stubs

## Quick start
```bash
# Java & Maven (Ubuntu):
sudo apt update && sudo apt install -y openjdk-17-jdk maven

# env (dev: plain http localhost -> COOKIE_SECURE=false)
export PORT=8086
export CORS_ORIGINS=http://localhost:3000,https://yamato.local
export COOKIE_DOMAIN=.yamato.local
export COOKIE_SECURE=false
export JWT_SECRET=change-me-super-secret

# run
mvn -q spring-boot:run

# test
curl -s http://localhost:8086/healthz
curl -i http://localhost:8086/auth/login   # -> 501 JSON envelope
```

## Routes included
- `POST  /auth/register`
- `POST  /auth/login`
- `POST  /auth/refresh`
- `POST  /auth/logout`
- `GET   /auth/session`
- `GET   /auth/oauth/{provider}`
- `GET   /auth/oauth/{provider}/callback`
- `POST  /auth/mfa/webauthn/begin`
- `POST  /auth/mfa/webauthn/finish`
- `POST  /auth/magic-link`
- `POST  /auth/magic-link/consume`
- `GET   /auth/oidc/.well-known/jwks.json`
- `GET   /healthz`
- `GET   /readyz`

## Next steps
- Wire Postgres (use the SQL in `migrations/` for schema parity).
- Implement handlers replacing 501s; use `CookieUtil` and `JwtHs256` helpers.
- Add real rate limiting (e.g., Bucket4J filter) if needed.
