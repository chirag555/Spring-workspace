package webapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import webapp.entity.Logger;
import webapp.repository.LoggerClassRepository;

@Service
public class LoggerService {
	@Autowired
	private LoggerClassRepository loggerClassRepository;
	Logger tempLogger=new Logger();
	public void addLogger(Logger listElement) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(listElement);
			listElement.setAfterSnapshot(jsonString);
			listElement.setBeforeSnapshot(jsonString);
			loggerClassRepository.save(listElement);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public Logger getLogger(int id) {
		return loggerClassRepository.findById(id).get();
	}

	public List<Logger> getLogger() {
		List<Logger> loggers = new ArrayList<>();
		for (Logger logger : loggerClassRepository.findAll()) {
			loggers.add(logger);
		}
		return loggers;

	}

	/*
	  public List<Logger> getLoggerByDate(String startDate, String endDate) {
	  List<Logger> loggers = new ArrayList<>(); try { for (Logger logger :
	  loggerClassRepository.findAllBycreatedDate(new
	  SimpleDateFormat("yyyy-MM-dd").parse(startDate),)) { loggers.add(logger); } }
	  catch (ParseException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  
	  return loggers;
	  
	  }
	 
*/
	public List<Logger> getLoggerByDate(String startDate, String endDate) {
		List<Logger> loggers = new ArrayList<>();
		try {
			for (Logger logger : loggerClassRepository.findAllBycreatedDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd").parse(endDate))) {
				loggers.add(logger);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loggers;

	}

	public List<Logger> getLoggerByEntityName(String entityName) {

		List<Logger> loggers = new ArrayList<>();
		for (Logger logger : loggerClassRepository.findByentityName(entityName)) {
			loggers.add(logger);
		}

		return loggers;
	}

}
