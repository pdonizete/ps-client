package net.paulosoft.client.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.paulosoft.client.dto.ClientDTO;
import net.paulosoft.client.entities.Client;
import net.paulosoft.client.repositories.ClientRepository;
import net.paulosoft.client.services.exceptions.DatabaseException;
import net.paulosoft.client.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {
@Autowired
private ClientRepository repository;
@Transactional(readOnly = true)
public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
	Page<Client> list=repository.findAll(pageRequest);
    return list.map(x -> new ClientDTO(x));

}
public ClientDTO findById (Long id) {
	Optional<Client> obj=repository.findById(id);
	Client entity=obj.orElseThrow(()->new net.paulosoft.client.services.exceptions.EntityNotFoundException("entity not found"));
	return new ClientDTO(entity);
}
@Transactional
public ClientDTO insert (ClientDTO dto) {
	Client entity=new Client();
	entity.setName(dto.getName());
	entity.setCpf(dto.getCpf());
	entity.setIncome(dto.getIncome());
	entity.setBirtDate(dto.getBirtDate());
	entity.setChildren(dto.getChildren());
	entity=repository.save(entity);
	return new ClientDTO(entity);
}
@Transactional
public ClientDTO update(Long id, ClientDTO dto) {
	try {
		Client entity =repository.getOne(id);
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirtDate(dto.getBirtDate());
		entity.setChildren(dto.getChildren());
		entity=repository.save(entity);
		return new ClientDTO(entity);
	}
	catch (javax.persistence.EntityNotFoundException e) {
		throw new EntityNotFoundException("id not found"+id);
		
	}
}
public void delete(Long id) {
	try {
		repository.deleteById(id);
	}
	catch (EmptyResultDataAccessException e) {
		throw new EntityNotFoundException("id not found"+id);
	}
	catch (DataIntegrityViolationException e) {
		throw new DatabaseException("Integrity violation");
	}
}
}
