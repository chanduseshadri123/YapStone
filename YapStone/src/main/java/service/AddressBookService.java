package service;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


import model.AddressBook;

@Service
public class AddressBookService {
	Hashtable<String, AddressBook> items;
	PrintWriter out;
	File file;
	ObjectMapper mapper;
	String path = "./test.json";
	public AddressBookService() {
		items = new Hashtable<String, AddressBook>();
	    mapper = new ObjectMapper();


		AddressBook a = new AddressBook();
		a.setId("1");
		a.setFirstName("Chandu");
		a.setLastName("Seshadri");
		a.setPhoneNumber("+353894354474");
		a.setAddress("2 first avenue, dublin 10");
		a.setEmailAddress("chanduseshadri@gmail.com");
		items.put("1", a);
		
		a = new AddressBook();
		a.setId("2");
		a.setFirstName("Durga");
		a.setLastName("Prasad");
		a.setPhoneNumber("+353894354494");
		a.setAddress("12 second avenue, dublin 11");
		a.setEmailAddress("durgaprasad@gmail.com");
		items.put("2", a);
		refreshItemsToFile();
		
	}
	public void refreshItemsToFile() {
		file = new File(path);
		if(file.exists()){
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(String id : items.keySet()) {
			AddressBook address = items.get(id);
			writeJson(address);
		}
	}
	
	
	
	public AddressBook getAddress(String id) {
		return items.get(id);
	}
	
	public Hashtable<String, AddressBook> getAllAddresses(){
		return items;
	}
	
	public void create(AddressBook address) {
		items.put(address.getId(), address);
		writeJson(address);
	}
	
	public void update(String id, AddressBook address) {
		if(items.containsKey(id)) {
			items.put(id, address);
			refreshItemsToFile();
		}
	}
	
	public void delete(String id) {
		if(items.containsKey(id)) {
			items.remove(id);
			refreshItemsToFile();
		}
	}
	
	
	public void writeJson(AddressBook address) {
		try {  
			out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
	        mapper.writeValue(out, address);
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }finally {
	    	out.close();
	    }
	}
	

	
}
