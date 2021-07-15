package unsch.edu.pe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/panel")
public class MaterialesController {

	@GetMapping("/materiales")
	public String Diseniadores() {

		return "views/materiales";
	}
	
	
}
