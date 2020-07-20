package webapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.entity.Logger;
import webapp.entity.Post;
import webapp.repository.LoggerClassRepository;

@Service
public class LoggerService {
	@Autowired
	private LoggerClassRepository loggerClassRepository;
	Logger tempLogger = new Logger();
	RestTemplate restTemplate = new RestTemplate();
	Post tempPost = new Post();
	String url = "http://localhost:9050/loggers/";
	ObjectMapper mapper = new ObjectMapper();
	Date date = new Date();

	public ResponseEntity<Logger> addLogger(Logger logger) {
		loggerClassRepository.save(logger);
		return ResponseEntity.accepted().body(logger);
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

	public List<Logger> getLoggerByDate(String startDate, String endDate) {
		List<Logger> loggers = new ArrayList<>();
		try {
			for (Logger logger : loggerClassRepository.findAllBycreatedDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd").parse(endDate))) {
				loggers.add(logger);
			}
		} catch (ParseException e) {
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

	public void migrateData() {
		
		for (Logger logger : loggerClassRepository.findAll()) {
			
			restTemplate.postForObject(url, logger, Logger.class);
		}
		
		
		
	}

}
