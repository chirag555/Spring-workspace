package spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.DAO.AppDAOImpl;
import spring.model.User;

@Controller
public class MainController {
	@RequestMapping("/")
	public ModelAndView welcome() {
		List<User> users=new ArrayList<User>();
		ModelAndView mav = new ModelAndView("Index");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("/spring/DAO/spring-AppDAOConfig.xml");
		AppDAOImpl  DAO=context.getBean("DAOBean",AppDAOImpl.class);
		users=DAO.listUsers();
	System.out.println(users);
		context.close();
		mav.addObject("users",users);
		return mav;
		
	}

	// @RequestMapping("displayname")
	@PostMapping("/displaydetail")
	public ModelAndView displayName(@ModelAttribute User user) {
		Date date = new Date();
		ModelAndView mav = new ModelAndView("displayDetails");
		List<String> names = new ArrayList();
		names.add("chirag");
		names.add("kaushik");
		names.add("aksh");
		names.add("sharma");
		names.add("deepak");
		names.add("chaurasiya");

		mav.addObject("user", user);
		mav.addObject("date", date);
		mav.addObject("names", names);

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
