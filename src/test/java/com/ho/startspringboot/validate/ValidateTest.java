package com.ho.startspringboot.validate;

import com.ho.startspringboot.dto.ValidateTestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.Validator;

import java.util.Set;

@Slf4j
@SpringBootTest
public class ValidateTest {
  @Autowired
  Validator validator;

  @Test
  void validate() {
    @Valid ValidateTestDto dto = ValidateTestDto.builder()
        .name(RandomStringUtils.random((int) (Math.random() * 20) + 1))
        .age((int) (Math.random() * 100) + 1)
        .password("rlawnsgh12")
        .build();

    log.debug("dto ===> {}", dto.toString());

    @Valid ValidateTestDto dto2 = ValidateTestDto.builder()
        .name("012345678901234567891")
        .password("rlawnsgh12!")
        .age((int) (Math.random() * 100) + 1)
        .build();

    @Valid ValidateTestDto dto3 = ValidateTestDto.builder()
        .name(RandomStringUtils.random(20))
        .password("rrrr1234")
        .age(31)
        .build();

    log.debug("dto2 ===> {}", dto2.toString());
    log.debug("dto3 ===> {}", dto3.toString());
  }
}
