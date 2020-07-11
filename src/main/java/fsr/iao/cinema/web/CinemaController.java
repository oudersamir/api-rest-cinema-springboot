package fsr.iao.cinema.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CinemaController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

}
