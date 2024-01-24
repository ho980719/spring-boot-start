package com.ho.startspringboot.app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CompanyDto {
  @Max(30)
  @NotNull
  @NotBlank
  private String companyName;

  @Length(max = 12, message = "사업자 번호를 확인해 주세요.")
  @NotNull
  @NotBlank
  private String bizNo;
}
