package webapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webapp.entity.Logger;
import webapp.services.LoggerService;

@RestController
@RequestMapping("/loggers")
public class LoggerController {

	@Autowired
	private LoggerService loggerService;

	@GetMapping
	public List<Logger> getLogger( @RequestParam(value ="startDate", required = false) String startDate,
			@RequestParam(value ="endDate", required = false) String endDate) {
		return startDate==null ? loggerService.getLogger():loggerService.getLoggerByDate(startDate, endDate);
	}
	
	@GetMapping("migratedata")
	public String migrateData(){
		loggerService.migrateData();
		return "success";
	}
	
	@PostMapping("/")
	public ResponseEntity<Logger> addLogger(@RequestBody Logger logger) {
		loggerService.addLogger(logger);
		return ResponseEntity.accepted().body(logger);
	}

	@GetMapping("/{id}")
	public Logger getLogger(@PathVariable int id) {
		return loggerService.getLogger(id);
	}

	@GetMapping("/entity/{entityName}")
	public List<Logger> getLogger(@PathVariable String entityName) {
		return loggerService.getLoggerByEntityName(entityName);
	}

	//to get the details logs between dates but with bydate as endpoint
	@GetMapping("/bydate")
	public List<Logger> getLoggerByDate(@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate) {
		return loggerService.getLoggerByDate(startDate, endDate);
	}
	
	/*
	 * @GetMapping() public ResponseEntity<?> getProgramById( @RequestParam(value =
	 * "startDate", required = false) Date startDate,@RequestParam(value =
	 * "endDate", required = false) Integer endDate) { return null;}
	 */
}
