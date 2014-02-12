package fr.jeromesengel.selenium.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.jeromesengel.selenium.common.Page;
import fr.jeromesengel.selenium.common.Result;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		return Page.HOME.getView();
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTestPage(Model model) {

		Result result = homeService.fakeBusinessMethod();
		model.addAttribute("result", result);
		model.addAttribute("color", result.getColor());

		return "forward:/";
	}
}