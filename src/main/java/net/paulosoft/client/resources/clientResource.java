package net.paulosoft.client.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.paulosoft.client.entities.Client;
import net.paulosoft.client.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
public class clientResource {
	@Autowired
	ClientRepository repository;
@GetMapping
public ResponseEntity<List<Client>> oi() {
	List <Client> lista=repository.findAll();
	return ResponseEntity.ok().body(lista);
}
}
