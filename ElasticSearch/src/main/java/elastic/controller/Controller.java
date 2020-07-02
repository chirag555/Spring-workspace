package elastic.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import elastic.model.Customer;
import elastic.service.CustomerService;

@RestController
@RequestMapping("/customers")

public class Controller {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public List<Customer> getCustomer() {
		return customerService.getCustomer();
	}

	@GetMapping("/{id}")
	public List<Customer> getCustomerByAge(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}

	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return ResponseEntity.accepted().body(customer);
	}
}
