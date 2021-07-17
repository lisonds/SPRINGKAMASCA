package unsch.edu.pe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unsch.edu.pe.model.entity.Materiales;
import unsch.edu.pe.service.IMaterialesService;


@Controller
@RequestMapping(value = "/panel")
public class MaterialesController {
	@Autowired
	private IMaterialesService MateServi;
	
	
	public String Diseniadores() {

		return "views/materiales";
	}
	
	@GetMapping("/materiales")
	private String Listar() {
		List<Materiales> materiales=MateServi.buscarTodas();
		for(Materiales c:materiales) {
			System.out.println(c.getIdmateriales());
			System.out.println(c.getNombre());
			System.out.println(c.getAncho());
			System.out.println(c.getLargo());
			System.out.println(c.getImagen());
		
		
		}
		
		return "views/materiales";
	}
	
	
}
