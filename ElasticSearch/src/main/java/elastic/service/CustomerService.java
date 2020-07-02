package elastic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elastic.model.Customer;
import elastic.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getCustomer() {

		List<Customer> customerList = new ArrayList<>();
		for (Customer customer : customerRepository.findAll()) {
			customerList.add(customer);
		}
		return customerList;
	}

	public List<Customer> getCustomerById(int id) {

		List<Customer> customerList = new ArrayList<>();
		for (Customer customer : customerRepository.findById(id)) {
			customerList.add(customer);
		}
		return customerList;
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}
}
