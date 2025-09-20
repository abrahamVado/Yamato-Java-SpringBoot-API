package com.yamato.authjava.auth;

import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void setCrossSiteCookie(HttpServletResponse resp, String name, String value, String domain, boolean secure, Integer maxAgeSeconds, String path, boolean httpOnly) {
        if (path == null || path.isEmpty()) path = "/";
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("=").append(value).append("; ");
        sb.append("Domain=").append(domain).append("; ");
        sb.append("Path=").append(path).append("; ");
        sb.append("SameSite=None; ");
        if (secure) sb.append("Secure; ");
        if (httpOnly) sb.append("HttpOnly; ");
        if (maxAgeSeconds != null) sb.append("Max-Age=").append(maxAgeSeconds).append("; ");
        String header = sb.toString().trim();
        resp.addHeader("Set-Cookie", header);
    }

    public static void clearCookie(HttpServletResponse resp, String name, String domain, boolean secure, String path) {
        setCrossSiteCookie(resp, name, "", domain, secure, 0, path, true);
    }
}
