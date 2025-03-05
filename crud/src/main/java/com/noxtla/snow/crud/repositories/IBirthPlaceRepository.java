package com.noxtla.snow.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.noxtla.snow.crud.models.BirthPlace;

public interface IBirthPlaceRepository extends JpaRepository<BirthPlace, Long>{

}
