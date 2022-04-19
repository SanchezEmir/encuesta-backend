package com.emirsanchez.encuestabackend.security;

import com.emirsanchez.encuestabackend.SpringApplicationContex;

public class SecurityConstants {

    public static final long EXPIRATION_DATE = 864000000; // 10 dias

    public static final String LOGIN_URL = "/users/login";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static String getTokenSecret() {

        AppProperties appProperties = (AppProperties) SpringApplicationContex.getBean("AppProperties");

        return appProperties.getTokenSecret();

    }


}
