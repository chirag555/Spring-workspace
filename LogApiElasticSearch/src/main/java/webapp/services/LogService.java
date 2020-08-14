package webapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webapp.entity.Log;
import webapp.repository.LogRepository;

@Service
public class LogService {
	@Autowired
	private LogRepository LogClassRepository;
	Log tempLog = new Log();

	public ResponseEntity<Log> addLog(Log Log) {
//		Log.setActions();
		LogClassRepository.save(Log);
		return ResponseEntity.accepted().body(Log);
	}

	public Log getLog(int id) {
		return LogClassRepository.findById(id).get();
	}

	public List<Log> getLog() {
		List<Log> Logs = new ArrayList<>();
		for (Log Log : LogClassRepository.findAll()) {
			Logs.add(Log);
		}
		return Logs;

	}

	public List<Log> getLogByDate(String startDate, String endDate) {
		List<Log> Logs = new ArrayList<>();
		try {
			for (Log Log : LogClassRepository.findAllBycreatedDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd").parse(endDate))) {
				Logs.add(Log);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Logs;
	}

	public List<Log> getLogByEntityName(String entityName) {

		List<Log> Logs = new ArrayList<>();
		for (Log Log : LogClassRepository.findByEntityName(entityName)) {
			Logs.add(Log);
		}

		return Logs;
	}

}
