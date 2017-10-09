package com.myapp.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myapp.beans.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Cacheable(value="departments")
	@Query("select d from Department d where d.id=:id")
	Department findOneById(@Param("id") int id);
}
