package com.myapp.service;

import com.myapp.beans.Contact;
import com.myapp.exception.SpringCacheException;
import com.myapp.exception.SpringCacheException;

import java.util.List;

public interface ContactService {
	Contact addData(Contact contact);
	Contact show(int id) throws SpringCacheException;
	Contact update(int id);
	void remove(int id);
	List<Contact> showAllContacts();
    //void evictCache();
}