package com.ho.startspringboot.app.service;

import com.ho.startspringboot.app.dto.CompanyDto;
import com.ho.startspringboot.app.entity.Company;
import com.ho.startspringboot.app.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
  private final CompanyRepository companyRepository;

  public List<Company> getCompanies() {
    return companyRepository.findAll();
  }

  public void createCompany(CompanyDto companyDto) {
    companyRepository.save(new Company(companyDto));
  }
}
