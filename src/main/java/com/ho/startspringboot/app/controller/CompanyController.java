package com.ho.startspringboot.app.controller;

import com.ho.startspringboot.app.dto.CompanyDto;
import com.ho.startspringboot.app.entity.Company;
import com.ho.startspringboot.app.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {
  private final CompanyService companyService;

  @GetMapping
  public ResponseEntity<List<Company>> companies() {
    return ResponseEntity.ok().body(companyService.getCompanies());
  }

  @PostMapping("/new")
  public ResponseEntity createCompany(@RequestBody @Valid CompanyDto companyDto) {
    companyService.createCompany(companyDto);
    return ResponseEntity.ok().build();
  }
}
