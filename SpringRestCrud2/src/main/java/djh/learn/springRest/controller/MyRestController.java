package djh.learn.springRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import djh.learn.springRest.entity.Customer;
import djh.learn.springRest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class MyRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> customers(){
		List<Customer> list = customerService.getCustomers();
		System.out.println("list"+list);
		return list;
	}
	
	@GetMapping("/hello")
	public String hello(){
	
		return "Saying hello";
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer customer(@PathVariable("customerId") int customerId){
		Customer cust = customerService.getCustomer(customerId);
		if(cust==null) {
			throw new CustomerExceptionHandler("Customer not found with id "+customerId);
		}
		System.out.println("customer si "+cust);
		return cust;
	}
	
	@PostMapping("/customers/")
	public Customer newCustomer(@RequestBody Customer customer){
		customer.setId(0);
		customerService.saveCustomer(customer);
		
		System.out.println("customer inserted is  "+customer);
		return customer;
	}
	
	@PutMapping("/customers/")
	public Customer oldCustomer(@RequestBody Customer customer){
		customerService.saveCustomer(customer);
		
		System.out.println("customer updated is "+customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int customerId){
		Customer cust = customerService.getCustomer(customerId);
		System.out.println("customer id is"+customerId);
		if(cust==null) {
			throw new CustomerExceptionHandler("Customer not found with id "+customerId);
		}
		else {
			customerService.deleteCustomer(customerId);
		}
		System.out.println("customer deleted Successfully!!!");
		return "customer deleted  with id "+customerId;
	
	}
}
