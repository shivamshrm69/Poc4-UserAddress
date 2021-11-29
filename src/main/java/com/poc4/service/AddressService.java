package com.poc4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc4.entity.Address;
import com.poc4.repository.AddressRepository;
@Service
public class AddressService {
@Autowired
AddressRepository addressRepository;
	public Address addAddress(Address address) {
		try
		{
			Address result=addressRepository.save(address);
			return result;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	public boolean deleteAddressById(int address_id) {
		try
		{
			addressRepository.deleteById(address_id);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		
	}
	public Address addressById(int address_id) {
		try {
			Optional<Address> opt= addressRepository.findById(address_id);
			Address address= opt.get();
			return address;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	public List<Address> allAddress() {
		try {
			List<Address> result=addressRepository.findAll();
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	public boolean deleteAddressByUserId(int user_id) {
		try
		{
			addressRepository.deleteByUserId(user_id);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
