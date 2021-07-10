package unsch.edu.pe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PanelController {
	
	@RequestMapping("/panel")
	public String Panel(){
		return "views/panel";
	}

}
