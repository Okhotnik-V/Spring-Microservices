package com.example.spring.repository;

import com.example.spring.dtos.MySQLDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLDTORepository extends CrudRepository<MySQLDTO, Integer> {
    MySQLDTO findByText(String text);
}
