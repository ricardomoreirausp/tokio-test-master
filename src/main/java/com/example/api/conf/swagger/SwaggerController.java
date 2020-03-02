package com.example.api.conf.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/doc")
public class SwaggerController {

	@GetMapping
	public ModelAndView doc() {
		return new ModelAndView("redirect:/swagger-ui.html");
	}
}
