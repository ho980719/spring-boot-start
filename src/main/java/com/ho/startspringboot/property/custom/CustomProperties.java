package com.ho.startspringboot.property.custom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ToString
@RequiredArgsConstructor
// @ConfigurationProperties annotation 단점은 자동 scan 아닌 직접 명시 필요
@ConfigurationProperties("ho.test")
public class CustomProperties {
  private final String name;
  private final String loginId;
  private final String password;
}
