package com.demo.ecommerce.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@MappedSuperclass
public class Audit {

    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;

    @PrePersist
    public void prePersist() {
        createTime = Objects.isNull(createTime) ? LocalDateTime.now() : createTime;
        updateTime = Objects.isNull(updateTime) ? createTime : updateTime;
    }

    @PreUpdate
    public void preUpdate() {
        updateTime = LocalDateTime.now();
    }
}
