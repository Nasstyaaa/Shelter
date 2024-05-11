package com.example.KR_sem4.repository;

import com.example.KR_sem4.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository  extends JpaRepository<Request, Long> {
    Request findRequestById(Long id);
    List<Request> findByUserId(Long id);
    List<Request> findAllByStatus(String request);
}


