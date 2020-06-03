package spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/")
	public String welcome() {
		return "hello";
	}

	//@RequestMapping("displayname")
	@GetMapping("displayname")
	public ModelAndView displayName(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
		Date date=new Date();
		List<String> names=new ArrayList();
		names.add("chirag");
		names.add("kaushik");
		names.add("aksh");
		names.add("sharma");
		names.add("deepak");
		names.add("chaurasiya");
		
		ModelAndView mav=new ModelAndView("displayName");
		mav.addObject("date",date);
		mav.addObject("fName",firstName);
		mav.addObject("lName",lastName);
		mav.addObject("names",names);
		return mav;
	}

	/*
	 * public String displayName(@RequestParam ("firstname") String
	 * firstName,@RequestParam("lastname") String lastName,Model model) {
	 * model.addAttribute("fName",firstName); model.addAttribute("lName",lastName);
	 * 
	 * return "displayName";
	 * 
	 * }
	 */

	/*
	 * public String displayName(HttpServletRequest request) { String
	 * firstName=request.getParameter("firstname"); String
	 * lastName=request.getParameter("lastname");
	 * request.setAttribute("firstName",firstName);
	 * request.setAttribute("lastName",lastName); return "displayName"; }
	 */
}
