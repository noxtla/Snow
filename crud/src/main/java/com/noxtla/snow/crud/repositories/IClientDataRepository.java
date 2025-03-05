package com.noxtla.snow.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noxtla.snow.crud.models.ClientData;

public interface IClientDataRepository extends JpaRepository<ClientData, Long>{

}
