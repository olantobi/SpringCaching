package com.myapp.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.myapp.beans.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	@Cacheable(value = "contacts")
	@Query("select c from Contact c where c.id=:id")
	Contact findOneById(@Param("id") int id);
	
}