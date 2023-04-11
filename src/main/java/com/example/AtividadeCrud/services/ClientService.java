package com.example.AtividadeCrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AtividadeCrud.dto.ClientDTO;
import com.example.AtividadeCrud.entities.Client;
import com.example.AtividadeCrud.repository.ClientRepository;

@Service
public class ClientService {
	
	
	
	@Autowired
	private ClientRepository repository;	
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client client = obj.get();
		return new ClientDTO(client);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		dtoToEntity(dto, client);
		repository.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		Client client = repository.getReferenceById(id);
		dtoToEntity(dto, client);		
		return new ClientDTO(client);
	}
	
	private void dtoToEntity(ClientDTO dto, Client client) {
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
	}

	public void delete(Long id) {
		repository.deleteById(id);
		
	}

}
