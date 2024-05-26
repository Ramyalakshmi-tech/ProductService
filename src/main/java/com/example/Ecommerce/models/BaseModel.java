package com.example.Ecommerce.models;

import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
@MappedSuperclass
@Data
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CreatedBy;
    private Date CreatedAt;
    private Boolean isDeleted;
}
