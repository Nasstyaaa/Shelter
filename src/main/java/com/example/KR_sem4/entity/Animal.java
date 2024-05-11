package com.example.KR_sem4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Table(name = "animals")
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "имя")
    private String name;

    @Column(name = "порода")
    private String breed;

    @Column(name = "доступность")
    private Boolean availability;

    //TODO исправить в фронте отправку
    @ManyToOne
    @JoinColumn(name = "категория_id")
    private Category category;

}
