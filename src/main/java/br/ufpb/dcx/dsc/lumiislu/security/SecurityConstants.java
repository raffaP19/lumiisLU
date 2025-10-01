package br.ufpb.dcx.dsc.lumiislu.security;

public class SecurityConstants {
    public static final String SECRET = "MeuSegredoSuperSecretoParaAssinarJWTsLumiisLU-2025";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 dias em milissegundos
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String LOGIN_URL = "/auth/login";
    public static final String SIGN_UP_URL = "/auth/register";
}
