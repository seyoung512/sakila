package com.example.sakila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 제일 먼저 실행됨
@SpringBootApplication // <--애너테이션은 제일먼저 실행
public class SakilaApplication implements WebMvcConfigurer {
	// OnInterceptor와 OffInterceptor를 자동으로 주입합니다. 
	// Spring 컨테이너가 이 두 인터셉터의 인스턴스를 관리하며, 필요한 곳에 주입합니다.
	@Autowired
	private OnInterceptor onInterceptor;
	@Autowired
	private OffInterceptor offInterceptor;
	
	// Spring의 설정이 로드되고, 애플리케이션 컨텍스트가 초기화
	public static void main(String[] args) {
		SpringApplication.run(SakilaApplication.class, args);
	}

	// 인터셉터 설정( 1)인터셉터 클래스 구현 2)인터셉터 맵핑
	@Override // List
	public void addInterceptors(InterceptorRegistry registry) {
		// InterceptorRegistry registry : 인터셉터 맵핑 리스트
		// 유효성 검사?
		registry.addInterceptor(onInterceptor).addPathPatterns("/on/**");
		registry.addInterceptor(offInterceptor).addPathPatterns("/off/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}