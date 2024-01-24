package com.ho.startspringboot.app.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
  @CreatedDate
  LocalDateTime createdDateTime;

  @CreatedBy
  Long createdBy;

  boolean deleted = false;
}
