package com.jatharthan.db.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatharthan.db.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person,Integer>  {

}
