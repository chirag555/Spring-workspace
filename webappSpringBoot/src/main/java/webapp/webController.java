package webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webController {

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
