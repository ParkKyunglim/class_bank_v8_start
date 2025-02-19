package com.tenco.bank.config;

import com.tenco.bank.handler.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // IoC 대상 (스프링 부트 설정 클래스 이다)
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    // DI 처리
    private final AuthInterceptor authInterceptor;

    // 우리가 만든 인터셉트 클래스를 등록할 수 있다.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/account/**")
                .addPathPatterns("/auth/**");
    }

    // Bean 객체 만들기
    @Bean // IoC 대상
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // 프로젝트에 사용할 가상 경로 정의 -> 페이지 소스보기 (/images/uploads/)
    // 실제 파일의 경로 file:///C://spring_work//upload
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/uploads/**")
                .addResourceLocations("file:///C:\\work_spring\\uploads/");
    }
}