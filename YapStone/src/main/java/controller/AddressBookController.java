package controller;

import java.util.Hashtable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.AddressBook;
import service.AddressBookService;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
	@Autowired
	AddressBookService addressBookService;
	
	@GetMapping("/all")
	public Hashtable<String, AddressBook> getAll(){
		return addressBookService.getAllAddresses();
	}
	
	@GetMapping("{id}")
	public AddressBook getAddress(@PathVariable("id") String id){
		return addressBookService.getAddress(id);
	}
	
	@PostMapping("/address")
	public void createAddress(@Valid @RequestBody AddressBook address) {
		System.out.println("hello " + address.getFirstName());
		addressBookService.create(address);
	}
	
	@PutMapping("/update/{id}")
	public void updateAddress(@PathVariable("id") String id, @Valid @RequestBody AddressBook address) {
		addressBookService.update(id, address);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAddress(@PathVariable("id") String id) {
		addressBookService.delete(id);
	}
	
}
