package com.example.shelter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "requests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "animal_id")
    @OneToOne
    private Animal animal;
}
