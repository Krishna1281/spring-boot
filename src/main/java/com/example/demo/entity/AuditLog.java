package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private LocalDateTime auditTime;

    @Column
    private String methodArgument;

    @Column(length = 10000)
    private String response;

    @PrePersist
    public void setAuditTime() {
        this.auditTime = LocalDateTime.now();
    }
}
