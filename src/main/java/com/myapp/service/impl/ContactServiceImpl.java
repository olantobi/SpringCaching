package com.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.myapp.beans.Contact;
import com.myapp.repository.ContactRepository;
import com.myapp.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepository;

	@Override
	@CachePut(value="appCache",key="#result.id")
	public Contact addData(Contact contact) {
		evictCache();
		return contactRepository.save(contact);
	}

	@Override
	@CacheEvict(value="appCache",allEntries=true,beforeInvocation=true)
	public void evictCache() {
	}
	
	@Override
	@Cacheable(value="appCache",key="#result.id")
	public Contact show(int id) {
		Contact contact = contactRepository.findOneById(id);
			System.out.println(contact.getId() + " " + contact.getFirstName() + " " + contact.getLastName());
			return contact;
	}

	@Override
	@CachePut(value="appCache",key="#result.id")
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

	@Override
	@Cacheable(value="appCache",keyGenerator="cacheKeyGenerator")
	public List<Contact> showAllContacts() {
		return contactRepository.findAll();
	}
}
