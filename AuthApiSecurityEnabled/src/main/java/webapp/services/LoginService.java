package webapp.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webapp.entity.Login;
import webapp.entity.UserPrincipal;
import webapp.repository.LoginRepository;

@Service
public class LoginService implements UserDetailsService {
	@Autowired
	LoginRepository loginRepository;

	LoginService loginService;
	int loginCounter;
	Login tempLogin;
	Date lockedDate = new Date();
	long tempDate;
	Date todaysDate = new Date();

	public Login addUser(Login login) {
		loginRepository.save(login);
		return login;
	}

	public String authenticateUser(String username, String password) {
		tempLogin = loginRepository.findByUsername(username);
		String status = null;
		if (tempLogin.getLockedStatus() < 3) {
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
			// 86400000 milliSeconds =1day
			tempDate = (lockedDate.getTime()) + 86400000;

			if (tempDate < todaysDate.getTime()) {
				tempLogin.setLockedStatus(0);
				tempLogin.setLockedDate(null);
				loginRepository.save(tempLogin);
				status = "success";
				// loginService.authenticateUser(username, password);
			} else {

				// status = "Locked for 24 hours " + lockedDate + " " + tempDate + " " +
				// todaysDate.getTime() + username+ password;
				status = "Locked after 3 Unsuccesful Attempts";
			}
		}
		return status;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		tempLogin = loginRepository.findByUsername(username);
		if (tempLogin == null)
			throw new UsernameNotFoundException("User Not Found");
		return new UserPrincipal(tempLogin);
	}
}