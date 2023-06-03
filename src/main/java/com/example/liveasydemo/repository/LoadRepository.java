package com.example.liveasydemo.repository;
import java.util.List;
import java.util.UUID;

import com.example.liveasydemo.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {
    // This method is used to get all the loads of a particular shipper
    List<Load> findAllByShipperId(UUID shipperId);
}
