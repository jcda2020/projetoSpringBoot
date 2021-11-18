package one.digitalinnovation.personApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personApi.dto.request.PersonDTO;
import one.digitalinnovation.personApi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personApi.service.PersonService;


@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class PersonController {
	
	private PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Validated PersonDTO personDTO) {
		
		return personService.listAll();
		
	}
	
	@GetMapping
	public List <PersonDTO> listAll(){
		
		return personService.listAll();
	}
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{
		
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Validated personDTO personDTO) throws PersonNotFoundException{
		
		return personService.updateById(id, personDTO );
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		
		personService.deleteById(id);
	}
	

}
