package com.example.demo;

import com.example.demo.model.Child;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChildRepository extends PagingAndSortingRepository<Child, Long>, CrudRepository<Child, Long> {

}