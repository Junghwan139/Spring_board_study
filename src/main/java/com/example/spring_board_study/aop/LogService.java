package com.example.spring_board_study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect

// Component를 통해 Spring bean객체를 만드는 것(bean객체는 싱글톤을 의미)
@Component

// 로그 라이브러리 log4J 라이브러리 사용
@Slf4j
public class LogService {

    // Around 어노테이션을 통해 logging의 대상을 지정
    @Around("execution(* com.example.spring_board_study.*.controller..*.*(..))")
    public Object controllerLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 로그의 형태를 json으로 출력하기 위해 json 객체 생성
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("method name", proceedingJoinPoint.getSignature().getName());

        // 사용자의 request정보는 HttpServletRequest객체 안에 담겨 있으므로, 해당 객체에서 추출
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        jsonObject.put("CRUD name", req.getMethod());  // get, put 요청
        Enumeration<String> req_body = req.getParameterNames();

        JSONObject jsonObject_detail = new JSONObject();

        while(req_body.hasMoreElements()){
            String body = req_body.nextElement();
            jsonObject_detail.put(body, req.getParameter(body));

        }
        jsonObject.put("user inputs",jsonObject_detail);


        log.debug("안찍힘");
        log.error("찍힘");
        log.info("request info"+jsonObject);

        return proceedingJoinPoint.proceed();







    }

}
