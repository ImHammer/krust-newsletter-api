package com.krust.newsletter.models;

import java.time.LocalDateTime;

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

@Entity(name = "newsletter")
@Table(name = "newsletters")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Newsletter
{
    @Id
    @SequenceGenerator(name = "newsletters_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="newsletters_id_seq")
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "published_date")
    private LocalDateTime publishedDate = LocalDateTime.now();

    private String title;
    private String author;
}
