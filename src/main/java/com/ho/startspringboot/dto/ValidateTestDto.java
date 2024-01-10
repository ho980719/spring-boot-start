package com.ho.startspringboot.dto;

import com.ho.startspringboot.validation.Password;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@Builder
@ToString
@AllArgsConstructor
public class ValidateTestDto {
  @Length(max = 20)
  private String name;

  @Password
  private String password;

  @Max(value = 100)
  @Min(value = 1)
  private int age;

  @Builder.Default
  private boolean deathStatus = false;
}
