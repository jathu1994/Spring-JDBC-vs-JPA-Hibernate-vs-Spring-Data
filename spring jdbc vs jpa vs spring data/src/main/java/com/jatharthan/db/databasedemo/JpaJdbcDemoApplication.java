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

//@SpringBootApplication
public class JpaJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("All users -> {}", repository.findAll());
//		logger.info("User id 10001 -> {}", dao.findById(10001));
//		logger.info("deleting 10002 -> no pf rows deleted {}", dao.deleteById(10002));
		logger.info("inserting 10004 -> {}", 
				repository.insert(new Person(10004,"Tara","Berlin",new Date())));
		logger.info("updating 10003 -> {}", 
				repository.update(new Person(10003,"Pieter","xxxxx",new Date())));
		logger.info("All users -> {}", repository.findAll());
	}
}
