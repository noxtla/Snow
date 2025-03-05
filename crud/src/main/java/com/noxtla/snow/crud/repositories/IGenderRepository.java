package com.noxtla.snow.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noxtla.snow.crud.models.Gender;

public interface IGenderRepository extends JpaRepository<Gender, Long>{

}
