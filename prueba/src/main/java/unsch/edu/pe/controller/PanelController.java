package unsch.edu.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PanelController {
	
	@RequestMapping("/panel")
	public String Panel(){
		return "views/panel";
	}

}
