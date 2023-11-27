package com.krust.newsletter.models;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "subscriber")
@Table(name = "subscribers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subscriber
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscribers_id_seq")
    @SequenceGenerator(name = "subscribers_id_seq", allocationSize = 1)
    private Integer id;

    private String email;

    @Column(name = "verification_code", length = 6)
    private String verificationCode;

    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "code_sent_time", columnDefinition = "timestamp")
    private Integer codeSentTime;

    @Column(name = "verification_attempts")
    private Integer verificationAttempts;

    @Column(name = "is_active")
    private boolean isActive;

    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @Column(name = "created_at", columnDefinition = "timestamp")
    private Integer createdAt;
}
