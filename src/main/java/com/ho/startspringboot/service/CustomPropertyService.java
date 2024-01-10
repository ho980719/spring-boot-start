package com.ho.startspringboot.service;

import com.ho.startspringboot.property.custom.CustomProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomPropertyService {
  private final CustomProperties customProperties;

  public void getProperties() {
    log.info("get properties => {}", customProperties.toString());
  }
}
