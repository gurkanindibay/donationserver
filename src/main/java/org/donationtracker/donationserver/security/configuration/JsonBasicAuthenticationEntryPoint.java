package org.donationtracker.donationserver.security.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * By default, the {@link BasicAuthenticationEntryPoint}  provisioned by Spring Security returns
 * a full page for a 401 Unauthorized response back to the client. This HTML representation
 * of the error renders well in a browser, but it not well suited for other scenarios,
 * such as a REST API where a json representation may be preferred.
 * <p>
 * The namespace is flexible enough for this new requirement as well – to address this –
 * the entry point can be overridden:
 * <p>
 * By writing directly to the HTTP Response we now have full control over the format
 * of the response body.
 * Source: https://www.baeldung.com/spring-security-basic-authentication
 */
@Component
public class JsonBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Value("${spring.application.name:Spring App}")
    private String applicationName;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.addHeader("Content-Type", "application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        PrintWriter writer = response.getWriter();
        writer.println(
                "{\"timestamp\":" + new Date().getTime() + ",\"status\":401,\"error\":\"Unauthorized\",\"message\":\"" + authEx
                        .getMessage() + "\"}");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(applicationName);
        super.afterPropertiesSet();
    }
}