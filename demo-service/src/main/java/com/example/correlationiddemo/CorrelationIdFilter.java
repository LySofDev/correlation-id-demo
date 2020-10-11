package com.example.correlationiddemo;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    @Value("${logging.correlationId.queryKey}")
    private String queryKey;

    @Value("${logging.correlationId.mdcKey}")
    private String mdcKey;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String correlationId;

        if (httpServletRequest.getParameter(queryKey) != null) {
            correlationId = httpServletRequest.getParameter(queryKey);
        } else {
            correlationId = UUID.randomUUID().toString();
        }

        MDC.put(mdcKey, correlationId);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
