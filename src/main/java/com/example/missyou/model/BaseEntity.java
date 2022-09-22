package com.example.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    private Timestamp createTime;
    private Timestamp updateTime;
    @JsonIgnore
    private Timestamp deleteTime;
}
