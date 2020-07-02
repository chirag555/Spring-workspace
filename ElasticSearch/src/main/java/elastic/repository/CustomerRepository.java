package elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import elastic.model.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer,Integer> {

	public List<Customer> findById(int id);
}
