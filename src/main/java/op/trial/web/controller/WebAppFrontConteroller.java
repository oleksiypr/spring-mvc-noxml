package op.trial.web.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import op.trial.domain.User;
import op.trial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Transactional
@Controller
public class WebAppFrontConteroller {
	@Autowired
	private UserService userService;
	

	@RequestMapping({"/", "/index", "/index.*"})
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value="/home")
	public ModelAndView home(HttpServletResponse response) throws IOException{
		ModelAndView mv = new ModelAndView("home");
		
		User u = new User();
		u.name = "Foo";
		u.address = "Bar Street";
		
		userService.save(u);		
		mv.addObject("user", u.id == null ? "User not saved!" : u);
		return mv;
	}
	
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/{id}")
	public ModelAndView user(@PathVariable Integer id, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("user");
		if (id == null) {
			mv.addObject("username", "No user selected!");
			return mv;
		}		
		
		User u = userService.find(id);
		mv.addObject("user", u == null ? "No user found" : u);
		return mv;
	}	
	
	@RequestMapping(value="/admin")
	public ModelAndView dmin(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("users", userService.findAll());
		return mv;
	}	
}
