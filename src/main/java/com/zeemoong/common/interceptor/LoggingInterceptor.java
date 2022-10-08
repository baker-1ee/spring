package com.zeemoong.common.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@RequiredArgsConstructor
@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {
    private final ObjectMapper objectMapper;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;
        ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper) response;

        if(requestWrapper.getContentType() != null && requestWrapper.getContentType().contains("application/json")) {
            if(requestWrapper.getContentAsByteArray().length != 0) {
                log.info("Request Body : {}", objectMapper.readTree(requestWrapper.getContentAsByteArray()));
            }
        }

        if(responseWrapper.getContentType() != null && responseWrapper.getContentType().contains("application/json")) {
            if(responseWrapper.getContentAsByteArray().length != 0) {
                log.info("Response Body : {}", objectMapper.readTree(requestWrapper.getContentAsByteArray()));
            }
        }
    }
}
