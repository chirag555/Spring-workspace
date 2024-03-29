package webapp.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webapp.entity.Login;
import webapp.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	LoginService loginService;
	int loginCounter;
	Login tempLogin;
	Date lockedDate = new Date();
	long tempDate;
	Date todaysDate = new Date();
	int lockCounter=3;
	public Login addUser(Login login) {
		loginRepository.save(login);
		return login;
	}

	public String authenticateUser(String username, String password) {
		tempLogin = loginRepository.findByUsername(username);
		String status = null;
		if (tempLogin.getLockedStatus() < lockCounter) {
			if (password.equals(tempLogin.getPassword())) {
				status = "success";
			} else {
				loginCounter = tempLogin.getLockedStatus() + 1;
				tempLogin.setLockedStatus(loginCounter);
				tempLogin.setLockedDate(todaysDate);
				// lockStautus();
				loginRepository.save(tempLogin);
				status = "Invalid Credential";
			}
		} else {
			lockedDate = tempLogin.getLockedDate();
			//86400000=1day
			tempDate = (lockedDate.getTime()) + 86400000;
			if (tempDate < todaysDate.getTime()) {
				tempLogin.setLockedStatus(0);
				tempLogin.setLockedDate(null);
				loginRepository.save(tempLogin);
				status="success";
				//loginService.authenticateUser(username, password);
			} else {
				
			//	status = "Locked for 24 hours  " + lockedDate + "  " + tempDate + "  " + todaysDate.getTime() + username+ password;
				status="Locked after 3 Unsuccesful Attempts";
			}
		}
		return status;
	}

	public void lockStautus() {
		/*
		 * if(tempDate>tempDate){ return "dude";
		 * 
		 * }else { lockedDate = tempLogin.getLockedDate(); tempDate =
		 * (lockedDate.getTime()) + 86400000; if ((lockedDate.getTime()) + 86400000 <
		 * todaysDate.getTime()) { tempLogin.setLockedStatus(0);
		 * tempLogin.setLockedDate(null); loginRepository.save(tempLogin);
		 * authenticateUser(username,password); } else { return
		 * "Account Locked for 24 hours : " + lockedDate + " " +tempDate+
		 * " "+todaysDate.getTime() ; } }
		 *
		 * lockedDate = tempLogin.getLockedDate(); tempDate = (lockedDate.getTime()) +
		 * 86400000; if ((lockedDate.getTime()) + 86400000 < todaysDate.getTime()) {
		 * tempLogin.setLockedStatus(0); tempLogin.setLockedDate(null);
		 * loginRepository.save(tempLogin); authenticateUser(username, password);
		 * 
		 * }
		 */

	}
}