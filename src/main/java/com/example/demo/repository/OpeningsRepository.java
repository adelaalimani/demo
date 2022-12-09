package com.example.demo.repository;

import com.example.demo.model.Opening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpeningsRepository extends JpaRepository<Opening, Long> {

}
