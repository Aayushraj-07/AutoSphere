package com.codewithaayush.repository;

import com.codewithaayush.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public interface CarRepository extends JpaRepository<Car, Long> {

}
