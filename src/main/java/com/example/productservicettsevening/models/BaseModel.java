package com.example.productservicettsevening.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
}
