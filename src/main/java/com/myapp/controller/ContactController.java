package com.myapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.beans.Contact;
import com.myapp.beans.Department;
import com.myapp.exception.SpringCacheException;
import com.myapp.service.ContactService;
import com.myapp.service.DepartmentService;


@RestController
@RequestMapping("/data")
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private DepartmentService deptService;

	@RequestMapping("/")
	public String show() {
		return "Hello World!";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addContact(@RequestBody Contact contact) {
		contactService.addData(contact);
	}

	@RequestMapping(value="/show",method=RequestMethod.GET)
	public void showContact(@RequestParam("id") int id) throws SpringCacheException {
		contactService.show(id);
	}
	
	@RequestMapping(value="/showAll",method=RequestMethod.GET)
	public List<Contact> showAllContacts() {
		return contactService.showAllContacts();
	}
	
	
	@RequestMapping(value="/adddept",method=RequestMethod.POST)
	public void addDepartment(@RequestBody Department department) {
		deptService.add(department);
	}

	@RequestMapping(value="/showdept",method=RequestMethod.GET)
	public void showDepartment(@RequestParam("id") int id) {
		deptService.show(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void updateContact(@RequestParam("id") int id) {
		contactService.update(id);
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public void deleteContact(@RequestParam("id") int id) {
		contactService.remove(id);
	}

}