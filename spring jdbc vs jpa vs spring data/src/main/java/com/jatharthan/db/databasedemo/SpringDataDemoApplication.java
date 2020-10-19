package com.jatharthan.db.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jatharthan.db.databasedemo.entity.Person;
import com.jatharthan.db.databasedemo.jdbc.PersonJbdcDao;
import com.jatharthan.db.databasedemo.jpa.PersonJpaRepository;
import com.jatharthan.db.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("All users -> {}", repository.findAll());
		logger.info("inserting 10004 -> {}", 
				repository.save(new Person("Tara","Berlin",new Date())));
		logger.info("updating 10003 -> {}", 
				repository.save(new Person(10003,"Pieter","xxxxx",new Date())));
		logger.info("All users -> {}", repository.findAll());
		repository.deleteById(10003);
		logger.info("All users -> {}", repository.findAll());
	}
}
