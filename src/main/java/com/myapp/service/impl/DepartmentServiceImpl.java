package com.myapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.myapp.beans.Department;
import com.myapp.repository.DepartmentRepository;
import com.myapp.service.DepartmentService;

@Service
@CacheConfig(keyGenerator="cacheKeyGenerator")
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public void show(int id) {
		Department d=departmentRepository.findOneById(id);
		System.out.println(d.getName());
	}

	@CachePut(value="appCache")
	@Override
	public Department add(Department department) {
		return departmentRepository.save(department); 
	}
}
