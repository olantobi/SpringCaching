package com.myapp.service;

import java.util.List;
import com.myapp.beans.Contact;

public interface ContactService {
	Contact addData(Contact contact);
	void show(int id);
	Contact update(int id);
	void remove(int id);
	List<Contact> showAllContacts();
}