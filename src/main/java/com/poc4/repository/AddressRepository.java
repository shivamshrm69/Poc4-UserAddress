package com.poc4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc4.entity.Address;

public interface AddressRepository extends MongoRepository<Address, Integer>{

	void deleteByUserId(int user_id);

}
