package com.poc4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc4.entity.Address;
import com.poc4.response.ReturnResponse;
import com.poc4.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/addAddress")
	public ReturnResponse addAddress(@RequestBody Address address) {
		ReturnResponse response=new ReturnResponse();
		
		Address result= addressService.addAddress(address);
		if(result==null)
		{
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		response.setSuccess(true);
		response.getResult().put("success", "Address saved successfully");
		return response;
	}

	@GetMapping("/allAddress")
	public ReturnResponse allAddress() {
		ReturnResponse response=new ReturnResponse();
		List<Address> addresses= addressService.allAddress();
		if(addresses==null)
		{
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		if(addresses.isEmpty())
		{
			response.setSuccess(true);
			response.getResult().put("success", "no addess available");
			return response;
		}
		response.setSuccess(true);
		response.getResult().put("success", addresses);
		return response;
	}
	@GetMapping("/addressById/{address_id}")
	public ReturnResponse addressById(@PathVariable int address_id) {
		ReturnResponse response=new ReturnResponse();
		Address address= addressService.addressById(address_id);
		if(address==null)
		{
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		response.setSuccess(false);
		response.getResult().put("success",address);
		return response;
	}
	

	@DeleteMapping("/deleteAddressById/{address_id}")
	public ReturnResponse deleteAddressById(@PathVariable int address_id) {
		ReturnResponse response=new ReturnResponse();
		
		boolean result=addressService.deleteAddressById(address_id);
		if(result==false)
		{
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		response.setSuccess(true);
		response.getResult().put("success", "Address deleted");
		return response;
	}

	@DeleteMapping("/deleteAddressByUserId/{user_id}")
	public ReturnResponse deleteAddressByUserId(@PathVariable int user_id) {
		ReturnResponse response=new ReturnResponse();
		
		boolean result=addressService.deleteAddressByUserId(user_id);
		if(result==false)
		{
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
		response.setSuccess(true);
		response.getResult().put("success", "Address deleted");
		return response;
	}
}
