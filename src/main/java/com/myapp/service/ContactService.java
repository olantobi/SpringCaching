package com.myapp.service;

import com.myapp.beans.Contact;

public interface ContactService {
	Contact addData(Contact contact);
	void show(int id);
	Contact update(int id);
	void remove(int id);
}