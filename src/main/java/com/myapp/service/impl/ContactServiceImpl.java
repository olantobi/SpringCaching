package com.myapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import com.myapp.beans.Contact;
import com.myapp.repository.ContactRepository;
import com.myapp.service.ContactService;

@Service
@CacheConfig(keyGenerator="cacheKeyGenerator")
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepository;

	@Override
	@CachePut(value="appCache")
	public Contact addData(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void show(int id) {
		Contact contact = contactRepository.findOneById(id);
			System.out.println(contact.getId() + " " + contact.getFirstName() + " " + contact.getLastName());
	}

	@Override
	@CachePut(value="appCache")
	public Contact update(int id) {
		Contact contact=contactRepository.findOneById(id);
		contact.setFirstName("Sunny");
		contactRepository.save(contact);
		return contact;
	}

	@Override
	@CacheEvict(value="appCache")
	public void remove(int id) {
		contactRepository.delete(id);
	}
}
