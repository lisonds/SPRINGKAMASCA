package unsch.edu.pe.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import unsch.edu.pe.model.entity.Materiales;
import unsch.edu.pe.service.IMaterialesService;


@Controller
@RequestMapping(value = "/panel")
public class MaterialesController {
	@Autowired
	private IMaterialesService MateServi;
	
	@GetMapping("materiales/save")
	public String Guardar(Materiales materiales) {
		double lar=materiales.getLargo();
		System.out.println(materiales.getIdmateriales());
		System.out.println(materiales.getNombre());
		System.out.println(materiales.getAncho());
		System.out.println(lar);
		System.out.println(materiales.getImagen());
		
		//MateServi.guardar(materiales);
		return "views/materiales";
	}
	
	@GetMapping("/materiales")
	private String Listar(Model model) {
		List<Materiales> materiales=MateServi.buscarTodas();
		for(Materiales c:materiales) {
			
		
			
		}
		model.addAttribute("Materiales",materiales);
		return "views/materiales";
	}
	
	@GetMapping("/materiales/editar")
	private String Editar(@RequestParam("idmateriales") int idmateriales,Model model) {
		System.out.println("Este ID llego ="+idmateriales);
		Materiales mate =MateServi.buscarPorId(idmateriales);
		
		System.out.println("Su ID seleccionado es"+mate.getIdmateriales());
		System.out.println(mate.getNombre());
		System.out.println("SE BIENE LO QUE VA ENTRAR");
		model.addAttribute("materiales", mate);
	return "views/materialesUsa";
	}
	
	@GetMapping("/materialesUsa")
	public String MaterialesUso() {

		return "views/materialesUsa";
	}
	
}
