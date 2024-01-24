package com.ho.startspringboot.app.entity;

import com.ho.startspringboot.app.dto.CompanyDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Company extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String companyName;
  private String bizNo;

  public Company(CompanyDto companyDto) {
    this.companyName = companyDto.getCompanyName();
    this.bizNo = companyDto.getBizNo();
  }
}
