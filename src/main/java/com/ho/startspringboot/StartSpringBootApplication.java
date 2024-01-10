package com.ho.startspringboot;

import com.ho.startspringboot.property.TestProperties;
import com.ho.startspringboot.property.custom.CustomProperties;
import com.ho.startspringboot.service.CustomPropertyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(CustomProperties.class)
public class StartSpringBootApplication implements CommandLineRunner {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(StartSpringBootApplication.class, args);

    // Environment.getProperty 이용
    TestProperties test = applicationContext.getBean(TestProperties.class);
    log.info("test properties => {}", test.toString());

    // @ConfigurationProperties 이용
    CustomPropertyService customPropertyService = applicationContext.getBean(CustomPropertyService.class);
    customPropertyService.getProperties();
  }

  // 1. CommandLineRunner의 run method를 override 하여 application 시작 시 특정 코드 실행
  @Override
  public void run(String... args) throws Exception {
    log.info("CourseTrackerApplication CommandLineRunner has executed");
  }

  // 2. CommandLineRunner를 구현한 빈
  @Bean
  public CommandLineRunner commandLineRunner() {
    return args -> {
      log.info("CommandLineRunner has executed as a bean definition with " + args.length + " arguments");
      for(String arg : args) {
        log.info("Argument: {}", arg);
      }
    };
  }
}
