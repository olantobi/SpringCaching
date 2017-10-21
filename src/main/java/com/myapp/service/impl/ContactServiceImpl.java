package com.myapp.service.impl;

import com.myapp.beans.Contact;
import com.myapp.exception.SpringCacheException;
import com.myapp.exception.ResultStatusConstants;
import com.myapp.exception.SpringCacheException;
import com.myapp.repository.ContactRepository;
import com.myapp.service.ContactService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
	 
	private static final Logger logger= LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private ContactRepository contactRepository;

    @Autowired
    private EhCacheCacheManager cacheManager;

    @Override
    //@CacheEvict(value = "appCache", beforeInvocation = true, allEntries = true)
    public Contact addData(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
    //@Cacheable(value = "appCache", key = "#result.id")
    public Contact show(int id) throws SpringCacheException  {
		try {
			Contact contact = contactRepository.findOneById(id);
			return contact;
		}
		catch (Exception e) {
			throw new SpringCacheException(HttpStatus.BAD_REQUEST,"Error",e);
		}
    }

	@Override
    //@CachePut(value = "appCache", key = "#result.id")
    public Contact update(int id) {
        Contact contact = contactRepository.findOneById(id);
        contact.setFirstName("Sunny");
		contactRepository.save(contact);
		return contact;
	}

	@Override
    //@CacheEvict(value = "appCache")
    public void remove(int id) {
		contactRepository.delete(id);
	}

	@Override
    //@Cacheable(value = "appCache", keyGenerator = "cacheKeyGenerator")
    public List<Contact> showAllContacts() {
		return contactRepository.findAll();
	}
}
