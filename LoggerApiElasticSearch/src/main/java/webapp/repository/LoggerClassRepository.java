package webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import webapp.entity.Logger;

public interface LoggerClassRepository extends ElasticsearchCrudRepository<Logger,Integer>{
	
	public List<Logger> findByentityName(String entityName);
	
	
	
	/// List<Logger> findAllBycreatedDate(@PathParam("startDate") Date startDate,@PathParam("endDate") Date endDate);
	List<Logger> findAllBycreatedDate(Date startDate, Date endDate);
	                    
}
