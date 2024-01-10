package com.ho.startspringboot.property;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:properties/properties-test.properties")
public class TestProperties {
  private final Environment env;

  @Override
  public String toString() {
    return "name : " + env.getProperty("member.name") + ", member.id : " + env.getProperty("member.id");
  }
}
