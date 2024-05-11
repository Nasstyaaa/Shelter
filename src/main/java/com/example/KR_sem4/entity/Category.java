package com.example.KR_sem4.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="название")
    private String name;
}
