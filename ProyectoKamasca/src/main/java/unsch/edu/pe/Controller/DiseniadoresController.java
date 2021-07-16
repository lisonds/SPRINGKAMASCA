package unsch.edu.pe.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/panel")
public class DiseniadoresController {
	
	
	@GetMapping("/disenia")
	public String Diseniadores() {

		return "views/usuarios";
	}
	
	@GetMapping("/disenia/from")
	public String DiseniadoresFrom() {

		return "views/diseniadorFrom";
	}
	
	@PostMapping("/disenia/sabe")
	public String Guardar() {

		return "diseniadorFrom";
	}
}
