package com.example.AtividadeCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AtividadeCrud.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
