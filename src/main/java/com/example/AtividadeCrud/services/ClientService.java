package com.example.AtividadeCrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AtividadeCrud.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

}
